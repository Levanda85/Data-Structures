package binarysearchtree

data class BinarySearchNode(
    var data: Int,
    var leftChild: BinarySearchNode? = null,
    var rightChild: BinarySearchNode? = null,
    var depth: Int = 0
) /*{
    override fun toString(): String {
        var tabs = (0 until depth).map {
            "\t"
        }.fold("") { e, i ->
            e + i
        }
        leftChild?.depth = depth + 1
        rightChild?.depth = depth + 1
        return "${tabs}data: $data\n${tabs}leftchild:\n${tabs}$leftChild\n${tabs}right child\n${tabs}$rightChild\n"
    }
}*/