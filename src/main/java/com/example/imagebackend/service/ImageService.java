package com.example.imagebackend.service;

import com.example.imagebackend.model.Image;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class ImageService {

    @Autowired
    private FirebaseService firebaseService;

    public Image saveImage(Image image) throws ExecutionException, InterruptedException {
        String documentId = image.getId() != null ? image.getId() : UUID.randomUUID().toString();
        image.setId(documentId);
        firebaseService.saveData("images", documentId, image);
        return image;
    }

    public List<Image> findAllImages() {
        try {
            List<Image> images = new ArrayList<>();
            Firestore db = com.google.firebase.cloud.FirestoreClient.getFirestore();
            Iterable<DocumentReference> refs = db.collection("images").listDocuments();
            for (DocumentReference ref : refs) {
                DocumentSnapshot doc = ref.get().get();
                if (doc.exists()) {
                    images.add(doc.toObject(Image.class));
                }
            }
            return images;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Optional<Image> findImageById(String id) {
        try {
            Object data = firebaseService.getData("images", id);
            if (data instanceof Map) {
                // Convert map to Image
                com.google.gson.Gson gson = new com.google.gson.Gson();
                Image image = gson.fromJson(new com.google.gson.Gson().toJson(data), Image.class);
                return Optional.of(image);
            }
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void deleteImage(String id) {
        try {
            Firestore db = com.google.firebase.cloud.FirestoreClient.getFirestore();
            db.collection("images").document(id).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}