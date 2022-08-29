import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Shop_windows extends JPanel {
    static JLabel label_material_name = new JLabel("Material");
    static JLabel label_material_price = new JLabel("Preis");
    static JTextField textField_material_name = new JTextField();
    static JTextField textField_material_price = new JTextField();
    static JButton btn_add = new JButton("Add");
    static JButton btn_clear = new JButton("Clear");
    static DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable(model);
    static JScrollPane tableScroller = new JScrollPane(table);
    static JButton btn_delete = new JButton("Delete Selected");
    static JButton btn_deleteAll = new JButton("Delete All");
    static JButton btn_save = new JButton("Save");
    static HashMap<String, String> list_jtable_save = new HashMap<String, String>();

    Info_keeper info_keeper=new Info_keeper();

    String [] data = {"Material","Preis"};


    public Shop_windows() throws IOException {
        this.setLayout(null);
           String [][] list_from_file = info_keeper.mat_list;
        // to copy the Array project ([[Ljava.lang.String;@78691e89)
        //  System.out.println(list);
//              check the Multidimensional Array
//        for (int i=0;i<list.length;i++){
//            for(int j=0;j<list[i].length;j++){
//                System.out.println(list[i][j]);
//            }
//        }
        model.setDataVector(list_from_file,data);
        model.addColumn("Material");
       model.addColumn("Preis");

        label_material_name.setBounds(40, 50, 50, 20);
        label_material_price.setBounds(40, 90, 50, 20);
        textField_material_name.setBounds(100, 50, 120, 20);
        textField_material_price.setBounds(100, 90, 120, 20);
        btn_add.setBounds(150, 180, 70, 30);
        btn_clear.setBounds(70, 180, 70, 30);
        tableScroller.setBounds(280, 50, 370, 160);
        btn_delete.setBounds(315, 250, 140, 30);
        btn_deleteAll.setBounds(470, 250, 140, 30);
        btn_save.setBounds(300,300,320,30);


        this.add(label_material_name);
        this.add(label_material_price);
        this.add(textField_material_name);
        this.add(textField_material_price);
        this.add(btn_add);
        this.add(btn_clear);
        this.add(btn_delete);
        this.add(btn_deleteAll);
        this.add(btn_save);
        this.add(tableScroller);


        // Button Add
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField_material_name.getText().equals("") && !textField_material_price.getText().equals("")) {

                    String material_name = textField_material_name.getText();
                    String material_price = textField_material_price.getText();
                    String[] userInfo = { material_name, material_price };
                    model.addRow(userInfo);
                }
            }
        });
        // Button Clear
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_material_name.setText("");
                textField_material_price.setText("");
            }
        });
        // Button Delete
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRowCount() > 0) {
                    int[] selectedIndices = table.getSelectedRows();
                    for (int i = selectedIndices.length - 1; i >= 0; i--) {
                        model.removeRow(selectedIndices[i]);
                    }
                }
            }
        });
        // Button Delete All
        btn_deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
            }
        });
        // Button Save
        // make File and save all the Info in Model/ Table (JTable)
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String str_1 = model.getValueAt(i, 0).toString();
                    String str_2 = model.getValueAt(i, 1).toString();
                    list_jtable_save.put(str_1, str_2);
                }
                try {
                    info_keeper.info_save(list_jtable_save);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                String [][] list = info_keeper.mat_list;
//              // to copy the Array project ([[Ljava.lang.String;@78691e89)
//                //  System.out.println(list);
//                for (int i=0;i<list.length;i++){
//                    for(int j=0;j<list[i].length;j++){
//                        System.out.println(list[i][j]);
//                    }
//                }
            }
        });

    }







}
