package pkg1721221029_veriyapilari_odev1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @file  LinkedList.java
 * @description Polinom Toplaması
 * @assignment 1
 * @date   11.Mar.2019
 * @author İsmail Taha Samed ÖZKAN itsamed.ozkan@stu.fsm.edu.tr
 */
public class LinkedList<T extends Number> {
//Listenin Başını Saklayan Özelliktir.
    private Node<T> head;
/*addFirst Metodu içerisine bir Node alacak şekilded tasarlanmıştır , T Generic tipinde bir üst ve katsayı alacak şekilde Overload edilmiştir 
  Eger liste boş ise Node Listenin başı yani head olarak atanır .
    eger liste boş degil ise o anda head olan değişken yeni head olacak Nodun next özelligine atanır ve head yeni Node olarak güncellenir.
    
    */
    void addFirst(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
// Addfirst Metodu Overload edilmiştir .
    void addFirst(T Katsayı, T Üs) {
        addFirst(new Node<>(Katsayı, Üs));
    }

/*
    
    
    */
/*addLast Metodu içerisine bir Node alacak şekilded tasarlanmıştır , T Generic tipinde bir üst ve katsayı alacak şekilde Overload edilmiştir 
  Eger liste boş ise Node Listenin başı yani head olarak atanır .
    eger liste boş degil ise o temp değişkeni oluşturularak liste üzerinde gezilir listenin sonunda olunması durumu tempin nextinin null olmasıdır
    bu durumda sona ekleme yapılır.
    
    
    */
    void addLast(Node newNode) {

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }
    
    void addLast(T Katsayı, T Üs) {
        Node<T> newNode = new Node<>(Katsayı, Üs);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }
    
    /*insertAfter Metodu içerisine 2 adet node  Node alacak şekilde tasarlanmıştır , T Generic tipinde bir üst  katsayı , Arananüs alacak şekilde  ve Node ve Aranan üstü alacak Overload edilmiştir 
  Temel amaç İsteninen nodu bulmak ve Bu noddan sonra gerekli baglantıları yaparak  Arkasına eklemek
    
    
    
    */
    void insertAfter(T EklenecekKatsayı, T EklenecekUs, T arananUs) {
        Node<T> temp = head;

        while (temp != null && temp.Üs != arananUs) {
            temp = temp.next;
        }

        if (temp != null) {
            Node<T> newNode = new Node<>(EklenecekKatsayı, EklenecekUs);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Ekleme İşlemi Başarısızlıkla Sonuçlandı");
        }
    }

    void insertAfter(Node<T> newNode, T arananUs) {
        Node<T> temp = head;

        while (temp != null && temp.Üs != arananUs) {
            temp = temp.next;
        }

        if (temp != null) {

            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Ekleme İşlemi Başarısızlıkla Sonuçlandı");
        }
    }

    void insertAfter(Node<T> newNode, Node<T> current) {
        Node<T> temp = head;

        while (temp != null && temp.Üs != current.Üs) {
            temp = temp.next;
        }

        if (temp != null) {

            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("Ekleme İşlemi Başarısızlıkla Sonuçlandı");
        }
    }
/*İnserSorted Metodu İçerisine Bir Node Alacak Şekilde tasarlanmıştır . 
    istemiz üstünde dolaşarak işlemlerimiz gerçekleşir .
    eger listenin boyu 0 yani liste boş ise addfirst metodu kullanılır. 
    eger listenin boyu 1 ise 3 adet durum oluşabilir  1. durum Yeni oluşan node listemizin ilk noduna eşit ise Aşağı yönlü ekleme yapmak için insertDownside Metodu Çalıştırılır
    Eger listenin boyu 2 ve ya daha fazla ise Listenin ilk elamanından (head) büyük bir Node gelmesi durumunda Yeni node listenin başı olur. addFirst Metodu kullanılır
    eger listede eklenicek yer bulunursa  1. olarak bulunan konumdan önceki node ile üsleri karşılaştırılır . üsler aynı ise aşağı yönlü ekleme , 
    üsler farklı ise yana doğru ekleme gerçekleşir.*/
    void insertSorted(Node<T> newNode) {
        Node<T> temp = head;

        if (size() == 0) {
            addFirst(newNode);
        } else if (size() == 1) {
            if (temp.Üs.intValue() == newNode.Üs.intValue()){
                insertDownSide(newNode);
            }
            else if (temp.Üs.intValue() < newNode.Üs.intValue()) {
                addFirst(newNode);
            }else if(temp.Üs.intValue() > newNode.Üs.intValue()) {
                addLast(newNode);
            }
        } else if (!(size() < 0) && size() >= 2) {
            Node<T> temp2 = head.next;
            Node<T> prev = head;
            if (newNode.Üs.intValue() > prev.Üs.intValue()) {
                addFirst(newNode);
            } else {
                while (temp2 != null && !(temp2.Üs.intValue() < newNode.Üs.intValue())) {
                    prev = temp2;
                    temp2 = temp2.next;
                }

                if (temp2 != null) {
                    if (prev.Üs.intValue() == newNode.Üs.intValue()){
                        insertDownSide(newNode);}else{
                    insertAfter(newNode, prev);}

                } else {
                    addLast(newNode);

                }
            }
        }
    }
/*inserDownside Metodu içerisine bir Node alacak Şekilde tasarlanmıştır.
  bir ara değişken oluşturularak listede dolaştırılır listedeki aynı üstlü bir Node bulursa addLastDownside Metodu ile nodu ekler . eger aynı üslü node bulamazsa sıralı bir şekilde listeye ekler. 
    */
    void insertDownSide(Node<T> newNode) {

        Node<T> temp = head;
        while (temp != null && temp.Üs.intValue() != newNode.Üs.intValue()) {
            temp = temp.next;
        }
        if (temp != null) {

            addLastDownside(newNode,temp);
        } else {
            insertSorted(newNode);
        }

    }
/*Listeden Eleman Siler.*/
    boolean remove(T SilinecekKatsyı, T SilinecekUs) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.Üs.equals(SilinecekUs) && head.Katsayı.equals(SilinecekKatsyı)) {
                head = head.next;
                return true;
            } else {
                Node<T> temp = head.next;
                Node<T> prev = head;

                while (temp != null && !temp.Katsayı.equals(SilinecekKatsyı) && !temp.Üs.equals(SilinecekUs)) {
                    prev = temp;
                    temp = temp.next;
                }

                if (temp != null) {
                    prev.next = temp.next;
                    return true;
                } else {
                    System.out.println("Silme İşlemi Başarısız ");
                }
            }
        }
        return false;
    }
