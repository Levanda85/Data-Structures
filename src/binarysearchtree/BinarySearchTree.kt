package binarysearchtree

class BinarySearchTree {

    var root: BinarySearchNode? = null

    fun insert(data: Int) {
        val node = BinarySearchNode(data)
        if (root == null) {
            root = node
            return
        }

        insertNode(root!!, node)
    }

    private fun insertNode(parent: BinarySearchNode, node: BinarySearchNode) {
        if (node.data >= parent.data) {
            if (parent.rightChild == null) {
                parent.rightChild = node
            } else {
                insertNode(parent.rightChild!!, node)
            }
        } else {
            if (parent.leftChild == null) {
                parent.leftChild = node
            } else {
                insertNode(parent.leftChild!!, node)
            }
        }
    }

    fun contains(data: Int): Boolean {
        if (root == null) {
            return false
        }

        return containsNode(root!!, data)
    }

    private fun containsNode(parent: BinarySearchNode, data: Int): Boolean {

        if (data > parent.data && parent.rightChild != null) {
            return containsNode(parent.rightChild!!, data)
        } else if (data < parent.data && parent.leftChild != null) {
            return containsNode(parent.leftChild!!, data)
        }
        return parent.data == data
    }


    fun remove(data: Int): Boolean {
        return if (contains(data)) {
            removeNode(root, data)
            true
        } else {
            println("$data not in the tree")
            false
        }
    }

    private fun removeNode(node: BinarySearchNode?, data: Int): BinarySearchNode? {
        if (node == null) {
            return null
        }
        if (data < node.data) node.leftChild = removeNode(node.leftChild!!, data)
        else if (data > node.data) node.rightChild = removeNode(node.rightChild!!, data)
        else {
            if (node.leftChild == null && node.rightChild == null) {
                return null
            } else if (node.leftChild == null) {
                node.data = minValue(node.rightChild!!).data
                node.rightChild = removeNode(node.rightChild!!, node.data)
            } else if (node.rightChild == null) {
                node.data = maxValue(node.leftChild!!).data
                node.leftChild = removeNode(node.leftChild!!, node.data)
            } else {
                node.data = minValue(node.rightChild!!).data
                node.rightChild = removeNode(node.rightChild!!, node.data)
            }
        }
        return node
    }

    private fun minValue(node: BinarySearchNode): BinarySearchNode {
        if (node.leftChild == null) {
            return node
        }
        return minValue(node.leftChild!!)
    }

    private fun maxValue(node: BinarySearchNode): BinarySearchNode {
        if (node.rightChild == null) {
            return node
        }
        return minValue(node.rightChild!!)
    }
}