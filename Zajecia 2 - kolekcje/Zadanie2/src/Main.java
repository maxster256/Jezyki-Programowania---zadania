import java.util.*;
public class Main {
    static ArrayList<Integer> array = new ArrayList<>(); //znacznie szybciej dodaje nowe elementy
    static LinkedList<Integer> linked = new LinkedList<>(); //szybciej usuwa elementy
    public static void main(String[] args) {
       start();
    }
    public static void start(){
        System.out.println("\nCzas wykonywania operacji w ArrayList\n");
        measure_time(array,2023);
        System.out.println("\nCzas wykonywania operacji w LinkedList\n");
        measure_time(linked,2023);
    }
    public static void measure_time(List<Integer> list,int item){
        double start,end;

        start = System.nanoTime();
        list.add(item);
        end = System.nanoTime();
        System.out.println("POST time: " + ((end-start)/1000) + " microseconds");

        start = System.nanoTime();
        list.set(0,1999);
        end = System.nanoTime();
        System.out.println("PUT time: " + ((end-start)/1000) + " microseconds");

        start = System.nanoTime();
        list.remove(0);
        end = System.nanoTime();
        System.out.println("DELETE time: " + ((end-start)/1000) + " microseconds");
    }
}