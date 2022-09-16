#time complexity O(n)
#space complexity O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
if(matrix.length==0)
{
    return false;
}
int n=matrix.length;
 int m=matrix[0].length;
        
int start=0;
int end=(n*m)-1;
while(start<=end)
{
int  mid=start+(end-start)/2;
    if(matrix[mid/m][mid%m]==target)
    {
        return true;
    }
    if(matrix[mid/m][mid%m]<target)
    {
        start=mid+1;
    }
    else{
        end=mid-1;
    }
    
   
}
    return false;            
    }
}