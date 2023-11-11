// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Question is only available on leetcode premium
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/* since the length of the array is unknown. We can reduce the problem by obtaining the
* the sub array which will contain the target. Once the sub array is found, we can
* perform the regular binary search to obtain the index of the target */

public class Problem3 {

    public static int findIndex(int arr[], int target){
        int low = 0 ;
        int high = 1;
        while(target > arr[high]){
            high = high *2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] agrs){

        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findIndex(arr,10);
        System.out.println("The target was found at index "+ans);
    }
}
