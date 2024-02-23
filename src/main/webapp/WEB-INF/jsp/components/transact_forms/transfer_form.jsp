<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

 <!-- Card transfer Card -->
    <div class="card transfer-card">
        <!-- Card Body -->
        <div class="card-body">


            <!-- Form Group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!--Select Account Options-->
                <select name="account_id" class="form-control my-3" id="">
                    <option value="">--Select Account--</option>
                </select>
                <!--End of Select Account Options-->
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!--Select Account Options-->
                <select name="account_id" class="form-control my-3" id="">
                    <option value="">--Select Account--</option>
                </select>
                <!--End of Select Account Options-->
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Enter transfer Amount</label>
                <input type="text" name="transfer_amount" class="form-control" placeholder="Enter transfer Amount">
            </div>
            <!--End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <button id="" class="btn btn-md transact-btn">Transfer</button>
            </div>
            <!--End of Form Group -->

        </div>
        <!--End of Card Body -->
    </div>
<!--End of Card transfer Card -->