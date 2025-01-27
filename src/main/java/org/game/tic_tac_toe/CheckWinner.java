package org.game.tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class CheckWinner {

    public static boolean checkWinner(JButton[][] board, int turns) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].getText() == "") continue;

            if (board[row][0].getText() == board[row][1].getText() &&
                    board[row][1].getText() == board[row][2].getText()) {
                for (int i = 0; i < 3; i++) {
                    setWinnet(board[row][i]);
                }
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col].getText() == "") continue;

            if (board[0][col].getText() == board[1][col].getText() &&
                board[1][col].getText() == board[2][col].getText()) {
                for (int i = 0; i < 3; i++) {
                    setWinnet(board[i][col]);
                }
                return true;
            }
        }

        if (board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != "") {
            for (int i = 0; i < 3; i++) {
                setWinnet(board[i][i]);
            }
            return true;
        }

        if (board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != "") {
            setWinnet(board[0][2]);
            setWinnet(board[1][1]);
            setWinnet(board[2][0]);
            return true;
            }

        if (turns == 8) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    setTie(board[row][col]);
                }
            }
            return true;
        }

        return false;
    }

    public static void setWinnet(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
    }

    public static void setWinnerText(JLabel textLabel, String currentPlayer) {
        textLabel.setText(currentPlayer + " wins!");
    }


    public static void setTie(JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
    }
}
