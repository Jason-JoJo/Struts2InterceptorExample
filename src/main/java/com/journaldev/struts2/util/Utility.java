package com.journaldev.struts2.util;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.OracleCodec;

public class Utility {
	
	/**
	 * ESAPI 修正 SQL Injection 問題
	 * 
	 * @param data 欲修正字串
	 * @return 修正後的字串
	 */
	public static String esapiEncode(String data) {
		if (data==null) 
			return null;
		return ESAPI.encoder().encodeForSQL(new OracleCodec(), data);
	}
	
	/**
	 * ESAPI 驗證輸入是否符合正規表達式的規範
	 * 
	 * @param data 欲檢查字串, reguExp 驗證用正規表達式(參考 ESAPI.properties 裡的 Validator.XXXX <- 這個 XXX)
	 * @return 符合 true, 不符合 false
	 */
	public static boolean esapiValidator(String data, String reguExp) {
		boolean validatorResult = true;
		if (reguExp==null) {
			//未指定正規表達式則使用內建
			reguExp = "CheckWord";
		}
		try {
			ESAPI.validator().getValidInput("ESAPI Validator", data, reguExp, 255, true);
		} catch (Exception e) {
			//不符合會跳 Exception
			validatorResult = false;
		}
		return validatorResult;
	}
	
	/**
	 * XSS 輸出至 html 頁面修正, 目標是 html 時(因為來源可能是 DB/File/http data..., 不一定是前端帶來, so 一樣要檢查)
	 */
	public static String esapiEncodeForHTML(String data) {
		return ESAPI.encoder().encodeForHTML(data);
	}
	
	/**
	 * XSS 輸出至 html 頁面修正, 目標是 JS 時(因為來源可能是 DB/File/http data..., 不一定是前端帶來, so 一樣要檢查)
	 */
	public static String esapiEncodeForJavaScript(String data) {
		return ESAPI.encoder().encodeForJavaScript(data);
	}
	

}
