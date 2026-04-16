//Time complexity : O(log n)
//Space complexity : O(1)
//Search Inside a Sorted Array whose Length is unknown

public class problem2Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while(reader.get(right) <= target) {
            left = right;
            right = 2*right;
        }

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
