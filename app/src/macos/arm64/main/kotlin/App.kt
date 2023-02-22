import kt.native.sandbox.Foo

fun main() {
    val foo = Foo(bar = "native")
    println("Hello ${foo.bar}!")
}
