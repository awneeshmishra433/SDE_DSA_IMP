package Strings;

public class MinCharsForPalindrome {
    public static int minChar(String s) {

        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();

        // Combine original + separator + reverse
        String str = s + "#" + rev;

        // Build LPS array
        int[] lps = new int[str.length()];

        int len = 0;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                    i--;
                }
            }
        }

        // Longest palindromic prefix
        int longestPalPrefix = lps[str.length() - 1];

        return s.length() - longestPalPrefix;
    }

    public static void main(String[] args) {
        String s = "aacecaaaa";
        System.out.println("Minimum characters to add to make it palindrome is : "+minChar(s));
    }
}
