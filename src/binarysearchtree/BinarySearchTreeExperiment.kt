package binarysearchtree

fun main() {
    val searchTree = BinarySearchTree(10)
    searchTree.insert(5)
    searchTree.insert(8)
    searchTree.insert(12)
    searchTree.insert(7)
    searchTree.insert(15)
    searchTree.insert(16)
    searchTree.insert(18)
    searchTree.insert(19)
    println(searchTree)
    searchTree.remove(8,searchTree)
    println(searchTree)
}