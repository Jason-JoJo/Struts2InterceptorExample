package com.journaldev.struts2.util;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.OracleCodec;

public class Utility {
	
	/**
	 * ESAPI �ץ� SQL Injection ���D
	 * 
	 * @param data ���ץ��r��
	 * @return �ץ��᪺�r��
	 */
	public static String esapiEncode(String data) {
		if (data==null) 
			return null;
		return ESAPI.encoder().encodeForSQL(new OracleCodec(), data);
	}
	
	/**
	 * ESAPI ���ҿ�J�O�_�ŦX���W��F�����W�d
	 * 
	 * @param data ���ˬd�r��, reguExp ���ҥΥ��W��F��(�Ѧ� ESAPI.properties �̪� Validator.XXXX <- �o�� XXX)
	 * @return �ŦX true, ���ŦX false
	 */
	public static boolean esapiValidator(String data, String reguExp) {
		boolean validatorResult = true;
		if (reguExp==null) {
			//�����w���W��F���h�ϥΤ���
			reguExp = "CheckWord";
		}
		try {
			ESAPI.validator().getValidInput("ESAPI Validator", data, reguExp, 255, true);
		} catch (Exception e) {
			//���ŦX�|�� Exception
			validatorResult = false;
		}
		return validatorResult;
	}
	
	/**
	 * XSS ��X�� html �����ץ�, �ؼЬO html ��(�]���ӷ��i��O DB/File/http data..., ���@�w�O�e�ݱa��, so �@�˭n�ˬd)
	 */
	public static String esapiEncodeForHTML(String data) {
		return ESAPI.encoder().encodeForHTML(data);
	}
	
	/**
	 * XSS ��X�� html �����ץ�, �ؼЬO JS ��(�]���ӷ��i��O DB/File/http data..., ���@�w�O�e�ݱa��, so �@�˭n�ˬd)
	 */
	public static String esapiEncodeForJavaScript(String data) {
		return ESAPI.encoder().encodeForJavaScript(data);
	}
	

}
