package com.example.imagebackend.controller;

import com.example.imagebackend.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/firebase")
public class FirebaseController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/save")
    public String saveData(
            @RequestParam String collection,
            @RequestParam String documentId,
            @RequestBody Object data
    ) throws ExecutionException, InterruptedException {
        return firebaseService.saveData(collection, documentId, data);
    }

    @GetMapping("/get")
    public Object getData(
            @RequestParam String collection,
            @RequestParam String documentId
    ) throws ExecutionException, InterruptedException {
        return firebaseService.getData(collection, documentId);
    }
}