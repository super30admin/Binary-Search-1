/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int s=0;
        int e=1;
        while(reader.get(e)<target){
            s=e+1;
            e=e*2;
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(target<reader.get(mid))
                e=mid-1;
            else
                s=mid+1;
        }
        return -1;
    }
}
