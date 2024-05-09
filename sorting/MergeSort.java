import java.util.ArrayList;
import java.util.List;

public class MergeSort{
	public void sort(int[] arr){
		mergeSort(arr, 0, arr.length - 1);	
	}
	
	private void mergeSort(int[] arr, int low, int high){
		if(low >= high) return;
		int mid = low + (high - low)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}

	private void merge(int[] arr, int low, int mid, int high){
		int left = low, right = mid+1;
		List<Integer> temp = new ArrayList<>();
		while(left <= mid && right <= high){
			if(arr[left] <= arr[right]){
				temp.add(arr[left]);
				++left;
			} else {
				temp.add(arr[right]);
				++right;
			}
		}
		while(left <= mid){
			temp.add(arr[left]);
			++left;
		}
		while(right <= high){
			temp.add(arr[right]);
			++right;
		}

		for(int i=low; i <= high; i++){
			arr[i] = temp.get(i-low);
		}
	}
}
