package queues

fun main() {
    val queue = Queue<Int>()

    queue.push(5)
    queue.push(6)
    queue.push(7)
    queue.push(8)
    queue.push(9)
    println(queue)
    queue.pop()
    println(queue)
    queue.pop()
    println(queue)
    queue.pop()
    println(queue)
    queue.pop()
    println(queue)
    queue.pop()
    println(queue)

    println(queue.size())
}