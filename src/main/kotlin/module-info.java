module to.grindelf.datawhale {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens to.grindelf.datawhale to javafx.fxml;
    exports to.grindelf.datawhale;
}