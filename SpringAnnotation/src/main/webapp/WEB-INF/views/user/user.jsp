<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="resources/libs/admin-lte2/css/skins/skin-purple.min.css">
<link rel="stylesheet" href="resources/libs/datatables/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="resources/libs/datatables/css/colReorder.dataTables.min.css">

<script src="resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="resources/libs/admin-lte2/js/app.js"></script>
<script src="resources/libs/datatables/js/jquery.dataTables.min.js"></script>
<script src="resources/libs/datatables/js/dataTables.colReorder.min.js"></script>
<style >
	
</style>

<title>Hello JSP</title>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

  <jsp:include page="../tenplate/header.jsp" />
  <jsp:include page="../tenplate/menu_sidebar_user.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Version 0.1</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    
     <table id="example" class="display" cellspacing="0" width="100%"></table>
    
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  

  <jsp:include page="../tenplate/footer.jsp" />
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->


<script>
$(document).ready(function() {
    var dataTable = $('#example').DataTable( {
        "processing"  : true,
        "colReorder"  : {
							fixedColumnsLeft: 1
						},
        "serverSide" : true,
        "searching"  : false,
        "ajax": {
            "url": "service/user/findAll",
            "type": "POST",
            contentType: 'application/json',
            "data": function ( d ) {
            	d.search.val = "ssss";
            	alert(JSON.stringify(d));
                return JSON.stringify(d);
              }
        },
        "columns": [ 
           
            { "data": "id" },
            { "data": null          ,title :"ลำดับ" },
            { "data": "username"    ,title :"ชื่อผู้ใช้" },
            { "data": "password"    ,title:"รหัสผ่าน"  },
            { "data": "create_date" ,title:"วันที่สร้าง" },
            { "data": "update_date" ,title:"วันที่แก้ไข"},
            { "data": null ,title:"action"}
        ],
        "columnDefs": [
            {
	        	"targets": 1,
	           	"render": function ( data, type, row, meta ) {
	             	return meta.settings._iDisplayStart + meta.row + 1;
	            }
         	 },{
         		 targets : 0,
         		 visible : false
         	 },{
         		targets : 6,
         		render : function( data, type, row, meta){
         			return "<button>edit</button>";
         		}
         	 }
         ]
    });
    
   
    
});
</script>
</body>
</html>