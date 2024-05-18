import java.util.*;
public class insertionsort
{
    public static void main(String[] args)
    {
        int arr[] = new int[10000];
        int arr1[] = new int[10000];
        Random rand = new Random();
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = rand.nextInt(10000);
        }

        long starttime1 = System.nanoTime();
        insertionSort(arr);
        long endtime1 = System.nanoTime();

        long starttime2 = System.nanoTime();
        insertionSort(arr);
        long endtime2 = System.nanoTime();
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr1[i] = arr[arr.length - 1 - i];
        }

        long starttime3 = System.nanoTime();
        insertionSort(arr1);
        long endtime3 = System.nanoTime();
        
        long elapsed1 = endtime1 - starttime1;
        long elapsed2 = endtime2 - starttime2;
        long elapsed3 = endtime3 - starttime3;
        System.out.println("Average Case:" + elapsed1 + " " + "ns");
        System.out.println("Best Case:" + elapsed2 + " " + "ns");
        System.out.println("Worst Case:" + elapsed3 + " " + "ns");
    }
    public static void insertionSort(int arr[])
    {
        for(int i = 1 ; i < arr.length ; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}