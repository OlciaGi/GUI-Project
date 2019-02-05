package olagilka;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static olagilka.Main.panelCenter;
import static olagilka.Main.panelNorth;
import static olagilka.Main.panelSouth;

public class ToolBar extends JToolBar implements ActionListener {


    private JButton docHelp;
    private JButton about;

    private JButton Sum;
    private JButton Avg;
    private JButton min;
    private JButton max;


    private JButton AddNumber;
    private JButton Clear;
    private JButton Random;

    private JButton Save;
    private JButton Print;
    private JButton Exit;


    public ToolBar()
    {
        CreateButtons();
        setLayout(new FlowLayout());
        setRollover(false);
        setFloatable(false);
        setBorderPainted(false);
        setOpaque(false);


    }

    private void CreateButtons() {
        BufferedImage buttonIcon;
        try {
            buttonIcon = ImageIO.read(new File("resources/images/save.png"));
            Save = new JButton(new ImageIcon(buttonIcon));
            Save.setPreferredSize(new Dimension(30,30));
            Save.setToolTipText("Zapisz");
            Save.addActionListener(this);
            add(Save);

            buttonIcon = ImageIO.read(new File("resources/images/print.jpg"));
            Print = new JButton(new ImageIcon(buttonIcon));
            Print.setPreferredSize(new Dimension(30,30));
            Print.setToolTipText("Drukuj");
            Print.addActionListener(this);

            add(Print);

            buttonIcon = ImageIO.read(new File("resources/images/close.jpg"));
            Exit = new JButton(new ImageIcon(buttonIcon));
            Exit.setPreferredSize(new Dimension(30,30));
            Exit.setToolTipText("Zamknij");
            Exit.addActionListener(this);

            add(Exit);

            add(Box.createRigidArea(new Dimension(10, 0)));

            buttonIcon = ImageIO.read(new File("resources/images/add.png"));
            AddNumber = new JButton(new ImageIcon(buttonIcon));
            AddNumber.setPreferredSize(new Dimension(30,30));
            AddNumber.setToolTipText("Dodaj liczbe");
            AddNumber.addActionListener(this);

            add(AddNumber);

            buttonIcon = ImageIO.read(new File("resources/images/reset.png"));
            Clear = new JButton(new ImageIcon(buttonIcon));
            Clear.setPreferredSize(new Dimension(30,30));
            Clear.setToolTipText("Wyzeruj tablice");
            Clear.addActionListener(this);

            add(Clear);

            buttonIcon = ImageIO.read(new File("resources/images/random.png"));
            Random = new JButton(new ImageIcon(buttonIcon));
            Random.setPreferredSize(new Dimension(30,30));
            Random.setToolTipText("Uzupelnij tablice losowymi wartosciami");
            Random.addActionListener(this);

            add(Random);

            add(Box.createRigidArea(new Dimension(10, 0)));

            buttonIcon = ImageIO.read(new File("resources/images/sum.png"));
            Sum = new JButton(new ImageIcon(buttonIcon));
            Sum.setPreferredSize(new Dimension(30,30));
            Sum.setToolTipText("Oblicz sume");
            Sum.addActionListener(this);

            add(Sum);

            buttonIcon = ImageIO.read(new File("resources/images/avg.png"));
            Avg = new JButton(new ImageIcon(buttonIcon));
            Avg.setPreferredSize(new Dimension(30,30));
            Avg.setToolTipText("Oblicz srednia");
            Avg.addActionListener(this);

            add(Avg);

            buttonIcon = ImageIO.read(new File("resources/images/min.png"));
            min = new JButton(new ImageIcon(buttonIcon));
            min.setPreferredSize(new Dimension(30,30));
            min.setToolTipText("Znajdz minimalna liczbe");
            min.addActionListener(this);

            add(min);

            buttonIcon = ImageIO.read(new File("resources/images/max.png"));
            max = new JButton(new ImageIcon(buttonIcon));
            max.setPreferredSize(new Dimension(30,30));
            max.setToolTipText("Znajdz maksymalna liczbe");
            max.addActionListener(this);

            add(max);

            add(Box.createRigidArea(new Dimension(10, 0)));

            buttonIcon = ImageIO.read(new File("resources/images/min_help_context.jpg"));
            docHelp = new JButton(new ImageIcon(buttonIcon));
            docHelp.setPreferredSize(new Dimension(30,30));
            docHelp.setToolTipText("O programie");
            docHelp.addActionListener(this);

            add(docHelp);

            buttonIcon = ImageIO.read(new File("resources/images/about.jpg"));
            about = new JButton(new ImageIcon(buttonIcon));
            about.setPreferredSize(new Dimension(30,30));
            about.setToolTipText("O autorze");
            about.addActionListener(this);

            add(about);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == AddNumber){
            Number number = panelNorth.getNumber();
            if(number.isValid())
            {
                panelCenter.setNumber(number);
            }else JOptionPane.showMessageDialog(null, "Wprowadzona tresc nie jest liczba", "Blad", JOptionPane.ERROR_MESSAGE);


        }else if (source == Clear){
            panelCenter.clearTable();
        }else if (source == Random){
            panelCenter.fillRandom();
        }else if (source == Save){
            panelCenter.save();
        }else if(source == docHelp){
            panelCenter.openHelpFile();
        }else if(source == Sum){
            panelCenter.checkSum();
        }else if(source == Avg){
            panelCenter.checkAvg();
        }else if(source == min) {
            panelCenter.checkMin();
        }else if(source == max){
            panelCenter.checkMax();
        }else if(source == about){
            AboutMe aboutMe = new AboutMe();
            aboutMe.setVisible(true);
        }else  if(source == Exit)
        {
           int a = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamknac aplikacje?", "zamykanie", JOptionPane.YES_NO_OPTION);
           if(a == 0)
           {
               System.exit(0);
           }
        }
    }




}
