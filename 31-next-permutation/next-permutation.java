class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the pivot
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // Step 2: Find the next greater element
        if (i >= 0) {
            int j;
            for (j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}