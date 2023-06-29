import java.util.Arrays;
import java.util.stream.Collectors;



public class MissingNumber {


    public static int[] removeTheElement(int[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Get the array
        int[] arr = { 1, 2, 3, 4, 5 };

        // Print the resultant array
        System.out.println("Original Array: "
                + Arrays.toString(arr));

        // Get the specific index
        int index = 2;

        // Print the index
        System.out.println("Index to be removed: " + index);

        // Remove the element
        arr = removeTheElement(arr, index);

        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(arr));
    }
    public static int missingNumber(int[] nums, int maxNum) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberSort(int[] nums, int maxNum) {
        Arrays.sort(nums);

        for (int i = 1; i < maxNum; i += 1) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        // If none is missing
        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
            return 0;
        }

        return maxNum;
    }

    public static int missingNumberSum(int[] nums, int maxNum) {
        // Alternate solution: int sum = (nums.length + 1)*(nums.length) / 2
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }
}
