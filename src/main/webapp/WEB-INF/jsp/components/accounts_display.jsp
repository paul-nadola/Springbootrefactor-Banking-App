<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!--Container-->
    <div class="container d-flex">

        <button id="add-account-btn" class="btn btn-lg shadow" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
            aria-controls="offcanvasRight">
            <i class="fa fa-credit-card"></i> Add new account
        </button>

        <!-- Transaction button -->
        <button id="transact-btn" class="btn btn-lg ms-auto shadow" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
            aria-controls="offcanvasExample">
            <i class="fa fa-wallet"></i> Transact
        </button>
        <!--End of Transaction button -->



    </div>
    <!--End of Container-->

    <!--Container : Total Accounts-->
    <!--Container : Total Accounts Balance Display-->

    <div class="container d-flex py-3">
        <h2 class="me-auto">
            Total Account Balance
        </h2>
        <h2 class="ms-auto">
            <c:if test="${requestScope.totalBalance != null}">
                <c:out value="${totalBalance}" />
            </c:if>
        </h2>
    </div>

    <!--End of Container : Total Accounts Balance Display-->
    <!--End of Container : Total Accounts-->

    <!-- Container: Accordion Home / Drop down -->
    <div class="container">
        <!--Accordian Menu Drop Down-->
            <c:if test="${requestScope.userAccounts != null}">

                <c:forEach items="${requestScope.userAccounts}" var="account">
                    <div class="accordion accordion-flush" id="accordionFlushExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#flush-${account.account_id}" aria-expanded="false" aria-controls="flush-collapseOne">
                                    ${account.account_name}
                                </button>
                            </h2>
                            <div id="flush-${account.account_id}" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                                <div class="accordion-body">
                                    <!-- Account Details List -->
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item d-flex">Account Name <span class="ms-auto"><b>${account.account_name}</b></span></li>
                                        <li class="list-group-item d-flex">Account Number <span class="ms-auto"><b>${account.account_number}</b></span></li>
                                        <li class="list-group-item d-flex">Account Type <span class="ms-auto"><b>${account.account_type}</b></span></li>
                                        <li class="list-group-item d-flex">Account Balance <span class="ms-auto"><b>${account.balance}</b></span></li>
                                        <li class="list-group-item d-flex">Created at <span class="ms-auto"><b>${account.created_at}</b></span></li>
                                    </ul>
                                    <!-- Account Details List -->
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </c:if>
        <!--End of Accordian Menu Drop Down-->
    </div>
    <!-- End of Container: Accordion Home / Drop Down -->