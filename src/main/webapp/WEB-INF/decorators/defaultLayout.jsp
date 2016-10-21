<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
    	<meta name="author" content="Geoffroy Warin">
        
        <title><dec:title default="Client Aps Utility" /></title>
        <script>
         var msg= "Hi All...";
         </script>
          <script type="text/javascript" src="<c:url value='static/js/global_helper.js'/>"></script>
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
			body {
				padding-top: 60px;
		        padding-bottom: 40px;
			}
			.sidebar-nav {
				padding: 9px 0;
			}
		</style>
        <!-- See http://twitter.github.com/bootstrap/scaffolding.html#responsive -->
        

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
      		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
    	

		<dec:head />
    </head>
    <body>

		
		<div id="message" class="alert alert-info">
			<spring:message code="message.lang.lbl"/>
		</div>
    
		<div class="container-fluid">
			<div class="row-fluid">
				
				<div class="span3">
                    <%@include file="bootstrapMenu.jsp"%>
				</div> <!--/span-->
				
				<div class="span9">
					<!--Body content-->
					<dec:body />
				</div>
			
			</div>
			<!---Add footer jsp file-->
			<hr>
			<footer>
			   <%@include file="footer.jsp"%>
			</footer>
			
		</div><!--/.container-fluid-->
		
		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
		<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>