import java.util.ArrayList;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        add_cars();
        System.out.println("\nLista przed sortowaniem:");
        iterate(cars);

        cars.sort(new CarComparator());
        System.out.println("\nLista po sortowaniu(wzgledem marki oraz w drugiej kolejnosci modelu):");
        iterate(cars);

        cars.sort(new CarComparatorYear());
        System.out.println("\nLista po sortowaniu(wzgledem roku od najstarszego):");
        iterate(cars);
    }
    public static void iterate(ArrayList<Car> list){
        for(Car car : list){
            System.out.println(car.getMarka()+"   "+car.getModel()+"   "+car.getRok());
        }
    }
    public static void add_cars(){
        cars.add(new Car("Toyota","Corolla",2020));
        cars.add(new Car("Volkswagen","Golf",2019));
        cars.add(new Car("Honda","Civic",2018));
        cars.add(new Car("Audi","A4",2017));
        cars.add(new Car("Ford","Mustang",2022));
        cars.add(new Car("Jeep","Wrangler",2020));
        cars.add(new Car("Jeep","Altima",2017));
    }
}