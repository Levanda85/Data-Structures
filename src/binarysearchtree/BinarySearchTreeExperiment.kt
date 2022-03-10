package binarysearchtree

fun main() {
    val searchTree = BinarySearchTree()
    searchTree.insert(5)
    searchTree.insert(9)
    searchTree.insert(7)
    searchTree.insert(4)
    searchTree.insert(12)
    searchTree.insert(15)
    searchTree.remove(5)
    println(searchTree.root)
}