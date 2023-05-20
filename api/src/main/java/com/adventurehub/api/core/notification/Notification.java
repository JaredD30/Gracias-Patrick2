package com.adventurehub.api.core.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private Integer notificationId;
    private Integer userId;
    private String message;
    private Date createdAt;
    private Date sentAt;
    private Boolean isSent;
    private String serviceAddress;
}
