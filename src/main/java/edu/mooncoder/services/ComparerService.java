package edu.mooncoder.services;

import edu.mooncoder.controllers.managers.ProjectsComparer;
import edu.mooncoder.exceptions.JavaFilesHasErrorsException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class ComparerService {
    private ProjectsComparer comparer;
    private Socket communicator;

    public ComparerService(int port) {
        try {
            var listener = new ServerSocket(port);
            System.out.println("Server listening port " + port);

            while (true) {
                System.out.println("Waiting for a new client.");
                try {
                    communicator = listener.accept();
                    System.out.println("Received a client.");

                    comparer = new ProjectsComparer();
                    try (var output = new ObjectOutputStream(communicator.getOutputStream());
                         var input = new DataInputStream(communicator.getInputStream())) {
                        compareProjects(input);

                        try {
                            output.writeObject(comparer.compare());
                        } catch (JavaFilesHasErrorsException e) {
                            printErrors(output);
                        }
                    }
                } finally {
                    if (communicator != null)
                        communicator.close();
                    System.out.print("Client already disconnected. ");
                }
            }
        } catch (IOException e) {
            System.out.println("El servidor se ha detenido, verifique la causa a continuacion:");
            System.out.println(e.getMessage());
        }
    }

    private void compareProjects(DataInputStream input) throws IOException {
        for (int i = 0; i < 2; i++) {
            chargeFilesToComparer(input);
            comparer.closeProject();
        }
    }

    private void chargeFilesToComparer(DataInputStream input) throws IOException {
        int length = input.readInt();

        for (int i = 0; i < length; i++) {
            String filename = input.readUTF();
            long fileLength = input.readLong();

            try (var stream = new ByteArrayInputStream(input.readNBytes((int) fileLength));
                 var reader = new InputStreamReader(stream)) {
                comparer.addReader(reader, filename);
            }
        }
    }

    private void printErrors(ObjectOutputStream output) throws IOException {
        List<Map<String, Object>> errors = comparer.getBugs();
        output.writeObject(errors);

        String genMsg = "Error en el archivo '%s', del projecto %d:\n" +
                "\tLinea %d:Columna %d. Mensaje: %s";
        for (Map<String, Object> error : errors) {
            String msg = String.format(genMsg, error.get("Archivo"), error.get("Projecto"),
                    error.get("Linea"), error.get("Columna"), error.get("Mensage"));

            System.out.println(msg);
        }
    }
}
