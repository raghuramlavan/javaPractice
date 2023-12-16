package javaPractice;

import java.util.HashMap;

public class SudokoCheck {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> m = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (m.containsKey(board[i][j])) {
                    return false;
                } else {
                    m.put(board[i][j], 1);
                }
            }
            m.clear();
        }
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> m = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (m.containsKey(board[j][i])) {
                    return false;
                } else {
                    m.put(board[j][i], 1);
                }
            }
            m.clear();
        }

        for (int k = 0; k < 9; k += 3) {
            for (int l = 0; l < 9; l += 3) {
                HashMap<Character, Integer> m = new HashMap<>();
                for (int i = k; i < 3 + k; i++) {
                    for (int j = l; j < 3 + l; j++) {
                        if (board[i][j] == '.')
                            continue;
                        if (m.containsKey(board[i][j])) {
                            return false;
                        } else {
                            m.put(board[i][j], 1);
                        }
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] argv) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        SudokoCheck s = new SudokoCheck();
        System.out.println(s.isValidSudoku(board));

    }

}


[[".",".",".",".","5",".",".","1","."]
,[".","4",".","3",".",".",".",".","."]
,[".",".",".",".",".","3",".",".","1"]
,["8",".",".",".",".",".",".","2","."]
,[".",".","2",".","7",".",".",".","."]
,[".","1","5",".",".",".",".",".","."]
,[".",".",".",".",".","2",".",".","."]
,[".","2",".","9",".",".",".",".","."]
,[".",".","4",".",".",".",".",".","."]]