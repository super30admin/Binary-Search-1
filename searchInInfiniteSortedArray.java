/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 //tc O(logn)
 // sc O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
       int start = 0;
        int end = 1;
        
        // find the range/eliminate the rest of the space search
        
        while(reader.get(end)<=target){
            start=end;
            end*=2;
        }
        // boiling down to normal bs
        while(start<=end){
            int mid = (start+end)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                start=mid+1;
            else if(reader.get(mid)>target)
                end=mid-1;
            
        }
        
        return -1;
        
    }
}
