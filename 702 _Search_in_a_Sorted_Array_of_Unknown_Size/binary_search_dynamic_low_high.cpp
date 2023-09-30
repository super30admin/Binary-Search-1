// Time Complexity : O(target)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A (no premium subscription)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We increase the search space exponentially (factor of *2) until we have upper bound >= target
// Everytime we increase the upper bound, we also update the lower bound of search space to prev upper bound +1 because it wont exist below the prev upper bound
// Now do simple BS in the current search space

#include<bits/stdc++.h>
using namespace std;

// Uses custom ArrayReader
class ArrayReader {
public:
    ArrayReader() {
        arr = vector<int>{-1,0,3,5,9,12};
    }
    int get(int idx) {
        int n = arr.size();
        if(idx>=n) {
            return INT_MAX;
        }
        return arr[idx];
    }
private:
    vector<int> arr;
};

class Solution {
public:
    int search(ArrayReader* reader, int target) {
        int low=0, high =1;
        while(low<=high) {
            if(target > reader->get(high)) {
                low = high+1;
                high = 2*low+1;
            }
            else {
                int mid = low + (high-low)/2;
                if(reader->get(mid) == target) {
                    return mid;
                }
                else if(reader->get(mid) < target) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
};

int main() {
    ArrayReader* reader = new ArrayReader();
    Solution S;
    cout<<S.search(reader, 9)<<endl;
}



