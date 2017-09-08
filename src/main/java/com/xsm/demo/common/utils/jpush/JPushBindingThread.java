package com.xsm.demo.common.utils.jpush;

/**
 * 极光绑定线程。登录时候绑定防止极光服务器网络不给力。登录缓慢，开线程单独处理
 * @author Mr.ShyMe
 *
 */
public class JPushBindingThread implements Runnable{
	private String userId;
	private String registrationId;
	private String areaCode;
	
	public JPushBindingThread(){
		
	}
	public JPushBindingThread(String userId,String registrationId,String areaCode){
		this.userId=userId;
		this.registrationId=registrationId;
		this.areaCode=areaCode;
	}
	public String getUserId() {
		return userId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	@Override
	public void run() {
		synchronized(this) {
			try{
				JPushUtil.bindingJPush(userId, registrationId,areaCode);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
	
