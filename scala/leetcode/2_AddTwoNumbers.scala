/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var carry = 0
        val dummy = List(0)
        var current = dummy

        var a = l1
        var b = l2

        while(a != null || b != null || carry > 0){
                    val sum = (if (a != null) a.x else 0) + (if (b != null) b.x else 0) + carry
            
            carry = sum / 10 // Return the decimal digit of the number
            val digit = sum % 10 // Return the integer digit of the number

            current.next = new ListNode(digit)
            current = current.next

            if(a != null) a = a.next
            if(b != null) b = b.next
        }

        dummyHead.next
    }
}