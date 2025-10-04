/**   
 *                  (finding range)      (BS)
 *  Time Complexity: log(m)       +   log(n) = log(m) if m > n
 *                   log(m)       +   log(n) = log(n) if n > m
 * 
 *   Time complexity of increasing search space by twice is same as 
 *   reducing the search space by half hence log(m) and binary search has TC on log(n)
 * 
 *  Space Complexity: O(1) as no extra space
 * 
 *  */

/**
 * First we find the range by checking target with high pointer.
 * If high is less than target, we found our range
 * else increase high by twice
 * Once range is found, apply binary search on range
 */

class Solution {

    public int search(ArrayReader reader, int target){

        int low = 0;
        int high = 1;

        while(target > reader(high)){ // find the range by checking high is less than target
            low = high;
            high = 2 * high;
        }

        // if range founf do binary search
        while(low <= high){

            int mid = (low + (high - low) / 2);

            if(reader(mid) === target){
                return reader(mid);
            }else if(reader(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;

    }
}