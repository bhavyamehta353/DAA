import java.util.*;
public class binarysearch {
    public static void main(String args[])
    {
        int arr[] = new int[10000];
        Random rand = new Random();
        for(int i = 0 ; i < arr.length ;i++)
        {
            arr[i] = rand.nextInt(10000);
        }
        Arrays.sort(arr);
        int key;
        System.out.print("Enter the key you want to find:");
        Scanner sc = new Scanner(System.in);
        key = sc.nextInt();

        long starttime = System.nanoTime();
        binarySearch(arr, key);
        long endtime = System.nanoTime();

        long elapsed = endtime - starttime;
        System.out.println("Time taken to search: " + elapsed + " " + "ns");
        sc.close(); 
    }

    public static void binarySearch(int arr[], int key)
    {
        int l = 0;
        int r = arr.length - 1;
        int found = 0;
        while(l <= r)
        {
            int mid = l + (r - l)/2;
            found = 0;
            if(key < arr[mid])
                r = mid - 1;
            else if(key > arr[mid])
                l = mid + 1;
            else if (key == arr[mid])
            {
                System.out.println("Key found at index: " + mid);
                found = 1;
                break;
            }
        }
        if(found == 0)
            System.out.println("Key wasnt found");
    }
}
