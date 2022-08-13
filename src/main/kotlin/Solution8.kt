class Solution8 {
    fun myAtoi(s: String): Int {
        var ans: Long = 0
        var p1 = 0
        var isPos = true
        while (p1 < s.length && s[p1] == ' ') {
            p1++
        }
        if (p1 < s.length && s[p1] == '+')
            p1++
        else if (p1 < s.length && s[p1] == '-') {
            isPos = false
            p1++
        }
        while (p1 < s.length && (s[p1] - '0') >= 0 && (s[p1] - '0') <= 9) {
            ans = ans * 10 + (s[p1] - '0')
            if (!isPos && -1 * ans <= Int.MIN_VALUE) {
                return Int.MIN_VALUE
            } else if (ans > Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
            p1++
        }
        return if (isPos) ans.toInt() else (-1 * ans).toInt()
    }
}