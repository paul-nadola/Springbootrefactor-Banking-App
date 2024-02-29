package com.demo_bank_v1.repository;


import com.demo_bank_v1.models.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    @Modifying
    @Query(value = "INSERT INTO payments(account_id, beneficiary, beneficiary_acc_no, amount, reference_no)", nativeQuery = true)

}
