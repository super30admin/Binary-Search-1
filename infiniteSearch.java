//Search in Infinite sorted array
//Time Complexity: O(log n)
//Space Complexity: O(1)

public class infiniteSearch {
    public static void main(String[] args) {
        int[] a = {3,5,6,7,8};
        int key = 7;

        int index = modBinSearch(a, key);
        System.out.println(index);
    }


    private static int binarySearch(int a[], int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private static int modifyBinarySearch(int a[], int key){
        int low = 0;
        int high = 1;
        int pHolder = a[0];

        while(pHolder < key){
            low = high;
            high = high * 2;
            pHolder = a[high];
        }

        return binarySearch(a, key, low, high);
    }

}