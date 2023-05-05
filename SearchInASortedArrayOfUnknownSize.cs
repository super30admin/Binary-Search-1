/*
 * Time Complexity: 0(log(m))
 * Space Complexity: 0(1)
 */
namespace LeetCodeSubmission.BinarySearch1;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

public class SearchInASortedArrayOfUnknownSize
{
    public int Search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        
        int idx = -1;
        
        while(low <= high){
            int mid = (high-low)/2 + low;
            
            if(reader.get(mid) == target){
                idx = mid;
                break;
            }
            
            else if(reader.get(mid) < target){
                
                low = mid+1;
                
                if(low == high){
                    high = 2*high;
                }
            }
            
            else if(reader.get(mid) > target){
                high = mid-1;
            }
            
        }
        
        return idx;
    }
}