package br.ufms.commands;

import br.ufms.FileManager;
import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class MakeDirectory implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception{
        if(params.length < 1) throw new InvalidParameterException();

        String path = params[0];

        System.out.println();
        System.out.printf("[Criando Diretorio][%d]\n Diretorio criado: %s -> %b",
                System.currentTimeMillis(), path, client.makeDirectory(path));
        System.out.println();
    }
}
