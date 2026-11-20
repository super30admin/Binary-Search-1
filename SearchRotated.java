/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }

 TC: O(logn)
 SC: O(1)
 */

class SearchRotated {
    public int search(ArrayReader reader, int target) {
        int l =0;
        int h =1;
        while(reader.get(h)<target){
            l=h;
            h=h*2;
        }

        while(l<=h){
            int mid = l+(h-l)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            if(reader.get(mid)<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }
}