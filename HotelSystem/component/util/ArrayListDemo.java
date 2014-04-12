package component.util;

import java.util.ArrayList;

public class ArrayListDemo
{
    public static void main(String [] args){
        ArrayList<Integer> nilai = new ArrayList<Integer>();
        ArrayList<String> nama = new ArrayList<String>();
        
        nilai.add(5);
        nilai.add(20);
        nilai.add(14);
        nilai.add(90);
        
        nama.add("Kamto");
        nama.add("Sri");
        nama.add("Narto");
        nama.add("Siti");
        nama.add("Andarini");
        nama.add("Sukma");
        
        int jumlah = nilai.get(0)+nilai.get(2);
        System.out.println("Nilai ke 1 ditambah nilai ke 3 = "+jumlah);
        
        System.out.println("Nama ke 3 adalah "+nama.get(2));
        System.out.println("Nama ke 5 adalah "+nama.get(4));
        
        System.out.println("Jumlah nama yang dimasukkan adalah "+nama.size());
        
        System.out.println("Semua nama yang dimasukkan adalah:");
        for(int i = 0; i < nama.size(); i++){
            System.out.println("Nama ke "+(i+1)+" adalah "+nama.get(i));
        }
    }
}
