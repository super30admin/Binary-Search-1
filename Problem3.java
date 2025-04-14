//Time Complexity: O(log T) T: it is the position of the target
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//702. Search in a Sorted Array of Unknown Size

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Problem3 {
    public int search(ArrayReader reader, int target) {

        int left=0,right=1; // taking first two elements as base

        while(reader.get(right)<=target){
            left=right; // left shifted to remove unwanted nums
            right=right*2; // inreasing the right boundary twice in each iteration
        }
        
        while(left<=right){ // basic binary search
            int mid=left+(right-left)/2;

            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;      
    }
}
