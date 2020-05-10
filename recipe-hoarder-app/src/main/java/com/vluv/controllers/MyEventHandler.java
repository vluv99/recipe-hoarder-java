package com.vluv.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MyEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {

        Platform.exit();
    }
}