//Search in Infinite sorted array
class Problem2 {
    public int search(ArrayReader reader, int target) {
        int low = 0, high =1;
        while(target>reader.get(high))
            high = high*2;
        return binarySearch(reader,target, low, high);
        
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(target == reader.get(mid))
                return mid;
            else{
                if(target<reader.get(mid))
                    high = mid-1;
                else
                    low = mid+1;
            }
        } return -1;
    }
}

/*
Time Complexity : Since binary search is used to compute the index, 
the complexity is O(log(n)) 

Space Complexity : Except for the constant space used for 
left, right, mid, no other auxillary space is used. Therefore, it is O(1)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : No

Your code here along with comments explaining your approach
- Low is initialized to 0 and high to 1
- if target doesn't lie in the range of low and high, 
expand the range by multiplying high by 2 and changing low to the old high.
- Once target is found to be in the range [easily found as array stream is given to be sorted], 
perform binary search to compute the index

*/