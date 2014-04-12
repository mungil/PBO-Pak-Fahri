package component.util;

import java.util.*;

/**
 * Write a description of class DemoInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoInput
{
    public void demo(){
        Scanner input = new Scanner(System.in);                
        
        System.out.print("Inputkan Nama : ");
        String nama = input.nextLine();
        
        System.out.print("Inputkan Nilai 1 : ");
        int nilai1 = input.nextInt();
        System.out.print("Inputkan Nilai 2 : ");
        int nilai2 = input.nextInt();
        
        System.out.print("Penambahan dari nilai 1 dan nilai 2 : "+(nilai1+nilai2));
        System.out.println("Nama anda adalah: "+nama);
    }
}
