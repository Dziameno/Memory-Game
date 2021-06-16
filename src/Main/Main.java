package Main;

import Model.Memory;
import View.View;

public class Main {
    public static void main(String[] args) {
        Memory app = new Memory();
        View game = new View(app);
        app.setView(game);
    }
}