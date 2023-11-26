package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.repository.ChatRoomRepository;
import com.renderbox.renderboxporoject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;

    public ChatRoom findOrCreateChatRoom(User user) {
        ChatRoom chatRoom = chatRoomRepository.findByUserId(user.getId());

        if (chatRoom == null) {
            chatRoom = new ChatRoom();
            chatRoom.getUsers().add(user);
            chatRoom.setMessages(new ArrayList<>());
            chatRoomRepository.save(chatRoom);
            user.setChatRooms(new HashSet<>());
            user.getChatRooms().add(chatRoom);
            userRepository.save(user);
            // add admin
        }
        return chatRoom;
    }

    public ChatRoom getChatRoomById(Long id) {
        return chatRoomRepository.getById(id);
    }
}
