//Binary Search is performed.
// Time Complexity is: O( log target) 

public class SearchInSortedArrayOfUnknownSize {
    
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target)
        {
            return 0;
        }
        
        int left = 0,right = 1;
        
        while(reader.get(right)<target)
        {
            left = right;
            right++;
        }
        
        int middle,num;
        
        while(left<=right)
        {
            middle = left + (right - left)/2;
            
            num = reader.get(middle);
            
            if(num == target)
            {
                return middle;
            }
            if(num>target)
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
        
        return -1;
    }
}