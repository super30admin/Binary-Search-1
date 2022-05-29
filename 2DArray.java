class 2DArray{

    public boolean searchMatrix(int[][] matrix, int target) {

        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[matrix.length-1].length-1]){
        return false;
        }

        int r=matrix.length;
        int l=0,l1=0,x,m=0;

        while(l<=r){
            m=l+(r-l)/2;
            l1=matrix[m].length-1;
            x=matrix[m][l1];
            int x1=matrix[m][0];
            if(x==target){
                return true;
            }else if(x>target){
                if(x1<=target){
                    break;
                }else{
                    r=m-1;
                }
            }else{
                l=m+1;
            }
        }

        int r1=matrix[m].length-1;
        l1=0;
        int m1=0;

        while(l1<=r1){
            m1=l1+(r1-l1)/2;
            x=matrix[m][m1];
            if(target==x){
                return true;
            }else if(target<x){
                r1=m1-1;
            }else{
                l1=m1+1;
            }
        }

        return false;

    }
}