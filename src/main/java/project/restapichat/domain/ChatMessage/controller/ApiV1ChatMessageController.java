package project.restapichat.domain.ChatMessage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat/rooms")
public class ApiV1ChatMessageController {
    @GetMapping("/{id}/messages")
    public String getChatMessages(@PathVariable("id") Long id,
                                  @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId) {

        return id+"번 채팅방 메시지 목록 조회 완료";
    }

    @PostMapping("/{id}/messages")
    public String createChatMessage(@PathVariable("id") Long id){
        return id + "번 채팅방 메시지 생성완료";
    }

}
