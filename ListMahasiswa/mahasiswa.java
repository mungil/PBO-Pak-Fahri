import java.util.*;
/**
 * Write a description of class mahasiswa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mahasiswa
{
    public static List<String> tabelNim = new ArrayList<>();
    private String nim, nama, email;
    private int semester;
    private double ipk;
    
   
    
    public mahasiswa(String nimIn, String namaIn, String emailIn, int semesterIn, double ipkIn) {
        setNim(nimIn);
        setNama(namaIn);
        setEmail(emailIn);
        setSemester(semesterIn);
        setIpk(ipkIn);

    }
    
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getSemester() {
        return semester;
    }
    
    public double getIpk() {
        return ipk;
    }
    
    public void setNim(String nimInput) {
        nim = nimInput;
    }
    
    public void setNama(String namaInput) {
        nama = namaInput;
    }
    
    public void setEmail(String emailInput) {
        email = emailInput;
    }
    
    public void setSemester(int semesterInput) {
        semester = semesterInput;
    }
    
    public void setIpk(double ipkInput) {
        ipk = ipkInput;
    }
    
    public void getIdentitas() {
       System.out.println("NIM      : "+getNim());
       System.out.println("Nama     : "+getNama());
       System.out.println("Email    : "+getEmail());
       System.out.println("Semester : "+getSemester());
       System.out.println("IPK      : "+getIpk());
       statusMhs();
    }
    
    public void statusMhs() {
        if(ipk<1) {
            System.out.println("Status   : Belum jadi mahasiswa");
        }
        else if( (ipk>=1.0) && (ipk<2.0) ) {
            System.out.println("Status   : Mahasiswa NASAKOM");
        }
        else if( (ipk>=2) && (ipk<3) ) {
            System.out.println("Status   : Mahasiswa Kurang Beruntung");
        }
        else if( (ipk>=3) && (ipk<=3.5) ) {
            System.out.println("Status   : IPK Cukup");
        }
        else if( (ipk>3.5) && (ipk<=4.0) ) {
            System.out.println("Status   : Summa Cumlaude");
        }
        else {
            System.out.println("Status   : IPK tidak terdefinisi secara benar !!!");
        }
        
    }
}
