<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

  <link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.min.css" >
  <link rel="stylesheet" href="resources/libs/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="resources/libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="resources/libs/admin-lte2/css/AdminLTE.min.css">
  <link rel="stylesheet" href="resources/libs/admin-lte2/css/skins/skin-green.min.css">
  <link rel="stylesheet" href="resources/libs/validate-form-master/css/formValidation.min.css">


  <script src="resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
  <script src="resources/libs/bootstrap/js/bootstrap.min.js" ></script>
  <script src="resources/libs/admin-lte2/js/app.js"></script>
  <script src="resources/libs/validate-form-master/js/formValidation.min.js"></script>
  <script src="resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
  <script src="resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
  <style >
	/* .main-sidebar { background-color: #333 !important }
	.sidebar-menu>li>.treeview-menu {
	    
	    background: #3d8420 !important
	} */
  </style>
  <title>Hello JSP</title>
</head>
<body class="hold-transition skin-green sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../template/header.jsp" />
    <jsp:include page="../template/menu_sidebar_admin.jsp" />


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Dashboard
          <small>Version 0.1</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home ${pageContext.response.locale}</a></li>
          <li class="active">Dashboard</li>
        </ol>
      </section>

      <!-- Main content -->
      <section class="content">



      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

   <jsp:include page="../template/footer.jsp" />

    <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->


<script>
var SpringAdminIdex = function(){
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-index').addClass('active');
	}
	
	return {
		init : function() {
			handleActiveMenu();
		}
	}
}();

$(document).ready(function() {
	SpringAdminIdex.init();
});
</script>
</body>
</html>