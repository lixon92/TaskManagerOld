package bootstrap;

import command.AbstractCommand;
import command.Project.CreateProjectCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private Scanner scanner = new Scanner(System.in);
    private Map <String, AbstractCommand> commands = new HashMap<>();
    private String inputText;
    private AbstractCommand tempObj;
    public void init(){
        registry(new CreateProjectCommand());
        for(;;){
            inputText = scanner.nextLine();
            tempObj = commands.get(inputText);
            if (tempObj != null){
                System.out.println("[" + tempObj.command() + "]");
                tempObj.execute();
                System.out.println("[OK]");
            }
            else {
                System.out.println("[FAIL]");
            }
        }
    }

    public void registry(AbstractCommand abstractCommand){
        commands.put(abstractCommand.command(), abstractCommand);
    }
}
