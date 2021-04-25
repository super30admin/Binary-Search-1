// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
Problem#1
class Solution {
    public int search(int[] a, int target) {
        
       if(a==null || a.length==0)
           return -1;
        int low=0; int high =a.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if((mid==0 || a[mid] < a[mid-1]) && (mid==a.length-1 || a[mid]< a[mid+1]))
            {
                return a[mid];
            }
            else if(a[mid] > a[low]) //left is sorted
            {
                 high=mid-1;
            }
        
               else
                {
                    low=mid+1;
                }
        }
        return 789;
    }
}
Time Complexity is O(logn)
problem#2

class Solution {
    
    public int search(ArrayReader reader, int target) 
    {
        
        if(reader.get(0)==target )
            return 0;
        int i =1;
//Every time we double the index if the target greater than element 
        while(reader.get(i) < target)
        {
            i=i*2;
        }
    
            
        if(reader.get(i)==target)
            return i;
Binary search from the double th index to 
         return binarySearch(reader,target,(i/2)+1, i-1);
        
        
    }
    
    int binarySearch(ArrayReader reader,int x,int low, int high )
    {
        int mid= (low+high)/2;
        while(low<=high)
        {
            if(reader.get(mid)==x)
                return mid;
            else if(reader.get(mid)<x)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
        
    }
}

TimeComplexity is log(position of element)