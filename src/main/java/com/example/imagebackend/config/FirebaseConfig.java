package com.example.imagebackend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() throws IOException {
        String credPath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        InputStream serviceAccount;
        if (credPath != null && !credPath.isEmpty()) {
            serviceAccount = new FileInputStream(credPath);
        } else {
            // fallback to classpath resource for local dev and tests
            serviceAccount = getClass().getClassLoader().getResourceAsStream("awadhi2025-db578-firebase-adminsdk-fbsvc-f0b932916e.json");
            if (serviceAccount == null) {
                throw new IllegalStateException("Firebase credentials not found! Set GOOGLE_APPLICATION_CREDENTIALS or place the JSON in resources.");
            }
        }

        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://awadhi2025-db578.firebaseio.com")
            .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}