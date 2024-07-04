package br.ufms;


import br.ufms.commands.Command;
import br.ufms.commands.MakeDirectory;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands;
    public CommandManager(){
        commands = new HashMap<String, Command>();

        commands.put("mkd", new MakeDirectory());
    }

    public Command getCommand(String name){
        return commands.get(name.toLowerCase());
    }
}
