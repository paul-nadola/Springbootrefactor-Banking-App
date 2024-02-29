<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Card withdrawal Card -->
<div class="card withdraw-card">
    <!-- Card Body -->
    <div class="card-body">
        <!--withdraw Form-->
        <form action="/transact/withdraw" method="POST" class="withdraw-form">
            <!-- Form Group -->
            <div class="form-group mb-2">
                <label for="">Enter Withdrawal amount</label>
                <input type="text" name="withdrawal_amount" class="form-control" placeholder="Enter Withdrawal amount">
            </div>
            <!--End of Form Group -->
             <!-- Form Group -->
            <div class="form-group">
                <label for="">Select Account</label>
                <!--Select Account Options-->
                <select name="account_id" class="form-control my-3" id="">
                    <option value="">--Select Account You Are Withdrawing From--</option>
                    <c:if test="${userAccounts != null}">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <!--End of Select Account Options-->
            </div>
            <!-- End of Form Group -->

            <!-- Form Group -->
            <div class="form-group my-2">
                <button id="" class="btn btn-md transact-btn">Withdraw</button>
            </div>
            <!--End of Form Group -->
        </form>
        <!--End of withdraw Form-->
    </div>
    <!--End of Card Body -->
</div>
<!--End of Card withdrawal Card -->