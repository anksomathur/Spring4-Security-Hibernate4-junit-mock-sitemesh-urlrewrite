<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>

<div class="container-fluid"> <!-- this is to make it responsive to your screen width-->
    <div class="row">
    <div class="span12">
    <p>Deaddr <strong>${user}</strong>, Welcome to Admin Page23.</p>
	<a href="<c:url value="/logout" />">Logout</a><button id="btnSubmit" onclick="callAjax();" >get User details</button>
	<div id="feedback"></div>
	</div>
    </div>
</div>
	
	
</body>
</html>