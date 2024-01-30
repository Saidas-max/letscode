package strings;

import java.util.HashMap;
import java.util.Map;

public class WriteOccurancesOfCharsBeside {

    public static void main(String[] args) {
        String s = "aaaabbcccccde";   
        System.out.println(writeOccurancesOfCharsBeside(s));
        System.out.println(writeOccurancesOfCharsBeside2(s));
    }
    public static String writeOccurancesOfCharsBeside(String s){

        int left = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int right = 0; right < s.length(); right++) {
            if(s.charAt(right)==s.charAt(left)){
                count++;
            }else {
                sb.append(s.charAt(left)).append(count);
                left = right;
                count = 1;
            }
        }
        sb.append(s.charAt(left)).append(count);
        return sb.toString();
    }
    public static String writeOccurancesOfCharsBeside2(String s){

        Map<Character, Integer> frequency = new HashMap<>();

        for (char ch : s.toCharArray()){
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()){
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}
