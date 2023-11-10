**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

//Time Complexity -> O(log n)
//Space Complexity ->O(1)
class Solution {
    //Using INFINITY_MAX
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        //Locate the part 
        while(reader.get(high)<target){
            low = high;
            high = high * 2;
        }
        //Binary search
        while(low <= high){
            int mid = low +( high - low )/2;
            if(reader.get(mid)==target ) return mid;
            else if (reader.get(mid) > target)
                high = mid -1;
            else
                low = mid+1;
        }
        return -1;
    }
}