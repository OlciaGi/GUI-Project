package olagilka;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static olagilka.Main.*;

public class Main{
    public static PanelCenter panelCenter;
    public static PanelEast panelEast;
    public static PanelNorth panelNorth;
    public static PanelSouth panelSouth;

    public static Font fnt = new Font(Font.SANS_SERIF, Font.BOLD, 14);
    public static Border SimpleBorder = BorderFactory.createLineBorder(Color.black, 1);

    public static void main(String[] args)
    {
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Czy na pewno chcesz zamknac aplikacje?",
                        "Zamykanie", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.exit(0);
                }
            }
        };



        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(exitListener);

    }


}

class MainWindow extends JFrame
{
    private JPanel contents;
    private Border borderContents = BorderFactory.createEmptyBorder(0,10,0,10);



    public MainWindow()
    {
        super("Java projekt ");



        contents = new JPanel();
        contents.setLayout(new BorderLayout());
        contents.setBorder(borderContents);
        setContentPane(contents);



        panelCenter = new PanelCenter();
        contents.add(panelCenter, BorderLayout.CENTER);

        panelEast = new PanelEast();
        contents.add(panelEast, BorderLayout.EAST);

        panelNorth = new PanelNorth();
        contents.add(panelNorth, BorderLayout.NORTH);

        panelSouth = new PanelSouth();
        contents.add(panelSouth, BorderLayout.SOUTH);

        MenuBar mb = new MenuBar();
        setJMenuBar(mb);

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = (screenSize.getWidth()/2)-(getWidth()/2);
        double height = (screenSize.getHeight()/2)-(getHeight()/2);

        setBounds((int)width,(int)height,600,600);

        setVisible(true);
    }


}
