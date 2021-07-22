package com.bavarna.tictactoeapp.model;

class Player {
    PlayerType type;
    int noOfMovesMade;

    public Player(PlayerType type, int noOfMovesMade) {
        this.type = type;
        this.noOfMovesMade = noOfMovesMade;
    }

    public void incrementMovesMade() {
        noOfMovesMade++;
    }

    public int getNoOfMovesMade() {
        return noOfMovesMade;
    }
}
