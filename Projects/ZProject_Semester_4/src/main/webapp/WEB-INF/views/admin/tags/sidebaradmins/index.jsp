 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

                    <!-- Brand Logo -->
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="brand-link">
      <img src="${pageContext.request.contextPath}/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${pageContext.request.contextPath}/assets/uploads/${accountUsername.avatar }" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="${pageContext.request.contextPath}/admin/profile/index?accountId=${accountUsername.accountId }" class="d-block">${accountUsername.fullname }</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
         
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/account" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Accounts
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/role" class="nav-link">
              <i class="nav-icon fas fa-user-tag"></i>
              <p>
                Roles
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/email" class="nav-link">
              <i class="nav-icon far fa-envelope"></i>
              <p>
                Emails
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/pay" class="nav-link">
              <i class="nav-icon fas fa-dollar-sign"></i>
              <p>
                Pays
                <span class="right badge badge-danger">New</span>
              </p>         
            </a>
          </li>
         <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/pack" class="nav-link">
              <i class="nav-icon fas fa-dollar-sign"></i>
              <p>
                Packs
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/category" class="nav-link">
              <i class="nav-icon fas fa-dollar-sign"></i>
              <p>
                Categories
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/quiz" class="nav-link">
              <i class="nav-icon fas fa-dollar-sign"></i>
              <p>
                Quizzes
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
              <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/ratingandcomment" class="nav-link">
              <i class="nav-icon fas fa-dollar-sign"></i>
              <p>
                Rating and Comment
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>

        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
    