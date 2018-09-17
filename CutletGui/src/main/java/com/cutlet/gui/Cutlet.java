/*
 * Copyright (C) 2017 rudolf.muehlbauer@gmail.com
 */
package com.cutlet.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author rmuehlba
 */
public class Cutlet extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {

            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainScene.fxml"), getBundle());
            final Parent root = loader.load();

            MainSceneController controller = (MainSceneController) loader.getController();
            controller.setStage(primaryStage);

            final Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add("/styles/Styles.css");

            primaryStage.setTitle(i18n("application.title"));
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest((event) -> {
                controller.processExit(null);
            });

        } catch (IOException ex) {
            Logger.getLogger(Cutlet.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //setDebugLevel(Level.OFF);

        launch(args);
    }

    public static void setDebugLevel(Level newLvl) {
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        rootLogger.setLevel(newLvl);
        for (Handler h : handlers) {
            //if (h instanceof FileHandler) {
            h.setLevel(newLvl);
            //}
        }
    }

    private static String i18n(String str) {
        final ResourceBundle bundle = getBundle();

        try {
            return bundle.getString(str);
        } catch (Exception e) {
            return "i18n(" + str + ")";
        }
    }

    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("Bundle", Locale.US);
    }

}
