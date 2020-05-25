package uncmath25.cli_game_template.impl;

import uncmath25.cli_game_template.config.GameConfig;
import uncmath25.cli_game_template.enums.SwipeDirection;
import uncmath25.cli_game_template.interfaces.Board;
import uncmath25.cli_game_template.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardImpl implements Board {
    private final Random rng;
    private Position[][] positions;

    public BoardImpl() {
        rng = new Random();
        initBoard();
    }

    private void initBoard() {
        this.positions = new Position[GameConfig.BOARD_SIZE][GameConfig.BOARD_SIZE];
        for (int rowIdx = 0; rowIdx < GameConfig.BOARD_SIZE; rowIdx++) {
            for (int colIdx = 0; colIdx < GameConfig.BOARD_SIZE; colIdx++) {
                positions[rowIdx][colIdx] = Position.buildEmpty();
            }
        }
        addRandomPosition();
        addRandomPosition();
    }

    public Position[][] getPositions() { return positions; };

    public void swipe(SwipeDirection swipeDirection) {}

    private void addRandomPosition() {
        final int[] nextPositionIndices = getRandomEmptyPosition();
        final int nextRowId = nextPositionIndices[0];
        final int nextColId = nextPositionIndices[1];
        final int randomValue = getRandomValue();
        positions[nextRowId][nextColId] = Position.buildPopulated(randomValue);
    }

    private int[] getRandomEmptyPosition() {
        final int[][] emptyPositionIndices = getEmptyPositionIndices();
        final int randomIdx = rng.nextInt(emptyPositionIndices.length);
        return emptyPositionIndices[randomIdx];
    }

    private int getRandomValue() {
        return rng.nextDouble() < 0.25 ? 4 : 2;
    }

    private int[][] getEmptyPositionIndices() {
        List<int[]> emptyPositionIndices = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < GameConfig.BOARD_SIZE; rowIdx++) {
            for (int colIdx = 0; colIdx < GameConfig.BOARD_SIZE; colIdx++) {
                if (positions[rowIdx][colIdx].isEmpty()) {
                    emptyPositionIndices.add(new int[]{rowIdx, colIdx});
                }
            }
        }
        return emptyPositionIndices.toArray(new int[0][0]);
    }
}
