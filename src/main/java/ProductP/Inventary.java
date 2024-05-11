package ProductP;

import PersonP.SellerP.Seller;
import PersonP.Users;
import java.io.*;
import java.util.ArrayList;

/**
 * Class responsible for managing the product inventory list
 * @author Pedro Sala Mora
 * @version 1
 */
public class Inventary {
    private final static String URL_FILE = "I:\\Entorns_Desenvolupament\\Projecte_Final" +
            "\\Projecte_ED_v2\\src\\File\\Inventary.txt";

    private ArrayList<Product> list_Inventary;

    /**Builder*/
    public Inventary() {
        list_Inventary = new ArrayList<>();
    }

    /**Getters and Setters*/
    public ArrayList<Product> getList_Inventary() {
        return list_Inventary;
    }

    public void setList_Inventary(ArrayList<Product> list_Inventary) {
        this.list_Inventary = list_Inventary;
    }


    /**Methods*/

    /**
     * method to read the txt file and load those classes into a list
     */
    public void ReadFile(){
        String line = "";

        try{
            BufferedReader myFile = new BufferedReader(
                    new FileReader(URL_FILE));

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

    /**
     * Save the list information to a .txt file
     */
    public void SaveFile(){
        try{
            BufferedWriter miFile = new BufferedWriter(
                    new FileWriter(URL_FILE));

            for (int i = 0; i < list_Inventary.size(); i++) {

                if(list_Inventary.get(i) instanceof Fruit){
                    miFile.write(list_Inventary.get(i).getProductor().getEmail()+";"+
                            "0;"+list_Inventary.get(i).getSeason()+";"+
                            list_Inventary.get(i).getPriceKg()+";"+
                            list_Inventary.get(i).getAmount()+";"+
                            list_Inventary.get(i).getName()+"\n");
                } else if (list_Inventary.get(i) instanceof Vegetable) {
                    miFile.write(list_Inventary.get(i).getProductor().getEmail()+";"+
                            "1;"+list_Inventary.get(i).getSeason()+";"+
                            list_Inventary.get(i).getPriceKg()+";"+
                            list_Inventary.get(i).getAmount()+";"+
                            list_Inventary.get(i).getName()+"\n");
                } else if (list_Inventary.get(i) instanceof VegetableLeafy) {
                    miFile.write(list_Inventary.get(i).getProductor().getEmail()+";"+
                            "2;"+list_Inventary.get(i).getSeason()+";"+
                            list_Inventary.get(i).getPriceKg()+";"+
                            list_Inventary.get(i).getAmount()+";"+
                            list_Inventary.get(i).getName()+"\n");
                }
            }
            miFile.close();
        }catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }
    }

    /**
     * Method to add a product to the list
     * (Metode per a afegir un producte a la llista)
     * @param p Product object we want to add
     */
    public void AddProduct(Product p){
        list_Inventary.add(p);
    }

    /**
     * Method to calculate the price of an inventory
     * (Metode per a calcular el preu de un inventari)
     * @param list_product List containing the products to be calculated
     * @return the resulting price
     */
    public static double CalculatePrice(ArrayList<Product> list_product){
        double aux = 0;
        for (int i = 0; i < list_product.size(); i++) {
            aux += list_product.get(i).getPriceKg() * list_product.get(i).getAmount();
        }
        return  aux;
    }

}
