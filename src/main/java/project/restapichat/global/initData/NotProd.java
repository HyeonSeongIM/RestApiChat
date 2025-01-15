package project.restapichat.global.initData;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import project.restapichat.domain.ChatMessage.service.ChatMessageService;
import project.restapichat.domain.ChatRoom.entity.ChatRoom;
import project.restapichat.domain.ChatRoom.service.ChatRoomService;
import project.restapichat.domain.Member.member.entity.Member;
import project.restapichat.domain.Member.member.service.MemberService;
import project.restapichat.domain.article.article.entity.Article;
import project.restapichat.domain.article.article.service.ArticleService;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    public ApplicationRunner applicationRunner(
            ChatRoomService chatRoomService,
            ChatMessageService chatMessageService,
            MemberService memberService,
            ArticleService articleService) {
        return args -> {
            ChatRoom chatRoom1 = chatRoomService.create("room");
            ChatRoom chatRoom2 = chatRoomService.create("room2");
            ChatRoom chatRoom3 = chatRoomService.create("room3");

            IntStream.range(1,100).forEach(num -> {
                chatMessageService.create(chatRoom1, "홍길동", "채팅메시지" + num);
            });

            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();
            Member member3 = memberService.join("user3", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();
        };
    }
}
