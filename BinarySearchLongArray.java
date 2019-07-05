class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=2; //initial value of high(unknown index)
        
        while(low<high)
        {
            if(reader.get(high)==target||reader.get(low)==target) //if any boundaries are equal to target
            {
                return reader.get(high)==target ? high : low;
            }
            if(reader.get(high)<=target) //if target>current upper index, then shift the search to the upper side of the array
            {
                low=high+1;
                high = high*2 > 10000? 10000 : high*2;
            }
            else
            {
                high = low + (high-low)/2; // target may lie in the lower half of the array, hence restrict the value of high to lower half
            }
        }
        
            return -1;
    }
}
