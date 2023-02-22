package kt.native.sandbox

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

actual fun getCurrentTime(): Duration {
    return System.currentTimeMillis().milliseconds
}
