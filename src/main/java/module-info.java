module com.yrtwitter.project_phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.yrtwitter.project_phase2 to javafx.fxml;
    exports com.yrtwitter.project_phase2;
    exports com.yrtwitter.project_phase2.gui;
    opens com.yrtwitter.project_phase2.gui to javafx.fxml;
    exports com.yrtwitter.project_phase2.gui.chat;
    opens com.yrtwitter.project_phase2.gui.chat to javafx.fxml;
    exports com.yrtwitter.project_phase2.gui.menu;
    opens com.yrtwitter.project_phase2.gui.menu to javafx.fxml;
    exports com.yrtwitter.project_phase2.gui.pages;
    opens com.yrtwitter.project_phase2.gui.pages to javafx.fxml;
}