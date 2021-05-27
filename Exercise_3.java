
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int search(ArrayReader reader, int target) {

        int high = 1;

        while(reader.get(high) < target) {

            /** increment high using bitwise left shift*/
            high = high << 1;

        }

        /** push previous value of high to low using bitwise right shift*/
        int low = high >> 1;


        /**Traditional binary search */
        while(low<=high){

            int mid = low + (high - low) / 2;
            if(reader.get(mid) > target) {
                high = mid - 1;
            }
            else if(reader.get(mid) < target) {
                low = mid + 1;
            }
            else {
                return mid;
            }

        }

        return -1;


    }
}