class Solution{
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = -1;
        int n =-1;
        for(int i =0;i<matrix.length;i++)
        {
            
            if(target <=matrix[i][matrix[i].length -1])
            {
                
                m=i;
                
                break;
            }
        }
        if(m!=-1)
        {
            
                for(int i=0; i<matrix[m].length;i++)
                                {
                                    
                                    if(target==matrix[m][i])
                                    {
                                        return true;
                                    }
                                }
            return false;
            
        }
        else
        {
            
            return false;
        }
        
       
    }
}