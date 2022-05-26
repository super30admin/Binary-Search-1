/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //Time complexity: O(logn)
        //Space complexity: O(1)
        if(reader.get(0)==target){
            return 0;
        }
        int l=0,i=1;
        while(reader.get(i)<target){ 
            i*=2;
        }
        int h=i;
        while(l<=h){
            int m=l+(h-l)/2;
            if(reader.get(m)==target){
                return m;
            }
            else if(reader.get(m)>target){
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return -1;
    }
}