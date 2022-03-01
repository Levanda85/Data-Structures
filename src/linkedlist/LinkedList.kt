package linkedlist

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun add(value: T) {
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

    fun add(index: Int, value: T) {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index - 1) {
            currentNode = currentNode.next
            currentIndex++
        }

        val newNode: Node<T> = Node(value = value, next = null)
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

    fun contains(value: T): Boolean {
        var currentNode = head
        while (currentNode?.value != value && currentNode != tail) {
            currentNode = currentNode?.next
        }
        return currentNode?.value == value
    }

    fun remove(value: T): Boolean {
        if (this.contains(value)) {
            if (size == 1) {
                head = null
                tail = null
            } else {
                val index = indexOf(value)
                when (index) {
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

    fun removeAt(index: Int): Boolean {
        val currentNode = get(index)
        if (currentNode != null) {
            remove(currentNode.value)
            return true
        }
        return false
    }

    fun indexOf(value: T): Int {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentNode.value != value) {
            currentNode = currentNode.next
            currentIndex++
        }

        return if (currentNode != null) currentIndex else -1
    }

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

    fun size(): Int = size

    fun clear() {
        if (size != 0) {
            for (i in 0 until size) {
                removeAt(0)
            }
        } else {
            println("list is already empty")
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }
}