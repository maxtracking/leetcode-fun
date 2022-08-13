class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x in 0..9) return true
        if (x < 0) return false
        val digits = mutableListOf<Int>()
        var reminder = x
        while (reminder > 0) {
            digits.add(reminder % 10)
            reminder /= 10
        }
        var left = 0
        var right = digits.size - 1
        val minDist = digits.size % 2
        while (right - left > minDist) {
            if (digits[left] != digits[right])
                return false
            left++
            right--
        }
        return true
    }
}