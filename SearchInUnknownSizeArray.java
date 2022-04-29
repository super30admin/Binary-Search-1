/**

Time Complexity : O(logN)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : The boundary Conditions, 
the code kept on breaking at boundary condition for few submissions

**/
class SearchInUnknownSizeArray
{

    private final int MULTIPLICATION_FACTOR = 2;
    
    public int search(ArrayReader reader, int target) 
    {
        int low = 0;
        int high  = 1;
        
        while(reader.get(high) < target)
        {
            low = high;
            high = high * MULTIPLICATION_FACTOR;
        }
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int midVal = reader.get(mid);
            
            if(midVal == target)
                return mid;
            else if(target > midVal)
                low = mid + 1;
            else
                high = mid -1;
        }
        
        return -1;
    }

}