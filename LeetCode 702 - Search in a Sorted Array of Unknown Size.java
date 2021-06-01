// Time Complexity: Since we use binary search methods here, 
// so the time complexity will be O(logn).
/* --------------------------------------------------------*/
// Space Complexity: the space complexity will be O(1).

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // pay attention to the logic:
            // we need firstly check whether the high is greater than target,
            // so that we can confirm the interval or check whether we need move forward.
            if(reader.get(high) < target){
                low = high + 1;
                high = 2 * low;
            }else{
                if(reader.get(mid) == target){
                    return mid;
                }else if(reader.get(mid) < target){
                        low = mid + 1;

                }else{
                        high = mid - 1;
                }
            }
        }
        return -1;
    }
}