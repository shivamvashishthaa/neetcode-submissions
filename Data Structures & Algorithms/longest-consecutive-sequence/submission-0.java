// Step 1: Add all numbers to a HashSet
// Step 2: Check if each number is the START of a sequence
// Step 3: Count forward from the start until the chain breaks
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (Integer integer : nums) set.add(integer);

        int length = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                length = Math.max(length, currentLength);
            }
        }
        return length;
    }
}
