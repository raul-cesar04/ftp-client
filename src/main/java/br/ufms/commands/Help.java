package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

public class Help implements Command{

    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        System.out.println("Comandos disponíveis: ");
        System.out.println("mkd [novo diretorio] - Make Directory: Cria um novo diretório");
        System.out.println("cwd [diretorio] - Change Working Directory: Muda o diretório atual.");
        System.out.println("pwd - Print Working Directory: Mostra o diretório atual.");
    }
}
