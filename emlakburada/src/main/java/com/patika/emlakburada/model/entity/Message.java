package com.patika.emlakburada.model.entity;

import com.patika.emlakburada.model.auditis.DateAudities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String desription;

    private boolean status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sender_userId")
    private User senderUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_userId")
    private User customer;
}
