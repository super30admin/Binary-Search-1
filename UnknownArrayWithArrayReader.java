// Time Complexity : O(log t) where t is index of target
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Solution using ArrayReader as found in Leetcode
class UnknownArrayWithArrayReader {
    public int search(ArrayReader reader, int target) {
        
       if(reader.get(0)==target) return 0; //First element is target
        
        //Array is all increasing, increase start and end to find range for target
        int s = 0;
        int e = 1;
        while(target>reader.get(e))
        {
            s=e;
            e = 2*e;
        }
        
        //Binary search in the obtained range
        while(s<=e)
        {
            int m = s + (e-s)/2;
            if(target==reader.get(m)) return m;
            if(target<reader.get(m))
                e=m-1;
            else
                s=m+1;
        }
            
        return -1;
  
        
    }
    
   
}