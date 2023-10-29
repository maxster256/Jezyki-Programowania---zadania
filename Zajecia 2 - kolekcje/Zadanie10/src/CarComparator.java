import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car A, Car B){
        if(A.getMarka().compareTo(B.getMarka())==0){
            return A.getModel().compareTo(B.getModel());
        }
        return A.getMarka().compareTo(B.getMarka());
    }
}
