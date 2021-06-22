class MaxSubArraySum{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){

		int max = arr[0];
		int prevArrSum = arr[0];
        
		for (int i = 1; i < n; i++) {

			prevArrSum = prevArrSum > 0 ? prevArrSum + arr[i] : arr[i];

            if (prevArrSum > max) max = prevArrSum;
		}

		return max;
    }
    
}