module com.yrtwitter.project_phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.yrtwitter.project_phase2 to javafx.fxml;
    exports com.yrtwitter.project_phase2;
    exports com.yrtwitter.project_phase2.controllers;
    opens com.yrtwitter.project_phase2.controllers to javafx.fxml;
}