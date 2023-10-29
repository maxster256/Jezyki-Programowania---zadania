import java.util.Comparator;

public class ListComparator implements Comparator<Person> {
    @Override
    public int compare(Person A, Person B){
        return Integer.compare(A.getAge(),B.getAge());
    }
}
