import java.util.Map;
import java.util.HashMap;

public class ValidParentheses {


    Map<Character, Character> parantheses = new HashMap<Character, Character>();

    public boolean isValid(String s) {
        init();

        if (s.length() <= 1)
            return false;

        for (int i = 0; i < s.length(); i++) {

            if (parantheses.containsKey(s.charAt(i)) && s.charAt(i + 1) == parantheses.get(s.charAt(i)) ) {
                i += 1;
                continue;
            }
            

            if (s.length() > i + 2 && parantheses.containsKey(s.charAt(i + 1)) && s.charAt(i + 2) == parantheses.get(s.charAt(i + 1))) {
                if (parantheses.containsKey(s.charAt(i)) && s.charAt(i + 3) == parantheses.get(s.charAt(i))) {
                    if (s.length() == i + 3)
                        return true;
                    i += 1; 
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    private void init() {
        parantheses.put('(', ')');
        parantheses.put('{', '}');
        parantheses.put('[', ']');
    }
}
