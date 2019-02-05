package olagilka;

public class Number {
    private int row;
    private int column;
    private String StrVal;
    private int intVal;

    public Number() {
    }

    public Number(int row, int column, String val) {
        this.row = row;
        this.column = column;
        StrVal = val;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setVal(String val) {
        StrVal = val;
    }

    public boolean isValid()
    {
        try{
            intVal = Integer.parseInt(StrVal);
            return true;
        }catch (NumberFormatException ex)
        {
            return false;
        }
    }

}
