package com.example.imagebackend.service;

import com.example.imagebackend.model.Image;
import com.example.imagebackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    public Optional<Image> findImageById(String id) {
        return imageRepository.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteImage(String id) {
        imageRepository.deleteById(id);
    }
}