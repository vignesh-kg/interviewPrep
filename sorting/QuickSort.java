public class QuickSort{
	public void sort(int[] arr){
		quicksort(arr, 0, arr.length - 1);
	}

	private void quicksort(int[] arr, int low, int high){
		if(low < high){
			int partitionIndex = findPartitionIndex(arr, low, high);
			quicksort(arr, low, partitionIndex-1);
			quicksort(arr, partitionIndex+1, high);
		}
	}

	private int findPartitionIndex(int[] arr, int low, int high){
		int i = low, j = high;
		int pivot = arr[low];
		while(i < j){
			while(i <= high && arr[i] <= pivot) ++i;
			while(j >= low && arr[j] > pivot) --j;

			if(i < j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		for(int num : arr){
			System.out.print(num + " ");
		}
		System.out.print("\n");
		return j;
	}
}
