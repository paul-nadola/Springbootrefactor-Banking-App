<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome-free-6.5.1-web/css/all.css">
    <link rel="stylesheet" href="css/default.css">
    <title>Login</title>
</head>

<body class="d-flex align-items-center justify-content-center">
    <!-- Card Login Form -->
    <div class="card login-form-card col-4 bg-transparent border-0">
        <!-- Card Body -->
        <div class="card-body">
            <!--form header-->
            <h1 class="form-header card-title mb-3">
                <i class="fa fa-user-circle"></i> Login
            </h1>
            <!--End of form header-->

            <!--Login Form-->
            <form action="" class="login-form">


                <!--Form Group-->
                <div class="form-group col">
                    <input type="email" name="email" class="form-control form-control-lg"
                        placeholder="Enter Email Address" />
                </div>
                <!--End of Form Group-->
                <!--Form Group-->
                <div class="form-group col">
                    <input type="password" name="password" class="form-control form-control-lg" placeholder="Enter password" />
                </div>
                <!--End of Form Group-->
                <div class="form-group col">
                    <button class="btn btn-lg">Login</button>
                </div>
            </form>
            <!--End of Login Form-->

            <!--Card Text-->
            <p class="card-text text-white my-3">
                Don't have an account? <span class="ms-2"><a href="/register" class="btn btn-sm text-warning">Sign up</a></span>
            </p>
            <!-- Back Button to landing page -->
            <small class="text-warning">
                <i class="fa fa-arrow-alt-circle-left"><a href="/" class="btn btn-sm text-warning">Back</a></i>
            </small>
            <!-- End of Back Button to landing page -->

            <!--End of Card Text-->
        </div>
        <!-- End of Card Body -->
    </div>
    <!-- End of Card Login Form -->
</body>

</html>