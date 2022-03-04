class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                arr.add(matrix[i][j]);
            }
        }
        
        int low = 0;
        int high = arr.size()-1;
        
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            
            if(arr.get(mid)==target)
            {
                return true;
            }
            else if(arr.get(mid)>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return false;
    }
}