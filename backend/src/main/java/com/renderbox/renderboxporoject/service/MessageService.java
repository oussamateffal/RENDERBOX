package com.renderbox.renderboxporoject.service;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.Message;
import com.renderbox.renderboxporoject.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageService {

    public Message sendMessage(User user, ChatRoom chatRoom, String content);
    public List<Message> getMessagesByChatRoom(ChatRoom chatRoom);
}
