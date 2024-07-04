package br.ufms;


import br.ufms.commands.Command;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        userInput();
    }

    private static void userInput(){
        try{
            InputManager inputManager = new InputManager();
            FTPService service = new FTPService();
            FTPClient ftp = service.loginFtp("localhost", 21, "test", "123456");
            CommandManager commandManager = new CommandManager();

            ftp.enterRemotePassiveMode();
            String commandRaw, commandId;
            String[] params;
            Command command;
            while(ftp.isConnected()){

                inputManager.displayMessage("Insira o comando FTP a ser realizado.");
                commandRaw = inputManager.getLine();
                commandId = inputManager.getCommand(commandRaw);
                params = inputManager.getParams(commandRaw);

                command = commandManager.getCommand(commandId);
                if(command != null){
                    command.execute(params, ftp);
                }
            }

            System.out.println("Fechou?");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}