package br.ufms;


import br.ufms.commands.Command;
import org.apache.commons.net.ftp.FTPClient;
import java.security.InvalidParameterException;

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

            String commandRaw, commandId;
            String[] params;
            Command command;
            while(ftp.isConnected()){
                printMenu();

                commandRaw = inputManager.getLine();
                commandId = inputManager.getCommand(commandRaw);
                params = inputManager.getParams(commandRaw);

                command = commandManager.getCommand(commandId);
                if(command != null){
                    command.execute(params, ftp);
                }
            }

            System.out.println("Fechou?");
        }catch (InvalidParameterException e){
            System.out.println("Parametro inválido!");
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printMenu(){
        System.out.println("FTP Clinte - Comandos");

        System.out.println("[DIRETÓRIOS]");
        System.out.println("MKD <novo_diretorio> - Make Directory: Cria novo diretório.");
        System.out.println("RMD <diretorio> - Remove Directory: Remove um diretório.");
        System.out.println("CWD <diretorio> - Change Working Directory: Muda o diretório atual.");
        System.out.println("PWD - Print Working Directory: Imprime o diretório atual.");
        System.out.println("LIST - Imprime arvore do diretório.");

        System.out.println("[ARQUIVOS]");
        System.out.println("STOR <local_path> <remote_path> - Upload de arquivo para servidor.");
    }
}