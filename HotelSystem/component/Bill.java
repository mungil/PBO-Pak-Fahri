package component;
/**
 * Write a description of class Bill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Bill
{
    private int total;
    private ArrayList<String> transaction = new ArrayList<String>();
    //private int transFee[] = new int[10];
    private ArrayList<Integer> transFee = new ArrayList<Integer>();
    private int transNum;
    public static final double PPN = 0.1; // konstan, tidak dapat dirubah
    
    public Bill(){
        transNum = 0;
    }
    
    public static double hitungPajak(int harga){
        return harga + (PPN * harga);
    }
    
    public void resetBill(){
        total = 0;
        transNum = 0;
        System.out.println("Billing telah direset");
    }
    
    public void addTransaction(String trans, int fee){
        //transaction[transNum] = trans;
        transaction.add(trans);
        //transFee[transNum] = fee;
        transFee.add(fee);
        transNum++;
    }
    
    public int countTotal(){
        for(int i = 0; i < transNum; i++){
            total += transFee.get(i);
        }
        return total;
    }
    
    public void printBill(){
        System.out.println("Transaksi yang dilakukan:");
        for(int i = 0; i < transNum; i++){
            System.out.println(transaction.get(i)+" harga : "+transFee.get(i));
        }
        System.out.println("Total : "+countTotal());
    }
}