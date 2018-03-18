/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import java.awt.Point;

/**
 *
 * @author Jeppe
 */
public class MoveGame {

    private final int gameWidth = 15;
    private final int gameHeight = 10;
    String[][] gameBoard = new String[gameWidth][gameHeight];
    Point playerLocation = new Point(0, 0);

    private boolean isValidMove(int x, int y) {
        return gameBoard.length >= x && gameBoard[0].length >= y
                && x >= 0 && y >= 0;
    }

    public enum Direction {
        Up, Down, Left, Right
    }

    public MoveGame() {

    }

    public String[][] getGameBoard() {
        updateGameBoard();
        return gameBoard;
    }

    private void updateGameBoard() {
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (playerLocation.x == x && playerLocation.y == y) {
                    gameBoard[x][y] = "[C]";
                } else {
                    gameBoard[x][y] = "[ ]";
                }
            }
        }
    }

    private void setNewCarLocation(int x, int y) {
        playerLocation.x = x;
        playerLocation.y = y;
    }

    public boolean moveCar(Direction d, int steps) {
        int x = playerLocation.x;
        int y = playerLocation.y;
        switch (d) {
            case Up:
                y -= steps;
                break;
            case Down:
                y += steps;
                break;
            case Left:
                x -= steps;
                break;
            case Right:
                x += steps;
                break;
            default:
                throw new AssertionError();
        }

        if (isValidMove(x, y)) {
            setNewCarLocation(x, y);
            return true;
        }
        return false;
    }

}
