package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.entity.UserRole;
import com.renderbox.renderboxporoject.repository.ChatRoomRepository;
import com.renderbox.renderboxporoject.service.ChatRoomService;
import com.renderbox.renderboxporoject.service.EmailService;
import com.renderbox.renderboxporoject.service.UserService;
import com.renderbox.renderboxporoject.utils.Utility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/sendToken")
    public ResponseEntity<String> sendVerificationToken(@RequestParam String email, HttpServletRequest request) {
        User user = userService.loadUserByEmail(email);
        if(user == null) {
            user = userService.addNewUser(email, "", "", UserRole.ROLE_USER);
        }
        else if (user.isBlocked() && user.getRole() == UserRole.ROLE_USER) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This email is blocked, you can not use our services!");
        }
        String token = RandomString.make(45);
        user.setChatToken(token);
        userService.save(user);
        String verificationLink = Utility.getAppUrl(request)+"/api/chat/verify_token?token="+token;
        emailService.sendVerificationEmail(user.getEmail(), verificationLink);
        return ResponseEntity.ok("A token verification was sent to your email");
    }

    @GetMapping("/verify_token")
    public ChatRoom verifyToken(@RequestParam(name = "token") String token) {
        User user = userService.getByChatToken(token);
        if(user == null || !user.getChatToken().equals(token)) {
            return null;
        }
        if(!user.isBlocked() && user.getRole().equals(UserRole.ROLE_USER)) {
            ChatRoom chatRoom = chatRoomService.findOrCreateChatRoom(user);
            return chatRoom;
        } else {
            return null;
        }
    }
}
