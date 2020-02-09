// Time Complexity :
//O(logN)

//// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ModifiedBinarySearch {
    public static void main(String[] args) {
    int[] arr = {3,5,7,10,11,15,16,17,18,19,20};
    int target = 11;
        System.out.println(search(arr,target));
    }
    private static int search(int[] arr,int target){
        int low = 0;
        int high =1;
        while (arr[high]<target){
            low = high+1;
            high = high*2;
        }

        while(low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                low =mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return -1;
    }
}
