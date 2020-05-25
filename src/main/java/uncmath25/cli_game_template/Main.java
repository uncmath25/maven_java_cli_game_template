package uncmath25.cli_game_template;

import uncmath25.cli_game_template.impl.GameImpl;
import uncmath25.cli_game_template.interfaces.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new GameImpl();
        game.run();
    }
}
