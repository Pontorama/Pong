import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){
        initUI();
    }

    private void initUI(){

        add(new GameBoard());
        setTitle("Pong");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var game = new Main();
            game.setVisible(true);
        });
    }
}
