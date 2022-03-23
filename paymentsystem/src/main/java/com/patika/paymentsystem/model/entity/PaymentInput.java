package com.patika.paymentsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.paymentsystem.model.enums.PaymentType;
import com.patika.paymentsystem.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long advertId;

    private Long userId;

    private String cardNumber;

    private String cardValidate;

    private String cardCvv;

    private PaymentType paymentType;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;
}
