package com.robinklaassen.aoc2015.Day06;

public class LightGrid2 {

    private int[][] grid;

    public LightGrid2(int xSize, int ySize) {
        this.grid = new int[xSize][ySize];
        // Initialize all lights off
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                this.grid[i][j] = 0;
            }
        }
    }

    public void processInstruction(int xLow, int yLow, int xHigh, int yHigh, Instruction instr) {
        for (int i = xLow; i <= xHigh; i++) {
            for (int j = yLow; j <= yHigh; j++) {
                switch (instr) {
                    case ON:
                        this.grid[i][j] += 1;
                        break;
                    case OFF:
                        this.grid[i][j] = Math.max(this.grid[i][j] - 1, 0);
                        break;
                    case TOGGLE:
                        this.grid[i][j] += 2;
                        break;
                }
            }
        }
    }

    public int countBrightness() {
        int count = 0;
        for (int[] lights : grid) {
            for (int light : lights) {
                count += light;
            }
        }
        return count;
    }
}


