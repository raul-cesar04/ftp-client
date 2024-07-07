package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class MakeDirectoryCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception{
        if(params.length < 1) throw new InvalidParameterException();

        String path = params[0];

        System.out.println();
        System.out.printf("[MKD][%d] Diretorio %s criado com sucesso: %b\n",
                System.currentTimeMillis(), path, client.makeDirectory(path));
        System.out.println();
    }

    @Override
    public String getId() {
        return "MKD <diretorio>";
    }

    @Override
    public String getDescription() {
        return "Make Directory: Cria novo diretório.";
    }
}
