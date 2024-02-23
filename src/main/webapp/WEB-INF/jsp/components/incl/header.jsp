<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!--Main Page Header-->
    <header class="main-page-header mb-3 bg-primary">
        <!--Container-->
        <div class="container d-flex align-items-center">
            <div class="company-name">
            <!-- Company Name -->
            Easy-Way Bank
            <!-- End of Company Name -->
        </div>
        <!--Navigation-->
        <nav class="navigation">
            <li><a href="">Dashboard</a></li>
            <li><a href="">Payment History</a></li>
            <li><a href="">Transaction History</a></li>
        </nav>
        <!--End of Navigation-->

        <!-- Display Name -->

        <div class="display-name ms-auto text-white">
            <i class="fa fa-circle text-success me-2"></i>Welcome <span>Nadola</span>
        </div>

        <!-- End of Display Name -->

        <!--Logout button-->
        <a href="" class="btn btn-sm text-white ms-2">
            <i class="fa fa-sign-out me-2">Sign Out</i>
        </a>
        <!--End of Logout button-->

        </div>
        <!--End of Container-->
    </header>

    <!--End of Main Page Header-->
