package br.ufms;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class VerifyUtils {
    public static int getDirectoryCount(String path, FTPClient client) throws Exception{
        int dirCount = 0;
        for(FTPFile file : client.listFiles(PathUtils.getPathFileDirectory(path))){
            if(!file.isDirectory()) continue;

            dirCount++;
        }

        return dirCount;
    }

    public static int getFileCount(String path, FTPClient client) throws Exception{
        int fileCount = 0;
        for(FTPFile file : client.listFiles(PathUtils.getPathFileDirectory(path))){
            if(file.isDirectory()) continue;

            fileCount++;
        }

        return fileCount;
    }

    public static int getDirectoryLevel(String path, FTPClient client, int level) throws Exception{

        Path pathPath = Paths.get(path);
        Path parent = pathPath.getParent();
        if(parent != null){
            return getDirectoryLevel(parent.toString(), client, level+1);
        }

        return level;
    }
}
