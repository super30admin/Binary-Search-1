// Time Complexity : O(logn) as the search space is reduced to half everytime ; where n is the no. of elements in array
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

class Search_In_InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1; // starting with low =0 and high = 1 as we do not the size of array and each
                      // time increasing high by 2 times and taking low to the previous position of
                      // high and then searching in the space from low to high
        while (reader.get(high) < target) { // taking the loop till the value of target is less then value at high
            low = high;
            high = 2 * high;
        }
        while (low <= high) {     //implementing binary search 
            int mid = low + (high - low) / 2;   // to avoid integer overflow ,mid has been calculated in this way 2^31 -1
            if (reader.get(mid) == target)      
                return mid;
            else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}