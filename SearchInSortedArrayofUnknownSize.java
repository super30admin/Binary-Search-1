/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int high=1;
        
        while(reader.get(high)!=Integer.MAX_VALUE && reader.get(high)<=target)
        {
            high=high*2;
        }
        
        return binarySearch(reader,target,0,high);
    }
    
    private int binarySearch(ArrayReader reader,int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(reader.get(mid) ==target)
                return mid;
            else if(reader.get(mid)<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}

//time: O(log n)where n is the number of elements
//space:O(1)
//ran succeddfuly on leetcode
//faced issue before the class for taking pointer at infinity.After class solution is clearly understood 
