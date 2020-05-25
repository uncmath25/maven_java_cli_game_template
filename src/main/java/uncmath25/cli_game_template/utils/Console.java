package uncmath25.cli_game_template.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    public static String readConsoleInputLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void writeConsoleOutput(String output) {
        System.out.println("\n" + output + "\n");
    }
}
