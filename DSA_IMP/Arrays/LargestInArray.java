package Arrays;

public class LargestInArray {
    public static int largest(int[] arr) {
        // code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
      int []arr={12,45,32,21,78};
        System.out.println("Maximum element of thios array is : "+largest(arr));
    }
}
