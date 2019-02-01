package ru.atkachev.TaskManager;

import ru.atkachev.TaskManager.bootstrap.Bootstrap;

public class Application {
    public static void main(String[] args) {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }
}
