package com.bavarna.tictactoeapp.model;

import java.util.Arrays;

public class GameInput {
    int n; // number of rows and columns
    public String inputMatrix[][];

    public GameInput(int n) {
        this.n = n;
        inputMatrix = new String[n][n];
        initMatrix();
    }

    private void  initMatrix() {
        for (String[] row: inputMatrix) {
            Arrays.fill(row, "");
        }
    }
}
