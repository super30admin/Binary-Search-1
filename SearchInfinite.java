class SearchInfinite{
    // Time Complexity : O(n) + log(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    //leetcode interface already defined:

    interface ArrayReader{
        public int get(int index){
            //i assume there must be some internal method here so just for the reference defined the
            //interface here for TA.
        }
    }

    public int search(ArrayReader reader, int target){

        /*
        1. this is somewhat like fast and slow pointer type algorithm to define the scope
        of array so that later we can apply binary search in that discovered scope.
        2. We applied this algorithm because we don't have proper defined end of array. Thats why we
        create our own array out of infinite array and then check for the target
         */
        int start = 0, end = start + 1;
        while (reader.get(end) < target){
            start = end;
            end = end * 2;
        }

        return helper(reader,target,start,end);
    }

    /*
        This is recurssive binary search approach. Iterative approach can also be used.
        If needed, will modify algorithm
     */
    private int helper(ArrayReader reader, int target, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = start + end - start/2;

        if (reader.get(mid) == target){
            return mid;
        }
        else if(reader.get(mid) > target){
            return helper(reader,target,start,mid-1);
        }
        else{
           return helper(reader,target,mid+1,end);
        }
    }

}

/*
Leetcode submission analysis:
47 / 47 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 40.4 MB

 */