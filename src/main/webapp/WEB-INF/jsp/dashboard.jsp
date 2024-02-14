<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome-free-6.5.1-web/css/all.css">
    <link rel="stylesheet" href="css/main.css">
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
    <!-- Right side Off Canvas: Accounts form container -->
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Create / Add an account</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <!-- Off canvas body: Accounts for wrapper -->
        <div class="offcanvas-body">
            <!--Card: Accounts Form Card-->
            <div class="card">
                <!-- Card Body -->
                <div class="card-body">
                    <form action="" class="add-account-form">

                        <!--Form Group-->
                        <div class="form-group mb-3">
                            <label for="">Enter Account Name</label>
                            <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
                        </div>
                        <!--End of Form Group-->

                        <!--Form Group-->
                        <div class="form-group mb-3">
                            <label for="">Select Account Type</label>
                            <select name="account_type" class="form-control" id="">
                                <option value="">-- Select Account Type --</option>
                                <option value="check">Check</option>
                                <option value="savings">Savings</option>
                                <option value="business">Business</option>
                            </select>
                        </div>
                        <!--End of Form Group-->

                        <!--Form Group-->
                        <div class="form-group mb-3">
                            <!-- Form Group -->
                            <div class="form-group my-2">
                                <button id="" class="btn btn-md transact-btn">Add Account</button>
                            </div>
                            <!--End of Form Group -->
                        </div>
                        <!--End of Form Group-->

                    </form>
                </div>
                <!--End of Card Body -->
            </div>
            <!--End of Card: Accounts Form Card-->
        </div>
        <!-- End of Off canvas body: Accounts for wrapper -->
    </div>
    <!-- End of Right side Off Canvas: Accounts form container -->

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
            0.00
        </h2>
    </div>

    <!--End of Container : Total Accounts Balance Display-->
    <!--End of Container : Total Accounts-->

    <!-- Container: Accordion Home / Drop down -->
    <div class="container">
    <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    Accordion Item #1
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the
                    <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    Accordion Item #2
                </button>
            </h2>
            <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the
                    <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being
                    filled with some actual content.</div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                    Accordion Item #3
                </button>
            </h2>
            <div id="flush-collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the
                    <code>.accordion-flush</code> class. This is the third item's accordion body. Nothing more exciting
                    happening here in terms of content, but just filling up the space to make it look, at least at first
                    glance, a bit more representative of how this would look in a real-world application.</div>
            </div>
        </div>
    </div>
    </div>
    <!-- End of Container: Accordion Home / Drop Down -->


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



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./js/main.js"></script>
</body>
</html>