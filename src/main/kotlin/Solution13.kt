class Solution13 {
    fun romanToInt(s: String): Int {
        val nums = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val keys = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)

        var str = s
        var result = 0
        var i = 0
        while (i < nums.size && str.isNotEmpty()) {
            val prefix = nums[i]
            val len = prefix.length
            while (str.startsWith(prefix)) {
                result += keys[i]
                str = str.substring(len)
            }
            i++
        }

        return result
    }
}