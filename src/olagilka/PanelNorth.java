package olagilka;

import javax.swing.*;
import java.awt.*;

import static olagilka.Main.fnt;

public class PanelNorth extends JPanel {

    private JPanel SubPanelNorth;
    private JPanel SubPanelWest;
    private JPanel SubPanelEast;

    private JLabel lblInsertNumber;
    private JTextField txtInsertNumber;

    private JLabel lblRowNumber;
    private JSpinner spnRowNumber;

    private JLabel lblColumnNumber;
    private JSpinner spnColumnNumber;



    public PanelNorth()
    {
        setPreferredSize(new Dimension(600,70));
        setLayout(new BorderLayout());

        SubPanelWest = new JPanel();
        SubPanelWest.setLayout(new GridBagLayout());

        SubPanelEast = new JPanel();
        SubPanelEast.setLayout(new GridBagLayout());
        SubPanelEast.setPreferredSize(new Dimension(400, 40));

        createSubPanelNorth();

        createLabels();
        createTextFields();
        createSpinners();

        addControlsToPanel();

        add(SubPanelWest, BorderLayout.CENTER);
        add(SubPanelEast, BorderLayout.EAST);
        add(SubPanelNorth, BorderLayout.NORTH);

    }

    private void createSubPanelNorth() {
        SubPanelNorth = new JPanel();
        SubPanelNorth.setLayout(new BorderLayout());
        SubPanelNorth.setPreferredSize(new Dimension(600, 40));
        SubPanelNorth.add(new ToolBar(), BorderLayout.WEST);
    }

    private void createSpinners() {
        SpinnerNumberModel model  = new SpinnerNumberModel(1, 1, 5, 1);
        SpinnerNumberModel model2  = new SpinnerNumberModel(1, 1, 5, 1);

        spnRowNumber = new JSpinner(model);
        spnRowNumber.setPreferredSize(new Dimension(50, 20));


        spnColumnNumber = new JSpinner(model2);
        spnColumnNumber.setPreferredSize(new Dimension(50, 20));
    }

    private void addControlsToPanel() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        SubPanelWest.add(lblInsertNumber);
        SubPanelWest.add(txtInsertNumber, gbc);

        SubPanelEast.add(lblRowNumber);
        SubPanelEast.add(spnRowNumber);
        SubPanelEast.add(Box.createRigidArea(new Dimension(10, 0))); // tworzy niewidzialny element
        SubPanelEast.add(lblColumnNumber);
        SubPanelEast.add(spnColumnNumber);
    }

    private void createTextFields() {
        txtInsertNumber = new JTextField();
    }

    private void createLabels() {

        lblInsertNumber = new JLabel("Wprowdz liczbe ");
        lblInsertNumber.setFont(fnt);
        lblInsertNumber.setPreferredSize(new Dimension(130, 20));


        lblRowNumber = new JLabel("Numer wiersza ");
        lblRowNumber.setFont(fnt);
        lblRowNumber.setPreferredSize(new Dimension(130, 20));

        lblColumnNumber = new JLabel("Numer kolumny ");
        lblColumnNumber.setFont(fnt);
        lblColumnNumber.setPreferredSize(new Dimension(130, 20));
    }

    public Number getNumber()
    {
        Number number = new Number();
        number.setColumn((int)spnColumnNumber.getValue());
        number.setRow((int)spnRowNumber.getValue());
        number.setVal(txtInsertNumber.getText());

        return number;
    }

}
