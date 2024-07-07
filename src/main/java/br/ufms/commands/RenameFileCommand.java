package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class RenameFileCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if(params.length < 2) throw new InvalidParameterException();
        String oldPath = params[0];
        String newPath = params[1];

        System.out.printf("[REN][%d] %s renomeado para %s com sucesso: %b.\n", System.currentTimeMillis(), oldPath, newPath, client.rename(oldPath, newPath));
    }

    @Override
    public String getId() {
        return "REN <caminho_original> <novo_caminho>";
    }

    @Override
    public String getDescription() {
        return "Renomeia arquivos ou diretórios no caminho especificado.";
    }
}
