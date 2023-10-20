package to.grindelf.datawhale

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


/**
 * Main application class.
 */
class DataWhaleApplication : Application() {

    companion object {

        /**
         * DataWhale Application entry-point.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            launch(DataWhaleApplication::class.java)
        }

        const val TITLE = "Data Whale"
        const val WIDTH = 800.0
        const val HEIGHT = 600.0
    }

    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(DataWhaleApplication::class.java.getResource("dw-main-view.fxml"))
        val scene = Scene(fxmlLoader.load(), WIDTH, HEIGHT)
        stage.title = TITLE
        stage.scene = scene
        stage.show()
    }
}
