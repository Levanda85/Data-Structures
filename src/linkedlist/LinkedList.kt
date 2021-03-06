package linkedlist

class LinkedList<T> {
    private var head: LinkedListNode<T>? = null
    private var tail: LinkedListNode<T>? = null
    private var size = 0

    //This method has time complexity as O(1)
    fun add(value: T) {
        if (isEmpty()) {
            head = LinkedListNode(value = value, next = null)
            tail = head
            size++
            return
        }

        tail!!.next = LinkedListNode(value = value)
        tail = tail!!.next
        size++
    }

    //This method has time complexity O(n)
    fun add(index: Int, value: T) {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index - 1) {
            currentNode = currentNode.next
            currentIndex++
        }

        val newNode: LinkedListNode<T> = LinkedListNode(value = value, next = null)
        when {
            index > size -> println("You can't add an element at index $index, last index is ${size - 1}")
            index == size -> add(value)
            index == 0 -> {
                newNode.next = head
                head = newNode
                size++
            }
            else -> {
                val temp = currentNode!!.next
                currentNode.next = newNode
                newNode.next = temp
                size++
            }
        }
    }

    //This method has time complexity O(n)
    fun contains(value: T): Boolean {
        var currentNode = head
        while (currentNode?.value != value && currentNode != tail) {
            currentNode = currentNode?.next
        }
        return currentNode?.value == value
    }

    //This method has time complexity as O(3n) and it means O(n)
    fun remove(value: T): Boolean {
        if (this.contains(value)) {
            if (size == 1) {
                head = null
                tail = null
            } else {
                when (val index = indexOf(value)) {
                    0 -> head = head!!.next
                    size - 1 -> {
                        tail = get(size - 2)
                        tail!!.next = null
                    }
                    else -> {
                        val temp = get(index - 1)!!
                        val tempNext = temp.next
                        temp.next = tempNext?.next
                    }
                }
            }
            size--
            return true
        } else {
            return false
        }
    }

    //This method has time complexity as O(4n) and it means O(n)
    fun removeAt(index: Int): Boolean {
        val currentNode = get(index)
        if (currentNode != null) {
            remove(currentNode.value)
            return true
        }
        return false
    }

    //This method has time complexity as O(n)
    fun indexOf(value: T): Int {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentNode.value != value) {
            currentNode = currentNode.next
            currentIndex++
        }

        return if (currentNode != null) currentIndex else -1
    }

    //This method has time complexity as O(n)
    fun get(index: Int): LinkedListNode<T>? {
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

    //This method has time complexity as O(n)
    fun clear() {
        if (size != 0) {
            for (i in 0 until size) {
                removeAt(0)
            }
        } else {
            println("list is already empty")
        }
    }

    //This method has time complexity as O(1)
    fun isEmpty(): Boolean {
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