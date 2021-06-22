class SPMN
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        Arrays.sort(arr);
        int searchFor = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > 0) {
				if (arr[i] == searchFor) continue;
                else if (arr[i] == searchFor+1) searchFor++;
                else break;
        	}
        }
        
        return searchFor+1;
    }
}