// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
    Since we do not have the length of the array, we try to find the low and high. We keep doubling high until arr[high] > target.
    Then we perform normal binary search between low and high.

*/
public class InfiniteArr {
  
    public static int search(int arr[],int target)
    {
        int low=0;
        int high = 1;
        while(arr[high]<target)
        {
            low = high;
            high = 2 * high;
        }
        return binarySearch(arr,target,low,high);
    }
    private static int binarySearch(int arr[], int target,int low,int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                            100, 130, 140, 160, 170}; 
        System.out.println(search(arr,10));
    }
}