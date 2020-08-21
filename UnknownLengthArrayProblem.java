class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0, right=1;
         while(reader.get(right)!=Integer.MAX_VALUE)
         {
         	right=right*2;
         }
        return binarySearch(reader,target,left,right);
    }
    int binarySearch(ArrayReader reader,int target,int left,int right)
    {
        while (left<=right) {
            int mid=left+(right-left)/2; 
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)>target)
            {
                right=mid-1; 
            }
            else  
            {
                left=mid+1; 
            }
            
        }
        return -1; 
    }
        
} 
//Time complexity=O(logn)
//Space complexity=O(1)