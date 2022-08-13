class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun addNext(node: ListNode?): ListNode? {
        next = node
        return next
    }
}