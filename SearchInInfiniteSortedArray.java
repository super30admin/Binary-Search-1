/* Runtime Complexity: O(log n)
*/ 


class Solution {
    public int search(ArrayReader reader, int target) {

        int low=0, high=1;
        while(reader.get(high)<target){
            low=high;
            high=2*high;
        }

        //Doing in now range of low to high
        //If we do (low< high) its same but we have add one extra condition check
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(reader.get(mid)== target)
            return mid;
            else if(reader.get(mid)>target)
            {
                high=mid-1;
            }
            else
                low=mid+1;
        }
       return -1; 
    }
}