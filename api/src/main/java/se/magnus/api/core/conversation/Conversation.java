package se.magnus.api.core.conversation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Conversation {
    private Integer conversationId;
    private Date date;
    private String status;
    private String serviceAddress;
}
