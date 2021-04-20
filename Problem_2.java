/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//Binary Search
//Time Complexity:O(logn)
//Space Complexity: O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0,right=1;
        while(target>reader.get(right)){
            left=right;
            right=2*right;
        }
        return bs(reader, left,right,target);
    }
    private int bs(ArrayReader reader, int left, int right, int target){
        int pivot;
        while(left<=right){
            pivot=left+ (right-left)/2;
            if(target==reader.get(pivot)) return pivot;
            else if(target>reader.get(pivot)) {
                left=pivot+1;
            }
            else right=pivot-1;
            
        }
        return -1;
    }
}