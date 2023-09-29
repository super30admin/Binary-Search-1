// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

public class SearchUnknownSizeArray {
    class Solution {
        public int search(ArrayReader reader, int target)
        {
            int l = 0, h = 1;
            while(reader.get(h) <= target){
                l = h;
                h = 2*h;
            }
            while(l <= h){
                int mid = l+(h-l)/2;
                if(reader.get(mid) == target) return mid;
                if(reader.get(mid) < target){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            return -1;
        }

    }
}
