/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 *///Time=O(log(n))
   //Space=O(1)
class Solution{
    public int search(ArrayReader reader, int target) {
        int l=0, h=1; 
        
        while (reader.get(h)<=target) {
            l=h;
            h*=2;
            
        }
        
        while (l<=h) {
            int mid=l+(h-l)/2;
            int cur = reader.get(mid);
            if (cur==target) 
                return mid;
            else if (cur<target)
                l=mid+1;
            else
                h=mid-1; 
        }
        return -1; 
    }
}
