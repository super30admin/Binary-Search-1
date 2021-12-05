// Time Complexity: O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {

    public int search(ArrayReader reader, int target) {
            
            int low=0;
            int high=1;
            
            // Increase the window size by doubling the high pointer till target in range
            while(reader.get(high)<target)
            {
                low=high;
                high=high*2;
            }
            
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                
                if(reader.get(mid)==target)
                    return mid;
                if(reader.get(mid)<target)
                    low=mid+1;
                else high=mid-1;
            }
            return -1;
        }
    }

