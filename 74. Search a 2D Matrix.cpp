// TC-OLOG(M*N)
// SC-O(1)
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
      int m=matrix.size();
        int n=matrix[0].size();
        int mid=0;
        int start=0;
        int end=m*n-1;
        while(start<=end){
            mid=(end+start)/2;
          int  mid_value=matrix[mid/n][mid%n];
            if(mid_value==target){return true;}
            else if(mid_value>target){end=mid-1;}
            else {start=mid+1;}
                
        }
        return false;
    }
};