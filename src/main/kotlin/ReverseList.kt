class ReverseList {
    fun reverseList(list: MutableList<Int>) {
        if (list.isEmpty()) {
            return
        }
        val item = list.removeFirst()
        reverseList(list)
        list.add(item)
    }
}