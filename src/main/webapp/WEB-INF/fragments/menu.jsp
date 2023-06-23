<!-- Navbar -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<%
String user = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
for(Cookie cookie : cookies){
if(cookie.getName().equals("user")) user = cookie.getValue();
if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" data-widget="pushmenu"
                                href="#" role="button"><i class="fas fa-bars"></i></a></li>
        <li class="nav-item d-none d-sm-inline-block"><a href="home.jsp"
                                                         class="nav-link">Home</a></li>
        <li class="nav-item d-none d-sm-inline-block"><a href="#"
                                                         class="nav-link">Contact</a></li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
        <!-- Navbar Search -->
        <li class="nav-item"><a class="nav-link"
                                data-widget="navbar-search" href="#" role="button"> <i
                    class="fas fa-search"></i>
            </a>
            <div class="navbar-search-block">
                <form class="form-inline">
                    <div class="input-group input-group-sm">
                        <input class="form-control form-control-navbar" type="search"
                               placeholder="Search" aria-label="Search">
                        <div class="input-group-append">
                            <button class="btn btn-navbar" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                            <button class="btn btn-navbar" type="button"
                                    data-widget="navbar-search">
                                <i class="fas fa-times"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div></li>

        <!-- Messages Dropdown Menu -->
        <li class="nav-item dropdown"><a class="nav-link"
                                         data-toggle="dropdown" href="#"> <i class="far fa-comments"></i>
                <span class="badge badge-danger navbar-badge">3</span>
            </a>
            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                <a href="#" class="dropdown-item"> <!-- Message Start -->
                    <div class="media">
                        <img src="./adminlte/img/user1-128x128.jpg" alt="User Avatar"
                             class="img-size-50 mr-3 img-circle">
                        <div class="media-body">
                            <h3 class="dropdown-item-title">
                                Brad Diesel <span class="float-right text-sm text-danger"><i
                                        class="fas fa-star"></i></span>
                            </h3>
                            <p class="text-sm">Call me whenever you can...</p>
                            <p class="text-sm text-muted">
                                <i class="far fa-clock mr-1"></i> 4 Hours Ago
                            </p>
                        </div>
                    </div> <!-- Message End -->
                </a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item"> <!-- Message Start -->
                    <div class="media">
                        <img src="./adminlte/img/user8-128x128.jpg" alt="User Avatar"
                             class="img-size-50 img-circle mr-3">
                        <div class="media-body">
                            <h3 class="dropdown-item-title">
                                John Pierce <span class="float-right text-sm text-muted"><i
                                        class="fas fa-star"></i></span>
                            </h3>
                            <p class="text-sm">I got your message bro</p>
                            <p class="text-sm text-muted">
                                <i class="far fa-clock mr-1"></i> 4 Hours Ago
                            </p>
                        </div>
                    </div> <!-- Message End -->
                </a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item"> <!-- Message Start -->
                    <div class="media">
                        <img src="./adminlte/img/user3-128x128.jpg" alt="User Avatar"
                             class="img-size-50 img-circle mr-3">
                        <div class="media-body">
                            <h3 class="dropdown-item-title">
                                Nora Silvester <span class="float-right text-sm text-warning"><i
                                        class="fas fa-star"></i></span>
                            </h3>
                            <p class="text-sm">The subject goes here</p>
                            <p class="text-sm text-muted">
                                <i class="far fa-clock mr-1"></i> 4 Hours Ago
                            </p>
                        </div>
                    </div> <!-- Message End -->
                </a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item dropdown-footer">See All
                    Messages</a>
            </div></li>
        <!-- Notifications Dropdown Menu -->
        <li class="nav-item dropdown"><a class="nav-link"
                                         data-toggle="dropdown" href="#"> <i class="far fa-user"></i>  
            </a>
            <div class="dropdown-menu dropdown-menu-md-right dropdown-menu-right">
                <span class="dropdown-header">Wellcom!</span>
                <div class="dropdown-divider"></div>
                <a href="ProfileServlet" class="dropdown-item"> <i
                        class="fas fa-user-minus"></i>  <span
                        class="float-center text-muted text-sm">Profile</span>
                </a>
                <a href="LogHistoryServlet" class="dropdown-item"> <i
                        class="fas fa-user-minus"></i>  <span
                        class="float-center text-muted text-sm">Log History</span>
                </a>
                <div class="dropdown-divider"></div>
                <a href="LogoutServlet" class="dropdown-item dropdown-footer"><i class="far fa-arrow-right"></i>LogOut</a>
            </div></li>
        <li class="nav-item"><a class="nav-link" data-widget="fullscreen"
                                href="#" role="button"> <i class="fas fa-expand-arrows-alt"></i>
            </a></li>
        <li class="nav-item"><a class="nav-link"
                                data-widget="control-sidebar" data-slide="true" href="#"
                                role="button"> <i class="fas fa-th-large"></i>
            </a></li>
    </ul>
</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link"> <img
            src="./adminlte/img/AdminLTELogo.png" alt="AdminLTE Logo"
            class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Future Jobs</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="./adminlte/img/user2-160x160.jpg" class="img-circle elevation-2"
                     alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block"> <%=user%></a>
            </div>
        </div>

        <!-- SidebarSearch Form -->
        <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search"
                       placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column"
                data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
with font-awesome or any other icon font library -->

                <!--for admin portal-->
                <li class="nav-item"><a href="#"
                                        class="nav-link active"> <i class="nav-icon fas fa-user"></i>
                        <p>
                            Admin <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <form method="GET" action="Admin" id="AdminAccountManagement">
                                <a href="#" 
                                   class="nav-link" id="AdminAccountManagementLink">  
                                    <p>Account Management</p>
                                </a>
                            </form>
                        </li>
                        <li class="nav-item">
                            <a href="ViewEmployer" class="nav-link">  
                                <p>Employer</p>
                            </a></li>
                        <li class="nav-item"><a href="ViewJobCategory"
                                                class="nav-link">  
                                <p>Job Category</p>
                            </a></li>
                        <li class="nav-item"><a href="ViewJob"
                                                class="nav-link">  
                                <p>Job</p>
                            </a></li> 

                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>Job Seeker</p>
                            </a></li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>Role Management</p>
                            </a></li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>Permition Management</p>
                            </a></li>
                    </ul>
                </li>

                <!--job seeker poratl-->
                <li class="nav-item"><a href="#"
                                        class="nav-link"> <i class="nav-icon fas fa-user"></i>
                        <p>
                            Pob Seeker <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item"><a href="./adduserform.jsp"
                                                class="nav-link"> 
                                <p>Job Seeker Registration</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>Job Seeker Acc Management</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>My Jobs</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>New Jobs</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">  
                                <p>Upload Resume</p>
                            </a>
                        </li>
                    </ul>
                </li>


                <!--employer portal--> 
                <li class="nav-item"><a href="#"
                                        class="nav-link"> <i class="nav-icon fas fa-user"></i>
                        <p>
                            Employer <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item"><a href="./adduserform.jsp"
                                                class="nav-link"> 
                                <p>Account Management</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">
                                <!--<i class="fas fa-users nav-icon"></i>-->
                                <p>My Account</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link">
                                <!--<i class="fas fa-users nav-icon"></i>-->
                                <p>Post Management</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link"> 
                                <!--<i class="fas fa-users nav-icon"></i>-->
                                <p>Job Applicant</p>
                            </a>
                        </li>
                    </ul>
                </li>


                <!-- for employer to manage sub account-->
                <li class="nav-item"><a href="#"
                                        class="nav-link"> <i class="nav-icon fas fa-user"></i>
                        <p>
                            Account Management <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item"><a href="./adduserform.jsp"
                                                class="nav-link"> <i class="fas fa-user-plus"></i>
                                <p>New Account</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link"> <i class="fas fa-users nav-icon"></i>
                                <p>Account Management</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link"> <i class="fas fa-users nav-icon"></i>
                                <p>Account Previlage</p>
                            </a>
                        </li>
                    </ul>
                </li>


                <!--employer sub-account portal-->
                <li class="nav-item"><a href="#"
                                        class="nav-link"> <i class="nav-icon fas fa-user"></i>
                        <p>
                            JOb <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item"><a href="./adduserform.jsp"
                                                class="nav-link"> <i class="fas fa-user-plus"></i>
                                <p>New Job</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link"> <i class="fas fa-users nav-icon"></i>
                                <p>Job Management</p>
                            </a>
                        </li>
                        <li class="nav-item"><a href="./viewuserform.jsp"
                                                class="nav-link"> <i class="fas fa-users nav-icon"></i>
                                <p>Applicants</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>


        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
<script>

    document.getElementById("AdminAccountManagementLink").addEventListener("click", function () {
        document.getElementById("AdminAccountManagement").submit();
    });
    document.getElementById("EmployerAccountManagementLink").addEventListener("click", function () {
        document.getElementById("EmployerAccountManagement").submit();
    });
</script>
