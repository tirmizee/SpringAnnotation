<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/select2/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-green.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/buttons.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/colReorder.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/responsive.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">


<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/select2/js/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.colReorder.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/js/bootstrap-toggle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>

<style >
.toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px;height:  }
.toggle.ios .toggle-handle { border-radius: 20px; }
div.dt-buttons {
    position: relative;
    float: right;
}
</style>
  <title>Permission</title>
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
          <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
          <li class="active">Dashboard</li>
        </ol>
      </section>
		
      <!-- Main content -->
      <section class="content">
      	<div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Search</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        
        <div class="box-body">
        <form id="frmSearchUser" role="form">
          <div class="row">
          	<div class="col-md-6">
          	  <div class="form-group">
                <label>Firstname</label>
                <input name="firstName" type="text" class="form-control"  placeholder="Username">
              </div>
           	</div>
           	<div class="col-md-6">
          	  <div class="form-group">
                <label>Lastname</label>
                <input name="lastName" type="text" class="form-control"  placeholder="Fullname">
              </div>
           	</div>
          </div>
          <!-- /.row -->
          <div class="row">
          	<div class="col-md-6">
          	 <div class="form-group">
                <label>Username</label>
                <input name="userName" type="text" class="form-control"  placeholder="Username">
              </div>
          	</div>
          	<div class="col-md-6">
          	  <div class="form-group">
                <label>Status</label>
                <select name="status" class="form-control select2" style="width: 100%;">
                  <option value="" selected="selected">All</option>
                  <option value="A">Active</option>
                  <option value="I">Inactive</option>
                </select>
              </div>
          	</div>
          </div>
          
          <div class="row text-center">
            <button id="btnClear" type="button" class="btn btn-default">Clear</button>
            <button id="btnSearch" type="submit" class="btn bg-olive">Search</button>
          </div>
         
         </form>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          One of the best ways to learn how to do anything new (including software APIs!) is to get your hands dirty
        </div>
      </div>
      <!-- /.box box-default-->
      	<div class="box">
            <div class="box-body">
             <table id="example" class="display nowrap" cellspacing="0" width="100%"></table>
            </div><!-- /.box-body -->
      	</div><!-- /.box -->
          
		

      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
	
	
	
   <jsp:include page="../template/footer.jsp" />

    <!-- /.control-sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->




<div id="modalView" class="modal fade bd-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" >
  <div class="modal-dialog modal-md" >
    <div class="modal-content" style="border-radius: 10px;">
     <div class="box box-info">
            <div class="box-header">
              <h3 class="box-title">View User</h3>
            </div>
            <div class="box-body">
              <div class="form-group">
                <label>Username</label>
                <input name="viewUsername" type="text" class="form-control" disabled>
              </div>
              <!-- /.form group -->
              <div class="form-group">
                <label>Fullname</label>
                <input name="viewFullname" type="text" class="form-control" disabled>
              </div>
             
              <!-- /.form group -->
              <div class="form-group">
                <label>Create Date</label>
                <input name="viewCreateDate" type="text" class="form-control" disabled>
              </div>
              <!-- /.form group -->
              <div class="form-group">
                <label>Status</label>
                <input name="viewStatus" type="text" class="form-control" disabled>
              </div>
              <!-- /.form group -->
              <div class="form-group">
                <button id="btnCloseView" class="btn btn-default pull-right">close</button>
              </div>
              <!-- /.form group -->
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
    </div>
  </div>
</div>



<div id="modalEdit" class="modal fade bd-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" >
  <div class="modal-dialog modal-md" >
    <div class="modal-content" style="border-radius: 10px;">
     <div class="box box-success">
      <div class="box-header">
        <h3 class="box-title">Edit User</h3>
      </div>
      <div class="box-body">
        <form id="frmEdit">
          <div class="form-group">
            <label>Username</label>
            <input name="editUsername" type="text" class="form-control" >
          </div>
          
          <!-- /.form group -->
          <div class="form-group">
            <label>Firstname</label>
            <input name="editFirstname" type="text" class="form-control" >
          </div>
          
          <!-- /.form group -->
          <div class="form-group">
            <label>Lastname</label>
            <input name="editLastname" type="text" class="form-control" >
          </div>
          
          <!-- /.form group -->
          <div class="form-group">
            <label>Status</label>
            <select name="editStatus" class="form-control select2" style="width: 100%;">
              <option value="A">Active</option>
              <option value="I">Inactive</option>
            </select>
          </div>
          
          <!-- /.form group -->
          <div class="form-group">
            <div class="row text-center">
              <button id="btnCloseEdit" type="button" class="btn btn-default">close</button>
              <button id="btnSaveEdit" type="submit" class="btn bg-olive">Save</button>
            </div>
          </div>
          <!-- /.form group -->
        </form>
      </div>
      <!-- /.box-body -->
    </div>
    <!-- /.box -->
  </div>
 </div>
