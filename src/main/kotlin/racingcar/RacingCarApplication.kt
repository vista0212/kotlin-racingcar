package racingcar

import racingcar.domain.PositiveCount
import racingcar.domain.RacingCarGame
import racingcar.userinterface.Console
import racingcar.userinterface.UserInterface

fun main() {
    val ui: UserInterface = Console()
    RacingCarApplication(ui).run()
}

class RacingCarApplication(private val userInterface: UserInterface) {

    fun run() {
        val carCountValue = userInterface.inputCarCount()
        val carCount = PositiveCount(carCountValue)

        val roundCountValue = userInterface.inputRoundCount()
        val roundCount = PositiveCount(roundCountValue)

        val racingCarGame = RacingCarGame(carCount, roundCount)
        racingCarGame.start()

        val results = racingCarGame.result()
        userInterface.outputResult(results)
    }
}