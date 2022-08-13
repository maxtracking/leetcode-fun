import kotlin.math.max

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        }
        val result: ListNode = ListNode(0)
        l1?.`val`?.let {
            result.`val` += it
        }
        l2?.`val`?.let {
            result.`val` += it
        }
        if (result.`val` > 9) {
            when {
                l1?.next != null -> l1.next?.`val` = l1.next!!.`val` + 1
                l2?.next != null -> l2.next?.`val` = l2.next!!.`val` + 1
                else -> {
                    result.next = ListNode(result.`val` / 10)
                    result.`val` = result.`val` % 10
                    return result
                }
            }
            result.`val` = result.`val` % 10
        }
        result.next = addTwoNumbers(l1?.next, l2?.next)
        return result
    }
}