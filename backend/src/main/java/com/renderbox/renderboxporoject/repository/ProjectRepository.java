package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByServiceId(Long serviceId);
}
