package com.bavarna.tictactoeapp.model;

public class GameController {
    private static GameController controller ;
    GameInput gameInput;
    GameData gameData;
    Result result;

    GameController(int n) {
        initializeGame(n);
    }

    public static GameController getInstance(int n) {
        if(controller == null) {
            controller = new GameController(n);
        }
        return  controller;
    }

    private void initializeGame(int n) {
        gameInput = new GameInput(n);
        Player playerX = new Player(PlayerType.X, 0);
        Player playerY = new Player(PlayerType.Y, 0);
        gameData = GameData.getInstance(playerX, playerY);
        result = Result.NONE;
    }

    public void resetGame(int n) {
        initializeGame(n);
        gameData.resetData();
    }

    public Result getGameResult(int row, int column) {

        gameData.setCurrentColumn(column);
        gameData.setCurrentRow(row);
        gameData.incrementMoves();

        gameInput.inputMatrix[row][column] = gameData.getCurrentInput();
        printInputMatrix();

        if(gameData.totalNumberOfMovesMade >= gameInput.n) {
            getGameResult();
        }

        System.out.println("result is " + result);

        if(gameData.totalNumberOfMovesMade != (gameInput.n * gameInput.n) && (result != Result.DRAW && result != Result.WIN) ) {
            gameData.switchPlayer();
        }


        return result;
    }

    public String getColumnValue(int row, int col) {
        System.out.println(gameInput.inputMatrix[row][col]);
        if(gameInput.inputMatrix[row][col].equals("T")) {
            return "";
        } else {
            return gameInput.inputMatrix[row][col];
        }
    }

    public GameInput getGameInput() {
        return gameInput;
    }

    public String getCurrentPlayer() {
        return gameData.getCurrentPlayer().name();
    }

    private void printInputMatrix() {
        for(int i =0 ; i<gameInput.n; i++) {
            for(int j=0; j< gameInput.n ; j++) {
                System.out.print(gameInput.inputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getGameResult() {

        InputValidator inputValidator = new InputValidator(gameInput, gameData.currentRow, gameData.currentColumn, gameData.getCurrentInput());
        result = inputValidator.validateGameAndReturnResult();

        if(result == Result.NONE && gameData.totalNumberOfMovesMade == (gameInput.n * gameInput.n)) {
            result = Result.DRAW;
        }
    }

}
