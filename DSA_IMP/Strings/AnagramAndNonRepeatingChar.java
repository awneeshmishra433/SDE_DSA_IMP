package Strings;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramAndNonRepeatingChar {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        return Arrays.equals(
                s1.chars().sorted().toArray(),s2.chars().sorted().toArray());
    }

    public static char nonRepeatingChar(String s) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : s.toCharArray()){
            if(map.get(ch)==1) return ch;
        }
        return '$';
    }

    public static void main(String[] args) {
        String s1="listen";
        String s2="silent";
        System.out.println("Checking if these strings are anagram or not : "+areAnagrams(s1,s2));

        String s="geeksforgeeks";
        System.out.println("First Non Reapeating Character is : "+nonRepeatingChar(s));
    }
}
