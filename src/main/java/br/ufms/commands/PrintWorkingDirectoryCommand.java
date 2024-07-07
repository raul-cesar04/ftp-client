package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

public class PrintWorkingDirectoryCommand implements Command{

    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        String workingDirectory = client.printWorkingDirectory();
        System.out.printf("[PWD][%d] '%s' é o diretório atual.\n", System.currentTimeMillis(), workingDirectory);
    }

    @Override
    public String getId() {
        return "PWD";
    }

    @Override
    public String getDescription() {
        return "Print Working Directory: Imprime o diretório atual.";
    }
}
