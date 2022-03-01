package stack

fun main() {
    val stack = Stack<Int>()

    stack.push(5)
    stack.push(6)
    stack.push(7)
    stack.push(8)
    stack.push(9)
    println(stack)
    stack.pop()
    println(stack)
    stack.pop()
    println(stack)
    stack.pop()
    println(stack)
    stack.pop()
    println(stack)
    stack.pop()
    println(stack)

    println(stack.size())
}