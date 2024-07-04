package br.ufms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileManager {
    public static FileInputStream getFileInputStream(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }
}
