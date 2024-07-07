package br.ufms.commands;

import br.ufms.PathUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.naming.LimitExceededException;
import javax.naming.SizeLimitExceededException;
import java.io.FileInputStream;
import java.security.InvalidParameterException;

public class StoreFileCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if (params.length < 2) throw new InvalidParameterException();

        String localPath = params[0];
        String remotePath = params[1];

        int fileCount = 0;
        for(FTPFile file : client.listFiles(PathUtils.getPathFileDirectory(remotePath))){
            if(file.isDirectory()) continue;

            fileCount++;
        }

        if(fileCount >= 2) throw new LimitExceededException();


        FileInputStream fileInputStream = new FileInputStream("local"+localPath);
        client.setFileType(FTPClient.BINARY_FILE_TYPE | FTPClient.ASCII_FILE_TYPE);
        System.out.println();
        System.out.printf("[STOR][%d] Arquivo %s enviado para %s com sucesso: %b\n", System.currentTimeMillis(), localPath, remotePath, client.storeFile(remotePath, fileInputStream));
    }

    @Override
    public String getId() {
        return "STOR <local_path> <remote_path>";
    }

    @Override
    public String getDescription() {
        return "Upload de arquivo para servidor.";
    }
}
