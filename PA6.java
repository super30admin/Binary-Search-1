class PA6{
    
    public static int search(int arr[], int target){
        int low= 0;
        int high =1;
       
        while(low<=high){

            if(target<=arr[high]){
                int mid=0;
                while(low<=high){
                    mid = low+(high-low)/2;
                    if(arr[mid]== target){
                        return mid;
                    }
                    if(arr[mid]<target){
                        low= mid+1;
                    }
                    else{
                        high= mid-1;
                    }
                }
                return -1;
            }
            else{
                low= high;
                //if(2*high > arr.length-1){
                  //  high = arr.length-1;
               // }
                //else{
                    high= 2*high;
               // }
                
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7,8,9,14,17,21,28,29,33,36,39,58,63,66,72};
        int target= 7;
       System.out.println("Target "+target+" found at index "+search(arr, target)); 
    }
}