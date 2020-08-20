<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download test</title>
</head>
<body>

<s:url id="fileDownload" namespace="/" action="download" ></s:url>


<div>

<h2>Download file - <s:a href="%{fileDownload}">download.txt</s:a></h2>

</div>
</body>
</html>