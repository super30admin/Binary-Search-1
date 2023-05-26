// Time Complexity : O(logn)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : a little bit

// It has a class ArrayReader which is built in leetcode so it will not run in local machine

class SearchInInfy {
    public int search(ArrayReader reader, int target) {
        int startValue = reader.get(0);
        if (target < 0) {
            if (startValue > 0) {
                return -1;
            } else {
                int predictedIndex = target - startValue;
                return binarySearch(reader, target, 0, predictedIndex);
            }
        } else {
            int predictedIndex = target - startValue;
            return binarySearch(reader, target, 0, predictedIndex);
        }
    }

    public int binarySearch(ArrayReader reader, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}