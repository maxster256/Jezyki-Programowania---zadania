import java.util.*;

public class Main {
    static HashMap<String,Integer> hash = new HashMap<>();
    static TreeMap<String,Integer> tree = new TreeMap<>(); //posortowana wedlug kluczy (alfabetycznie)
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        add_elements(hash);
        add_elements(tree);
        System.out.println("HashMap:\n"+hash+"\n");
        System.out.println("TreeMap:\n"+tree);
    }
    public static void add_elements(Map<String,Integer> mapa){
        mapa.put("Paris",2102650);
        mapa.put("Vienna",1982442);
        mapa.put("Sofia",1280334);
        mapa.put("Milan",1354196);
        mapa.put("Moscow",13104177);
        mapa.put("Cologne",1084831);
        mapa.put("Yerevan",1092800);
        mapa.put("Madrid",3280782);
    }
}