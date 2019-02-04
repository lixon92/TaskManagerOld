package ru.atkachev.tm.command.data.xml;

import ru.atkachev.tm.api.IServiceLocate;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Project;

import java.io.Serializable;

public class XMLSaveCommand extends AbstractCommand implements Serializable {
    public XMLSaveCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "save-xml";
    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
