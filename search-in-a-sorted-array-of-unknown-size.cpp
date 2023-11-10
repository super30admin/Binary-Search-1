/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */
// The code performs a binary search on a sorted array with an unknown size, utilizing the ArrayReader interface to fetch elements.
// It first finds an appropriate range (low and high) where the target might be present by doubling the high index until reader.get(high) exceeds the target.
// Then, it applies binary search within this identified range.
// Time Complexity: O(log n)
// Space Complexity: O(1)

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low=0, high=1;
        while(reader.get(high)<target){
            low=high;
            high=2*high; 
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)return mid;
            else if(reader.get(mid)>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
};