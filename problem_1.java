class problem_1{
/*
 * 
 * 
 * 
 * 
 */
    public boolean searchMatrix(int[][] ar, int T) {
        int up = 0 ;
        int down = ar.length-1;
        
        while(up<=down){
            int m = down-(down-up)/2;
            int x = ar[m][ar[0].length-1];
            
            if(T>x){up=m+1;}
            else if(T<x){
                if(T<ar[m][0]){down=m-1;}
                    else{
                    int l = 0;
                    int r = ar[0].length-1;
                    
                    while(l<=r){
                        int mid = r-(r-l)/2;
                        int y = ar[m][mid];
                        
                        if(T>y){l=mid+1;}
                        else if(T<y){r=mid-1;}
                        else{return true;}
                    }
                    return false;
                    
                }
            }
            else{return true;}
        }
        return false;
        
    }
}
