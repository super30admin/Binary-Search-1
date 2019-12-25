// Time Complexity : O(N)
    // for loop - O(N)
    // if condition - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

public class Main {

    public static void main(String[] args) {

        int[] numsArray = {1, 2, 3, 4, 5, 6, 7, 25, 75, 13}; // intializing the array of unknown length
        System.out.println(search(numsArray,71));      // returns -1
        System.out.println(search(numsArray,25));      // returns 7
    }

    public static int search(int[] nums, int target) {
        int index = 0;  // index to return if the value is found
        for ( int numbers : nums) {         // using the foreach loop, considers all the elements and goes through one after another
            if(numbers == target){          // if the target element is found, return the index
                return index;
            }
            index++;        // increment the index after each comparison
        }
        return -1;          // return -1 if the element is not found
    }
}
