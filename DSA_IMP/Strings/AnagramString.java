package Strings;
import java.util.Arrays;

public class AnagramString {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        return Arrays.equals(
                s1.chars().sorted().toArray(),s2.chars().sorted().toArray());
    }

    public static void main(String[] args) {
        String s1="listen";
        String s2="silent";
        System.out.println("Checking if these strings are anagram or not : "+areAnagrams(s1,s2));
    }
}
