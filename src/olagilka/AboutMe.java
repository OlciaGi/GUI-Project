package olagilka;

import javax.swing.*;

public class AboutMe extends JDialog {
    public AboutMe() {
        setTitle("O autorze");
        setResizable(false);
        setModal(true);
        setSize(100,120);

        JTextPane textPane = new JTextPane();
        textPane.setText("Praca zaliczeniowa\nOla Giłka\nStudia niestacjonarne\nInformatyka, Semestr 4");
        textPane.setEditable(false);
        add(textPane);

        pack();
    }
}
