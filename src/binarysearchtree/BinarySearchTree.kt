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

    fun contains(data: Int): Boolean {
        var currentNode = root
        while (currentNode?.data != data) {
            when {
                data < currentNode!!.data -> {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left
                    } else {
                        return false
                    }
                }
                data > currentNode.data -> {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right
                    } else {
                        return false
                    }
                }
            }
        }
        return currentNode.data == data
    }

    fun remove(data: Int): Boolean {
        if (contains(data)) {
            var prev: BinarySearchNode? = null
            var currentNode: BinarySearchNode? = root
            while (currentNode != null && currentNode.data != data) {
                if (currentNode.data > data) {
                    prev = currentNode
                    currentNode = currentNode.left
                } else if (currentNode.data <= data) {
                    prev = currentNode
                    currentNode = currentNode.right
                }
            }
            when {
                currentNode!!.left == null && currentNode.right == null && currentNode == prev!!.left -> {
                    prev.left = null
                }
                currentNode.left == null && currentNode.right == null && currentNode == prev!!.right -> {
                    prev.right = null
                }
                currentNode.left != null && currentNode.right == null && currentNode == prev!!.left -> {
                    prev.left = currentNode.left
                }
                currentNode.left != null && currentNode.right == null && currentNode == prev!!.right -> {
                    prev.right = currentNode.left
                }
                currentNode.right != null && currentNode.left == null && currentNode == prev!!.left -> {
                    prev.left = currentNode.right
                }
                currentNode.right != null && currentNode.left == null && currentNode == prev!!.right -> {
                    prev.right = currentNode.right
                }
                currentNode.data == root!!.data -> {
                    root!!.right!!.left = root!!.left
                    root = root!!.right
                }
            }
            return true
        } else {
            println("$data is not in the tree")
            return false
        }
    }

    /* when {
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
     return true*/
}