// 702. Search in a Sorted Array of Unknown Size

// Time Complexity : O(log n)
// Space Complexity : O(1) since we only used pointers 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// [-1,2,4,6,7,8,11,15,17,19]
// [ 0,1,2,3,4,5, 6, 7, 8, 9]
// low is at index 0 
// what is the unknown? - where to put high pointer!! so initially put high at index 1 
// keep multiplying high by 2 -> and stop when a[high] > target 
// then you know that is your end point, and you can do BS between low and high..

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while( reader.get(high) < target ){
            low = high; // missed this line the first time
            high*=2;
        }
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(low) <= target && target < reader.get(mid))
                high = mid -1;
            else
                low = mid+1;
        }
        return -1;
    }
}