package ru.atkachev.tm.command.user;

import ru.atkachev.tm.api.IServiceLocate;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.User;

public class UserLogonCommand extends AbstractCommand {

    private boolean secure = false;


    public UserLogonCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "logon";
    }

    public void execute() {
        System.out.println("enter user login");
        final String userLogin = serviceLocate.getTerminalService();
        System.out.println("enter user password");
        final String userPassword = serviceLocate.getTerminalService();
        final User user = serviceLocate.getUserService().findUser(userLogin, userPassword);
        if(user == null){
            System.out.println("user not find");
        }
        else
        {
            serviceLocate.getUserService().sessionStart(user);
        }
    }

    public String description() {
        return "logon";
    }
}
