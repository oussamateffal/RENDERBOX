package com.renderbox.renderboxporoject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @Lob
    @Column(length = 512)
    private String description;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Photo> photos;

    @Transient
    public Photo getFirstPhoto() {
        if(photos == null || photos.isEmpty()) {
            return null;
        }
        return photos.get(0);
    }
}
