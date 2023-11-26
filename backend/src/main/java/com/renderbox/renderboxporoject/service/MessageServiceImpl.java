package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.Message;
import com.renderbox.renderboxporoject.entity.User;
import com.renderbox.renderboxporoject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(User user, ChatRoom chatRoom, String content) {
        Message message = new Message();
        message.setUser(user);
        message.setChatRoom(chatRoom);
        message.setContent(content);

        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByChatRoom(ChatRoom chatRoom) {
        return messageRepository.findByChatRoom(chatRoom);
    }
}
