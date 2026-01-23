package br.com.dio;

import br.com.dio.ui.BoardFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BoardFrame().setVisible(true);
        });
    }
}