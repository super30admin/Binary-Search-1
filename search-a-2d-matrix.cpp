class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if(m==0)return false;
        int n = matrix[0].size();
        int low = 0;
        int high = (m*n)-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int middle_element = matrix[mid/n][mid%n];
            if(middle_element==target)return true;
            else if(middle_element > target)high = mid-1;
            else low = mid+1;
        }
        return false;
    }
};
