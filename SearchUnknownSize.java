/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        int left=0;
        int right=1;

        while(reader.get(right)<target){
            left=right;
            right=right*2;
        }

        while(left<=right){
            int mid = left+(right-left)/2;
            int num = reader.get(mid);
            if(num==target) return mid;
            if(target<num){
                right = mid -1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
