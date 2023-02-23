import kt.native.sandbox.getCurrentTime
import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    println("Hello jvm multiplatform!")
    val dateFormatter = SimpleDateFormat.getDateTimeInstance()
    println("Current time: ${dateFormatter.format(Date(getCurrentTime().inWholeSeconds))}")
}
