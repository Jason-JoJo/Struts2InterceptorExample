package com.journaldev.struts2.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HellowInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("destroy HellowInterceptor");
		
	}

	@Override
	public void init() {
		System.out.println("init HellowInterceptor");
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("intercept HellowInterceptor");
		Object user = ActionContext.getContext().getSession().get("user");
		
		if(user == null) {
			System.out.println("user==null");
			return "toLogin";
		}else {
			System.out.println("user!=null");
			invocation.invoke();
			return "welcome";
		}
				
	}

}
