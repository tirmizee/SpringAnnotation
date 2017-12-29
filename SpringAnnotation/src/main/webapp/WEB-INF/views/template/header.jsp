<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>T</b>MZ</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>TIRMI</b>ZEE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
     
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" class="user-image" alt="User Image">
              <span class="hidden-xs">${sessionScope.user.firstName} ${sessionScope.user.lastName}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" class="img-circle" alt="User Image">
                <p>
                  ${sessionScope.user.firstName} ${sessionScope.user.lastName} - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li> <!--end User image -->
           
             
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li><!-- end Menu Footer-->
            </ul>
          </li> <!--end User Account: style can be found in dropdown.less -->
          
          
        </ul>
      </div>  <!--end Navbar Right Menu -->

    </nav>
  </header>