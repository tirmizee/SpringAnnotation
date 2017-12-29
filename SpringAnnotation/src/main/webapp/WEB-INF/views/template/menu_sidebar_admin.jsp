  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/admin.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${user}</p>
          <a href="">${user}</a>
        </div>
      </div>
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        
        <li class="active treeview" >
          <a href="#">
            <i class="fa fa-briefcase" style="height: 20px;"></i>
            <span>Role Management</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right" ></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/admin/permission"><i class="fa fa-circle-o"></i> permission </a></li>
           
          </ul>
        </li>
       
       </ul>
       
         
    </section>
    <!-- /.sidebar -->
  </aside>