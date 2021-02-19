// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Did binary tree search with the 'r' value as integer.max value and then followed the traditional binary tree approach

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int l = 0;
        int r = Integer.MAX_VALUE;
        
        while(l<=r)
        {
            int mid =  (l+r)/2;
            
            if(target == reader.get(mid))
                return mid;
            if(target<reader.get(mid))
            {
                r = mid -1;
            }
            else
            {
                l = mid +1;
            }
        }
        return -1;
    }
}


//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Optimised the code for the left and the right value and still doing binary search after disregarding one side.

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int l = 0;
        int r = 1;
        
        while(reader.get(r)!= Integer.MAX_VALUE && reader.get(r)<= target)
        {
            r = r * 2;
        }
        //disregarding left side of mid.(optimising 'l')
        if(target>reader.get(r/2))
        {
            l=r/2;
        }
        //binary search between 'l' and 'r'
        while(l<=r)
        {
            int mid =  (l+r)/2;
            
            if(target == reader.get(mid))
                return mid;
            if(target<reader.get(mid))
            {
                r = mid -1;
            }
            else
            {
                l = mid +1;
            }
        }
        return -1;
    }
}