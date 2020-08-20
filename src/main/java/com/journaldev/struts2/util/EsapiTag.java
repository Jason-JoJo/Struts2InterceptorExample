package com.journaldev.struts2.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.owasp.encoder.tag.EncodingTag;
import org.owasp.esapi.ESAPI;

public class EsapiTag extends SimpleTagSupport{

    /**
     * The value to be written out by the tag.
     */
    protected String value;
    /**
     * Sets the value to be written out by the tag.
     * @param value the value to be written out by the tag.
     */
    public void setValue(String value) {
        this.value = value;
    }

    StringWriter sw = new StringWriter();
	
	@Override
	public void doTag() throws JspException, IOException {
//		EsapiTag.esapiEncodeForHTML(getJspContext().getOut().toString());
//		EsapiTag.esapiEncodeForHTML("123");
//		Encode.forHtml(getJspContext().getOut(), _value);
		
//		System.out.println("----value : "+_value);
//		esapiEncodeForHTML(_value);
		
//		System.out.println("in doTag");
//		getJspBody().invoke(sw);
//		String encodeStr = esapiEncodeForHTML(sw.toString());
//	    getJspContext().getOut().println(encodeStr);
	    
//	    esapiEncodeForHTML(sw.toString()); 
		String encodeStr = null;
	    if(value != null) {
	    	//<esapi:forHTML value='value'>
//	    	System.out.println("value = "+value);
	    	encodeStr = esapiEncodeForHTML(value);
//	    	System.out.println("encodeStr = "+encodeStr);
	    }else {
	    	//<esapi:forHTML> sw </esapi:forHTML>
	    	getJspBody().invoke(sw);
			encodeStr = esapiEncodeForHTML(sw.toString());
		    	
	    }
	    getJspContext().getOut().print(encodeStr);
	}

	/**
	 * XSS 輸出至 html 頁面修正, 目標是 html 時(因為來源可能是 DB/File/http data..., 不一定是前端帶來, so 一樣要檢查)
	 */
	public static String esapiEncodeForHTML(String data) {
//		String esString = ESAPI.encoder().encodeForHTML(data)+" : OK";
		System.out.println("in esapiEncode");
		return ESAPI.encoder().encodeForHTML(data)+" : encode OK";
	}
	
	/**
	 * XSS 輸出至 html 頁面修正, 目標是 JS 時(因為來源可能是 DB/File/http data..., 不一定是前端帶來, so 一樣要檢查)
	 */
	public static String esapiEncodeForJavaScript(String data) {
		return ESAPI.encoder().encodeForJavaScript(data);
	}
	
}
