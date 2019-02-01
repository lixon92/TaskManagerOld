package ru.atkachev.TaskManager.command.helper;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelpCommand extends AbstractCommand {
    Map<String, AbstractCommand> commands = serviceLocate.getCommandList();
    public HelpCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public void execute() {
       List<String> keys = new ArrayList<String>(commands.keySet());

       for(int i = 0; i < keys.size(); i++) {
           String key = keys.get(i);
           String description = commands.get(key).description();
           System.out.printf("%-10s %-10s%n", key, description);
       }
    }

    @Override
    public String description() {
        return "Help";
    }
}
