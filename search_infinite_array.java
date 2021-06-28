class Solution {
    public int search(ArrayReader reader, int target) {        
        int low  = 0;
        int high = 1;
        
        while(low<=high && low!=Integer.MAX_VALUE)
        {
            if(reader.get(low)==target)
            {
                return low;
            }
            if(reader.get(high)<= target)
            {
                low = high;
                high = high*2;
            }
            else{
                int mid = low + (high-low)/2;
                if(reader.get(mid)==target)
                {
                    return mid;
                }
                if(reader.get(mid)>target)
                {
                        high = mid-1;
                }
                else{
                        low = mid+1;
                    }      
                }
        }
        return -1;
    }
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1).
