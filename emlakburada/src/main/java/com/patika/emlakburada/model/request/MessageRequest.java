package com.patika.emlakburada.model.request;

import com.patika.emlakburada.model.entity.User;
import com.patika.emlakburada.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageRequest {

    private String title;

    private String desription;

    private Date sendDate;

    private Date readDate;

    private Status status;

    private User senderUser;

    private User customer;
}
