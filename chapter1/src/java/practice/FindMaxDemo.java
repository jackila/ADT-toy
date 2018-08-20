package practice;

import java.util.Collection;
import java.util.Collections;

public class FindMaxDemo{


    public static Comparable findMax(Comparable[] arr){

        int maxIndex =0;

        for(int i =0;i < arr.length;i++ ){
            if(arr[i].compareTo(arr[maxIndex]) > 0){

                maxIndex = i;
            }
        }
        //arr[maxIndex] = "hello world"; this will throw exception

        return arr[maxIndex];
    }

    public static double totalArea(Collection<Shape> arr ){
        double totalArea = 0;
        for (Shape s : arr) {
            if(s != null){
                totalArea+=s.size;
            }
        }
        return totalArea;
    }

    public static void main(String[] args) {

        Shape[] sh1 = {
                new Circle(2),
                new Square(4),
                new Rectangle(2,5)

        };

        String[] st1 = {
                "jeckie","rabbit","fire"
        };

        Collection<Circle> cl1 = Collections.EMPTY_LIST;
        cl1.add(new Circle(2)); //java.lang.UnsupportedOperationException
        //System.out.println(totalArea(cl1));

        System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
    }



}

abstract class Shape implements Comparable<Shape> {//java5之前是没有泛型存在的

    int size;

    @Override
    public int compareTo(Shape o) {

        return Double.compare((o).getSize(),getSize());
    }

    public abstract double getSize() ;
}

class Circle extends Shape{

    int radius ;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getSize() {
        return Math.PI*Math.pow((double) radius,2d);
    }
}

class Square extends Shape{
    int base;

    public Square(int base) {
        this.base = base;
    }

    @Override
    public double getSize() {
        return Math.pow(base,2);
    }
}

class Rectangle extends Shape{

    int width;
    int high;

    public Rectangle(int width, int high) {
        this.width = width;
        this.high = high;
    }

    @Override
    public double getSize() {
        return width*high;
    }
}
