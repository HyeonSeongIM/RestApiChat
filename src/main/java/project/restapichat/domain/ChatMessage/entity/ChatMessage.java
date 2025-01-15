package project.restapichat.domain.ChatMessage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import project.restapichat.domain.ChatRoom.entity.ChatRoom;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    public ChatMessage() {

    }
    private String writerName;
    private String content;
    @ManyToOne
    private ChatRoom chatRoom;
}
