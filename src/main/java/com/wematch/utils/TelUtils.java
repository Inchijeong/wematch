package com.wematch.utils;

public class TelUtils {

	public static String changeSecretNumber(String tel) {
		StringBuilder sb = new StringBuilder(tel);
		int len = sb.length();
		return sb.replace(len-3, len-1, "**").toString();
	}
}
