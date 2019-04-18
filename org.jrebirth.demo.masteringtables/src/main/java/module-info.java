/**
 * @author Sébastien Bordes
 */
module org.jrebirth.demo.masteringtables {
    exports org.jrebirth.demo.masteringtables.beans;
    exports org.jrebirth.demo.masteringtables.ui.menu;
    exports org.jrebirth.demo.masteringtables.service;
    exports org.jrebirth.demo.masteringtables.ui.splash;
    exports org.jrebirth.demo.masteringtables.resources;
    exports org.jrebirth.demo.masteringtables;
    exports org.jrebirth.demo.masteringtables.ui.page;
    exports org.jrebirth.demo.masteringtables.ui.expression;
    exports org.jrebirth.demo.masteringtables.ui;
    exports org.jrebirth.demo.masteringtables.ui.result;
    exports org.jrebirth.demo.masteringtables.ui.powered;
    exports org.jrebirth.demo.masteringtables.ui.game;
    exports org.jrebirth.demo.masteringtables.command;

    requires java.compiler;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    
    requires org.jrebirth.af.api;
    requires org.jrebirth.af.component;
    requires org.jrebirth.af.core;
    
    requires org.slf4j;
}
