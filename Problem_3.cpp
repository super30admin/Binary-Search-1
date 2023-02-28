702. Search in a Sorted Array of Unknown Size

TC = O2(logn) = O(logn)
SC = O(1)


class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target) { // O(logn)
            low = high;
            high = high*2;
        }
        while (low < high) { // O(logn)
            int mid = low + (high - low)/2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) < target) low = mid +1;
            else high = mid;
        }
        if (reader.get(low) == target) return low;
        return -1;
    }
};


