package br.ufms;


import org.apache.commons.net.ftp.FTPClient;

public class Main {
    public static void main(String[] args) {
        try{
            InputManager inputManager = new InputManager();
            FTPClient ftp = new FTPService().loginFtp("localhost", 21, "test", "123456");

            ftp.enterRemotePassiveMode();
            String commandRaw, command, params;
            while(ftp.isConnected()){
                inputManager.displayMessage("Insira o comando FTP a ser realizado.");
                commandRaw = inputManager.getLine();
                command = inputManager.getCommand(commandRaw);
                params = inputManager.getParams(commandRaw);

                ftp.doCommand(command, params);
            }

            System.out.println("Fechou?");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}