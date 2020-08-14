package launcher;

import controller.MainFrameController;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        MainFrameController controller = new MainFrameController(mainFrame);
        mainFrame.setVisible(true);

        controller.born();
    }
}
