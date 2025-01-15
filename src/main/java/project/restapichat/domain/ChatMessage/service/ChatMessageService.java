package project.restapichat.domain.ChatMessage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.restapichat.domain.ChatMessage.entity.ChatMessage;
import project.restapichat.domain.ChatMessage.repository.ChatMessageRepository;
import project.restapichat.domain.ChatRoom.entity.ChatRoom;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public void create(ChatRoom chatRoom, String writerName, String content) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessageRepository.save(chatMessage);
    }
}
