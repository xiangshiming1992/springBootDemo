package com.xsm.demo.common.utils.RedisUtil;

import com.xsm.demo.service.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redis Token工具类
 */
@SuppressWarnings("unchecked")
@Component
public class RedisTokenUtils {
    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setRedis (RedisTemplate redis) {
        this.redisTemplate = redis;
        // 泛型设置成 Long 后必须更改对应的序列化方案
        redis.setKeySerializer (new JdkSerializationRedisSerializer());
    }
    /**
     * 创建一个 token 关联上指定用户
     * @param userId 指定用户的 id
     * @param timeout 有效时间，单位秒
     * @return 生成的 token
     */
    @SuppressWarnings("unchecked")
    public TokenModel createToken(String userId,long timeout) {
        // 使用 uuid 作为源 token
        String token = UUID.randomUUID().toString ().replace ("-", "");
        TokenModel model = new TokenModel(userId, token);
        // 存储到 redis 并设置过期时间
        redisTemplate.boundValueOps(userId.toString()).set(token, timeout , TimeUnit.SECONDS);
        return model;
    }
    /**
     * 检查 token 是否有效
     * @param model token
     * @return 是否有效
     */
    @SuppressWarnings("unchecked")
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = (String)redisTemplate.boundValueOps(model.getUserId()).get();
        if (token == null || !token.equals (model.getToken ())) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        redisTemplate.boundValueOps (model.getUserId()).expire (72, TimeUnit.HOURS);
        return true;
    }
    /**
     * 从字符串中解析 token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String [] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        String userId = param [0];
        String token = param [1];
        return new TokenModel(userId, token);
    }
    /**
     * 清除 token
     * @param userId 登录用户的 id
     */
    @SuppressWarnings("unchecked")
    public void deleteToken(String userId) {
        redisTemplate.delete(userId);
    }
}
