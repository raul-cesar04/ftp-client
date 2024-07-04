package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class PrintWorkingDirectory implements Command{

    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        client.printWorkingDirectory();
    }
}
