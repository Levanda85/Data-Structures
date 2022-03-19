package binarysearchtree

data class BinarySearchNode(
    var data: Int,
    var leftChild: BinarySearchNode? = null,
    var rightChild: BinarySearchNode? = null
)