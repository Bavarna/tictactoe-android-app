package com.bavarna.tictactoeapp.model;

public class GameData {
    Player playerX, playerY;
    int totalNumberOfMovesMade;
    int currentRow;
    int currentColumn;
    boolean isCurrentPlayerX;
    private static GameData gameData;

    GameData(Player X, Player Y) {
        playerX = X;
        playerY = Y;
        currentRow= -1;
        currentColumn = -1;
        isCurrentPlayerX = true;
        totalNumberOfMovesMade = 0;
    }

    public static GameData getInstance(Player X, Player Y) {
        if(gameData == null) {
            gameData = new GameData(X, Y);
        }
        return gameData;
    }

    public void resetData() {
        currentRow= -1;
        currentColumn = -1;
        isCurrentPlayerX = true;
        totalNumberOfMovesMade = 0;
    }
    public void incrementMoves() {
        switch (gameData.getCurrentPlayer()) {
            case X:
                gameData.playerX.incrementMovesMade();
                break;
            case Y:
                gameData.playerY.incrementMovesMade();
                break;
        }
        totalNumberOfMovesMade++;
    }

    public int getTotalNumberOfMovesMade() {
        return totalNumberOfMovesMade;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void switchPlayer() {
        isCurrentPlayerX = !isCurrentPlayerX;
    }

    public PlayerType getCurrentPlayer() {
        if(isCurrentPlayerX) {
            return PlayerType.X;
        } else {
            return  PlayerType.Y;
        }
    }

    public String getCurrentInput() {
        if(isCurrentPlayerX) {
            return "X";
        } else {
            return "Y";
        }
    }


}
