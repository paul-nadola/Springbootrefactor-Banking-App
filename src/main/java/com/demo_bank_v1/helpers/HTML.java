package com.demo_bank_v1.helpers;

public class HTML {

    public static String htmlEmailTemplate (String token, String code) {

        // Verify account url
        String url = "http://127.0.0.1:8070/verify?token" + token + "&code" + code;

        //When using quotes in this html, use single quotes so as not to create conflict with java's
        //double quotes

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <!-- <link rel='stylesheet' href='./css/email.css'> -->\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        *{\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: Comfortaa;\n" +
                "        }\n" +
                "\n" +
                "        /* Main Body Style */\n" +
                "\n" +
                "        body {\n" +
                "            height: 100vh;\n" +
                "            background-color: rgba(205, 205, 235, 0.925);\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        /* Wrapper */\n" +
                "\n" +
                "        .wrapper {\n" +
                "            width: 550px;\n" +
                "            height: auto;\n" +
                "            padding: 15px;\n" +
                "            background-color: white;\n" +
                "            border-radius: 7px;\n" +
                "        }\n" +
                "\n" +
                "        /* Email Message Header */\n" +
                "        .email-msg-header{\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .wrapper div{\n" +
                "            font-size: 35px;\n" +
                "            color: grey;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        /* Welcome Text */\n" +
                "        .welcome-text {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        /* Verify Account Button */\n" +
                "        .verify-account-btn {\n" +
                "            padding: 15px;\n" +
                "            background-color: rgb(99, 99, 240);\n" +
                "            text-decoration: none;\n" +
                "            color: white;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        /* Copy Right Wrapper */\n" +
                "        .copy-right{\n" +
                "            padding: 15px;\n" +
                "            color: grey;\n" +
                "            font-size: 14px;\n" +
                "            margin: 20px 4px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "    <!-- wrapper -->\n" +
                "    <div class='wrapper'>\n" +
                "        <!-- Email Message Header -->\n" +
                "        <h2 class='email-msg-header'>\n" +
                "            Welcome and Thank you for Choosing          \n" +
                "        </h2>\n" +
                "        <!--End of Email Message Header -->\n" +
                "        <!-- Company Name -->\n" +
                "        <div class='company-name'>Eazy Way Bank</div>\n" +
                "        <!--End of Company Name -->\n" +
                "\n" +
                "        <hr>\n" +
                "        <!--Welcome Text-->\n" +
                "        <p class='welcome-text'>\n" +
                "            Your Account has been successfully registered, please click <br>below to verify your account!\n" +
                "        </p>\n" +
                "        <!--End of Welcome Text-->\n" +
                "        <br>\n" +
                "        <br>\n" +
                "\n" +
                "        <!-- Verify Account Button -->\n" +
                "        <center><a href='"+ url +"' class='verify-account-btn' role='button'>Verify Account</a></center>\n" +
                "        <!--End of Verify Account Button -->\n" +
                "\n" +
                "        <!--Copy Right Wrapper-->\n" +
                "        <div class='copy-right'>\n" +
                "            &copy; Copy Right 2024. All rights reserved by EazyWayBank.com\n" +
                "        </div>\n" +
                "        <!--End of Copy Right Wrapper-->\n" +
                "    </div>\n" +
                "    <!--End of  wrapper -->\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        return "";
    };

}
