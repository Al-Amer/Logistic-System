import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Info_keeper {


    public Info_keeper() throws IOException {

    }
    public void info_save (HashMap<String,String> list) throws IOException {
        File info_file = new File("File_material_price _name.txt");
        FileWriter info_file_writer = new FileWriter(info_file);
        for (String i:list.keySet()){
            info_file_writer.write(i+" "+list.get(i)+"\n");
        }
        info_file_writer.close();
    }

    public String [][] info_read_and_show()throws IOException {
        HashMap<String, String> list = new HashMap<String, String>();
        ArrayList<String>material_name_list = new ArrayList<>();
        ArrayList<String>material_price_list = new ArrayList<>();
        File file_info = new File("File_material_price _name.txt");
        Scanner fileReader = new Scanner(file_info);
        while(fileReader.hasNextLine()){
            String data = fileReader.nextLine();
            String [] data_split = data.split(" ");
            list.put(data_split[0],data_split[1]);
            material_name_list.add(data_split[0]);
            material_price_list.add(data_split[1]);
        }

        String [][] list_2 = new String[material_name_list.size()][2];
        for (int i =0 ; i< material_name_list.size();i++){
            for(int j = 0; j<2;j++){
                if (j==0){
                    list_2[i][j]=material_name_list.get(i);
                }else{
                    list_2[i][j]=material_price_list.get(i);
                }
            }
        }

        return list_2;
    }
    String [][] mat_list = info_read_and_show();




    }