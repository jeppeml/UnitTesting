/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import java.util.Scanner;

/**
 *
 * @author Jeppe
 */
public class UnitTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "";
        MoveGame moveGame = new MoveGame();
        while (!input.equals("quit")) {
            printGameBoard(moveGame.getGameBoard());
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            switch (input) {
                case "up":
                    moveGame.moveCar(MoveGame.Direction.Up, 1);
                    break;
                case "down":
                    moveGame.moveCar(MoveGame.Direction.Down, 1);
                    break;
                case "left":
                    moveGame.moveCar(MoveGame.Direction.Left, 1);
                    break;
                case "right":
                    moveGame.moveCar(MoveGame.Direction.Right, 1);
                    break;
                default:
                    System.out.println("Unknown command, 'quit, up, down, left, right' are valid");
            }
        }
    }

    public static void printGameBoard(String[][] gameBoard) {
        for (int y = 0; y < gameBoard[0].length; y++) {
            for (int x = 0; x < gameBoard.length; x++) {
                System.out.print(gameBoard[x][y]);
            }
            System.out.println("");
        }
    }
}
