package view;

import controller.MainFrameController;

import javax.swing.*;

public class MainFrame extends JFrame {

    private Grid grid;

    public MainFrame() {
        this.build();
        this.buildComponents();
    }

    private void build() {
        this.setSize(1400, 800);
        this.setTitle("Automate cellulaire");
        this.setResizable(false);
    }

    private void buildComponents() {
        this.grid = new Grid();
        this.add(grid);
    }

    public void printMatrice(int[][] matrice) {
        this.grid.printMatrice(matrice);
    }

    public void repaint() {
        this.grid.repaint();
    }
}
