class Solution11 {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0
        var area = 0

        while (left < right) {
            if (height[left] < height[right]) {
                area = height[left] * (right - left)
                left++
            } else {
                area = height[right] * (right - left)
                right--

            }
            if (result < area)
                result = area
        }
        return result
    }
}