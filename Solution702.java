/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution702 {
    public int search(ArrayReader reader, int target) {
        
        int low=0, high=1;
        while(reader.get(high)<target){
            low=high;
            high=2*high;           
    
        }
        return BinarySearch(reader, target,low,high);
        
    }
    
    private int BinarySearch(ArrayReader reader, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            int x=reader.get(mid);
        
        if(target>x)
        {
            low=mid+1;
        }
        else if(target==x)
        {
            return mid;
        }
            else{
                high=mid-1;
            }
        
        
        }
        return -1;
    }
}