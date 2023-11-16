package com.renderbox.renderboxporoject.repository;

import com.renderbox.renderboxporoject.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByServiceId(Long serviceId);

    @Query("select p from Project p where p.projectName like :x")
    public Page search(@Param("x") String nom, Pageable pageable);
}
