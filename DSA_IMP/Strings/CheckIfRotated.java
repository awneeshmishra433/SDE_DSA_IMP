package Strings;

public class CheckIfRotated {
    public static boolean areRotations(String s1, String s2) {
        // code here
        if(s1.length()!=s2.length()) return false;
        return (s1+s1).contains(s2);
    }//got tle here so next

        public boolean areRotations2(String s1, String s2) {

            if (s1.length() != s2.length()) {
                return false;
            }

            String text = s1 + s1;

            return kmp(text, s2);
        }

        private boolean kmp(String text, String pattern) {

            int n = text.length();
            int m = pattern.length();

            // Build LPS array
            int[] lps = new int[m];

            int len = 0;
            int i = 1;

            while (i < m) {

                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
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

                if (text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;

                    // Complete pattern found
                    if (j == m) {
                        return true;
                    }
                } else {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }

            return false;
        }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
    }
}
