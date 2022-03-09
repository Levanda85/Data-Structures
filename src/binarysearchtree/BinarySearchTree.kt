package binarysearchtree

class BinarySearchTree {

    var root: BinarySearchNode? = null

    fun insert(data: Int) {
        val node = BinarySearchNode(data)
        if (root == null) {
            root = node
            return
        }
        var prev: BinarySearchNode? = null
        var currentNode: BinarySearchNode? = root
        while (currentNode != null) {
            if (currentNode.data > data) {
                prev = currentNode
                currentNode = currentNode.left
            } else if (currentNode.data <= data) {
                prev = currentNode
                currentNode = currentNode.right
            }
        }
        if (prev!!.data > data) prev.left = node else prev.right = node
    }

    fun contains(value: Int): Boolean {
        var currentNode = root
        while (currentNode?.data != value) {
            when {
                value < currentNode!!.data -> {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left
                    } else {
                        return false
                    }
                }
                value > currentNode.data -> {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right
                    } else {
                        return false
                    }
                }
            }
        }
        return currentNode.data == value
    }

    /*fun remove(value: Int, parent: BinarySearchTree): Boolean {
        if (contains(value)) when {
            value < data && left != null -> {
                return left!!.remove(value, this)
            }
            value < data -> return false
            value > data && right != null -> return right!!.remove(value, this)
            value > data -> {
                return false
            }
            else -> {
                when {
                    left == null && right == null && this == parent.left -> {
                        parent.left = null
                    }
                    left == null && right == null && this == parent.right -> {
                        parent.right = null
                    }
                    left != null && right == null && this == parent.left -> {
                        parent.left = this.left
                    }
                    left != null && right == null && this == parent.right -> {
                        parent.right = this.left
                    }
                    right != null && left == null && this == parent.left -> {
                        parent.left = this.right
                    }
                    right != null && left == null && this == parent.right -> {
                        parent.right = this.right
                    }
                    else -> {
                        data = right!!.min()
                        right!!.remove(data, this)
                    }
                }
                return true
            }
        } else {
            println("$value is not in the tree")
            return false
        }
    }

    fun min(): Int = if (left == null) data else left!!.min()*/
}