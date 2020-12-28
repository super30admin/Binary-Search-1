


class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty() && matrix.size()==0) return false;
        int m=matrix.size();
        int n=matrix[0].size();
        int low=0; int high = m*n-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            int r=mid/n;// n is number of coloumns
            int c=mid%n;
            
            if(target==matrix[r][c]) return true;
            else if (target<matrix[r][c])
                high=mid-1;
            else
                low=mid+1;
        }    
            
        return false;
                   
        //return 0;
    }
};