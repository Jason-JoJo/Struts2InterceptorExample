package com.journaldev.struts2.actions;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class GetRequest extends ActionSupport implements ServletRequestAware ,SessionAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Map<String, Object> session;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public String execute() throws Exception {
		
		String userField = request.getParameter("userField");
		session.put("userField",userField);
		
		return SUCCESS;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	
	
}
