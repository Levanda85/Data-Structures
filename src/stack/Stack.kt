package stack

class Stack<T> {
    private var bottom: StackNode<T>? = null
    private var top: StackNode<T>? = null
    private var size = 0

    //This method has time complexity as O(1)
    fun push(value: T) {
        if (isEmpty()) {
            bottom = StackNode(value = value, next = null)
            top = bottom
            size++
            return
        }

        top!!.next = StackNode(value = value)
        top = top!!.next
        size++
    }

    //This method has time complexity as O(n)
    fun pop(): Boolean {
        if (isEmpty()) {
            return false
        } else if (size == 1) {
            bottom = null
            top = null
        } else {
            top = get(size - 2)
            top!!.next = null
        }
        size--
        return true
    }

    //This method has time complexity as O(1)
    fun size(): Int = size

    //This method has time complexity as O(n)
    private fun get(index: Int): StackNode<T>? {
        if (index in 0 until size) {
            var currentNode = bottom
            var currentIndex = 0

            while (currentNode != null && currentIndex < index) {
                currentNode = currentNode.next
                currentIndex++
            }

            return currentNode
        }

        throw IndexOutOfBoundsException()
    }

    //This method has time complexity as O(1)
    private fun isEmpty(): Boolean {
        return size == 0
    }

    //This method has time complexity as O(n)
    override fun toString(): String {
        return if (isEmpty()) {
            "Empty stack"
        } else {
            bottom.toString()
        }
    }
}