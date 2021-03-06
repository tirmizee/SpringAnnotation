  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${user.firstName} ${user.lastName}</p>
          <a href="">${user.username}</a>
        </div>
      </div>
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview menu-index"><a href="${pageContext.request.contextPath}/admin"><i class="fa fa-globe " style="height: 20px;"></i> <span>Main</span></a></li>
        <li class="treeview menu-role" >
          <a href="#">
            <i class="fa fa-briefcase" style="height: 20px;"></i>
            <span>Role Management</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right" ></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="test"><a href="${pageContext.request.contextPath}/admin/test"><i class="fa fa-circle-o"></i> test </a></li>
          	 <li class="permission"><a href="${pageContext.request.contextPath}/admin/permission"><i class="fa fa-circle-o"></i> Assign Permission </a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart" style="height: 20px;"></i>
            <span>Report</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu" style="display: none;">
            <li><a href="chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
            <li class="active"><a href="morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
          </ul>
        </li>
        <li class="treeview menu-setting" >
          <a href="#">
            <i class="fa fa-gear" style="height: 20px;"></i>
            <span>Setting</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right" ></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="session"><a href="${pageContext.request.contextPath}/admin/session"><i class="fa fa-circle-o"></i> Session </a></li>
           
          </ul>
        </li>
        
       </ul>
       
         
    </section>
    <!-- /.sidebar -->
  </aside>