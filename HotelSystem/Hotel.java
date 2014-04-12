import component.*;
/**
 * Write a description of class Hotel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hotel
{
    private Room [] rooms;
    private Service [] servs;
    private Bill tagihan = new Bill();
    
    public Hotel(){
        rooms = new Room[10];
        servs = new Service[5];
        roomsRegister();
        servicesRegister();
    }
        
    public void runner(){        
        rooms[5].setRoomClass(9);
        
        /* Transaksi Pertama */
        rooms[3].checkIn(2);
        tagihan.addTransaction(rooms[3].transactionName(), rooms[3].getPrice());
        tagihan.addTransaction(servs[0].transactionName(), servs[0].getPrice());
        rooms[3].checkOut();
        tagihan.printBill();
    }        
    
    public void roomsRegister(){
        rooms[0] = new Room("A01", 1);
        rooms[1] = new Room("A02", 1);
        rooms[2] = new Room("A03", 1);
        rooms[3] = new Room("B01", 2);
        rooms[4] = new Room("B02", 2);
        rooms[5] = new Room("B03", 2);
        rooms[6] = new Room("B04", 2);
        rooms[7] = new Room("B05", 2);
        rooms[8] = new Room("C01", 3);
        rooms[9] = new Room("C02", 3);
    }
    
    public void servicesRegister(){
       servs[0] = new Service("Laundry", 20000);
       servs[1] = new Service("Snack", 20000);
       servs[2] = new Service("Dinner", 20000);
       servs[3] = new Service("Breakfast", 20000);
       servs[4] = new Service("WiFi", 20000);
    }
}
