package ProductP;

import PersonP.SellerP.Seller;
import PersonP.Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventary {
    private ArrayList<Product> list_Inventary;

    public Inventary() {
        list_Inventary = new ArrayList<>();
    }

    //ReadFile
    public void ReadFile(){
        String line = "";

        try{
            BufferedReader myFile = new BufferedReader(
                    new FileReader(
                            "I:\\Entorns_Desenvolupament\\Projecte_Final" +
                                    "\\Projecte_ED_v2\\src\\File\\Inventary.txt"));

            line = myFile.readLine();
            while(line!=null){
                String[] parts = line.split(";");

                Users u1 = new Users();
                u1.ReadFile();

                //Fruta
                if(parts[1].equals("0")){
                    list_Inventary.add(new Fruit((Seller) u1.PersonSearch(parts[0]),
                            parts[2],Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4]),parts[5]));
                    //Verdura
                }else if(parts[1].equals("1")){
                    list_Inventary.add(new Vegetable((Seller) u1.PersonSearch(parts[0]),
                            parts[2],Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4]),parts[5]));
                    //Vegetableleafy
                }else if(parts[1].equals("2")){
                    //System.out.println(parts[5]);
                    list_Inventary.add(new VegetableLeafy((Seller) u1.PersonSearch(parts[0]),
                            parts[2],Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4]),parts[5]));
                }
                line = myFile.readLine();
            }
            myFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //SaveFile

    //ShowProduct

    //RemoveProduct

    //AddProduct

    //ShowProductSeller


    public ArrayList<Product> getList_Inventary() {
        return list_Inventary;
    }


}
