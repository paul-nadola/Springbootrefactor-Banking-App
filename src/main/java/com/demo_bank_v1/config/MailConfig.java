//package com.demo_bank_v1.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//public class MailConfig {
//
//    @Bean
//    public static JavaMailSenderImpl getMailConfig(){
//        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();
//
//        // Set Properties:
//        Properties props = emailConfig.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        // Set Mail Credentials:
//        emailConfig.setHost("smtp.gmail.com");
//        emailConfig.setPort(587);
//        emailConfig.setUsername("oyingadev@gmail.com");
//        emailConfig.setPassword("N@dola7244");
//
//        return emailConfig;
//    }
//    // End Of Email Config Method.
//}
package com.demo_bank_v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSender getMailConfig() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // Set Properties:
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

//        properties.remove("mail.smtp.auth.mechanisms");
        // Use OAuth 2.0 for Gmail:

        properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");

        // Set Mail Credentials:
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("oyingadev@gmail.com");

        // Use an access token instead of the password for OAuth 2.0:
        mailSender.setPassword("N@dola7244");

        return mailSender;
    }
}
//package com.demo_bank_v1.config;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.Properties;
//
//public class MailConfig {
//
//    private static final String CREDENTIALS_FILE_PATH = "/path/to/client_secret.json";
//    private static final String TOKENS_DIRECTORY_PATH = "/path/to/tokens";
//
//    @Bean
//    public static JavaMailSender getMailConfig() throws Exception {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        // Set Properties:
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.put("mail.transport.protocol", "smtp");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.debug", "true");
//
//        // Use OAuth 2.0 for Gmail:
//        properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");
//
//        // Set Mail Credentials:
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("oyingadev@gmail.com");
//
//        // Use an access token instead of the password for OAuth 2.0:
//        mailSender.setPassword(getAccessToken());
//
//        return mailSender;
//    }
//
//    private static String getAccessToken() throws Exception {
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//        // Load client secrets
//        InputStream in = MailConfig.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        Credential credential = new AuthorizationCodeInstalledApp(
//                new GoogleAuthorizationCodeFlow.Builder(
//                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets,
//                        Collections.singletonList("https://www.googleapis.com/auth/gmail.send"))
//                        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                        .setAccessType("offline")
//                        .build(),
//                new LocalServerReceiver()).authorize("user");
//
//        return credential.getAccessToken();
//    }
//}
