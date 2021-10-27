package com.robinklaassen.aoc2015.Day02;

import java.util.*;

public class Present {

    private int l;
    private int w;
    private int h;

    public Present(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public static Present fromLine(String line) {
        String[] arr = line.split("x");
        return new Present(
                Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]),
                Integer.parseInt(arr[2])
        );
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getRequiredPaper() {
        int area1 = this.l * this.w;
        int area2 = this.w * this.h;
        int area3 = this.h * this.l;

        int smallest = Math.min(Math.min(area1, area2), area3);

        return 2 * area1 + 2 * area2 + 2 * area3 + smallest;
    }

    public int getVolume() {
        return l * w * h;
    }

    public int getRibbonLength() {
        List<Integer> sides = Arrays.asList(l, w, h);
        Collections.sort(sides);

        return 2 * sides.get(0) + 2 * sides.get(1) + getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return l == present.l && w == present.w && h == present.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, w, h);
    }
}
