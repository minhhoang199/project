package com.tm.j10.domain;

import com.tm.j10.domain.enumeration.VoucherStatus;
import com.tm.j10.domain.enumeration.VoucherValueType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "voucher")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "voucher_id", length = 20, nullable = false)
    private String voucherId;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "valid_to", nullable = false)
    private Long validTo;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "valid_from", nullable = false)
    private Long validFrom;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "value", nullable = false)
    private Double value;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "min_value", nullable = false)
    private Double minValue;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "max_value", nullable = false)
    private Double maxValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "voucher_status", nullable = false)
    private VoucherStatus voucherStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "value_type", nullable = false)
    private VoucherValueType valueType;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "min_value", nullable = false)
    private Long voucherQuantity;

    @ManyToMany
    @JoinTable(name = "customer_voucher",
        joinColumns = @JoinColumn(name = "voucher_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    @Size(max = 200)
    @Column(name = "created_by", length = 200)
    private String createdBy;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Long createdDate;

    @Size(max = 200)
    @Column(name = "modified_by", length = 200)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

}
