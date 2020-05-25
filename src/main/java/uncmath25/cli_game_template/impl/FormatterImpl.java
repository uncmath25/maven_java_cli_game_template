package uncmath25.cli_game_template.impl;

import uncmath25.cli_game_template.config.GameConfig;
import uncmath25.cli_game_template.enums.SwipeDirection;
import uncmath25.cli_game_template.interfaces.Formatter;
import uncmath25.cli_game_template.model.Position;

import java.util.HashMap;
import java.util.Map;

public class FormatterImpl implements Formatter {
    private final Map<String, SwipeDirection> swipeDirectionInputMap = new HashMap<String, SwipeDirection>(){{
        put("l", SwipeDirection.LEFT);
        put("r", SwipeDirection.RIGHT);
        put("u", SwipeDirection.UP);
        put("d", SwipeDirection.DOWN);
    }};

    public String getWelcomeMessage() {
        return "Welcome to CLI Game Template!!!\n\n"
                + "Enter your desired swipe direction as: l, r, u, d"
                + "(For left, right, up down)";
    }

    public String getUserInputPrompt() {
        return "Enter your next swipe:";
    }

    public SwipeDirection parseUserSwipe(String userInput) {
        return swipeDirectionInputMap.getOrDefault(userInput, null);
    }

    public String formatPositions(Position[][] positions) {
        String boundaryLine = "  -";
        String gapLine = "  |";
        for (int colIdx = 0; colIdx < GameConfig.BOARD_SIZE; colIdx++) {
            boundaryLine += "------";
            gapLine += "     |";
        }
        boundaryLine += "\n";
        gapLine += "\n";

        String output = boundaryLine;
        for (int rowIdx = 0; rowIdx < GameConfig.BOARD_SIZE; rowIdx++) {
            String numberLine = "  |";
            for (int colIdx = 0; colIdx < GameConfig.BOARD_SIZE; colIdx++) {
                final Integer value = positions[rowIdx][colIdx].getValue();
                final String formattedValue = value != null ? value.toString() : " ";
                numberLine += "  " + formattedValue + "  |";
            }
            output += gapLine;
            output += numberLine + "\n";
            output += gapLine;
            output += boundaryLine;
        }
        return output;
    }
}
