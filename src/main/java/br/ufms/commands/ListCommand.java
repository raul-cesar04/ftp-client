package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ListCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        String path = (params.length > 0)?params[0]:"/";

        printTree(path, client);
    }

    @Override
    public String getId() {
        return "LIST <diretorio (opcional)> ";
    }

    @Override
    public String getDescription() {
        return "Imprime arvore do diretório.";
    }

    private void printTree(String path, FTPClient client) throws Exception {
        FTPFile[] files = client.listFiles(path);
        System.out.printf("[LIST][%d] %s\n", System.currentTimeMillis(), path);
        for(FTPFile file : files) {
            String separator = file.isDirectory()?"":"/";
            System.out.println();
            System.out.println(path+separator+file.getName());
            if(file.isDirectory()){
                printTree(path + file.getName(), client);
            }
        }
    }
}
