package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.entity.Photo;
import com.renderbox.renderboxporoject.repository.PhotoRepository;
import com.renderbox.renderboxporoject.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private FileStorageService fileStorageService;


    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable Long id) {
        Optional<Photo> photoOptional = photoRepository.findById(id);
        return photoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            String photoUrl = fileStorageService.storeFile(file);
            return ResponseEntity.ok(photoUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file.");
        }
    }


    @PostMapping
    public ResponseEntity<Photo> createPhoto(@RequestBody Photo photo) {
        Photo createdPhoto = photoRepository.save(photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long id, @RequestBody Photo updatedPhoto) {
        Optional<Photo> existingPhotoOptional = photoRepository.findById(id);

        if (existingPhotoOptional.isPresent()) {
            Photo existingPhoto = existingPhotoOptional.get();
            existingPhoto.setPhotoUrl(updatedPhoto.getPhotoUrl());
            photoRepository.save(existingPhoto);
            return ResponseEntity.ok(existingPhoto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        if (photoRepository.existsById(id)) {
            photoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
