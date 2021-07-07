// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: Since the length of the array is unknown, we cannot apply the regular binary search directly. We first need to get the range of numbers within which the target is expected to exist. The steps involved for this purpose are:
// initialize low = 0, high = 1
// double the high index every time we get an unsuccessful check (whether target is less than high or not).
// To optimize the low value, we can assign it to the previous high value as we know it for sure that the target does not exist till that value.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        try {
            while(target > reader.get(high)) {
                low = high;
                high *= 2;
            }
            return binarySearch(reader, low, high, target);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you are trying to access is out of bounds");
            return Integer.MAX_VALUE;
        }
    }
    
    public int binarySearch(ArrayReader reader, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(target >= reader.get(low) && target < reader.get(mid)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}