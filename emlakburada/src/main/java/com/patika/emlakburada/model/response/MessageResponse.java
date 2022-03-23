package com.patika.emlakburada.model.response;

import com.patika.emlakburada.model.auditis.DateAudities;
import com.patika.emlakburada.model.entity.User;
import com.patika.emlakburada.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse extends DateAudities {

    private Long id;

    private String title;

    private String desription;

    private Date sendDate;

    private Date readDate;

    private Status status;

    private User senderUser;

    private User customer;
}
