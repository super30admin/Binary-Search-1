class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0, right=Integer.MAX_VALUE;
        while (left<=right) {
            int mid=(left+right)/2; 
            int x = reader.get(mid);
            if (x==Integer.MAX_VALUE || x>target)
            {
                right=mid-1; 
            }
            else if (x<target) 
            {
                left=mid+1; 
            }
            else 
            {
                return mid; 
            }
        }
        return -1; 
    }
        
    
}