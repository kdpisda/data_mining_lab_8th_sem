import java.util.ArrayList;
import java.util.List;
import java.io.*;

class Data {
    private int no;
    private int rollNo;
    private String name;
    private String dmw;
    private String spm;
    private String nn;
    private String cg;

    public Data(int no, int rollNo, String name, String dmw, String spm, String nn, String cg) {
        this.no = no;
        this.rollNo = rollNo;
        this.name = name;
        this.dmw = dmw;
        this.spm = spm;
        this.nn = nn;
        this.cg = cg;
    }

    public int getNo() {
        return this.no;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public String getName() {
        return this.name;
    }

    public String getDMW() {
        return this.dmw;
    }

    public String getSPM() {
        return this.spm;
    }

    public String getNN() {
        return this.nn;
    }

    public String getCG() {
        return this.cg;
    }

    public void printAll() {
        System.out.println("No: " + this.getNo());
        System.out.println("Name: " + this.getName());
        System.out.println("Roll No.: " + this.getRollNo());
        System.out.println("DMW: " + this.getDMW());
        System.out.println("SPM: " + this.getSPM());
        System.out.println("NN: " + this.getNN());
        System.out.println("CG: " + this.getCG() + "\n");
    }

}

class DataTable {
    List<Data> data = new ArrayList<>();

    public void addRow(String[] row) {
        Data dRow = new Data(Integer.parseInt(row[0]), Integer.parseInt(row[1]), row[2], row[3], row[4], row[5],
                row[6]);
        dRow.printAll();
        this.data.add(dRow);
    }
}

class NanFixerMean {

    DataTable data = new DataTable();
    String csvFile = "/home/kdpisda/Projects/college/8thsem/data_mining/NaNFixerData.csv";
    BufferedReader br = null;
    String line = "";
    String csvSplitBy = ",";

    private void loadData() {
        String[] row;
        try {
            this.br = new BufferedReader(new FileReader(this.csvFile));
            this.br.readLine();
            while ((this.line = this.br.readLine()) != null) {
                row = this.line.split(this.csvSplitBy);
                this.data.addRow(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this.br != null) {
                try {
                    this.br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        NanFixerMean fixer = new NanFixerMean();
        fixer.loadData();
    }
}