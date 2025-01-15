package project.restapichat.domain.ChatRoom.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import project.restapichat.global.jpa.BaseEntity;

@Entity
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {
    public ChatRoom() {

    }

    public String name;
}
