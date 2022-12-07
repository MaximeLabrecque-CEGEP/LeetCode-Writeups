import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class romanToInt {
    HashMap<Character, Integer> simpleMap = new HashMap<Character, Integer>();
    HashMap<ArrayList<Character>, Integer> lowerMap = new HashMap<>();
    ArrayList<Character> a = new ArrayList<Character>(2);

    int fin = 0;

    public int roman(String s) {

        init();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i != s.length() - 1) {
                char next = s.charAt(i + 1);

                a = new ArrayList<>();
                a.add(c);
                a.add(next);

                if (lowerMap.containsKey(a)) {
                    fin += lowerMap.get(a);
                    i += 1;
                    continue;
                }
            }

           fin += simpleMap.get(c);
        }

        return fin;
    }

    public void init() {
        simpleMap.put('I', 1);
        simpleMap.put('V', 5);
        simpleMap.put('X', 10);
        simpleMap.put('L', 50);
        simpleMap.put('D', 500);
        simpleMap.put('C', 100);
        simpleMap.put('M', 1000);

        lowerMap.put(new ArrayList<Character>(Arrays.asList('I', 'V')), 4);
        lowerMap.put(new ArrayList<Character>(Arrays.asList('I', 'X')), 9);
        lowerMap.put(new ArrayList<Character>(Arrays.asList('X', 'L')), 40);
        lowerMap.put(new ArrayList<Character>(Arrays.asList('X', 'C')), 90);
        lowerMap.put(new ArrayList<Character>(Arrays.asList('C', 'D')), 400);
        lowerMap.put(new ArrayList<Character>(Arrays.asList('C', 'M')), 900);
    }
}
