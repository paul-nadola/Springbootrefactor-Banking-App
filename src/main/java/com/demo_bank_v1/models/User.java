package com.demo_bank_v1.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class User {

    @Id
    private int user_id;

    @NotEmpty(message = "The First name field cannot be empty")
    @Size(min = 3)
    private String first_name;
    @NotEmpty
    @Size(min = 3)
    private String last_name;
    @Email
    @NotEmpty
    @Pattern(regexp =
            "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})",
            message = "Please Enter a Valid Email"
    )
    private String email;
    private String password;
    private String token;
    private String code;
    private int verified;
    private LocalDate verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
