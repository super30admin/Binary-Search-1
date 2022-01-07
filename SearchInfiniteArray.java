//  Time Complexity O(n). Space complexity O(1)

// Approach 
// We will be accomplishing this using two stacks
// The push operations remains similar
// During the peek & pop operation we transfer all the elements from in stack to the out stack and operate/display top element of the out stack.
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while(reader.get(right)<target){
                left = right;
                right = 2*right;
        }
        while(left<=right){
            int mid = left + (right-left)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

// class SearchInfiniteArray{

//     public static int searchNum(int arr[], int target){
//         int left = 0;
//         int right = 1;
//         while(arr[right]<=target){
//             System.out.print("dd" + x  + y);
//                 left = right;
//                 right = 2*right;
//         }
//         while(left<=right){
//             int mid = left + (right-left)/2;
//             if(arr[mid] == target){
//                 return mid;
//             }
//             if(arr[mid] < target){
//                 left = mid + 1;
//             }else{
//                 right = mid - 1;
//             }
//         }
//         return -1;
//     }

//     // public static int binarySearch(int arr[], int target,int left,int right){
//     //     // int left = 0;
//     //     // int right = arr.length - 1;

//     //     return -1;
//     // }

//     public static void main(String args[]){
//         int arr[] = {0,1,3,4,5,6,7,9,11,22,36,54};
//         int target  = 11;
//         int index = searchNum(arr, target);
//         System.out.println("Index " + index);
//     }
// }