</div>


<div class="modal fade" id="modalDelete">
  <div class="modal-dialog">
    <div class="modal-content"  style="border-radius: 10px;">
      <div class="box box-danger">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Confirm Delete Data</h4>
	      </div>
	      <div class="modal-body">
	        <p>Are you sure to delete data</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
	        <button id="btnDelete" type="button" class="btn btn-danger">Delete</button>
	      </div>
	   </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
  


<script>



var AjaxManager = {
	RootUrl: 'http://localhost:8080/SpringAnnotation',
	PostData : function (objToPost, postUri, onPostSuccess, onPostError) {
        $.ajax({
            type: 'POST',
            url: postUri,
            contentType: 'application/json',
            headers: {
                'Accept': 'application/json'
            },
            data: JSON.stringify(objToPost)
        }).done(function (objRet) {
            onPostSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            onPostError(jqXHR, textStatus, errorThrown);
        });
    },
    GetData: function (objToGet, getUri, onGetSuccess, onGetError) {
        $.ajax({
            type: 'GET',
            url: getUri,
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            headers: {
            	'Accept': 'application/json'
            },
            data: objToGet,
        }).done(function (objRet) {
            onGetSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            onGetError(jqXHR, textStatus, errorThrown);
        });
    }
};

var SpringPermission = function() {
	
	// init global variables
	var curSearchParam = {};
	var curEditData = {};
	var curDeleteData = {};
	
	
	// commons function
	
	
	// setting function
	var handleFormEdit = function() {
		$('#frmEdit').formValidation({
	        framework: 'bootstrap',
	        excluded: ':disabled',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	editUsername: {
	                validators: {
	                    notEmpty: {
	                        message: 'The username is required'
	                    }  
	                }
	            },
	            editFirstname: {
	                validators: {
	                    notEmpty: {
	                        message: 'The firstname is required'
	                    }
	                }
	            },
	            editLastname: {
	                validators: {
	                    notEmpty: {
	                        message: 'The lastname is required'
	                    }
	                }
	            }
	        }
	    })  
	    .on('success.form.fv', function(e) {
            e.preventDefault();
            
            curEditData.username = $('input[name="editUsername"]').val();
			curEditData.firstname = $('input[name="editFirstname"]').val();
			curEditData.lastname = $('input[name="editLastname"]').val();
			curEditData.status = $('select[name="editStatus"]').select2("val");
			
			/* AjaxManager.PostData(curEditData ,AjaxManager.RootUrl + '/service/user/update',function(response){
			
			});  */
			
			AjaxManager.PostData(curEditData ,AjaxManager.RootUrl + '/service/user/update',function(response){
				$('#modalEdit').modal('hide');
				console.log(response);
				swal({
					  type: 'success',
					  title: 'แก้ไขข้อมูล สำเร็จ',
					  showConfirmButton: false,
					  timer: 2000
					})
				$('#example').DataTable().ajax.reload(null, false );
			}); 
			
            fv.defaultSubmit();
        });;
	}
	
	var handleDataTable = function() {
		var btnPermission = '<button data-btn-name="btnPermission" type="button" class="btn btn-warning" data-toggle="tooltip" title="Edit!"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>';
		var btnEdit = '<button data-btn-name="btnEdit" type="button" class="btn btn-success" data-toggle="tooltip" title="Edit!"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>';
		var btnDelete = '<button data-btn-name="btnDelete" type="button" class="btn btn-danger" data-toggle="tooltip" title="Delete!"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>';
		var btnInfo = '<button data-btn-name="btnInfo" type="button" class="btn btn-info" data-toggle="tooltip" title="View!"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></button>';
		var btnToggle = function (row) {
			return '<input data-btn-name="btnToggle" type="checkbox" '+(row.status === "A" ? "checked" :"")+' data-toggle="toggle" data-on="Active" data-off="Inavtive" data-onstyle="success" data-offstyle="danger" data-style="ios"  data-size="small" readonly>';
		}
		
		var dataTable = $('#example').DataTable( {
	        processing  : true,
	        responsive  : true,
	        select      : true,
	        serverSide  : true,
	        searching   : false,
	        dom         : 'Bfrtip',
	        initComplete: function () {
	        	$('.dt-buttons').html('<button type="button" class="btn bg-orange btn-flat margin">Create User</button>')
	        },
	        buttons: [
	            {
	                text: 'Create User',
	                action: function ( e, dt, node, config ) {
	                    alert( 'Button activated' );
	                }
	            }
	        ],
	        colReorder  : {
								fixedColumnsLeft: 1,
						        fnReorderCallback : function () {
						        	$('input[data-btn-name="btnToggle"]').each(function(){
						     			$(this).bootstrapToggle();
						     		});
							 	}
							},
			drawCallback : function( settings ) {
				$('input[data-btn-name="btnToggle"]').each(function(){
	     			$(this).bootstrapToggle();
	     		});
		    },
	        ajax : {
	            url  : "../service/user/findAll",
	            type : "POST",
	            contentType: 'application/json',
	            data : function ( d ) {
	            	d.search.userName = curSearchParam.userName;
	            	d.search.firstName = curSearchParam.firstName;
	            	d.search.lastName = curSearchParam.lastName;
	            	d.search.status = curSearchParam.status;
	                return JSON.stringify(d);
	            },
				error: function (xhr, textStatus, errorThrown) {
				    switch (xhr.status) {
				  	  	case 302: alert(JSON.stringify(xhr));break;
				    	case 404: alert(JSON.stringify(xhr));break;
				    }
				}
	        },
	        columns : [ 
	            { data : "id" },
	            { data : null          ,title :"ลำดับ" },
	            { data : "username"    ,title :"ชื่อผู้ใช้" },
	            { data : "fullname"    ,title :"ชื่อ-สกุล" },
	            { data : "create_date" ,title:"วันที่สร้าง" },
	            { data : "status"      ,title:"สถานะ"  },
	            { data : null }
	        ],
	        columnDefs : [
	            {
		        	targets  : 1,
		        	orderable : false,
		           	render   : function ( data, type, row, meta ) {
		             	return meta.settings._iDisplayStart + meta.row + 1;
		            }
	         	 },
	         	 {
	         		 targets : 0,
	         		 visible : false
	         	 
	         	 },
	         	 {
	         		 targets : 5,
	         		 width   : "10%",
		             render   : function ( data, type, row, meta ) {
		             	return btnToggle(row);
		             }
	         	 
	         	 },
	         	 {
	         		 targets   : 6,
	         		 className : "dt-right",
	         		 orderable : false,
		           	 render    : function ( data, type, row, meta ) {
		             	return btnPermission + ' ' + btnInfo + ' ' + btnEdit + ' ' + btnDelete;
		             }
	         	 
	         	 }
	         ], 
	         fnDrawCallback : function( oSettings ) {
	        	$('button[data-btn-name="btnEdit"]').tooltip();    	
	        	$('input[data-btn-name="btnToggle"]').each(function(){
	     			$(this).bootstrapToggle();
	     		});
	        	
	         }
	    });
		
		// handle button info for table
		$(document).on('click', 'button[data-btn-name="btnInfo"]', function () {
			var data = dataTable.row( $(this).parents('tr') ).data();
			console.log(JSON.stringify(data,undefined,4));
			$('input[name="viewUsername"]').val(data.username);
			$('input[name="viewFullname"]').val(data.fullname);
			$('input[name="viewCreateDate"]').val(data.create_date);
			$('input[name="viewStatus"]').val(data.status === 'A' ? 'Active' : 'Inactive');
			$('#modalView').modal('show');
		});
		
		// handle button edit for table
		$(document).on('click', 'button[data-btn-name="btnEdit"]', function () {
			$('#frmEdit').formValidation('resetForm', true);
			curEditData = dataTable.row( $(this).parents('tr') ).data();
			console.log(JSON.stringify(curEditData,undefined,4));
			$('input[name="editUsername"]').val(curEditData.username);
			$('input[name="editFirstname"]').val(curEditData.firstname);
			$('input[name="editLastname"]').val(curEditData.lastname);
			$('select[name="editStatus"]').select2("val", curEditData.status);
			$('#modalEdit').modal('show');
		});
		
		// handle button delete for table
		$(document).on('click', 'button[data-btn-name="btnDelete"]', function () {
			curDeleteData = dataTable.row( $(this).parents('tr') ).data();
			console.log(JSON.stringify(curDeleteData,undefined,4));
			$('#modalDelete').modal('show');
		});
		
		// handle button toggle for table
		$(document).on('change', 'input[data-btn-name="btnToggle"]', function (e) {
			var data = dataTable.row( $(this).parents('tr') ).data();
			data.status = data.status === "I" ? "A" : "I";
			AjaxManager.PostData({id : data.id , status : data.status},AjaxManager.RootUrl + '/service/user/updateStatus',function(reponse){
				if (reponse) {
					$('#example').DataTable().ajax.reload(null, false );
					swal({
						  type: 'success',
						  title: 'แก้ไขสถานนะของ ' + data.fullname + ' สำเร็จ',
						  showConfirmButton: false,
						  timer: 2000
						})
				}else{
					$('#example').DataTable().ajax.reload(null, false);
					swal({
						  type: 'error',
						  title: 'แก้ไขสถานนะของ ' + data.fullname + ' ล้มเหลว',
						  showConfirmButton: false,
						  timer: 2000
						},
						  function(){
							$(this).prop('checked', false).change();
						  })
				}
			});
			
		});
	}
	
	var handleSelect2 = function(){
		 $('.select2').select2();
	}
	
	var handleButtonSearch = function() {
		$('#btnSearch').on('click',function(e){
			e.preventDefault()
			curSearchParam.userName = $('input[name="userName"]').val();
			curSearchParam.firstName = $('input[name="firstName"]').val();
			curSearchParam.lastName = $('input[name="lastName"]').val();
			curSearchParam.status = $('select[name="status"]').val();
			console.log(JSON.stringify(curSearchParam,undefined,4));
			$('#example').DataTable().ajax.reload();
		});
	}
	
	var handleButtonClear = function () {
		$('#btnClear').on('click',function(){
			$('#frmSearchUser')[0].reset();
			$('select[name="status"]').trigger('change.select2'); 
		});
	}
	
	var handleButtonCloseView = function() {
		$('#btnCloseView').on('click',function(){
			$('#modalView').modal('hide');
		});
	}
	
	var handleButtonCloseEdit = function () {
		$('#btnCloseEdit').on('click',function(){
			$('#modalEdit').modal('hide');
		});
	}
	
	var handleButtonDelete = function(){
		$('#btnDelete').on('click',function(){
			AjaxManager.GetData({},AjaxManager.RootUrl + '/service/user/delete/' + curDeleteData.id ,function(response){
				$('#modalDelete').modal('hide');
				if(response){
					swal({ type: 'success',  title: 'ลบข้อมูล สำเร็จ'   , showConfirmButton: false, timer: 2000 });
				}else{
					swal({ type: 'error'  ,  title: 'ลบข้อมูล ล้มเหลว'  , showConfirmButton: false, timer: 2000 });
				}
				$('#example').DataTable().ajax.reload();
			},function (jqXHR, textStatus, errorThrown) {
				 switch (jqXHR.status) {
			        case 404: alert(JSON.stringify(jqXHR));break;
			    }
			});
		});
	}
	
	var handleActiveMenu = function() {
		 $('ul.sidebar-menu > li.menu-role').addClass('active');
		 $('ul.sidebar-menu > li.menu-role > ul.treeview-menu > li.test').addClass('active');
	}
	
	return { 
		init : function(){
			handleActiveMenu();
			handleFormEdit();
			handleDataTable();
			handleSelect2();
			handleButtonSearch();
			handleButtonClear();
			handleButtonCloseView();
			handleButtonCloseEdit();
			handleButtonDelete();
		}
	};
	
	
}();

$(document).ready(function() {
	SpringPermission.init();
});

</script>
</body>
</html>