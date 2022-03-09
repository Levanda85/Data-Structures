package binarysearchtree

data class BinarySearchTree( // burda sadece root olcak, Nodenin left right data.
    var data: Int,
    var left: BinarySearchTree? = null,
    var right: BinarySearchTree? = null
) {
    fun insert(value: Int) {
        when {
            value <= data && left != null -> left!!.insert(value)
            value <= data -> left = BinarySearchTree(value)
            value > data && right != null -> right!!.insert(value)
            value > data -> right = BinarySearchTree(value)
        }
    }

    fun contains(value: Int): Boolean {
        if (value < data && left != null) {
            return left!!.contains(value)
        }
        if (value > data && right != null) {
            return right!!.contains(value)
        }
        return value == data
    }

    fun remove(value: Int, parent: BinarySearchTree): Boolean {
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

    fun min(): Int = if (left == null) data else left!!.min()
}