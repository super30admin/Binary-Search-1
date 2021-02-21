// Time Complexity : O(log N) where N is the length of elements. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach

public class RotatedArray {
    
    public static int getIndexForTheTarget(int[] array, int target) {
        
        int low = 0;
        int high = array.length -1;

        while(low<= high) {
            int mid = low + (high - low) /2;
            if(array[mid] == target) {
                return mid;
            }

            if(array[low]<=array[mid]) //If starting less than mid, then it must be sorted
            {
                if(target >= array[low] && target < array[mid]) { //If the target element is preset, we should travers to left side of the array
                    high = mid - 1;
                } else { // else go to right
                    low = mid + 1;
                }
            } else  { 
                if(target>array[mid] && target <= array[high]) {  // if the target is grater than mid and less than high, it should be available in the right side,
                    low = mid+1;
                } else {
                    high = mid -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] rotatedArray = {3,1};
        int index = getIndexForTheTarget(rotatedArray, 1);
        System.out.println("The value is presented in the index: "+index);

    }
}
