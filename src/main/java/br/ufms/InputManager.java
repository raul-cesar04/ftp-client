package br.ufms;

import java.util.Arrays;
import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getCommand(String rawCommand){
        return rawCommand.split(" ")[0];
    }

    public String[] getParams(String rawCommand){
        String[] pieces = rawCommand.split(" ");
        return Arrays.copyOfRange(pieces, 1, pieces.length);
    }
    public String getLine(){
        return scanner.nextLine();
    }
}
