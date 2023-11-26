package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.Message;
import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.service.ChatRoomService;
import com.renderbox.renderboxporoject.service.MessageService;
import com.renderbox.renderboxporoject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private UserService userService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(
            @RequestParam Long userId,
            @RequestParam Long chatRoomId,
            @RequestParam String content
    ) {
        User user = userService.getUserById(userId);
        ChatRoom chatRoom = chatRoomService.getChatRoomById(chatRoomId);
        messageService.sendMessage(user, chatRoom, content);

        return ResponseEntity.ok("Message sent successfully.");
    }


    @PostMapping("/sendWithChatToken")
    public ResponseEntity<String> sendMessage(
            @RequestParam String token,
            @RequestParam String email,
            @RequestParam Long chatRoomId,
            @RequestParam String content
    ) {
        User user = userService.getByChatToken(token);
        if(user == null || user.isBlocked() || !user.getEmail().equals(email)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token invalid, please request an other");
        }
        ChatRoom chatRoom = chatRoomService.getChatRoomById(chatRoomId);
        messageService.sendMessage(user, chatRoom, content);

        return ResponseEntity.ok("Message sent successfully.");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Message>> getMessage(@RequestParam Long chatRoomId) {
        ChatRoom chatRoom = chatRoomService.getChatRoomById(chatRoomId);
        List<Message> messages = messageService.getMessagesByChatRoom(chatRoom);
        return ResponseEntity.ok(messages);
    }
}
