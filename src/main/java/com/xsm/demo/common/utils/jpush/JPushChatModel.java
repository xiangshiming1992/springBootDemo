package com.xsm.demo.common.utils.jpush;

import java.util.Date;

/**
 * 消息推送
 * @author Mr.ShyMe
 *
 */
public class JPushChatModel {
	//TJ_SHAKE_B:天降摇币，   TJ_YB：天降元宝，   TJ_SW：天降奖品 ,
	//TJ_DJ_LIMIT_TIME：天降限时加时器,
	//TJ_DJ_LIMIT_MAGNIFIER：天降限时放大镜,
	//TJ_DJ_TIME_PERM：天降永久加时器,
	//TJ_DJ_MAGNIFIER_PERM：天降永久放大镜 
	//TJ_DJ_LIMIT_FREEZE：限时冻结,
	//TJ_DJ_LIMIT_STEPBACK：限时倒退一步
	//TJ_DJ_YJ_FREEZE：永久冻结
	//TJ_DJ_YJ_STEPBACK：永久倒退一步
	//SHAKE:摇奖中奖推送,
	//ALL_SHAKE全平台摇奖中奖推送，
	//msg_official:消息中心中的官方消息 ,msg_sys:消息中心中的系统消息,msg_prize:消息中心中的奖品消息,msg_act:消息中心活动
	//天降道具 以 TJ_DJ_开头
	//博奖开奖了 BLC_OPEN
	private String type;
	private String title;
	private String content;
	private Date tuiTime;
	private String dataId;
	private String url;
	private String scheme;//yqsappscheme://www.yqsapp.com:80/mypath?id=id
	public String getType() {
		return type == null ? "" : type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title == null ? "" : title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content == null ? "" : content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTuiTime() {
		return tuiTime == null ? new Date() : tuiTime;
	}
	public void setTuiTime(Date tuiTime) {
		this.tuiTime = tuiTime;
	}
	
	public String getDataId() {
		return dataId == null ? "" : dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getUrl() {
		return url == null ? "" : url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getScheme() {
		return scheme == null ? "" : scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
}
