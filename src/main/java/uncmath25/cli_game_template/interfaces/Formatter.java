package uncmath25.cli_game_template.interfaces;

import uncmath25.cli_game_template.enums.SwipeDirection;
import uncmath25.cli_game_template.model.Position;

public interface Formatter {
    String getWelcomeMessage();
    String getUserInputPrompt();
    SwipeDirection parseUserSwipe(String userInput);
    String formatPositions(Position[][] positions);
}
