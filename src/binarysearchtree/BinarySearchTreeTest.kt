package binarysearchtree

fun main() {
    val searchTree = BinarySearchTree()
    searchTree.insert(10)
    searchTree.insert(5)
    searchTree.insert(3)
    searchTree.insert(4)
    searchTree.insert(2)
    searchTree.insert(7)
    searchTree.insert(8)
    searchTree.insert(12)
    searchTree.insert(11)
    searchTree.insert(15)
    searchTree.insert(14)
    searchTree.insert(16)
    println(searchTree.root)
    searchTree.remove(14)
    println(searchTree.root)
}