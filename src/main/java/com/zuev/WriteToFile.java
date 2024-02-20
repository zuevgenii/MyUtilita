package com.zuev;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFile {

    private String dest;

    public String getDest() {
        return dest;
    }

    public WriteToFile(String dest) {
        this.dest = dest;
    }

    public static boolean createFiles(String fileName) throws IOException {
        Path path = Path.of(Properties.getFullPath() + Properties.getPrefix() + fileName);
        if (Files.notExists(path)) {
            if (!Files.isDirectory(Path.of(Properties.getFullPath())))
                Files.createDirectories(Path.of(Properties.getFullPath()));
            Files.createFile(Path.of(Properties.getFullPath() + Properties.getPrefix() + fileName));
        } else if (Properties.isRewrite()) {
            Files.delete(Path.of(Properties.getFullPath() + Properties.getPrefix() + fileName));
            Files.createFile(Path.of(Properties.getFullPath() + Properties.getPrefix() + fileName));
        }
        return true;
    }

    public void write(String string) {
        try (FileWriter writer = new FileWriter(this.dest, true)) {
            writer.write(string + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write into a file" + this.dest);
            throw new RuntimeException(e);
        }
    }

}
