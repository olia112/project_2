import java.util.Scanner;

/**
 * Created by Оля on 20.10.2014.
 */
public class Commandes {
    public Address[] list = new Address[0];
    public int[] t = new int[0];

    public void Add(Address newaddr) {
        Address[] newlist = new Address[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newlist[i] = list[i];
        }
        newlist[newlist.length - 1] = newaddr;
        list = newlist;
    }

    public int[] find(String name) {
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].name.equals(name)) {
                int[] w = new int[t.length + 1];
                for (int l = 0; l < t.length; l++) {
                    w[l] = t[l];
                }
                w[j] = i;
                j++;
                System.out.println("Индекс: " + i + ") Имя: " + list[i].name + " Телефон: " + list[i].phone + " Email: " + list[i].email);
                t = w;
            }
        }
        if (t.length == 0) {
            System.out.println("Человек с таким именем в книге отсутствует");
        }
        return t;
    }

    public Address get(int index) {
        return list[index];
    }


    public void delete(int index) {
        if (index < list.length) {
            Address[] newlist = new Address[list.length - 1];
            int j = 0;
            for (int i = 0; i < list.length; i++) {
                if (i == index) continue;
                newlist[j] = list[i];
                j++;
            }
            list = newlist;
        } else System.out.println("Запись с таким индексом отсутствует");
    }


    public int gecCount() {
        return list.length;
    }

    public void allprint() {
        for (int i = 0; i < list.length; i++) {
            // System.out.println(i + ") Имя: " + list[i].name + " Телефон: " + list[i].phone + " Email: " + list[i].email);
            System.out.print(i+") ");print(list[i]);
        }

    }

    public void izmenenie() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите индекс записи");
        int l = in.nextInt();
        if (l < list.length) {
            System.out.println("Введите новое имя");
            String n = in.next();
            System.out.println("Введите новый телефон");
            String p = in.next();
            System.out.println("Введите новый email");
            String e = in.next();
            list[l].name = n;
            list[l].phone = p;
            list[l].email = e;
        } else System.out.println("Запись с таким индексом отсутствует");
    }
    public void print (Address adr){
        System.out.println("Имя: " + adr.name + " Телефон: " + adr.phone + " Email: " + adr.email);
    }
