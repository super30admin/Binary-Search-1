//Search in sorted array of unknown size - LC 153

// Binary sort can be applied in any scenario where the search space can be reduced to half or doubled to half.
// Arrayreader API is used to read this array of size unknown
// We increase the high pointer by 2x every time the element is not found. And move the low to previous high - Till our target is in the range or low and high
// This way we are doubling our search range
// Once L and H are determined, we do the normal Binary Search
// find mid and compare nums[mid] with target
// Time Complexity - O(log(n))


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high)<target){
            low = high;
            high=2*low;   
        }
        while(low<=high){
            int mid = low+(high-low)/2; //to handle integer overflow in Java. Doesnot                                       //happen in dynamic languages like python, JS
            if (reader.get(mid)==target){
                return mid;

            }
            else if (reader.get(mid)>target){
                high=mid-1;
                }
        else if(reader.get(mid)<target){
            low=mid+1;
            }
                
        }
        return -1;
    }
}
