package com.xsm.demo.service.model;

public class TokenModel {
	 // 用户 id
    private String userId;
    // 随机生成的 uuid
    private String token;
    
    public TokenModel(){}
    
    public TokenModel(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
    public String getUserId () {
        return userId;
    }
    public void setUserId (String userId) {
        this.userId = userId;
    }
    public String getToken () {
        return token;
    }
    public void setToken (String token) {
        this.token = token;
    }
}
