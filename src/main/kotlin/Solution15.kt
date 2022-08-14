import java.util.*

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        var num1Idx = 0
        while (num1Idx + 2 < nums.size) {
            if (num1Idx == 0 || nums[num1Idx] != nums[num1Idx - 1]) {
                var num2Idx = num1Idx + 1
                var num3Idx: Int = nums.size - 1
                while (num2Idx < num3Idx) {
                    val sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx]
                    if (sum == 0) {
                        // Add triplet to result
                        result.add(listOf(nums[num1Idx], nums[num2Idx], nums[num3Idx]))
                        num3Idx--

                        // Skip all duplicates from right
                        while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1])
                            num3Idx--
                    } else if (sum > 0) {
                        // Decrement num3Idx to reduce sum value
                        num3Idx--
                    } else {
                        // Increment num2Idx to increase sum value
                        num2Idx++
                    }
                }
            }
            num1Idx++
        }
        return result
    }
}