package br.ufms;


import br.ufms.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands;
    public CommandManager(){
        commands = new HashMap<String, Command>();

        commands.put("mkd", new MakeDirectory()); // Make Directory
        commands.put("cwd", new ChangeWorkingDirectory()); // Change Working directory
        commands.put("pwd", new PrintWorkingDirectory()); // Print Working directory
        commands.put("help", new Help()); // Ajuda
        commands.put("listdir", null); // Listar diretorios
        commands.put("list", null); // Listar arquivos no diretorio
        // TODO: rename files, rename directories, create files, remove files, remove directories
    }

    public Command getCommand(String name){
        return commands.get(name.toLowerCase());
    }
}
