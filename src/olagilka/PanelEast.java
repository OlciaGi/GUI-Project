package olagilka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static olagilka.Main.panelCenter;
import static olagilka.Main.panelNorth;
import static olagilka.Main.panelSouth;


public class PanelEast extends JPanel implements ActionListener{

    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnRandomFill;
    private JButton btnSaveToFile;

    private int btnWidth = 130;
    private int btnHeight = 25;

    public PanelEast()
    {
        setPreferredSize(new Dimension(150,300));
        createButtons();
    }

    private void createButtons() {
        btnAdd = new JButton("Dodaj");
        btnAdd.setPreferredSize(new Dimension(btnWidth,btnHeight));
        btnAdd.addActionListener(this);
        add(btnAdd);
        btnAdd.setBackground(Color.orange);
        setVisible(true);

        btnClear = new JButton("Wyzeruj");
        btnClear.setPreferredSize(new Dimension(btnWidth,btnHeight));
        btnClear.addActionListener(this);
        add(btnClear);
        btnClear.setBackground(Color.orange);
        setVisible(true);

        btnRandomFill = new JButton("Wypenij losowo");
        btnRandomFill.setPreferredSize(new Dimension(btnWidth,btnHeight));
        btnRandomFill.addActionListener(this);
        add(btnRandomFill);
        btnRandomFill.setBackground(Color.orange);
        setVisible(true);

        btnSaveToFile = new JButton("Zapisz do pliku");
        btnSaveToFile.setPreferredSize(new Dimension(btnWidth,btnHeight));
        btnSaveToFile.addActionListener(this);
        add(btnSaveToFile);
        btnSaveToFile.setBackground(Color.green);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btnAdd){
            Number number = panelNorth.getNumber();
            if(number.isValid())
            {
                panelCenter.setNumber(number);
                panelSouth.setStatus("OK");
                panelSouth.setInfo("Dodano");
            }else {
                panelSouth.setStatus("Blad");
                panelSouth.setInfo("Wprowadzona tresc nie jest liczba");
                JOptionPane.showMessageDialog(null, "Wprowadzona tresc nie jest liczba", "Blad", JOptionPane.ERROR_MESSAGE);
            }


        }else if (source == btnClear){
            panelCenter.clearTable();
        }else if (source == btnRandomFill){
            panelCenter.fillRandom();
        }else if (source == btnSaveToFile){
            panelCenter.save();
        }
    }

}
