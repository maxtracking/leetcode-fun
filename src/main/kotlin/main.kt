fun main(args: Array<String>) {
    val list = mutableListOf(10, 1, 5)
    ReverseList().reverseList(list)
    println(list)

    val unique = Unique()
    println("isUnique: ${unique.isUnique("abc")}, isUnique2: ${unique.isUnique2("abc")}, isUnique3: ${unique.isUnique3("abca")}")
    println("isPermutation: ${Permutation().isPermutation2("abb", "bac")}")

    val list1 = buildList1()
    val list2 = buildList2()
    val result = Solution2().addTwoNumbers(list1, list2)
    var head = result
    while (head != null) {
        print(head.`val`)
        head = head.next
    }
    println("\nFINISHED")

    val solution3 = Solution3()
    println(solution3.lengthOfLongestSubstring("abcabcbb"))
    println(solution3.lengthOfLongestSubstring2p("abcabcbb"))

    val solution4 = Solution4()
    println(solution4.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))

    println(Solution5().longestPalindrome("abbaba"))
    println(Solution6().convert("ABCDE", 4))
    println(Solution7().reverse(1534236469))
    println(Solution8().myAtoi("-91283472332"))
    println(Solution9().isPalindrome(1000021))
}

//fun reverseList(list: MutableList<Int>) {
//    if (list.isEmpty()) {
//        return
//    }
//    val item = list.removeFirst()
//    reverseList(list)
//    list.add(item)
//}

//fun isUnique(string: String): Boolean {
//    val set = mutableSetOf<Char>()
//    for (i in string.indices) {
//        if (set.contains(string[i])) {
//            return false
//        }
//        set.add(string[i])
//    }
//
//    return true
//}
//
//fun isUnique2(string: String): Boolean {
//    var bitField = 0
//    for (i in string.indices) {
//        if (bitField and (string[i] - 'a') != 0) {
//            return false
//        }
//        bitField = bitField or (string[i] - 'a')
//    }
//
//    return true
//}
//
//fun isUnique3(string: String): Boolean {
//    val chars = string.toCharArray()
//    chars.sort()
//    for (i in 0 until chars.size - 1) {
//        if (chars[i] == chars[i + 1]) {
//            return false
//        }
//    }
//    return true
//}

//fun isPermutation(string1: String, string2: String): Boolean {
//    if (string1.length != string2.length) {
//        return false
//    }
//    val chars1 = string1.toCharArray()
//    chars1.sort() // n log(n)
//    val chars2 = string2.toCharArray()
//    chars2.sort() // m log(m)
//    return chars1.contentEquals(chars2) // max(m, n)
//    // nlog(n) + mlog(m) + max(m,n) = 2nlog(n) + n ~ nlog(n)
//}
//
//fun isPermutation2(string1: String, string2: String): Boolean {
//    if (string1.length != string2.length) {
//        return false
//    }
//    val set1 = string1.toSet() // n
//    for (element in string2) { // m
//        if (set1.contains(element).not()) {
//            return false
//        }
//    }
//    // max(m,n)
//    return true
//}

fun buildList1(): ListNode {
    val result = ListNode(9)
    var head: ListNode? = result
    for (i in 1..6) {
        head!!.next = ListNode(9)
        head = head.next
    }
    return result
}

fun buildList2(): ListNode {
    val result = ListNode(9)
    var head: ListNode? = result
    for (i in 1..3) {
        head!!.next = ListNode(9)
        head = head.next
    }
    return result
}
