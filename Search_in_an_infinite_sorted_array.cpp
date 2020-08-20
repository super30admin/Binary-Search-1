// Search_in_an_infinite_sorted_array.cpp
// Time Complexity O(logN)
// Space Complexity: O(1)

#include <iostream>
using namespace std;
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        /*initialize left to 0 and right to 1.
        Keep incrementing left (by 1) and right values(by 2) until
        right elemnt is less than target. These are our array boundries */
        int left = 0, right = 1;
        while (reader.get(left) != 2147483647 && reader.get(right) != 2147483647) {
            if (reader.get(right) < target) {
                right = right + 2;
                left += 1;
            }
            else {
                break;
            }

        }
        //binary search with above calculated left and right values as array boundries.
        while (left <= right) {
            int mid = (left + right) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
};
int main()
{
    return 0;
}
