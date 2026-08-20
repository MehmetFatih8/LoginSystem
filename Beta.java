import javax.swing.*;


public class Beta {

    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(() -> {

            MainFrame mf = new MainFrame();
            mf.setVisible(true);
            mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        });
    }



}


