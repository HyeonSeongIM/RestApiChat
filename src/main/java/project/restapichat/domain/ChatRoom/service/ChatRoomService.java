package project.restapichat.domain.ChatRoom.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.ChatRoom.entity.ChatRoom;
import project.restapichat.domain.ChatRoom.repository.ChatRoomRepository;

@Service
@AllArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom create(String name) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(name)
                .build();

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }
}