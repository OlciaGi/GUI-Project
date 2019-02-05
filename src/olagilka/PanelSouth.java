package olagilka;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static olagilka.Main.*;
import static olagilka.Main.panelCenter;

public class PanelSouth extends JPanel implements ActionListener {

    private JPanel subPanelNorth;
    private JPanel subPanelCenter;
    private JPanel subPanelSouth;


    private Border borderRegion= BorderFactory.createTitledBorder(SimpleBorder, "Uzyskany rezultat", TitledBorder.CENTER, TitledBorder.TOP);

    private JLabel lblOperation;
    private JList lstOperation;
    private JButton btnOperation;

    private JTextArea txtResult;
    private String Result;
    private JScrollPane spResult;

    private JLabel lblInfo;
    private JTextField txtInfo;
    private String Info;


    private JLabel lblStatus;
    private JTextField txtStatus;
    private String Status;

    private static String[] OperationList = {"Suma elementow", "Srednia elementow", "Wartosc min i max"};

    public PanelSouth()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500,280));
        Result = "";
        createSubPanels();

    }

    private void createSubPanelNorthControls() {
        lblOperation = new JLabel("Obliczenia");
        lblOperation.setFont(fnt);
        subPanelNorth.add(lblOperation);

        lstOperation = new JList(OperationList);
        lstOperation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstOperation.setBorder(SimpleBorder);
        subPanelNorth.add(lstOperation);

        btnOperation = new JButton("Oblicz");
        btnOperation.setPreferredSize(new Dimension(100,25));
        btnOperation.addActionListener(this);
        subPanelNorth.add(btnOperation);


    }

    private void createSubPanels() {
        subPanelNorth = new JPanel();
        subPanelNorth.setPreferredSize(new Dimension(500, 70));
        createSubPanelNorthControls();


        subPanelCenter = new JPanel();
        subPanelCenter.setLayout(new BorderLayout());
        subPanelCenter.setBorder(borderRegion);
        subPanelCenter.setPreferredSize(new Dimension(500, 160));
        createSubPanelCenterControls();

        subPanelSouth = new JPanel();
        subPanelSouth.setLayout(new GridBagLayout());
        subPanelSouth.setPreferredSize(new Dimension(500, 30));
        createSubPanelSouthControls();

        add(subPanelNorth, BorderLayout.NORTH);
        add(subPanelCenter, BorderLayout.CENTER);
        add(subPanelSouth, BorderLayout.SOUTH);

    }

    private void createSubPanelSouthControls() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblInfo = new JLabel("Info: ");
        lblInfo.setFont(fnt);
        txtInfo = new JTextField();
        txtInfo.setText("Praca zaliczeniowa, Aleksandra Giłka");
        subPanelSouth.add(lblInfo);
        subPanelSouth.add(txtInfo, gbc);

        subPanelSouth.add(Box.createRigidArea(new Dimension(10, 0)));

        lblStatus = new JLabel("Status: ");
        lblStatus.setFont(fnt);
        txtStatus = new JTextField();
        txtStatus.setText("Ok");
        subPanelSouth.add(lblStatus);
        subPanelSouth.add(txtStatus, gbc);

    }

    private void createSubPanelCenterControls() {
        txtResult = new JTextArea();
        spResult = new JScrollPane(txtResult);


        subPanelCenter.add(spResult, BorderLayout.CENTER);
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
        txtInfo.setText(Info);
        txtInfo.repaint();
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
        txtStatus.setText(status);
        txtStatus.repaint();
    }

    public void addResultText(String text){
        Result += text+"\n";
        txtResult.setText(Result);
        txtResult.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btnOperation){

            switch(lstOperation.getSelectedIndex())
            {
                case 0:
                    panelCenter.checkSum();
                    break;
                case 1:
                    panelCenter.checkAvg();
                    break;
                case 2:
                    panelCenter.checkMin();
                    panelCenter.checkMax();
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Nie wybrano operacji z listy", "Blad", JOptionPane.ERROR_MESSAGE);
                        break;

            }
        }
    }
}
