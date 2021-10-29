package com.robinklaassen.aoc2015.Day06;

public class LightGrid {

    private boolean[][] grid;

    public LightGrid(int xSize, int ySize) {
        this.grid = new boolean[xSize][ySize];
        // Initialize all lights off
        this.processInstruction(0, 0, xSize - 1, ySize - 1, Instruction.OFF);
    }

    public void processInstruction(int xLow, int yLow, int xHigh, int yHigh, Instruction instr) {
        for (int i = xLow; i <= xHigh; i++) {
            for (int j = yLow; j <= yHigh; j++) {
                switch (instr) {
                    case ON:
                        this.grid[i][j] = true;
                        break;
                    case OFF:
                        this.grid[i][j] = false;
                        break;
                    case TOGGLE:
                        this.grid[i][j] = !this.grid[i][j];
                        break;
                }
            }
        }
    }

    public int countTurnedOn() {
        int count = 0;
        for (boolean[] booleans : grid) {
            for (boolean bool : booleans) {
                if (bool) {
                    count++;
                }
            }
        }
        return count;
    }
}


