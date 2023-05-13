package org.aps.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Firebase {
    public static Firestore db;

    /**
     * This is a Singleton pattern, utilized to force all application uses a unique connection of Firestore,
     * preventing memory issues and max-simultaneously connections error.
     */
    public void run() {
        if (Firebase.db == null) {
            this.instance();
        }
    }

    private void instance() {
        try {
            InputStream serviceAccount = new FileInputStream("../configs/serviceAccount.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            Firebase.db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException exception) {
            System.out.println("Credentials error");
        }
    }
}
