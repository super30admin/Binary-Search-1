class Solution
{
public:
    bool searchMatrix(vector<vector<int>> matrix, int target)
    {
        int m = matrix.size();
        int n = matrix[0].size();
        int start = 0;
        int end = m * n - 1;
        while (start <= end)
        {
            /* code */
            int mid = floor(start + (end - start) / 2);
            int row_num = floor(mid / n);
            int col_num = floor(mid % n);
            if (matrix[row_num][col_num] == target)
            {
                return true;
            }
            else
            {
                if (matrix[row_num][col_num] > target)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
};