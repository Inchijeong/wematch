package com.wematch.apis.dto;

import java.util.Collection;

public class ApiResult<T> {

	private final Integer totalDataCount;
	private final T result;
	
	ApiResult(T result) {
		this.result = result;		
		this.totalDataCount = result instanceof Collection ? ((Collection)result).size() : 1;
	}
	
	public static <T> ApiResult<T> succeed(T result){
		return new ApiResult<T>(result);
	}
	
	public T getResult() {
		return result;
	}
	
	public Integer getTotalDataCount() {
		return totalDataCount;
	}
}
