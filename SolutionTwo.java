// Time Complexity : Not sure about this confused about log complexity
// Space Complexity : Not sure about this
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : no problem it was simple as compre to other problem in the same section.


// Your code here along with comments explaining your approach
/*
Array is sorted so we just take mid element
if mid element is target then we found the element just return mid as index
if target is less than mid element then move the end to mid-1 location
if target is greater than mid element then move the start to mid+1 location
loop condition until start meets end.

if not found then come out of loop target will be either start index or end index
  */

class SolutionTwo {
    public int search(ArrayReader reader, int target)
    {
        if(reader==null)
            return -1;

        int start=reader.get(0);
        int end=reader.get(10000-1);
        int mid=0;

        while(start<=end)
        {
            mid=start+(start+end)/2;

            if(reader.get(mid)==target)
                return mid;

            if(target<mid)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        if(reader.get(start)==target)
            return start;
        if(reader.get(end)==target)
            return end;

        return -1;

    }
}