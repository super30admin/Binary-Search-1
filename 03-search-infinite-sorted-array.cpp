/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index) const;
 * };
 */

 /*
 TC - O(logN), where N is the size of the array, although unknown to us but still optimal
 SC - O(1)
 Issues Faced - saw this problem after a long time, had difficulty visualizing the initial expansion logic but was able to guess correctly to start at 1 and keep doubling
 //had to also think about how the INT_MAX boundary automatically becomes the stop point for the search if we hit it

 Solved on Leetcode - No, since I do not have LC Premium IDE access for this question
 
 */

 class Solution {
    public:
        int search(const ArrayReader& reader, int target) {
            int lo = 0;
            //approach should be some sort of way in which we expand rightward and keep looking, by a factor of 2 each time
            int hi = 1;

            while (reader.get(hi) < target) {
                lo = hi;
                hi = hi * 2;
            }

            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
                
                if (reader.get(mid) == target) {
                    return mid;
                }

                if (reader.get(mid) > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return -1;
           
            
        }
    };
    