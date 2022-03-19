package linkedlist

fun main() {

    val linkedList = LinkedList<String>()

    linkedList.add("A")
    linkedList.add("B")
    linkedList.add("C")
    linkedList.add("D")
    print("$linkedList\n")
    linkedList.add(0, "P")
    print("$linkedList\n")
    linkedList.add(5, "R")
    print("$linkedList\n")
    linkedList.add(5, "S")
    print("$linkedList\n")
    linkedList.add(2, "T")
    print("$linkedList\n\n")

    println(linkedList.contains("P"))
    println(linkedList.contains("R"))
    println(linkedList.contains("B"))
    println(linkedList.contains("E"))
    println()

    println(linkedList.indexOf("P"))
    println(linkedList.indexOf("R"))
    println(linkedList.indexOf("B"))
    println(linkedList.indexOf("E"))
    println()

    println(linkedList.get(0))
    println(linkedList.get(7))
    println(linkedList.get(3))
    println()

    println(linkedList.remove("P"))
    println(linkedList.remove("R"))
    println(linkedList.remove("B"))
    println(linkedList.remove("E"))
    print("$linkedList\n")

    println(linkedList.removeAt(0))
    println(linkedList.removeAt(6))
    println(linkedList.removeAt(3))
    print("$linkedList\n")

    linkedList.clear()
    println(linkedList.size())
    println(linkedList.isEmpty())
}





