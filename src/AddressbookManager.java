import java.util.Scanner;

/**
 * Created by Оля on 20.10.2014.
 */
public class AddressbookManager {
    public static void main(String[] args) {
        Commandes book = new Commandes();
        Scanner in = new Scanner(System.in);
        out:
        while (true) {
            System.out.println("1: Добавление адресса");
            System.out.println("2: Поиск записи по имени человека");
            System.out.println("3: Поиск записи по индексу");
            System.out.println("4: Удаление записи из книги по индексу");
            System.out.println("5: Получение количества записей в книге");
            System.out.println("6: Вывод всей книги");
            System.out.println("7: Изменение записи по её индексу");
            System.out.println("8: Выход");
            System.out.print("Введите номер необходимого действия: ");
            int m = in.nextInt();

            switch (m) {
                case 1:
                    System.out.println("Введите имя");
                    String n = in.next();
                    System.out.println("Введите телефон");
                    String p = in.next();
                    System.out.println("Введите email");
                    String e = in.next();
                    Address a = new Address(n, p, e);
                    book.add(a);

                    continue;
                case 2:
                    System.out.println("Введите имя для поиска");
                    String t = in.next();
                    int[] dex = book.find(t);
                    if (dex.length == 0) {
                        System.out.println("Человек с таким именем в книге отсутствует");
                    } else {
                        for (int i = 0; i < dex.length; i++) {
                            Address address = book.get(dex[i]);
                            book.print(address);
                        }
                    }
                    continue;
                case 3:
                    System.out.println("Введите индекс записи для поиска");
                    int s = in.nextInt();
                    if (s < book.list.length) {
                        Address v = book.get(s);
                        System.out.println(v.name + " " + v.phone + " " + v.email);
                    } else System.out.println("Элемент с таким индексом отсутствует");
                    continue;
                case 4:
                    System.out.println("Введите индекс записи для удаления");
                    int x = in.nextInt();
                    if (x < book.gecCount() && x>-1) {
                    book.delete(x);
                    } else System.out.println("Запись с таким индексом отсутствует");
                    continue;
                case 5:
                    if (book.gecCount() == 1) System.out.println("В адресной книге " + book.gecCount() + " запись");
                    else if (book.gecCount() == 2 || book.gecCount() == 3 || book.gecCount() == 4)
                        System.out.println("В адресной книге " + book.gecCount() + " записи");
                    else System.out.println("В адресной книге " + book.gecCount() + " записей");
                    continue;
                case 6:
                    book.allprint();
                    continue;
                case 7:
                    System.out.println("Введите индекс записи");
                    int vr = in.nextInt();
                    if (vr < book.gecCount()) {
                        System.out.println("Введите новое имя");
                        String n1 = in.next();
                        System.out.println("Введите новый телефон");
                        String p1 = in.next();
                        System.out.println("Введите новый email");
                        String e1 = in.next();
                        book.izmenenie(vr, n1, p1, e1);
                    } else System.out.println("Запись с таким индексом отсутствует");
                    continue;
                case 8:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Введённое действие невозможно! Повторите попытку");
                    continue;
            }
            break;
        }
    }
}
