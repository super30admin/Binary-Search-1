public class Test {
    public static void main(String[] args) {
        System.out.println("Index of target is");
        int[] arr = {3,5,7,10,11,13,14,15,17,19};
        int target = 11;
        System.out.println(m_binary_search(arr, target));
    }
    private static int m_binary_search(int arr[], int target)
    {
        int low = 0, high = 1;
        while(arr[high] < target)
        {
            low = low+1; //works with low = high + 1;
            high = high*2;
        }
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            if (target == arr[mid])
                return mid;
            if (arr[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}