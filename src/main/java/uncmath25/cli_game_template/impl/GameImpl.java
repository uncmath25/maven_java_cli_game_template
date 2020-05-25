package uncmath25.cli_game_template.impl;

import uncmath25.cli_game_template.enums.SwipeDirection;
import uncmath25.cli_game_template.interfaces.Board;
import uncmath25.cli_game_template.interfaces.Formatter;
import uncmath25.cli_game_template.interfaces.Game;
import uncmath25.cli_game_template.model.Position;
import uncmath25.cli_game_template.utils.Console;

import java.io.IOException;

public class GameImpl implements Game {
    private boolean isGameStarted;
    private boolean isGameOver;
    private Board board;
    private Formatter formatter;

    public GameImpl() {
        this.isGameStarted = false;
        this.isGameOver = false;
        board = new BoardImpl();
        formatter = new FormatterImpl();
    }

    public void run() throws IOException {
        while (!isGameOver) {
            render();
            final String userInput = getUserInput();
            update(userInput);
        }
    }

    private void render() {
        if (!isGameStarted) {
            Console.writeConsoleOutput(formatter.getWelcomeMessage());
            isGameStarted = true;
        }
        final Position[][] positions = board.getPositions();
        final String formattedOutput = formatter.formatPositions(positions);
        Console.writeConsoleOutput(formattedOutput);
    }

    private String getUserInput() throws IOException {
        Console.writeConsoleOutput(formatter.getUserInputPrompt());
        return Console.readConsoleInputLine();
    }

    private void update(String userInput) {
        final SwipeDirection swipeDirection = formatter.parseUserSwipe(userInput);
        if (swipeDirection == null) {
            Console.writeConsoleOutput("Invalid swipe, please try again... (l, r, u, d)\n");
        }
        board.swipe(swipeDirection);
    }
}
