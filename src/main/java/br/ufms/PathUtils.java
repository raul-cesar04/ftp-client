package br.ufms;

import java.nio.file.Paths;

public class PathUtils {
    public static String getPathFileName(String path){
        return Paths.get(path).getFileName().toString();
    }

    public static String getParentDirectory(String path){
        return Paths.get(path).getParent().toString();
    }

    public static String getPathFileDirectory(String path){
        return path.replaceAll(getPathFileName(path), "");
    }
}
