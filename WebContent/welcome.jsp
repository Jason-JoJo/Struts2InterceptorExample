<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tlds/Esapi.tld" prefix="esapi" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<h2>----userName----</h2>
<h3>struts-tags : <s:property value="userName"></s:property></h3>
<br>
<h3>EL : ${userName }</h3>
<h3>&#36{user } EL : ${user }</h3>

<h2>----email----</h2>
<h3><% String email=request.getParameter("email") ;%></h3>
<h3>Scripting <%= email %></h3>
<h3>EL request.email : ${request.email }</h3>
<h3>EL email : ${email }</h3>
<h3> JSTL : <c:out value='${email}' default='is email'/></h3>
<h3> Struts2 (OGNL) : <s:property value="email"/></h3>
<h3> 自訂標籤 value='email' : <esapi:forHtml value='email'/></h3>
<h3> 自訂標籤 value='123444' : <esapi:forHtml value='123444'/></h3>
<h3> 自訂標籤 + OGNL : <esapi:forHtml> <s:property value="email"/></esapi:forHtml></h3>
<h3> 自訂標籤 夾 String : <esapi:forHtml> ijsss%!*/ff</esapi:forHtml></h3>
<h3> 自訂標籤+EL : <esapi:forHtml value="${email}"/></h3>

</body>
</html>