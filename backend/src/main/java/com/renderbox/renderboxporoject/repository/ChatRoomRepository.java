package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.ChatRoom;
import com.renderbox.renderboxporoject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query("select c from ChatRoom c join fetch c.messages m join c.users u where u.id = :userId order by m.date desc")
    public ChatRoom findByUserId(@Param("userId") Long userId);
}
