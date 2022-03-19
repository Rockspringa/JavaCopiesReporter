package edu.mooncoder.services;

import edu.mooncoder.controllers.managers.ProjectsComparer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ComparerService {
    private static ProjectsComparer comparer;
    private static ServerSocket listener;

    private static void compareProjects() {
        try {
            StringBuilder fileContent = new StringBuilder();
            String line;
            int timesClosed = 0;

            Socket communicator = listener.accept();
            System.out.println("Received a client.");

            InputStreamReader bis = new InputStreamReader(communicator.getInputStream());
            BufferedReader reader = new BufferedReader(bis);

            do {
                line = reader.readLine();

                if (line.equals("EOF")) {
                    comparer.addReader(new StringReader(fileContent.toString()));
                    fileContent.setLength(0);
                } else if (line.equals("close")) {
                    comparer.close();
                    timesClosed++;
                } else {
                    fileContent.append(line).append("\n");
                }
            } while (timesClosed != 2);

            reader.close();
            System.out.println(comparer.compare());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runServer(int port) {
        try {
            comparer = new ProjectsComparer();
            listener = new ServerSocket(port);
            System.out.println("Server listening port " + port);

            while (true) {
                compareProjects();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
