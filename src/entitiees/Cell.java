package entitiees;

import java.awt.*;

public class Cell {
    private int state;
    private Point point;

    public Cell(int state, int x, int y) {
        this.state = state;
        this.point = new Point(x, y);
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Point getPoint() {
        return this.point;
    }
}
