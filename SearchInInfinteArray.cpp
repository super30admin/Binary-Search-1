class Solution {
public:
    int search(const ArrayReader& reader, int target)
    {
        int low = 0, high = 1;

        while (reader.get(high) != INT_MAX) {
            if ((reader.get(low) <= target) && (reader.get(high) >= target)) {
                break;
            }

            low = high;
            high = high * 2;
        }
    
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (reader.get(mid) == target) {
                return mid;
            }

            if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        return -1;
    }
};
