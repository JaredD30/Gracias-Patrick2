package com.adventurehub.api.core.conversation_user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConversationUser {
    private Integer conversationUserId;
    private Integer conversationId;
    private Integer userId;
    private String serviceAddress;
}
