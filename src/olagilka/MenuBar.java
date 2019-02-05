package olagilka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static olagilka.Main.panelCenter;
import static olagilka.Main.panelNorth;

public class MenuBar extends  JMenuBar implements ActionListener {
    JMenuItem docHelp;
    JMenuItem about;
    JMenuItem Sum;
    JMenuItem Avg;
    JMenuItem min;
    JMenuItem max;
    JMenuItem AddNumber;
    JMenuItem Clear;
    JMenuItem Random;
    JMenuItem Save;
    JMenuItem Print;
    JMenuItem Exit;

    public MenuBar()
    {
        CreateFileMenu();
        CreateEditMenu();
        CreateOperationMenu();
        CreateHelpMenu();
    }

    private void CreateHelpMenu() {
        JMenu Help = new JMenu("Pomoc");
        docHelp = new JMenuItem("Kontekst pomocy");
        docHelp.setIcon(new ImageIcon("resources/images/min_help_context.jpg"));
        docHelp.addActionListener(this);

        about = new JMenuItem("Informacje o programie");
        about.addActionListener(this);
        about.setIcon(new ImageIcon("resources/images/min_about.jpg"));

        Help.add(docHelp);
        Help.add(about);
        add(Help);
    }

    private void CreateOperationMenu() {
        JMenu Operation = new JMenu("Operacje");
        Sum = new JMenuItem("Oblicz sume elementow");
        Sum.setIcon(new ImageIcon("resources/images/min_sum.png"));
        Sum.addActionListener(this);

        Avg = new JMenuItem("Oblicz srednia elementow");
        Avg.setIcon(new ImageIcon("resources/images/min_avg.png"));
        Avg.addActionListener(this);

        min = new JMenuItem("Wyszukaj liczbe minimalna");
        min.setIcon(new ImageIcon("resources/images/min_min.png"));
        min.addActionListener(this);

        max = new JMenuItem("Wyszukaj liczbe maksymalna");
        max.setIcon(new ImageIcon("resources/images/min_max.png"));
        max.addActionListener(this);

        Operation.add(Sum);
        Operation.add(Avg);
        Operation.add(min);
        Operation.add(max);
        add(Operation);
    }

    private void CreateEditMenu() {
        JMenu Edit = new JMenu("Edycja");
        AddNumber = new JMenuItem("Dodaj liczbe");
        AddNumber.setIcon(new ImageIcon("resources/images/min_add.png"));
        AddNumber.addActionListener(this);

        Clear = new JMenuItem("Wyzeruj tablice");
        Clear.setIcon(new ImageIcon("resources/images/min_reset.png"));
        Clear.addActionListener(this);

        Random = new JMenuItem("Wyplenij losowo");
        Random.setIcon(new ImageIcon("resources/images/min_random.png"));
        Random.addActionListener(this);

        Edit.add(AddNumber);
        Edit.add(Clear);
        Edit.add(Random);
        add(Edit);
    }

    private void CreateFileMenu() {
        JMenu file = new JMenu("Plik");
        Save = new JMenuItem("Zapisz");
        Save.setIcon(new ImageIcon("resources/images/min_save.png"));
        Save.addActionListener(this);

        Print = new JMenuItem("Drukuj");
        Print.setIcon(new ImageIcon("resources/images/min_print.jpg"));
        Print.addActionListener(this);

        Exit = new JMenuItem("Wyjdz");
        Exit.setIcon(new ImageIcon("resources/images/min_close.jpg"));
        Exit.addActionListener(this);

        file.add(Save);
        file.add(Print);
        file.add(new JSeparator());
        file.add(Exit);
        add(file);
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
