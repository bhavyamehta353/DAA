import java.util.*;
public class mergesort {
    public static void main(String[] args) 
    {
        int arr[] = new int[10000];
        Random rand = new Random();
        for(int i = 0 ; i < arr.length ; i++) 
        {
            arr[i] = rand.nextInt(10000);
        }
        long starttime = System.nanoTime();
        mergeSort(arr , 0 , arr.length - 1);
        long endtime = System.nanoTime();
        long elapsed = endtime - starttime;
        System.out.println("Time taken:" +  elapsed + " " + "ns");
    }

    public static void merge(int arr[], int l , int mid , int r)
    {
        int i,j,k;
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for(i = 0 ; i < n1 ; i++)
        {
            L[i] = arr[l+i];
        }
        for(j = 0 ; j < n2 ; j++)
        {
            R[j] = arr[mid + 1 + j];
        }

        i = j = 0 ; 
        k = l;
        while( i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
        }

        while(i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int left , int right)
    {
        if(left < right)
        {
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left , mid , right);
        }


    }
}

