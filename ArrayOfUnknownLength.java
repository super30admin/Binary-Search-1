// Time Complexity : O(log(n))+ O(log(n)) = 2 * O(logn)
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Premium Question

// Your code here along with comments explaining your approach

class ArrayOfUnknownLength{
    public int search(ArrayReader reader, int target) {
        //initial initialization of low and high
        int low = 0;
        int high = 1;
        
        //Searching a range for target by always doubling the high. TC: O(logn)
        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) <= target){
            low = high;
            high = high * 2;
        }
        
        //BinarySearh Elements. TC : O(logn)
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(reader.get(mid) == target) return mid;
            
            else if(reader.get(mid) < target){
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return -1;
    }
}