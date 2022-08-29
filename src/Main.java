import javax.swing.*;
import java.io.IOException;

public class Main {

    private static void create_and_show_Window() throws IOException {

         JFrame main_windows = new JFrame("Material Price Calculator");
         JPanel sell_layout = new Customer_windows();
         JPanel buy_layout = new Shop_windows();
        JTabbedPane j_tabbed_pane = new JTabbedPane( JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        // Main windows
        main_windows.setSize(800,450);
        main_windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JTabbed pane Add
        j_tabbed_pane.addTab("Verkaufen",sell_layout);
        j_tabbed_pane.addTab("Laden", buy_layout );

        // Windows Add
        main_windows.add(j_tabbed_pane);
        main_windows.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    create_and_show_Window();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }



}