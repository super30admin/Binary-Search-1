
public class Rotatearray {
    public static void main(String args[]){
        int[] arr = {5,6,1,2,3,4};
        int target = 3;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                System.out.print(mid);
                return;
            }
            else if(arr[low]<=arr[mid]){
                if(target>=arr[low]&& target<arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid +1;
                }
            }
            else{
                if(arr[mid]<target && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }

            
        }
       

    }
}
