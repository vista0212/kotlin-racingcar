package racingcar

import java.util.concurrent.ThreadLocalRandom

interface Moveable {
    fun moving(): Boolean

    class Always : Moveable {
        override fun moving() = true
    }

    class Random : Moveable {
        private val intRandom = IntRandom.Smart(ThreadLocalRandom.current(), BOUND_MAX)

        override fun moving() = intRandom.next().moreThen(MOVING_MIN)

        companion object {
            private const val BOUND_MAX = 10
            private const val MOVING_MIN = 4
        }
    }
}

private fun Int.moreThen(min: Int) = this >= min