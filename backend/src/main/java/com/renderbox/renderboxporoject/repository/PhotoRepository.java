package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
