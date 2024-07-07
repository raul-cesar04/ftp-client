package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

public class PrintWorkingDirectoryCommand implements Command{

    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        client.printWorkingDirectory();
    }
}
