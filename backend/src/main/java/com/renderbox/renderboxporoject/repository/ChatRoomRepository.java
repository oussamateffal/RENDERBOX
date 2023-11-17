package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    public ChatRoom findByUser(User user);
}
