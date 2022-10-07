// Time Complexity : log(m) + log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// I have taken input as an reader array instead of ArrayReader for it to work on the IDE
public class searchInInfiniteArray {
    public int search(int[] reader, int target) {

        int low =0;
        int high = 1;
        int mid;

        while( reader[high] < target ){

            if( reader[high] == target){
                return high;
            }else{
                low = high+1;
                high = 2*high;
            }

        }

        return helper(reader, low, high, target);

    }

    public int helper(int[] reader, int low, int high, int target){


        while (low<= high){

            int mid = low + (high-low)/2;

            if(reader[mid] == target){
                return mid;
            }else if( reader[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return -1;
    }
}
