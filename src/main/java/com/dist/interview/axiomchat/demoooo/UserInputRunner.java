package com.dist.interview.axiomchat.demoooo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserInputRunner implements CommandLineRunner {

    private final AxiomService axiomService;

    public UserInputRunner(AxiomService axiomService) {
        this.axiomService = axiomService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        axiomService.saveUserToAxiom(email, password);
    }
}
