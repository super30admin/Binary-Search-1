/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int l=0;     // intial values start with smallest range 
        int h =1;
        while(reader.get(h) != INT_MAX && reader.get(h)<target)// target is not present increase the range
    
        {
            l =h;
            h = h*2;   // binary value bcz we will use binary search
        }
        //once we get the range apply binary search
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            if(reader.get(mid)==target)
             return mid;
             else if (reader.get(mid)<target)
              l = mid+1;
              else 
              h = mid-1;
        } 
        return -1;
    }
};