import java.util.Random;

public class quicksort {
    public static void main(String[] args) {
        int arr[] = new int[10000];
        Random rand = new Random();
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = rand.nextInt(10000);
        }

        long startime = System.nanoTime();
        quickSort(arr, 0 , arr.length - 1);
        long endtime = System.nanoTime();

        long elapsed = endtime - startime;
        System.out.println("Time taken:" + elapsed + " " + "ns");
    }
    
    public static int partition(int arr[] , int low , int high)
    {
        int pivot = arr[high];
        int i = low;
        for(int j = low ; j < high ; j++)
        {
            if(arr[j] <= pivot)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low , int high)
    {
        if(low < high)
        {
            int pivot = partition(arr , low , high);
            quickSort(arr, low , pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
}
