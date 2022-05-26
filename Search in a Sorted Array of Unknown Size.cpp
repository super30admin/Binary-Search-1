//Time Complexity- O(logn)
//Space Complexity- O(1)

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
        
        int start=0;
        int end=1;
        
        while(reader.get(end)<target){         //While element at end is lesser than target, update start to end and end to 2*end
            start=end;
            end++;
        }
        
        while(start<=end){                     //Applying Binary Search on our search space
            int mid=start+(end-start)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            if(reader.get(mid)>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
};