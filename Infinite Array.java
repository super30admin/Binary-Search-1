// Time Complexity : O(log(n)), for searching the range its  O(log(n)) + for searching the element its O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        if(low>high) return -1; //if its not in range, not possible becasue of implementation
        
        int mid = low + (high-low)/2;
        
        if(reader.get(mid) == target)
            return mid;
        else if(reader.get(mid)<target)
            return binarySearch(reader, mid+1, high, target);
        else
            return binarySearch(reader, low, mid-1, target);
    }
    
    public int search(ArrayReader reader, int target) {
        int slow = 0; // slow pointer
        int fast = 1; // fast pointer
        
        while(reader.get(fast)<=target){
            slow = fast;
            fast *= 2;
        }
        
        return binarySearch(reader, slow, fast, target);
    }
}