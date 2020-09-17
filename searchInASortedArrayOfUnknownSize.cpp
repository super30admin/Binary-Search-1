//time complexity: O(logn)
//space complexity:O(1)
//approach: binary search, first check with left=0 & right=1, if found return else keep on increasing the search size left=right, right*=2;
//solved on leetcode? yes
//problem faced? yes, I looked for the solution and then i solved it.
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
        int l=0;
        int r=1;
        while(reader.get(r)<target)
        {
            l=r;
            r=r*2;
        }
        while(l<=r)
        {
            int m=l+(r-l)/2;
            int num=reader.get(m);
            if(num==target)
            {
                return m;
            }
            if(num<target)
                l=m+1;
            else
                r=m-1;
        }
        return -1;
    }
};