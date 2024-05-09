public class InsertionSort{
	public void sort(int[] arr){
		System.out.println("Entering Insertion Sort");
		for(int i = 0; i < arr.length; i++){
			int j = i;
			while(j > 0 && arr[j-1] > arr[j]){
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				--j;
			}
		}
	}
}
