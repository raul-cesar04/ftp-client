package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class RemoveDirectoryCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if(params.length == 0) throw new InvalidParameterException();

        String directory = params[0];

        System.out.printf("[RMD][%d] Diretório %s removido com sucesso: %b\n", System.currentTimeMillis(), directory, client.removeDirectory(directory));
    }
}
