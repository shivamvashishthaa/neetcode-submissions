//1. Left se prefix products store karo.
//2. Right se suffix products multiply karo.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null)
            return null;
        if (nums.length == 0)
            return nums;

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: result[i] = product of all elements to the LEFT of i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: multiply by product of all elements to the RIGHT of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}
