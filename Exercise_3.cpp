// Time Complexity                                  : O(N)
// Space Complexity                                 : O(Log N)
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : The edge cases caused issues but resolved them quickly. 

#include<bits/stdc++.h>
using namespace std;



#define MAX 2147483647

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int l = 0, r = 1, e = 1;
        
        while(l <= r) {
            int md = l + (r-l)/2;
            int v = reader.get(md);
            
            if(target == v) {
                return md;
            } else if (target > v) {
                l = md+1;
                if(target <= reader.get(r)) {
                    r = r;
                } else {
                    e *= 2;
                    r = e;
                }
            } else {
                r = md - 1;
            }
            
        }
        return -1;
    }
};