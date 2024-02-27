<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Card deposit Card -->
<div class="card deposit-card">
    <!-- Card Body -->
    <div class="card-body">
       <!--Deposit Form-->
       <form action="/transact/deposit" method="POST" class="deposit-form">
        <!-- Form Group -->
        <div class="form-group mb-2">
            <label for="">Enter deposit amount</label>
            <input type="text" name="deposit_amount" class="form-control" placeholder="Enter deposit amount">
        </div>
        <!--End of Form Group -->
        <!-- Form Group -->
        <div class="form-group">
            <label for="">Select Account</label>
            <!--Select Account Options-->
            <select name="account_id" class="form-control my-3" id="">
                <option value="">--Select Account--</option>
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
            <button id="" class="btn btn-md transact-btn">Deposit</button>
        </div>
        <!--End of Form Group -->
       </form>
       <!--End of Deposit Form-->
    </div>
    <!--End of Card Body -->
    </div>
<!--End of Card deposit Card -->
