package com.example.custom_manager.repository;

import com.example.custom_manager.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    Optional<Voucher> findVoucherByCode(String code);
}
