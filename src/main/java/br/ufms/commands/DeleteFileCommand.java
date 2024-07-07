package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class DeleteFileCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if(params.length < 1) throw new InvalidParameterException();

        String path = params[0];
        System.out.printf("[DEL][%d] Arquivo %s deletado com sucesso: %b\n", System.currentTimeMillis(), path, client.deleteFile(path));
    }

    @Override
    public String getId() {
        return "DEL <arquivo>";
    }

    @Override
    public String getDescription() {
        return "Deleta arquivo no servidor.";
    }
}
