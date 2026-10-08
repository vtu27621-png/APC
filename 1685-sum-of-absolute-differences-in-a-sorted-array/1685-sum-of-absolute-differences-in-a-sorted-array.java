class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            // Formula: (left_count * num - left_sum) + (right_sum - right_count * num)
            res[i] = (i * nums[i] - leftSum) + (rightSum - (n - 1 - i) * nums[i]);

            leftSum += nums[i];
        }

        return res;
    }
}