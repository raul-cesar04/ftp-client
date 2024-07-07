package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

public interface Command {
    public void execute(String[] params, FTPClient client) throws  Exception;
    public String getId();
    public String getDescription();
}
