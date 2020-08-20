
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No, i  need subscription to do this.
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

int search(ArrayReader nums, int target)
{
int low  = 0;
int high = 1;

// getting the end limit or starting of the infinite values in the array.
while (nums.get(high) != INT_MAX )
    high = high*2;
}

// then after getting the end limit we simply apply the binary search to the array.

int binarysearch(ArrayReader nums, int target)
{
    int s = 0;
    int e = nums.size() - 1;

    while(s <= e) {
        int m = s + (e - s) / 2;
        if(nums.get(m) == target){
            return m;
        }
        else if (nums.get(mid) > target){
                e = m - 1;
            }
            else s = m+1;
            
    }
    return -1;
}