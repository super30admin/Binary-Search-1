// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :No
// Approach: Using binary search by doubling the search space, till the target is found.
// l,r pointers initially at 0,1 indices.


class SearchSortedArrayUnknownSize {
    public int search(ArrayReader reader,int target)
    {
        int l=0,r=1;
        while(reader.get(r)<target)
        {
            l=r;
            r=2*r;
        }
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(reader.get(m)==target){return m;}
            else if(reader.get(m)<target){l=m+1;}
            else{r=m-1;}
        }
        if(reader.get(l)==target) return l;
        return -1;
    }
}
