package pkg1721221029_veriyapilari_odev1;
/**
 * @file  Main.java
 * @description Polinom Toplaması
 * @assignment 1
 * @date   01.Mar.2019
 * @author İsmail Taha Samed ÖZKAN itsamed.ozkan@stu.fsm.edu.tr
 */
public class Node<T extends Number> {

    T Katsayı;
    T Üs;
    Node<T> next;
    Node<T> next2;

    public Node(T Kuvvet, T Üs) {
        this.Katsayı = Kuvvet;
        this.Üs = Üs;
    }


}
