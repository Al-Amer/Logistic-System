import javax.management.remote.JMXPrincipal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Customer_windows extends JPanel {


  //  static JComboBox material_list_box = new JComboBox();
    static JComboBox material_list_box ;

    static JButton button_calculator = new JButton("Rechnen");
    static JLabel text_height = new JLabel();
    static JLabel text_weight = new JLabel();
    static JTextField text_height_measure = new JTextField(7);
    // JTextField text = new HintTextField("Maß");
    static JTextField text_weight_measure = new JTextField(7);
    static JTextArea text_result = new JTextArea();
    static JScrollPane scrollPane_text_result = new JScrollPane(text_result);
    Info_keeper info_keeper = new Info_keeper();




    public Customer_windows() throws IOException {
        this.setLayout(null);
        String [][] list_from_file = info_keeper.mat_list;
        String [] material_list_name = new String[list_from_file.length];
        double [] material_list_price = new double[list_from_file.length];
        for (int i=0;i<list_from_file.length;i++){
            for(int j =0;j<list_from_file[i].length;j++){
                if (j == 0){
                    material_list_name[i] = list_from_file[i][j];
                }else if (j == 1){
                    double from_string_to_float = Double.valueOf(list_from_file[i][j]);
                    material_list_price[i] = from_string_to_float;
                }
            }
        }

        material_list_box = new JComboBox(material_list_name);
        text_height.setText("Länge");
        text_weight.setText("Breite");
        text_result.setText("Ergbnisse");
        //
        text_height.setBounds(40, 50, 50, 20);
        text_weight.setBounds(40, 90, 50, 20);
        text_height_measure.setBounds(100, 50, 120, 20);
        text_weight_measure.setBounds(100, 90, 120, 20);
        button_calculator.setBounds(70, 180, 170, 30);
        material_list_box.setBounds(280, 50, 230, 30);
        scrollPane_text_result.setBounds(100, 250, 360, 90);




        this.add(text_height);
        this.add(text_weight);
        this.add(text_height_measure);
        this.add(text_weight_measure);
        this.add(button_calculator);
        this.add(material_list_box);
        this.add(scrollPane_text_result);


        this.setVisible(true);

        button_calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String changed_word = (String) material_list_box.getSelectedItem();
                int element_nu_of_changed_word_of_material_list ;
                element_nu_of_changed_word_of_material_list = getArrayIndex(material_list_name,changed_word);
                String height_measure_in_string = text_height_measure.getText().toString();
                String weight_measure_in_string = text_weight_measure.getText().toString();
                 float height_measure_in_float = Float.valueOf(height_measure_in_string);
                float  weight_measure_in_float = Float.valueOf(weight_measure_in_string);
                float price_calculator = (float)((((height_measure_in_float * weight_measure_in_float)/100) * material_list_price[element_nu_of_changed_word_of_material_list]));
                String  result = "Result is it \n"+ price_calculator+" $";
                text_result.setText(result);

            }
        });

    }
    public int getArrayIndex(String [] arr,String word) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i].equals(word)){
                k=i;
                break;
            }
        }
        return k;
    }

}
