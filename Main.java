package pkg1721221029_veriyapilari_odev1;

/**
 * @file  Main.java
 * @description Polinom Toplaması
 * @assignment 1
 * @date   11.Mar.2019
 * @author İsmail Taha Samed ÖZKAN itsamed.ozkan@stu.fsm.edu.tr
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LinkedList<Integer> Polinoms= new LinkedList<Integer>();
       
       Polinoms.CreateAdditionList("veri.txt",Polinoms);
       
       Polinoms.print();
       
       int x = Polinoms.getX("veri.txt");
       
       int total = Polinoms.calculate(x);
        
       System.out.println("Total = "+ total);
    }

}
