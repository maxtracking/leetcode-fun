import java.lang.Math.pow
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

class Solution7 {
    fun reverse(x: Int): Int {
        val stack = Stack<Int>()
        var reminder = Math.abs(x)
        val isNegative = x < 0

        while (reminder > 0) {
            stack.push(reminder % 10)
            reminder /= 10
        }
        val buffer = StringBuffer()
        while (!stack.empty()) {
            val digit = stack.pop()
            buffer.insert(0, digit)
        }
        val reversed: Int = try {
            buffer.toString().toInt()
        } catch (e: Throwable) {
            0
        }
        return if (isNegative) -1 * reversed else reversed
    }
}