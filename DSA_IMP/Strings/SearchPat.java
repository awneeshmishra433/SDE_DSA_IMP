package Strings;

import java.util.ArrayList;

public class SearchPat {
    public static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        // Build LPS array for pattern
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Search pattern in text
        i = 0;
        int j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // Complete pattern found
                if (j == m) {
                    ans.add(i - j);

                    // Continue searching for overlapping occurrences
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "geek";
        System.out.println("The pat found at following indiceces : "+search(pat,txt));
    }
}
