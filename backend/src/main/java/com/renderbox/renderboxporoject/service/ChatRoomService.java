package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatRoom findOrCreateChatRoom(User user) {
        ChatRoom chatRoom = chatRoomRepository.findByUserId(user.getId());

        if (chatRoom == null) {
            chatRoom = new ChatRoom();
            chatRoom.getUsers().add(user);
            chatRoom.setMessages(new ArrayList<>());
            chatRoomRepository.save(chatRoom);
        }

        return chatRoom;
    }

    public ChatRoom getChatRoomById(Long id) {
        return chatRoomRepository.getById(id);
    }
}
