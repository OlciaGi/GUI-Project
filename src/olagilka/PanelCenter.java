package olagilka;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import static olagilka.Main.panelSouth;


public class PanelCenter extends JPanel {

    private JTable tbTable;
    private String tableArrayString[][];
    private int tableArrayInt[][];


    public PanelCenter()
    {

        setLayout(new BorderLayout());

        String[] columnNames = {"1", "2", "3", "4", "5"};

        tableArrayString = new String[5][5];
        for(String[] row: tableArrayString)
        {
            Arrays.fill(row, "0");
        }
        tbTable = new JTable(tableArrayString, columnNames);
        tbTable.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(tbTable);

        add(scrollPane, BorderLayout.CENTER);

        tableArrayInt= new int[5][5];
        for(int[] row: tableArrayInt)
        {
            Arrays.fill(row, 0);
        }
    }

    public void setNumber(Number number)
    {
        tableArrayString[number.getColumn()-1][number.getRow()-1] = Integer.toString(number.getIntVal());
        tableArrayInt[number.getColumn()-1][number.getRow()-1] = number.getIntVal();
        tbTable.repaint();
    }

    public String getValue(int row, int col)
    {
        return tableArrayString[col][row];
    }

    public void clearTable()
    {

        for(String[] row: tableArrayString)
        {
            Arrays.fill(row, "0");
        }


        for(int[] row: tableArrayInt)
        {
            Arrays.fill(row, 0);
        }

        tbTable.repaint();
    }

    public void fillRandom()
    {
        Random rnd = new Random();

       for(int i =0; i< 5; i++)
       {
           for(int j=0; j< 5; j++)
           {
               int x = rnd.nextInt(1000);
               tableArrayInt[i][j]=x;
               tableArrayString[i][j]=Integer.toString(x);
           }
       }

        tbTable.repaint();
    }

    public void save()
    {
        try {
            PrintWriter out = new PrintWriter("dataFile.txt");
            for(int i =0; i< 5; i++)
            {
                for(int j=0; j< 5; j++)
                {
                    out.print(tableArrayString[i][j]+ "\t");
                }
                out.println();
            }
            out.close();
            panelSouth.addResultText("Poprawnie zapisano");

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    public void checkSum()
    {
        int result = 0;
        for(int i =0; i< 5; i++)
        {
            for(int j=0; j< 5; j++)
            {
                result += tableArrayInt[i][j];
            }
        }

        panelSouth.addResultText("Suma komorek = " + result);
    }

    public void checkAvg()
    {
        double result = 0;
        for(int i =0; i< 5; i++)
        {
            for(int j=0; j< 5; j++)
            {
                result += tableArrayInt[i][j];
            }
        }

        result = result/25;

        panelSouth.addResultText("Srednia wartosc w komorkach = " + result);
    }

    public void checkMin()
    {
        int result = tableArrayInt[0][0];

        for(int i =0; i< 5; i++)
        {
            for(int j=0; j< 5; j++)
            {
                if(result >  tableArrayInt[i][j]) result =  tableArrayInt[i][j];
            }
        }


        panelSouth.addResultText("Najmniejsza wartosc w tabeli = " + result);
    }

    public void checkMax()
    {
        int result = tableArrayInt[0][0];

        for(int i =0; i< 5; i++)
        {
            for(int j=0; j< 5; j++)
            {
                if(result <  tableArrayInt[i][j]) result =  tableArrayInt[i][j];
            }
        }


        panelSouth.addResultText("Najwieksza wartosc w tabeli = " + result);
    }

    public void openHelpFile()
    {
        File htmlFile = new File("resources/help/index.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
