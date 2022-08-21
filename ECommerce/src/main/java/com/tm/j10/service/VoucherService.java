package com.tm.j10.service;

import com.tm.j10.domain.Voucher;
import com.tm.j10.domain.enumeration.VoucherStatus;
import com.tm.j10.repository.VoucherRepository;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {
    private VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public void createNewVoucher(Voucher newVoucher) {
        //validate
        Long validTo = newVoucher.getValidTo();
        Long validFrom = newVoucher.getValidFrom();
        if (validTo == null ||
            validFrom == null ||
            validTo <= validFrom ||
            validTo < System.currentTimeMillis() / 1000L ||
            validFrom < System.currentTimeMillis() / 1000L ||
            validTo <= 0 ||
            validFrom <= 0) {
            throw new RuntimeException("Invalid valid time");
        }

        Double maxValue = newVoucher.getMaxValue();
        Double minValue = newVoucher.getMinValue();
        if (maxValue == null ||
            minValue == null ||
            maxValue <= minValue ||
            maxValue <= 0 ||
            minValue <= 0) {
            throw new RuntimeException("Invalid limited value of voucher");
        }

        Long voucherQuantity = newVoucher.getVoucherQuantity();
        if (voucherQuantity == null ||
            voucherQuantity <= 0) {
            throw new RuntimeException("Invalid voucher quantity");
        }

        String voucherId = generateVoucherId();
        newVoucher.setVoucherId(voucherId);
        newVoucher.setVoucherStatus(VoucherStatus.ACTIVE);

        voucherRepository.save(new Voucher());

    }

    private String generateVoucherId() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder();
        int voucherIdLength = 10;
        for (int i = 0; i < voucherIdLength; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
