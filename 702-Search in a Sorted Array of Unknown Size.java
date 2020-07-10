//Time complexity=O(log N)
//Spacecomplexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start=0;
        int end=1;
		//We are initially finding the range in which our target exists then we are calling binarySearch function
        while(target>reader.get(end))
        {
            start=end;
            end=end*2;
        }
        return binarySearch(reader,start,end,target);
    }
    private int binarySearch(ArrayReader reader,int start,int end, int target)
    {
        int mid;
        while(start<=end){
        mid=start+(end-start)/2;
        if(reader.get(mid)==target)
            return mid;
        if(reader.get(start)<=reader.get(mid))
        {
            if(target<reader.get(mid) && target>=reader.get(start))
                end=mid-1;
            else
                start=mid+1;
        }
            if(reader.get(mid)<=reader.get(end))
            {
                if(target>reader.get(mid) && target<=reader.get(end))
                    start=mid+1;
                else
                    end=mid-1;
            }
            }
        return -1;
    }
}