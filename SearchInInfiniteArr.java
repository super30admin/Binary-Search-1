// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No due to primium question access
// Any problem you faced while coding this :

class Solution{
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == Integer.MAX_VALUE) return -1;

        int l = 0;
        int h = 1;
        //get the part of the array until target is less than high index val.
        //increase l tp previous h and h by 2 times.
        while(reader.get(h) < target) {
            l = h;
            h = h*2;
        }

        //do a normal binary search on that part where target is located.
        return binarySearch(reader, target, l, h);
    }

    private int binarySearch(ArrayReader reader, int target, int l, int h) {

        while(l<=h){
            int m = l+(h-l)/2;
            if(reader.get(m) == target){
                return m;
            }
            else if(target > reader.get(m)) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return -1;
    }
}