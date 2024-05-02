import java.util.*;

public class Nqueen {
    static int totalSolutions = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Queens: ");
        int N = sc.nextInt();
        int board[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
        helper(board, 0, N);
        if (totalSolutions == 0)
            System.out.println("No solutions found.");
        else
            System.out.println("Total solutions: " + totalSolutions);
        sc.close();
    }

    public static boolean helper(int board[][], int col, int N) {
        if (col >= N) {
            totalSolutions++;
            System.out.println("Solution " + totalSolutions + ":");
            printSolution(board, N);
            return false; // change to false to find all solutions
        }
        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (safe(board, col, i, N)) {
                board[i][col] = 1;
                res = helper(board, col + 1, N) || res;
                board[i][col] = 0;
            }
        }
        return res;
    }

    public static boolean safe(int board[][], int col, int row, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
