import kt.native.sandbox.getCurrentTime
import platform.Foundation.*

fun main() {
    println("Hello macos native!")
    val dateFormatter = NSDateFormatter.new()!!
    dateFormatter.dateStyle = NSDateFormatterFullStyle
    dateFormatter.timeStyle = NSDateFormatterFullStyle
    val interval = getCurrentTime().inWholeSeconds.toDouble()
    val date = NSDate.dateWithTimeIntervalSince1970(interval)
    println("Current time: ${dateFormatter.stringFromDate(date)}")
}
