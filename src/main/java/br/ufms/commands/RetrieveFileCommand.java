package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

public class RetrieveFileCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if(params.length < 1) throw new InvalidParameterException();

        String path = params[0];

        String filename = Paths.get(path).getFileName().toString();

        FileOutputStream fos = new FileOutputStream(new File("local/"+filename));

        System.out.printf("[RETR][%d] Download do arquivo %s bem sucedido: %b\n", System.currentTimeMillis(), path, client.retrieveFile(path, fos));
        fos.close();
    }

    @Override
    public String getId() {
        return "RETR <arquivo>";
    }

    @Override
    public String getDescription() {
        return "Recupera uma cópia do arquivo.";
    }
}
