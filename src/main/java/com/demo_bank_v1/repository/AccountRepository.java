package com.demo_bank_v1.repository;


import com.demo_bank_v1.models.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Accounts,Integer> {


    @Query(value = "SELECT * FROM accounts WHERE user_id = :user_id", nativeQuery = true)
    List<Accounts> getUserAccountById(@Param("user_id")int user_id);

    @Query(value = "SELECT balance FROM accounts WHERE user_id = :user_id", nativeQuery = true)
    BigDecimal getTotalBalance(@Param("user_id")int user_id);

}
