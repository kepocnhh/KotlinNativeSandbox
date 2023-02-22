import kt.native.sandbox.Foo
import kt.native.sandbox.getCurrentTime
import platform.Foundation.*

fun main() {
    val foo = Foo(bar = "native")
    println("Hello ${foo.bar}!")
    val dateFormatter = NSDateFormatter.new()!!
    dateFormatter.dateStyle = NSDateFormatterFullStyle
    dateFormatter.timeStyle = NSDateFormatterFullStyle
    val interval = getCurrentTime().inWholeSeconds.toDouble()
    val date = NSDate.dateWithTimeIntervalSince1970(interval)
    println("Current time: ${dateFormatter.stringFromDate(date)}")
}
