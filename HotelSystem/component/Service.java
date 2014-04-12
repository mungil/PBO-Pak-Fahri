package component;

/**
 * Write a description of class Service here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Service
{
    private String serviceName;
    private int fee;
    
    public Service(String serviceName, int fee){
        this.serviceName = serviceName;
        this.fee = fee;
    }
    
    public String transactionName(){
        return serviceName;
    }
    
    public int getPrice(){
        return fee;
    }
    
    public void description(){
        System.out.println("Nama Servis: "+serviceName);
        System.out.println("Harga: "+fee);
    }
}
