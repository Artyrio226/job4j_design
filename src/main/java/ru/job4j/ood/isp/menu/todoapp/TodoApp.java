package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.SimpleMenu;

import java.util.Arrays;
import java.util.List;

public class TodoApp {

    private final Output out;

    public TodoApp(Output out) {
        this.out = out;
    }

    public void init(Input input, Menu menu, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, menu);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Menu menu = new SimpleMenu();
        List<UserAction> actions = Arrays.asList(
                new CreateRoot(output),
                new CreateChild(output),
                new ExecuteAction(output),
                new PrintMenu(output),
                new ExitAction(output)
        );
        new TodoApp(output).init(input, menu, actions);
    }
}