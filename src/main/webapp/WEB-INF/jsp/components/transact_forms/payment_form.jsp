 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

 <!-- Card Payment Card -->
    <div class="card payment-card">
        <!-- Card Body -->
        <div class="card-body">
            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Beneficiary Account Holder</label>
                <input type="text" name="beneficiary" class="form-control" placeholder="Enter Account holder / Beneficiary name">
            </div>
            <!--End of Form Group -->
            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Beneficiary Account number</label>
                <input type="text" name="account_number" class="form-control" placeholder="Enter Account holder / Beneficiary number">
            </div>
            <!--End of Form Group -->

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
                <label for="">Reference</label>
                <input type="text" name="reference" class="form-control" placeholder="Enter Reference">
            </div>
            <!--End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Enter Payment Amount</label>
                <input type="text" name="payment_amount" class="form-control"
                    placeholder="Enter Payment Amount">
            </div>
            <!--End of Form Group -->

            <!-- Form Group -->
            <div class="form-group mb-2">
                <button id="" class="btn btn-md transact-btn">Pay</button>
            </div>
            <!--End of Form Group -->

        </div>
        <!--End of Card Body -->
    </div>
<!--End of Card Payment Card -->