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
  <link rel="stylesheet" href="resources/libs/admin-lte2/css/skins/skin-green.min.css">
  <link rel="stylesheet" href="resources/libs/validate-form-master/css/formValidation.min.css">


  <script src="resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
  <script src="resources/libs/bootstrap/js/bootstrap.min.js" ></script>
  <script src="resources/libs/admin-lte2/js/app.js"></script>
  <script src="resources/libs/validate-form-master/js/formValidation.min.js"></script>
  <script src="resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
  <script src="resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
  <style >

  </style>
  <title>Hello JSP</title>
</head>
<body class="hold-transition skin-green sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../tenplate/header.jsp" />
    <jsp:include page="../tenplate/menu_sidebar_admin.jsp" />


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
<button id="btn">click</button>
<form id="bookForm" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="col-xs-1 control-label">Book</label>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="book[0].title" placeholder="Title" />
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="book[0].isbn" placeholder="ISBN" />
        </div>
        <div class="col-xs-2">
            <input type="text" class="form-control" name="book[0].price" placeholder="Price" />
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-default addButton"><i class="fa fa-plus"></i></button>
        </div>
    </div>

    <!-- The template for adding new field -->
    <div class="form-group hide" id="bookTemplate">
        <div class="col-xs-4 col-xs-offset-1">
            <input type="text" class="form-control" name="title" placeholder="Title" />
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="isbn" placeholder="ISBN" />
        </div>
        <div class="col-xs-2">
            <input type="text" class="form-control" name="price" placeholder="Price" />
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-default removeButton"><i class="fa fa-minus"></i></button>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-5 col-xs-offset-1">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>

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
	
	

	$('#btn').on('click',function(){
		alert($("input[name='dueDate[]']").val());
	});
	
	var list = [];
	  var titleValidators = {
	            row: '.col-xs-4',   // The title is placed inside a <div class="col-xs-4"> element
	            validators: {
	                notEmpty: {
	                    message: 'The title is required'
	                }
	            }
	        },
	        isbnValidators = {
	            row: '.col-xs-4',
	            validators: {
	                notEmpty: {
	                    message: 'The ISBN is required'
	                },
	                isbn: {
	                    message: 'The ISBN is not valid'
	                }
	            }
	        },
	        priceValidators = {
	            row: '.col-xs-2',
	            validators: {
	                notEmpty: {
	                    message: 'The price is required'
	                },
	                numeric: {
	                    message: 'The price must be a numeric number'
	                }
	            }
	        },
	        bookIndex = 0;

	    $('#bookForm')
	        .formValidation({
	            framework: 'bootstrap',
	            icon: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
	            fields: {
	                'book[0].title': titleValidators,
	                'book[0].isbn': isbnValidators,
	                'book[0].price': priceValidators
	            }
	        })

	        // Add button click handler
	        .on('click', '.addButton', function() {
	            bookIndex++;
	            var $template = $('#bookTemplate'),
	                $clone    = $template
	                                .clone()
	                                .removeClass('hide')
	                                .removeAttr('id')
	                                .attr('data-book-index', bookIndex)
	                                .insertBefore($template);

	            // Update the name attributes
	            $clone
	                .find('[name="title"]').attr('name', 'book[' + bookIndex + '].title').end()
	                .find('[name="isbn"]').attr('name', 'book[' + bookIndex + '].isbn').end()
	                .find('[name="price"]').attr('name', 'book[' + bookIndex + '].price').end();

	            // Add new fields
	            // Note that we also pass the validator rules for new field as the third parameter
	            $('#bookForm')
	                .formValidation('addField', 'book[' + bookIndex + '].title', titleValidators)
	                .formValidation('addField', 'book[' + bookIndex + '].isbn', isbnValidators)
	                .formValidation('addField', 'book[' + bookIndex + '].price', priceValidators);
	        })

	        // Remove button click handler
	        .on('click', '.removeButton', function() {
	            var $row  = $(this).parents('.form-group'),
	                index = $row.attr('data-book-index');
	            list = list.slice(index, 1).clean("{}"); 
	            // Remove fields
	            $('#bookForm')
	                .formValidation('removeField', $row.find('[name="book[' + index + '].title"]'))
	                .formValidation('removeField', $row.find('[name="book[' + index + '].isbn"]'))
	                .formValidation('removeField', $row.find('[name="book[' + index + '].price"]'));

	            // Remove element containing the fields
	            $row.remove();
	        })
     .on('success.form.fv', function(e) {
            e.preventDefault();
            list = [];
            for (var i = 0; i < bookIndex+1; i++) {
            	list.push({
        			title : $("input[name='book[" + i + "].title']").val()
        		});
			}
            $.ajax({
            	  method: "POST",
            	  url: "service/test",
            	  contentType: 'application/json',
            	  data : list,
            	  success : function (data) {
						alert(data);
					}
            });

     });

});
</script>
</body>
</html>