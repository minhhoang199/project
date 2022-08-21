package com.tm.j10.web.rest;

import com.tm.j10.domain.Voucher;
import com.tm.j10.service.VoucherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public/vouchers")
public class VoucherController {
    private VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @PostMapping
    public ResponseEntity<String> addNewVoucher(@RequestBody Voucher newVoucher){
        this.voucherService.createNewVoucher(newVoucher);
        return ResponseEntity.ok("Created new voucher succeed");
    }
}
