//Time Complexity : O(log mn)
//Space Complexity : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlow=0,rowhigh=matrix.length-1,collow=0,colhigh=matrix[0].length-1,pr=-1,pc=-1;
        
        while(rowlow<=rowhigh)
        {
            int mid=rowlow+(rowhigh-rowlow)/2;
            if(matrix[mid][0]<=target)
            {
                pr=mid;
                rowlow=mid+1;
                
            }
            else
            {
                pr=mid-1;
                rowhigh=mid-1;
            }
        }
        while(collow<=colhigh)
        {
            if(pr<0)
                return false;
            int mid=collow+(colhigh-collow)/2;
            System.out.println(mid+" "+pr);
            if(target==matrix[pr][mid])
                return true;
            else if(target>matrix[pr][mid])
            {
                collow=mid+1;
                
            }
            else{
                colhigh=mid-1;
            }
        }
        return false;
    }
}