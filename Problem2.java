// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// we check whether left half is sorted or right half is sorted
// if left half is sorted then we check whether target lies in left half or not

import java.util.Scanner;
public class Problem2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];
        for(int i=0; i<n; i++){ 
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(a,target));
    }
    public static int search(int a[],int t){
        int l=0,h=a.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==t)
                return mid;
            if(a[l]<=a[mid]){
                if(a[l]<=t&&a[mid]>=t)
                    h=mid-1;
                else
                    l=mid+1;
            }else{
                if(a[mid]<=t&&a[h]>=t)
                    l=mid+1;
                else
                    h=mid-1;
            }
        }
        return -1;
    }
}