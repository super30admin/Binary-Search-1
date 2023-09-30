// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
public:
    int search(vector<int>& a, int target) {
    int n = a.size();
    int low=0;
    int high=n-1;
    while(low<high){
        int mid= low+(high-low)/2;
        if(a[0]>target ^ a[0]>a[mid] ^ target > a[mid])low=mid+1;
        else high = mid;

    }
    return ((low==high && a[low]==target) ? low:-1);
}
};
// Your code here along with comments explaining your approach in three sentences only
