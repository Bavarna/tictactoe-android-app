package com.bavarna.tictactoeapp.model;

class InputValidator {
    GameInput input;
    int currentRow;
    int currentColumn;
    String currentInput;
    public InputValidator(GameInput input, int currentRow, int currentColumn, String currentInput) {
        this.input = input;
        this.currentColumn = currentColumn;
        this.currentRow = currentRow;
        this.currentInput = currentInput;
    }

    public Result validateGameAndReturnResult() {
        Result result = Result.NONE;
        System.out.println(currentInput);
        if(validateRow()) {
            result = Result.WIN;
        } else if(validateColumn()) {
            result = Result.WIN;
        } else if(validateDiagonal()) {
            result = Result.WIN;
        }
        return result;
    }

    private boolean validateRow() {
        boolean isSuccess = true;
        int i = currentRow;
        for(int j = 0; j < input.n; j++) {
            if(!input.inputMatrix[i][j].equals(currentInput)) {
                isSuccess = false;
                break;
            }
        }
        System.out.println("validate row : " + isSuccess);
        return isSuccess;
    }

    private boolean validateColumn() {
        boolean isSuccess = true;
        int j = currentColumn;
        for(int i =0 ; i < input.n; i++) {
            if(!input.inputMatrix[i][j].equals(currentInput)) {
                isSuccess = false;
                System.out.println("input.inputMatrix[i][j] " + input.inputMatrix[i][j]
                + " input : " + currentInput);
                break;
            }
        }
        System.out.println("validate col : " + isSuccess);
        return isSuccess;
    }

    private boolean validateDiagonal() {

        boolean isSuccess = true;

        if(currentRow == currentColumn ) {
            System.out.println("validate dia : left");
            for(int i =0 ; i < input.n; i++) {
                if(!input.inputMatrix[i][i].equals(currentInput)) {
                    isSuccess = false;
                    break;
                }
            }
        }

        else if( currentColumn + currentRow == input.n - 1) {
            System.out.println("validate dia : right" );
            int j = input.n;
            for(int i = 0; i < input.n; i++) {
                if(!input.inputMatrix[i][j-1].equals(currentInput)) {
                    isSuccess = false;
                    break;
                }
                j--;
            }
        } else {
            isSuccess = false;
        }
        System.out.println("validate dia : " + isSuccess);

        return isSuccess;
    }
}
