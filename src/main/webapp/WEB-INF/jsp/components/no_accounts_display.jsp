<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Container: No Accounts -->
    <div class="container">
        <!-- Card : No accounts -->
        <div class="card no-accounts-card">
            <!-- Card Body -->
            <div class="card-body">
                <!-- Card Title -->
                <h1 class="card-title">
                    <i class="fas fa-ban text-danger"></i>No Registered Accounts
                </h1>
                <!--End of Card Title -->
                <br>
                <!-- Card Text -->
                <div class="card-text">
                    You currently do not have any registered accounts. <br>
                    Please click below to register / add a new account.
                </div>
                <!--End of Card Text -->
                <br>
                <button id="" class="btn btn-primary btn-lg shadow" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                    <i class="fa fa-credit-card"></i> Add new account
                </button>

            </div>
            <!--End of Card Body -->
        </div>
        <!--End of Card : No accounts -->

    </div>
    <!--End of Container: No Accounts -->