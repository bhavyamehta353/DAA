import java.util.*;
public class minmaxsearch {
    public static int min;
    public static int max;
    public static void main(String[] args) {
        int arr[] = new int[10000];
        Random rand = new Random();
        for(int i=0; i<arr.length ; i++)
        {
            arr[i] = rand.nextInt(10000);
        }
        minmaxSearch(arr, 0, arr.length - 1);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
    public static void minmaxSearch(int arr[], int low , int high)
    {
        if(low == high)
        {
            min = max = arr[low];
        }
        else if(low == high - 1)
        {
            if(arr[low] < arr[high])
            {
                min = arr[low];
                max = arr[high];
            }
            else
            {
                min = arr[high];
                max = arr[low];
            }
        }
        else
        {
            int mid = low + (high - low)/2;
            minmaxSearch(arr, low, mid);
            int min1 = min;
            int max1 = max;
            minmaxSearch(arr, mid+1, high);
            if(max1 > max)
                max = max1;
            if(min1 < min)
                min = min1;
        } 
    }
}
