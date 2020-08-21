//Time Complexity :O(logn) //Space Complexity :O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target)
                return pivot;
            if (num > target)
                right = pivot - 1;
            else
                left = pivot + 1;
        }

        return -1;

    }
}