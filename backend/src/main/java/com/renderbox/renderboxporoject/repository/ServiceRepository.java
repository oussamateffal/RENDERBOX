package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("select s from Service s where s.serviceName like :x")
    public Page search(@Param("x") String nom, Pageable pageable);
}
