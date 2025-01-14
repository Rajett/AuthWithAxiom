package com.dist.interview.axiomchat.demoooo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

@Service
public class AxiomService {

    private final RestTemplate restTemplate;

    public AxiomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveUserToAxiom(String email, String password) {
        String url = "https://api.axiom.co/v1/datasets/interviewapp/ingest";

        // Préparation des données à envoyer
        User user = new User(email, password);
        Object[] users = { user }; // Tableau JSON attendu

        // Configuration des en-têtes
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer xapt-901790d1-0a77-4834-afb2-94ce56d2ea17");
        headers.set("Content-Type", "application/json");
        headers.set("X-AXIOM-ORG-ID", "interviewapp-8qn7");

        HttpEntity<Object[]> requestEntity = new HttpEntity<>(users, headers);

        try {
            // Envoi de la requête POST
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            System.out.println("Response from Axiom: " + response.getBody());
        } catch (Exception ex) {
            System.err.println("Error sending data to Axiom: " + ex.getMessage());
        }
    }

    // Classe User interne pour représenter les données JSON
    public static class User {
        private String email;
        private String password;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}

