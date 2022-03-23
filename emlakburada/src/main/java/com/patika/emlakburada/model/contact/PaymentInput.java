package com.patika.emlakburada.model.contact;

import com.patika.emlakburada.model.entity.User;
import com.patika.emlakburada.model.enums.PaymentType;
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

    @Temporal(TemporalType.DATE)
    private Date paymentDate;
}
