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
    public Firebase() {

    }

    public static void main(String[] args) {
        try {
            InputStream serviceAccount = new FileInputStream("../configs/serviceAccount.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        catch (IOException exception) {
            System.out.println("Credentials error");
        }


    }
}
