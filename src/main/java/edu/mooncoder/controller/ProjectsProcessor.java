package edu.mooncoder.controller;

import edu.mooncoder.exceptions.AnalysisFailedException;
import edu.mooncoder.osrn.model.containers.Osrn;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProjectsProcessor extends Socket {
    private final DataOutputStream output;
    private final ObjectInputStream input;

    public ProjectsProcessor(String address, int port) throws IOException {
        super(address, port);
        System.out.println("Connected");

        output = new DataOutputStream(this.getOutputStream());
        input = new ObjectInputStream(this.getInputStream());
    }

    private File[] getFilesOfDirectory(File dir) throws FileNotFoundException {
        List<File> files;
        if (dir == null) {
            throw new FileNotFoundException();
        }
        if (dir.isDirectory()) {
            files = Arrays.asList(Objects.requireNonNull(dir.listFiles()));
        } else {
            files = List.of(dir);
        }

        while (files.stream().anyMatch(File::isDirectory)) {
            files.forEach(file -> {
                if (file.isDirectory()) files.addAll(Arrays.asList(Objects.requireNonNull(file.listFiles())));
            });
        }

        return files.toArray(new File[0]);
    }

    public Osrn getReport() throws IOException, ClassNotFoundException, AnalysisFailedException {
        Object provisional = input.readObject();
        if (provisional instanceof Osrn report) {
            return report;
        }
        if (provisional instanceof List<?> errors) throw new AnalysisFailedException(errors);
        throw new ClassNotFoundException();
    }

    public void sendProject(File dir) throws IOException {
        File[] files = getFilesOfDirectory(dir);
        output.writeInt(files.length);

        for (File file : files) {
            output.writeUTF(file.getName());
            output.writeLong(file.length());

            try (var fileStream = new FileInputStream(file); var stream = new BufferedInputStream(fileStream)) {
                int theByte;
                while ((theByte = stream.read()) != -1) output.write(theByte);
            }
        }
    }
}
