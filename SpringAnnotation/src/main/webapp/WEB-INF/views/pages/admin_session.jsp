<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-green.min.css">

<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>


<title>Session</title>
</head>
<body class="hold-transition skin-green sidebar-mini">

	<div class="wrapper">
    	<jsp:include page="../template/header.jsp" />
    	<jsp:include page="../template/menu_sidebar_admin.jsp" />
    	
    	<div class="content-wrapper">
    	
    	</div><!-- /.content-wrapper -->
    	
	</div><!-- ./wrapper -->
<script>
var SpringSession = function() {
	
	var handleActiveMenu = function() {
		 $('ul.sidebar-menu > li.menu-setting').addClass('active');
		 $('ul.sidebar-menu > li.menu-setting > ul.treeview-menu > li.session').addClass('active');
	}
	
	return {
		init : function() {
			handleActiveMenu();		
		}
	};
}();
$(document).ready(function() {
	SpringSession.init();
});
</script>
</body>
</html>