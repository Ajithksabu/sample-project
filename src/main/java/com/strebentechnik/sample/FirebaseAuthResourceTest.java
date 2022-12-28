package com.strebentechnik.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@Path("/auth")
public class FirebaseAuthResourceTest {

    @Inject
    FirebaseAuth firebaseAuth;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public void getUserById()
            throws FirebaseAuthException, FileNotFoundException, IOException {

        FileInputStream serviceAccount = new FileInputStream("./firebase-config.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://nuxtbase-60921-default-rtdb.asia-southeast1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

        // return firebaseAuth.getUser(uid);
    }

}
