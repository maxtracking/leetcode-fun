class Solution12 {
    fun intToRoman(num: Int): String {
        val nums = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val keys = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)

        val buffer = StringBuffer()
        var reminder = num
        var i = 0
        while (i < keys.size && reminder > 0) {
            while (reminder >= keys[i]) {
                buffer.append(nums[i])
                reminder -= keys[i]
            }
            i++
        }

        return buffer.toString()
    }
}