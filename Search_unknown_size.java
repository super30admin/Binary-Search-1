// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution2 {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 1;
        while(reader.get(h)<target){
            l = h;
            h = 2*h;
        }
        while(l<=h){
            int mid = l + (h-l)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                l = mid+1;
            else
                h = mid-1;
        }
        return -1;
    }
}