package com.example.custom_manager.service;


import com.example.custom_manager.model.Voucher;
import com.example.custom_manager.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public Voucher findbyCode(String code) {
        Optional<Voucher> voucherfound = voucherRepository.findVoucherByCode(code);

        if(voucherfound.isPresent()) {
            return voucherfound.get();
        }
        return null;

    }
}
