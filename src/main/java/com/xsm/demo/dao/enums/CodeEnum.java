package com.xsm.demo.dao.enums;

import java.util.ArrayList;
import java.util.List;


public enum CodeEnum {
	/**
	 * 10000-表示业务执行通畅，执行成功
	 */
	SUCCESS("10000", "表示业务执行通畅，执行成功"),
	/**
	 * 校验，业务处理出现异常--APP判断 code=10001时拿出后端提示的message提示框提示即可
	 */
	BUSSINESS_HANDLE_ERROR("10001", "校验，业务处理出现异常"),
	/**
	 * 请登录--APP判断 code=10002,跳到登录页面
	 */
	PLEASE_SIGN_IN("10002", "请登录再操作"),
	/**
	 * 登录账号被冻结，禁用--APP判断 code=10003,提示用户账号被冻结请联系官方客服处理，弹出拨打官方电话等操作
	 */
	ACCOUNT_FREEZE("10003", "登录账号被冻结，禁用"),
	/**
	 * 请绑定手机号，--APP判断 code=10004,提示用户执行该操作需要绑定手机号，弹出绑定框走绑定流程
	 */
	PLEASE_BIND_YOUR_PHONE("10004", "执行该操作需要绑定手机号"),
	/**
	 * 余额不足，是否去充值，--APP判断 code=10005,提示用户余额不足，是否去充值
	 */
	INSUFFICIENT_BALANCE("10005", "余额不足，是否去充值"),
	/**
	 * 系统异常
	 */
	SYSTEM_ERROR("SYSTEM_ERROR","系统异常");
	
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>DomainResultCodeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private CodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return DomainResultCodeEnum
	 */
	public static CodeEnum getByCode(String code) {
		for (CodeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DomainResultCodeEnum>
	 */
	public List<CodeEnum> getAllEnum() {
		List<CodeEnum> list = new ArrayList<CodeEnum>();
		for (CodeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (CodeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

