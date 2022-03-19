package queues

class Queue<T> {
    private var first: QueueNode<T>? = null
    private var last: QueueNode<T>? = null
    private var size = 0

    //This method has time complexity as O(1)
    fun push(value: T) {
        if (isEmpty()) {
            first = QueueNode(value = value, next = null)
            last = first
            size++
            return
        }

        last!!.next = QueueNode(value = value)
        last = last!!.next
        size++
    }

    //This method has time complexity as O(n)
    fun pop(): Boolean {
        if (isEmpty()) {
            return false
        } else if (size == 1) {
            first = null
            last = null
        } else {
            first = first?.next
        }
        size--
        return true
    }

    //This method has time complexity as O(1)
    fun size(): Int = size

    //This method has time complexity as O(1)
    private fun isEmpty(): Boolean {
        return size == 0
    }

    //This method has time complexity as O(n)
    override fun toString(): String {
        return if (isEmpty()) {
            "Empty stack"
        } else {
            first.toString()
        }
    }
}