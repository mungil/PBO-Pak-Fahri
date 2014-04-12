
/**
 * Write a description of class driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class driver
{    
    public static void main(String [] args) {
       mahasiswa ketua, anggota;
    
       MatKul KelBaru = new MatKul("A11.4408", "PBO");
    
       ketua = new mahasiswa("A11.06779", "Ikhsan Aryan", "toge@gmail.com", 4, 3.3);
       KelBaru.setKomting(ketua);
       
       anggota = new mahasiswa("A11.06781", "Maulana Ikhsan", "ikhsan@gmail.com", 4, 3.8);
       KelBaru.addMhs(anggota);
       
       KelBaru.printAllMhs();
       
       KelBaru.printKomting();
       //System.out.println("Jumlah mahasiswa : "+KelBaru.jmlMhs());
       
       
       
       mahasiswa cobaMhs = new mahasiswa();
       
       
       
    }
}
