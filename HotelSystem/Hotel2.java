import java.util.*;
import component.*;
/**
 * Write a description of class Hotel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hotel2
{
    private ArrayList <Room> rooms = new ArrayList<Room>();
    private ArrayList <Service> servs = new ArrayList<Service>();
    private Bill tagihan = new Bill();
    
    public Hotel2(){
        roomsRegister();
        servicesRegister();
    }
        
    public void runner(){        
        System.out.println("Pajak PPN sebesar "+Bill.PPN);
        
        rooms.get(3).checkIn(2);
        tagihan.addTransaction(rooms.get(3).transactionName(), rooms.get(3).getPrice());
        tagihan.addTransaction(servs.get(0).transactionName(), servs.get(0).getPrice());
        rooms.get(3).checkOut();
        tagihan.printBill();
        System.out.println("Pajaknya adalah "+Bill.hitungPajak(tagihan.countTotal()));
    }        
    
    public void roomsRegister(){
        rooms.add(new Room("A01", 1));
        rooms.add(new Room("A02", 1));
        rooms.add(new Room("A03", 1));
        rooms.add(new Room("B01", 2));
        rooms.add(new Room("B02", 2));
        rooms.add(new Room("B03", 2));
        rooms.add(new Room("B04", 2));
        rooms.add(new Room("B05", 2));
        rooms.add(new Room("C01", 3));
        rooms.add(new Room("C02", 3));
    }
    
    public void servicesRegister(){
        servs.add(new Service("Laundry", 20000));
        servs.add(new Service("Snack", 20000));
        servs.add(new Service("Dinner", 20000));
        servs.add(new Service("Breakfast", 20000));
        servs.add(new Service("WiFi", 20000));
    }
    
    public void pesanKamar() {
        System.out.print("Pilih kamar yang akan dipesan [1-10] : ");
        //int roomNo = 1;
        
        Scanner roomNo = new Scanner(System.in);
        int RoomNo = roomNo.nextInt();
        
        rooms.get(RoomNo-1).printStatus();
        rooms.get(RoomNo-1).checkIn(1);
        tagihan.addTransaction(rooms.get(RoomNo-1).transactionName(), 
                               rooms.get(RoomNo-1).getPrice());
    }
    
    public void pesanService() {
        System.out.println("Pilih service yang ingin dipesan [1-5] : ");
        //int servNo = 1;
        
        Scanner servNo = new Scanner(System.in);
        int ServNo = servNo.nextInt();
        
        tagihan.addTransaction(servs.get(ServNo-1).transactionName(),
                               servs.get(ServNo-1).getPrice());
    }
    
    public void cetakBill() {
        tagihan.printBill();
        System.out.println("Pajaknya adalah "+Bill.hitungPajak(tagihan.countTotal()));
    }
    
    public void menu() {
        int pilih, i;
        Scanner cek = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI HOTEL KAMI\n");
        /*
         * Tampilkan menu dibawah ini secara berulang-ulang hingga user menginput angka 3
        */
       do {
       System.out.println("================================");
       System.out.println("Silahkan pilih menu dibawah ini:");
       System.out.println("================================");
       System.out.println("1. Pesan kamar");
       System.out.println("2. Pesan service");
       System.out.println("3. Print Tagihan (Keluar)");
       System.out.println("================================");
       System.out.print("Pilihan anda : ");
       pilih = cek.nextInt();
       
       //kondisi
       switch(pilih) {
           case 1 : pesanKamar(); break;
           case 2 : pesanService(); break;
           case 3 : 
              cetakBill();
              System.out.println("Terima kasih telah berkunjung");
              System.out.println("Sampai jumpa di waktu berikutnya");  
           ;break;
       }
       
       } while(pilih!=3);
       /*
        * Jika usar menginput angka 3, jalankan perintah dibawah ini dan program berhenti
       */
      
      /*cetakBill();
      System.out.println("Terima kasih telah berkunjung");
      System.out.println("Sampai jumpa di waktu berikutnya");*/
      
    }
}
