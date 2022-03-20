package binarysearchtree

fun main() {
    val searchTree = BinarySearchTree()
    searchTree.insert(8)
    searchTree.insert(3)
    searchTree.insert(4)
    searchTree.insert(6)
    searchTree.insert(10)
    searchTree.insert(7)
    searchTree.insert(1)
    searchTree.insert(13)
    searchTree.insert(14)
    //searchTree.root?.depth = 0
    println(searchTree.contains(7))
    println(searchTree.contains(10))
    println(searchTree.contains(3))
    println(searchTree.contains(8))
    println(searchTree.contains(18))
    println(searchTree.contains(35))
    println(searchTree.root)
    searchTree.remove(8)
    searchTree.remove(14)
    println(searchTree.root)
    println(searchTree.contains(14))
    println(searchTree.contains(8))
    println(searchTree.contains(3))
}