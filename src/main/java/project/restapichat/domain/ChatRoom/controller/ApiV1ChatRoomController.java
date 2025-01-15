package project.restapichat.domain.ChatRoom.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import project.restapichat.domain.ChatRoom.entity.ChatRoom;
import project.restapichat.domain.ChatRoom.service.ChatRoomService;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@AllArgsConstructor
@Slf4j
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    // 채팅방 목록 조회
    @GetMapping
    public String getAllChatRooms() {

        log.info("채팅방 목록 조회 완료");
        return "";
    }

    // 채팅방 조회
    @GetMapping("/{id}")
    public String getChatRoomById(@PathVariable("id") Long id) {

        log.info("{}번 채팅방 조회 완료", id);
        return "";
    }

    // 채팅방 생성
    @PostMapping
    public String createChatRoom(@RequestBody ChatRoom chatRoom) {

        log.info("{}채팅방 생성 완료", chatRoom);
        return "";
    }


}
