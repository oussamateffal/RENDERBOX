package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.entity.Photo;
import com.renderbox.renderboxporoject.entity.Project;
import com.renderbox.renderboxporoject.repository.PhotoRepository;
import com.renderbox.renderboxporoject.repository.ProjectRepository;
import com.renderbox.renderboxporoject.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{projectId}/photos")
    public ResponseEntity<List<Photo>> getProjectPhotos(@PathVariable Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            List<Photo> photos = project.getPhotos();
            return ResponseEntity.ok(photos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byService/{serviceId}")
    public List<Project> getProjectsByService(@PathVariable Long serviceId) {
        return projectRepository.findByServiceId(serviceId);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Project> createProject(@RequestParam("file") MultipartFile file, @ModelAttribute Project project) {
        try {
            // Save the project first to generate its ID
            Project createdProject = projectRepository.save(project);

            if(createdProject.getPhotos() == null) {
                createdProject.setPhotos(new ArrayList<Photo>());
            }
            // Handle file upload logic using the FileStorageService
            String photoUrl = fileStorageService.storeFile(file);

            // Create a Photo entity with the file URL and associate it with the project
            Photo photo = new Photo();
            photo.setProject(createdProject);
            photo.setPhotoUrl(photoUrl);
            Photo savedPhoto = photoRepository.save(photo);
            createdProject.getPhotos().add(savedPhoto);
            projectRepository.save(createdProject);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/{projectId}/photos")
    public ResponseEntity<Photo> addPhotoToProject(@PathVariable Long projectId, @RequestBody Photo photo) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            photo.setProject(project);
            Photo createdPhoto = photoRepository.save(photo);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        Optional<Project> existingProjectOptional = projectRepository.findById(id);

        if (existingProjectOptional.isPresent()) {
            Project existingProject = existingProjectOptional.get();
            existingProject.setProjectName(updatedProject.getProjectName());
            existingProject.setService(updatedProject.getService());
            projectRepository.save(existingProject);
            return ResponseEntity.ok(existingProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{projectId}/photos/{photoId}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long projectId, @PathVariable Long photoId, @RequestBody Photo updatedPhoto) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Photo> existingPhotoOptional = photoRepository.findById(photoId);
            if (existingPhotoOptional.isPresent()) {
                Photo existingPhoto = existingPhotoOptional.get();
                existingPhoto.setPhotoUrl(updatedPhoto.getPhotoUrl());
                photoRepository.save(existingPhoto);
                return ResponseEntity.ok(existingPhoto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{projectId}/photos/{photoId}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long projectId, @PathVariable Long photoId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Photo> photoOptional = photoRepository.findById(photoId);
            if (photoOptional.isPresent()) {
                photoRepository.deleteById(photoId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
