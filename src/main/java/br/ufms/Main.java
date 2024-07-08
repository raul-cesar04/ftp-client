package br.ufms;


import br.ufms.commands.Command;
import org.apache.commons.net.ftp.FTPClient;

import javax.naming.LimitExceededException;
import java.security.InvalidParameterException;

public class Main {
    private static FTPService service;
    private static CommandManager commandManager;
    public static void main(String[] args) {

        service = new FTPService();
        commandManager = new CommandManager();

        userInput();
    }

    private static void userInput(){
        try{
            InputManager inputManager = new InputManager();
            FTPClient ftp = service.loginFtp("localhost", 21, "test", "123456");

            String commandRaw, commandId;
            String[] params;
            Command command;
            while(ftp.isConnected()){
                printMenu();
                try{
                    commandRaw = inputManager.getLine();
                    commandId = inputManager.getCommand(commandRaw);
                    params = inputManager.getParams(commandRaw);

                    command = commandManager.getCommand(commandId);
                    if(command != null){
                        command.execute(params, ftp);
                    }

                }catch (InvalidParameterException e){
                    System.out.println("Parametro inválido!");
                }catch (LimitExceededException e){
                    System.out.println("Limite de arquivos ou diretorios atingido no diretório (2 arquivos e 5 pastas).");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            System.out.println("Fechou?");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printMenu(){
        System.out.println("FTP Clinte - Comandos");

        for(String n: commandManager.getKeySet()){
            Command cmd = commandManager.getCommand(n);
            System.out.printf("%s - %s\n", cmd.getId(), cmd.getDescription());
        }
    }
}