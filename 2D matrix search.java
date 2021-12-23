//Time complexity: O(m)+O(logn), m=number of rows, n=number of columns
//Space complexity: n (creating an arraylist of size n)
import java.util.*;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res=false;
        int m=matrix.length; int n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            if(target==matrix[i][0])
            {
                res=true;
                break;
            }
            else if(target >matrix[i][0] && target <=matrix[i][n-1])
            {
                ArrayList<Integer> arr=new ArrayList<Integer>();
                for(int k=0;k<n;k++)
                {
                    arr.add(matrix[i][k]);
                }
                res= BinarySearch(arr, 0, n-1, target);
                break;
            }
        }
        return res;
    }
    public boolean BinarySearch(ArrayList<Integer> arr, int l, int h, int t)
    {
      
        if(h>=l)
        {
            int mid= (h+l)/2;
            if(t==arr.get(mid))
            {
                return true;
            }
            else if(t>arr.get(mid))
            {
                return BinarySearch(arr,mid+1,h,t);
            }
            else if(t<arr.get(mid))
            {
                return BinarySearch(arr,l,mid-1,t);
            }
        }
        return false;
        
    }
}