import java.util.Scanner;

/**
 * Created by Оля on 20.10.2014.
 */
public class Commandes {
    public Address[] list = new Address[0];

    public void add(Address newaddr) {
        Address[] newlist = new Address[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newlist[i] = list[i];
        }
        newlist[newlist.length - 1] = newaddr;
        list = newlist;
    }

    public int[] find(String name) {
        int j = 0;
        int[] t = new int[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i].name.equals(name)) {
                int[] w = new int[t.length + 1];
                for (int l = 0; l < t.length; l++) {
                    w[l] = t[l];
                }
                w[j] = i;
                j++;
                t = w;
            }
        }
        return t;
    }

    public Address get(int index) {
        return list[index];
    }


    public void delete(int index) {
            Address[] newlist = new Address[list.length - 1];
            int j = 0;
            for (int i = 0; i < list.length; i++) {
                if (i == index) continue;
                newlist[j] = list[i];
                j++;
            }
            list = newlist;
    }


    public int gecCount() {
        return list.length;
    }

    public void allprint() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(i+") ");print(list[i]);
        }

    }

    public void izmenenie(int l, String n1, String p1, String e1) {
            list[l].name = n1;
            list[l].phone = p1;
            list[l].email = e1;
    }    
    public void print (Address entry){
        System.out.println("Имя: " + entry.name + " Телефон: " + entry.phone + " Email: " + entry.email);
    }
}
