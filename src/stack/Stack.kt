package stack

import linkedlist.Node

class Stack<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    //This method has time complexity as O(1)
    fun push(value: T) {
        if (isEmpty()) {
            head = Node(value = value, next = null)
            tail = head
            size++
            return
        }

        tail!!.next = Node(value = value)
        tail = tail!!.next
        size++
    }

    //This method has time complexity as O(2n) and it means O(n)
    fun pop(): Boolean {
        val lastNode = getLastElement()
        if (lastNode != null) {
            if (size == 1) {
                head = null
                tail = null
            } else {
                val index = size - 1
                when (index) {
                    0 -> head = head!!.next
                    else -> {
                        tail = get(size - 2)
                        tail!!.next = null
                    }
                }
            }
            size--
            return true
        }
        return false
    }

    //This method has time complexity as O(n)
    private fun getLastElement(): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < size - 1) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    //This method has time complexity as O(n)
    fun get(index: Int): Node<T>? {
        if (index in 0 until size) {
            var currentNode = head
            var currentIndex = 0

            while (currentNode != null && currentIndex < index) {
                currentNode = currentNode.next
                currentIndex++
            }

            return currentNode
        }

        throw IllegalArgumentException()
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
            "Empty list"
        } else {
            head.toString()
        }
    }
}