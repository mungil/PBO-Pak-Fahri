
/**
 * Write a description of class MatKul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class MatKul
{
    private String kodeKelompok;
    private String matKul;
    private mahasiswa komting;
    private ArrayList <mahasiswa> list = new ArrayList <mahasiswa> ();
    
    public MatKul(String kodeKelompok, String matkul) {
        this.kodeKelompok = kodeKelompok;
        this.matKul = matkul;
    }
    
    public void setKomting(mahasiswa mhsKomting) {
        komting = mhsKomting;
        addMhs(mhsKomting);
    }
    
    public void printKomting() {
        komting.getIdentitas();
    }
    
    public void addMhs(mahasiswa mhsInput) {
        list.add(mhsInput);
    }
    
    public void printAllMhs() {
        int i;
        for(i=0; i<jmlMhs(); i++) {
            list.get(i).getIdentitas();
            if(i<(jmlMhs()-1) || i==0 ) {
                System.out.println("----------------------------------------");
            }
        }
    }
    
    public int jmlMhs() {
        return list.size();
    }
    
}
