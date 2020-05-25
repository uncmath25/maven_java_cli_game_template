package uncmath25.cli_game_template.interfaces;

import uncmath25.cli_game_template.enums.SwipeDirection;
import uncmath25.cli_game_template.model.Position;

public interface Board {
    Position[][] getPositions();
    void swipe(SwipeDirection swipeDirection);
}