/*print metodu listede dolaşarak listeyi bize yazdırır . Ana yön aşağı doğrudur eger aynı katsayılı nodelar var ise bu nodlar sağa doğru dallanarak gösterilir.
    2. yönün kontrolü node sınıfının next2 özelligi sayesinde kontrol edilir.
    */
    void print() {
        Node<T> temp = head;

        while (temp != null) {

            System.out.print(temp.Katsayı + " | " + temp.Üs + " -> ");
            if (temp.next2 != null) {
                Node<T> tempAlt = temp.next2;
                while (tempAlt != null) {
                    System.out.print(""+ tempAlt.Katsayı + " | " + tempAlt.Üs+" → ");
                    tempAlt = tempAlt.next2;
                }
                System.out.print(" null ");
            }else{System.out.print(" null ");
            }
            temp = temp.next;
            System.out.println("");
            System.out.println("↓");
        }
        System.out.println("null");
    }
/*Liste Üzeribde dolaşarak listenin uzunlugunu belirler.*/
    int size() {
        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    /*Nodun next2 özelligine bakarak en  sona aynı üsse sayip nodu ekler.*/
    void addLastDownside(Node<T> newNode, Node<T> currentNode) {

        Node<T> temp = currentNode;

        while (temp.next2 != null ) {
            
            temp = temp.next2;
        }
        if(currentNode.Üs == newNode.Üs){
        temp.next2 = newNode;}

    }
/*
    Dosya Okuma işlemleri burada gerçekleşir . Dosyanın uzantısı verilerek parameterelerdeki liste doldurulur .
    Dosya satır satır okunur . satırlardaki ',' karakterine göre katsayı ve üs değerlerine sahip nodelar oluşturulur . 
    ilk polinom sıralı bir şekilde oluşturulur daha sonraki polinomlar için dallanmalarda sıra kontrolü olmaz fakat ana listeye eklenirken sıralı bir şekilde eklemir
    
    Dosyanın formatı 
    1. satır x değeri
    Katsayı, Üs 
    şeklinde olmalıdır.
    */
    void CreateAdditionList(String filePath, LinkedList<T> list) {
        try {

            File file = new File(filePath);

            Scanner input = new Scanner(file);

            input.nextLine();
            

            while (input.hasNext()) {
                String line = input.nextLine();

                if (line.charAt(0) != '*') {

                    int katsayi = Integer.parseInt(line.split(",")[0].trim());
                    int üs = Integer.parseInt(line.split(",")[1].trim());

                    list.insertSorted(new Node(katsayi, üs));

                    //   System.out.println("Kaysayı = " + katsayi + " Üs = " + üs);
                } else if (line.charAt(0) == '*') {
                    while (input.hasNext()) {
                        String linec = input.nextLine();
                        if (linec.charAt(0) != '*') {
                            int katsayi = Integer.parseInt(linec.split(",")[0].trim());
                            int üs = Integer.parseInt(linec.split(",")[1].trim());
                            list.insertDownSide(new Node(katsayi, üs));
                        }
                        if (linec.charAt(0) == '*') {
                        }

                    }

                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosyanız bulunamadı.");

        }

    }
    //Dosyayı okuyarak integer bir x değeri döndürür .
int getX(String filePath){
    
    try {
           File file = new File(filePath);

            Scanner input = new Scanner(file);
    int xValue = Integer.parseInt(input.nextLine());
    return xValue;
    } catch (Exception e) {
        return 0;
    
    }
}
/*Bütün liste taranarak gerekli işlemler sonucu toplam hesaplanır.*/
 int  calculate(int x) {
     int Total = 0;
     Node<T> temp = head;

        while (temp != null) {

            Total +=(temp.Katsayı.intValue() * ((int)Math.pow(x, temp.Üs.intValue()) ));
            
            if (temp.next2 != null) {
                Node<T> tempAlt = temp.next2;
                while (tempAlt != null) {
                    Total +=(tempAlt.Katsayı.intValue() * ((int)Math.pow(x, tempAlt.Üs.intValue()) ));
                    
                    tempAlt = tempAlt.next2;
                }
                
            }else{
            }
            temp = temp.next;
            
        }
        return Total;
    }

}
