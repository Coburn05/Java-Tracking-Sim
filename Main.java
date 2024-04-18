public class Main {
    private static MainUI mainUI = new MainUI();

    public Main() {}

    public static void main(String[] args) {
        mainUI.draw(1280, 768);
    }

    public static MainUI getMainUI() {
        return mainUI;
    }
}
