
public class InfiniteSortedArray {
	public int search(int[] nums, int target) {
		try {
			int i = 0;
			while (nums[i] != target) {
				i++;
			}
			if (nums[i] == target) {
				return i;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bounds");
		}
		return -1;
	}
	public static void main(String[] args) {
		InfiniteSortedArray i = new InfiniteSortedArray();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int target = 11;
		System.out.println(i.search(arr, target));
	}
}
