//time O(log N)
//space O(1)
//approach: Binary search


class Solution {
    public int search(ArrayReader reader, int target) {
        int left  = 0;
        int right = 1;
        while(target > reader.get(right)) {
                left = right;
                right *=2;
        }
        while(left<=right) {
            int mid  = (right-left)/2 + left;
            if(reader.get(mid) == target) {
                return mid;
            } else if (target < reader.get(mid)) {
                right = mid -1;
            } else if (target > reader.get(mid)) {
                left = mid + 1;
            }
        }  
        return -1;
    }
}
