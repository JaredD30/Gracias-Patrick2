package com.adventurehub.api.core.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private Integer messageId;
    private Integer conversationId;
    private Integer userId;
    private String content;
    private String serviceAddress;
}
