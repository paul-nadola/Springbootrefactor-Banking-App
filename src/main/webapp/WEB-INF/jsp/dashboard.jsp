<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome-free-6.5.1-web/css/all.css">
    <link rel="stylesheet" href="../css/main.css">
    <!-- <script src="./js/bootstrap.bundle.js"></script> -->
    <title>Dashboard</title>
</head>
<body>
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

    <!-- Start of Transact ffcanvas -->
    <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasExampleLabel">Transact</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <!-- Offcanvas: Transact Body -->
        <div class="offcanvas-body">
            <small class="card-text">
                Choose an option below to perform a transaction
            </small>
            <!--Transaction type Drop Down List-->
                <select name="transact-type" class="form-control my-3" id="transact-type">
                    <option value="">--Select Transaction Type--</option>
                    <option value="payment">Payment</option>
                    <option value="transfer">Transfer</option>
                    <option value="deposit">Deposit</option>
                    <option value="withdraw">Withdrawal</option>
                </select>
            <!--End of Transaction type Drop Down List-->

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

                <!-- Card deposit Card -->
                <div class="card deposit-card">
                    <!-- Card Body -->
                    <div class="card-body">
                       <!--Deposit Form-->
                       <form action="" class="deposit-form">
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

                <!-- Card withdrawal Card -->
                <div class="card withdraw-card">
                    <!-- Card Body -->
                    <div class="card-body">
                        <!--withdraw Form-->
                        <form action="" class="withdraw-form">
                            <!-- Form Group -->
                            <div class="form-group mb-2">
                                <label for="">Enter Withdrawal amount</label>
                                <input type="text" name="withdraw_amount" class="form-control" placeholder="Enter Withdrawal amount">
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
        </div>
        <!--End of Offcanvas: Transact Body -->
    </div>
    <!--End of Transact offcanvas -->


    <!-- Display Accounts -->

    <!--Do not Display Accounts -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/main.js"></script>
</body>
</html>