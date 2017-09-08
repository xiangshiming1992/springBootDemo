package com.xsm.demo.service.helper.alipay.util;

import com.xsm.demo.common.global.InitGlobalConfig;
import com.xsm.demo.common.utils.HttpClientUtil;
import com.xsm.demo.service.helper.alipay.config.AlipayConfig;
import com.xsm.demo.service.helper.alipay.sign.MD5;
import com.xsm.demo.service.helper.alipay.sign.RSA;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/* *
 *类名：AlipayNotify
 *功能：支付宝通知处理类
 *详细：处理支付宝各接口通知返回
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考

 *************************注意*************************
 *调试通知返回时，可查看或改写log日志的写入TXT里的数据，来检查通知返回是否正常
 */
public class AlipayNotify {
	private static final Logger logger = LoggerFactory.getLogger(AlipayNotify.class);
    /**
     * 
     * 支付宝查询订单状态
     * @param sign 签名
     * @param trade_no 支付宝交易号
     * @param out_trade_no 商户唯一订单号
     * @return 查询结果字符串
     * @since  1.0.0
     */
    public static String alipayQueryOrderStatus(String trade_no, String out_trade_no) throws Exception{
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("service", InitGlobalConfig.getAliPayConfigMap().get("alipay.queryOrder.serviceName"));
    	map.put("partner", InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id"));
    	map.put("_input_charset", AlipayConfig.input_charset);
    	if(!StringUtils.isBlank(trade_no)){
    		map.put("trade_no", trade_no);
    	}
    	if(!StringUtils.isBlank(out_trade_no)){
    		map.put("out_trade_no", out_trade_no);
    	}
    	map.put("sign", "");
    	map.put("sign_type", "MD5");
    	Map<String, String> signatureMap = AlipayCore.paraFilter(map);
    	//1、组装待签名参数
    	String content = AlipayCore.queryCreateLinkString(signatureMap);
    	//2、签名
    	String sign = MD5.sign(content, InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id"), AlipayConfig.input_charset);
    	map.put("sign", sign);
    	//3、组装查询地址
    	String queryUrl = InitGlobalConfig.getAliPayConfigMap().get("https.post.query.order.url")+"?service="+InitGlobalConfig.getAliPayConfigMap().get("alipay.queryOrder.serviceName")+"&sign="+sign;
    	if(trade_no!=null && !trade_no.equals("")){
    		queryUrl = queryUrl +"&trade_no="+trade_no;
    	}
    	queryUrl = queryUrl + "&partner=" + InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id");
    	if(out_trade_no!=null && !out_trade_no.equals("")){
    		queryUrl = queryUrl +"&out_trade_no="+out_trade_no;
    	}
    	queryUrl = queryUrl + "&_input_charset=" + AlipayConfig.input_charset+"&sign_type="+AlipayConfig.querysign_type;
    	return HttpClientUtil.post(queryUrl, null);
//    	return checkUrl(queryUrl);
    }
    
    /**
     * 
     * 【支付宝查询订单功能】生成待签名字符串
     * @param map
     * @return 待签名字符串
     * @since  1.0.0
     */
    public static String generationToBeSignedOn(String partner, String _input_charset, String trade_no, String out_trade_no){
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("service", "single_trade_query");
    	map.put("partner", partner);
    	map.put("_input_charset", _input_charset);
    	map.put("trade_no", trade_no);
    	map.put("out_trade_no", out_trade_no);
    	return AlipayCore.createLinkString(map);
    }
    

    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) throws Exception {
        //1、验证是否是支付宝通知
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
			logger.info("------------支付宝支付异步通知ID的结果:"+responseTxt);
		}else{
			return false;
		}
		
		//2、验证签名是否合法
	    String sign = "";
	    if(params.get("sign") != null){
	    	sign = params.get("sign");
	    }
	    boolean isSign = getSignVeryfy(params, sign);
	    //写日志记录， 支付宝支付异步通知验证签名的结果
        String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    AlipayCore.logResult(sWord);
	    
	    logger.info("------------支付宝支付异步通知验证签名的结果:"+isSign);
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 支付宝退款异步通知验证合法性方法
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean refundverify(Map<String, String> params) throws Exception {
        //1、验证是否是支付宝通知
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
			logger.info("------------支付宝退款异步通知验证ID验证后的结果:"+responseTxt);
		}else{
			return false;
		}
		
		//2、验证签名是否合法
	    String sign = "";
	    if(params.get("sign") != null){
	    	sign = params.get("sign");
	    }
	    boolean isSign = refundGetSignVeryfy(params, sign);
	    logger.info("------------支付宝退款异步通知验证签名的结果:"+isSign);
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 支付宝验签方法
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> params, String sign) throws Exception {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        if(params.get("sign_type").equals("RSA")){
        	isSign = RSA.verify(preSignStr, sign, InitGlobalConfig.getAliPayConfigMap().get("alipay.ali_public_key"), AlipayConfig.input_charset);
        }
        if(params.get("sign_type").equals("MD5")){
        	isSign = MD5.verify(preSignStr, sign, InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id"), AlipayConfig.input_charset);
        }
        return isSign;
    }
	
	/**
     * 支付宝退款异步通知验签方法
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean refundGetSignVeryfy(Map<String, String> Params, String sign) throws Exception {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        isSign = MD5.verify(preSignStr, sign, InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id"), AlipayConfig.input_charset);
        return isSign;
    }

	public static void signbijiao() {
		try {
			String aString = "notify_time=2015-01-20 10:44:25, notify_type=trade_status_sync, notify_id=5cf9a3dc868b5dfc880933a8e1ed3fd520, sign_type=RSA, "
					+ "sign=eopUP9rCLuGcKxYXCTFwtd5azCJTUrsMc8cLAjJQC7pyqYRbHTQw3l6vdjfVdnwv7zySF9dbrSAvQA3/3ePqSN5HtySeSj9PfLP6eJwGhLM8JwPr68b+wMy3kGmpQYHhJz0L23EkKsZfxnM7Wyg8pBrB76MPEEWhRiWZa4Lq4R0=, "
					+ "out_trade_no=20150120103929alipay6255046, subject=抢！抢！大优惠, payment_type=1, trade_no=2015012020214600, trade_status=TRADE_CLOSED, "
					+ "seller_id=2088411686683782, seller_email=yz@cqnt.com.cn, buyer_id=2088702713958006, buyer_email=18225097233, total_fee=0.01, quantity=1, "
					+ "price=0.01, body=本次订单交易商品包括:抢！抢！大优惠,, gmt_create=2015-01-20 10:40:24, gmt_payment=2015-01-20 10:40:25, is_total_fee_adjust=N, "
					+ "use_coupon=N, discount=0.00";
			Map<String, String> mapstr = new HashMap<String, String>();
			mapstr.put("notify_time", "2015-01-20 10:44:25");
			mapstr.put("notify_type", "trade_status_sync");
			mapstr.put("notify_id", "5cf9a3dc868b5dfc880933a8e1ed3fd520");
			mapstr.put("sign_type", "RSA");
			mapstr.put("sign", "eopUP9rCLuGcKxYXCTFwtd5azCJTUrsMc8cLAjJQC7pyqYRbHTQw3l6vdjfVdnwv7zySF9dbrSAvQA3/3ePqSN5HtySeSj9PfLP6eJwGhLM8JwPr68b+wMy3kGmpQYHhJz0L23EkKsZfxnM7Wyg8pBrB76MPEEWhRiWZa4Lq4R0=");
			mapstr.put("out_trade_no", "20150120103929alipay6255046");
			mapstr.put("subject", "抢！抢！大优惠");
			mapstr.put("trade_no", "2015012020214600");
			mapstr.put("trade_status", "TRADE_CLOSED");
			mapstr.put("seller_id", "2088411686683782");
			mapstr.put("seller_email", "yz@cqnt.com.cn");
			mapstr.put("buyer_id", "2088702713958006");
			mapstr.put("buyer_email", "18225097233");
			mapstr.put("total_fee", "1");
			mapstr.put("success_num", "0.01");
			mapstr.put("quantity", "1");
			mapstr.put("price", "0.01");
			mapstr.put("body", "本次订单交易商品包括:抢！抢！大优惠,");
			mapstr.put("gmt_create", "2015-01-20 10:40:24");
			mapstr.put("gmt_payment", "2015-01-20 10:40:25");
			mapstr.put("is_total_fee_adjust", "N");
			mapstr.put("use_coupon", "N");
			mapstr.put("discount", "0.01");
			String sign = "";
		    if(mapstr.get("sign") != null){
		    	sign = mapstr.get("sign");
		    }
		    
		    logger.info("------------------验证结果为:"+AlipayNotify.verify(mapstr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    /**
    * 验证是否是支付宝通知
    * @param notify_id 通知校验ID
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String verifyResponse(String notify_id) throws Exception{
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        String partner = InitGlobalConfig.getAliPayConfigMap().get("alipay.merchant_id");
        String veryfy_url = InitGlobalConfig.getAliPayConfigMap().get("alipay.https.verify.url") + "partner=" + partner + "&notify_id=" + notify_id;
        return checkUrl(veryfy_url);
    }

    /**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) throws Exception{
        String inputLine = "";
        URL url = new URL(urlvalue);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        inputLine = bufferedReader.readLine().toString();
        return inputLine;
    }
}
