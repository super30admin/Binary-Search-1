/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int searchSpace = 1;
        int low = 0;
        while(low<=searchSpace){
            if(reader.get(0) == target){
                return 0;
            }

            if(reader.get(searchSpace) < target){
                low = searchSpace;
                searchSpace = searchSpace * 2;
            }
            else{

                int mid = low + (searchSpace - low)/2;
                if(reader.get(mid)== target){
                    return mid;
                }
                else if (reader.get(mid) < target){
                    low = mid + 1;
                }
                else{
                    searchSpace = mid -1;
                }

            }

        }
        return -1;
    }
}