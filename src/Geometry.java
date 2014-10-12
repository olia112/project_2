import java.util.Scanner;

/**
 * Created by Оля on 12.10.2014.
 */
public class Geometry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double s=0;
        System.out.println("Введите количество углов в фигуре");
        int m = in.nextInt();
        Point [] l = new Point [m];
        System.out.println("Вводите координаты углов по порядку");
        for (int i=0;i<m;i++){
            System.out.println("Введите координаты "+(i+1)+" угла");
            System.out.println("Введите координату x");
            double x=in.nextDouble();
            System.out.println("Введите координату y");
            double y=in.nextDouble();
            l[i] = new Point(x, y);
        }
        for (int i=0;i<m;i++){
            if (i==(m-1)){s=s+perimeter(l[i], l[0]);}
            else s=s+perimeter(l[i], l[i+1]);
        }
        System.out.println("Периметр равен: " +s);
    }
    public static double perimeter (Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x))+Math.sqrt((p1.y-p2.y)*(p1.y-p2.y));

    }
}
