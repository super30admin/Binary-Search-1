//Time complexity: log(N)
//Space complexity: O(1)
//In this problem we use the approach of two pointers. 
//We cannot use binary search here because we do not know the last value.
//We compare the high with the target, if it is smaller, we multiply the 
//high by 2 and set low as the previous high.
public class problem3
{
    class Solution {
        public int search(ArrayReader reader, int target) {
            int low = 0; int high = 1;
        
            while(reader.get(high) < target){
        
                low = high;
                high = 2*high;
            }
            while(low<= high){
                int mid = low + (high - Low)/2;
                if(reader. get(mid)= target) return mid;
                else if(reader.get(mid) > target){
                    high = mid - 1;
                } 
                else {
                    low = mid + 1;
                }
                return -1;
            }
    }    
    
