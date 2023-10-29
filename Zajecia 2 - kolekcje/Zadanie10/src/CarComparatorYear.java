import java.util.Comparator;

public class CarComparatorYear implements Comparator<Car> {
    @Override
    public int compare(Car A, Car B){
        return Integer.compare(A.getRok(),B.getRok());
    }
}
