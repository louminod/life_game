package view;

import entitiees.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

public class Grid extends JPanel {

    private ConcurrentHashMap<Cell, String> mapCells;
    private boolean initialized = false;

    public Grid() {
        mapCells = new ConcurrentHashMap<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell cell : mapCells.keySet()) {
            int cellX = 10 + (cell.getPoint().x * 10);
            int cellY = 10 + (cell.getPoint().y * 10);
            switch (cell.getState()) {
                case 1:
                    g.setColor(Color.decode("#FFFD54"));
                    break;
                case 2:
                    g.setColor(Color.decode("#F3AC3D"));
                    break;
                case 3:
                    g.setColor(Color.decode("#ED612B"));
                    break;
                case 4:
                    g.setColor(Color.decode("#EB3223"));
                    break;
            }
            g.fillRect(cellX, cellY, 10, 10);
        }
    }

    public void printMatrice(int[][] matrice) {
        if (!initialized) {
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    Cell cell = new Cell(matrice[i][j], i, j);
                    this.mapCells.put(cell, "a");
                    repaint();
                }
            }
            this.initialized = true;
        } else {
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    Cell cell = new Cell(matrice[i][j], i, j);
                    for (Cell cellule : this.mapCells.keySet()) {
                        if (cellule.getPoint().x == cell.getPoint().x && cellule.getPoint().y == cell.getPoint().y) {
                            cellule.setState(cell.getState());
                            repaint();
                        }
                    }
                }
            }
        }
    }
}
