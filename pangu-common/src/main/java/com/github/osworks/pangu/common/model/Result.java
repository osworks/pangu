package com.github.osworks.pangu.common.model;

import java.io.Serializable;

import com.github.osworks.pangu.common.constants.Constants;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 响应结果封装
 * 
 * @author xiongchun
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态标识
	 */
	private boolean status = true;
	
	/**
	 * 自定义状态码
	 */
	private String statusCode;
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 调试信息，当请求头中包含x-debug=true时，拦截器将获取堆栈信息返回前端
	 */
	private String debugMsg;
	
	/**
	 * 返回消息体
	 */
	private T result;
	
	public Result(String statusCode, String message, T result){
		setStatusCode(statusCode).setMessage(message).setResult(result);
	}
	
	public Result(Boolean status, String statusCode, String message, T result){
		setStatus(status).setStatusCode(statusCode).setMessage(message).setResult(result);
	}
	
	public Result(Boolean status, String statusCode, String message){
		setStatus(status).setStatusCode(statusCode).setMessage(message);
	}
	
	/**
	 * 请求成功
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return new Result<T>(Constants.Result.SUCCESS, "请求成功", data);
	}
	
	/**
	 * 请求失败
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Result<T> fail(T data){
		return new Result<T>(false, Constants.Result.FAIL, "请求失败");
	}
	
}
