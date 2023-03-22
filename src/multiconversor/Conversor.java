package multiconversor;

import javax.swing.SwingUtilities;

import multiconversor.View.View;

public class Conversor {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(View::new);
    }
}