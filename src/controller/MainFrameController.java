package controller;

import view.MainFrame;

import java.util.Random;

public class MainFrameController {
    private MainFrame mainFrame;
    private int matrice[][] = new int[138][75];
    private Random random;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.random = new Random();
        this.buildMatrice();
        this.printMatrice();
    }

    private void buildMatrice() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                this.matrice[i][j] = this.random.nextInt((4 - 1) + 1) + 1;
            }
        }
    }

    private void printMatrice() {
        this.mainFrame.printMatrice(this.matrice);
    }

    public void born() {
        while (true) {

            this.changeState();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeState() {
        for (int x = 0; x < matrice.length; x++) {
            for (int y = 0; y < matrice[x].length; y++) {
                int state = matrice[x][y];
                int stateUp = (state == 4) ? 1 : (state + 1);
                int nbstateUpNeighboors = 0;

                // Déplacement sur x
                int left = matrice[(x - 1 > 0) ? (x - 1) : (matrice.length - 1)][y];
                if (left == stateUp) {
                    nbstateUpNeighboors++;
                }

                int right = matrice[(x + 1) % (matrice.length)][y];
                if (right == stateUp) {
                    nbstateUpNeighboors++;
                }

                // Déplacement sur y
                int up = matrice[x][(y - 1 > 0) ? (y - 1) : matrice[x].length - 1];
                if (up == stateUp) {
                    nbstateUpNeighboors++;
                }

                int down = matrice[x][(y + 1) % matrice[x].length];
                if (down == stateUp) {
                    nbstateUpNeighboors++;
                }

                if (nbstateUpNeighboors >= 2) {
                    matrice[x][y] = stateUp;
                }
            }
        }

        this.printMatrice();
    }
}
