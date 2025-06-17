package com.example.imagebackend.controller;

import com.example.imagebackend.model.Image;
import com.example.imagebackend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(
        @RequestParam("file") MultipartFile file,
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("analysisType") String analysisType) {
        try {
            Image image = new Image();
            image.setTitle(title);
            image.setDescription(description);
            image.setUploadDate(new java.util.Date());
            image.setData(file.getBytes());
            image.setAnalysisType(analysisType);
            Image savedImage = imageService.saveImage(image);
            return ResponseEntity.ok(savedImage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.findAllImages();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable String id) {
        return imageService.findImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable String id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}