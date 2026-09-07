package Strings;

public class addBinary {
    public static String addBinary(String s1, String s2) {
        // code here
        StringBuilder res=new StringBuilder ();
        int n=s1.length()-1;
        int m=s2.length()-1;
        int carry=0;
        while(n>=0||m>=0||carry>0){
            int sum=carry;
            if(n>=0){
                sum=sum+s1.charAt(n)-'0';
                n--;
            }
            if(m>=0){
                sum+=s2.charAt(m)-'0';
                m--;
            }
            res.append(sum%2);
            carry=sum/2;
        }
        res.reverse();
        // to manage the zeroes in input output requirements
        int i=0;
        while(i<res.length()-1 && res.charAt(i)=='0') i++;
        return res.substring(i);

    }
    public static void main(String[] args) {
        String s1="10001";
        String s2="11111";
        System.out.println("Addition of these strings is : "+addBinary(s1,s2));
    }
}
