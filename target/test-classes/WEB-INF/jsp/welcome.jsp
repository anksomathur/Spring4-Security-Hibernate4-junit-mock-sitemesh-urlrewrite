<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<c:url var="home" value="/" scope="request" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>

	Greeting : ${greeting}
	This is a welcome page.
	<a href="<c:url value="/login"/>">Login"</a>
	
</body>
</html>