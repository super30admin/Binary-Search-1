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
        int l=0;
        int r=1;
        while(reader.get(r)<target){
            l=r;
            r=2*r;
        }
        return BS(reader,l,r,target);
    }
    int BS(const ArrayReader& reader, int l, int r,int target){
        while(l<=r){
            int mid = l+floor((r-l)/2);
            if(reader.get(mid)==target){
                return mid;
            }
            else if (reader.get(mid)<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
};