import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Person> lista = new ArrayList<>();
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        add_people();
        System.out.println("\nLista przed sortowaniem:");
        iterate(lista);
        ListComparator com = new ListComparator();
        Collections.sort(lista,com);
        System.out.println("\nLista po sortowaniu (wzgledem wieku):");
        iterate(lista);
    }
    public static void iterate(ArrayList<Person> lista){
        for(Person person : lista){
            System.out.println("Name: "+person.getName()+"     Age: "+person.getAge());
        }
    }
    public static void add_people(){
        lista.add(new Person("Anna",32));
        lista.add(new Person("Maciej",22));
        lista.add(new Person("Mateusz",25));
        lista.add(new Person("Joanna",21));
        lista.add(new Person("Pawel",26));
    }
}