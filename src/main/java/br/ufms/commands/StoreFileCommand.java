package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.security.InvalidParameterException;

public class StoreFileCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if (params.length < 2) throw new InvalidParameterException();

        String localPath = params[0];
        String remotePath = params[1];

        FileInputStream fileInputStream = new FileInputStream(localPath);
        client.setFileType(FTPClient.BINARY_FILE_TYPE | FTPClient.ASCII_FILE_TYPE);
        System.out.println();
        System.out.printf("[STOR][%d] Arquivo %s enviado para %s com sucesso: %b\n", System.currentTimeMillis(), localPath, remotePath, client.storeFile(remotePath, fileInputStream));
    }
}
