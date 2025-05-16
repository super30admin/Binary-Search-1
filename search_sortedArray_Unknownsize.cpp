//Time complexity : O(logm + log k)

#include <bits/stdc++.h>
using namespace std;

class ArrayReader {
public:
    vector<int> arr;
    
    ArrayReader(vector<int>& input) {
        arr = input;
    }

    int get(int index) {
        if (index >= arr.size()) return INT_MAX;
        return arr[index];
    }
};

class Solution {
public:
    int search(ArrayReader& reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);

            if (val == target)
                return mid;
            else if (val < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
};

int main() {
    vector<int> nums = {1, 3, 7, 10, 13, 18, 24, 35, 47, 59, 72, 85, 100};
    ArrayReader reader(nums);

    Solution sol;
    int target = 35;

    int result = sol.search(reader, target);
    if (result != -1) {
        cout << "Target " << target << " found at index " << result << endl;
    } else {
        cout << "Target " << target << " not found in the array." << endl;
    }

    return 0;
}
