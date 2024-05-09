public class Main{
	public static void main(String[] args){
		int[] arr = new int[]{13, 25, 99, 45, 2, 9, 101, 27, 37, 33, 49, 57, 1, 2, 3, 99, 110};
		//int[] arr = new int[]{13, 25, 99, 45, 2, 9, 100};
		System.out.println("Before Sorting");
		for(int num : arr){
			System.out.print(num + " ");
		}
		System.out.print("\n");
		//QuickSort qs = new QuickSort();
		//qs.sort(arr);
		MergeSort ms = new MergeSort();
		ms.sort(arr);
		System.out.println("After Sorting");
		for(int num : arr){
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}
}
