package kt.native.sandbox

import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.posix.gettimeofday
import platform.posix.timeval
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

actual fun getCurrentTime(): Duration {
    val millis: Long = memScoped {
        val timeVal = alloc<timeval>()
        gettimeofday(timeVal.ptr, null)
        val sec = timeVal.tv_sec
        val usec = timeVal.tv_usec
        (sec * 1_000L) + (usec / 1_000L)
    }
    return millis.milliseconds
}
