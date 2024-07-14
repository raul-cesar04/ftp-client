package br.ufms;


import br.ufms.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandManager {
    private Map<String, Command> commands;
    public CommandManager(){
        commands = new HashMap<String, Command>();

        commands.put("mkd", new MakeDirectoryCommand()); // Make Directory
        commands.put("cwd", new ChangeWorkingDirectoryCommand()); // Change Working directory
        commands.put("pwd", new PrintWorkingDirectoryCommand()); // Print Working directory
        commands.put("rmd", new RemoveDirectoryCommand()); // Remove diretório
        commands.put("list", new ListCommand()); // Listar arquivos no diretorio

        commands.put("stor", new StoreFileCommand()); // Criar arquivo
        commands.put("del", new DeleteFileCommand()); // Remove arquivo
        commands.put("ren", new RenameFileCommand()); // Renomeia arquivo
        commands.put("retr", new RetrieveFileCommand()); // Download de arquivo
    }

    public Command getCommand(String name){
        return commands.get(name.toLowerCase());
    }

    public String[] getKeySet(){
        String[] keys;

        this.commands.keySet().toArray(keys = new String[commands.size()]);

        return keys;
    }
}
