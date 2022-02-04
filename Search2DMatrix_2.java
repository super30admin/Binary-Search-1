/*
Time Complexity = O(logn)
* */

class Search2DMatrix_2{
    int m = matrix.length, n = matrix[0].length;

    int s= 0, e =m*n-1;

    while(s < =e)
    {
        int mid = s+(e-s)/2;
        int i = mid/n;
        int j = mid%n;

        if(matrix[i][j] == target)
        {
            return true;
        }
        else if (target > matrix[i][j])
        {
               s= mid+1;
        }
        else
        {
            e = mid-1;
        }


    }

}