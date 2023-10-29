import java.util.*;

public class Main {
    static HashSet<Integer> hash = new HashSet<>();
    static TreeSet<Integer> tree = new TreeSet<>();
    static int number;
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        System.out.println("Podaj 5 liczb");
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        for(int i=0;i<5;i++){
            number=in.nextInt();
            hash.add(number);
            tree.add(number);
        }
        System.out.println("Zawartosc HashSet:");
        iterate(hash);      //nieposortowana kolekcja bez powtorzen
        System.out.println("Zawartosc TreeSet:");
        iterate(tree);      //posortowana kolekcja bez powtorzen
        in.close();
    }
    public static void iterate(Set<?> set){
        for(Object num : set){
            System.out.println(num);
        }
    }
}