
import DB.ConnectDB;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import Bath.Cum;
import Bath.ProductListView;
import Asset.Product.product;
import Asset.user;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acebi
 */
public class Launch {
    public static void main(String args[]) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        ConnectDB.getConnection();
        
        user.run();
        
        product.run();
        
        new Cum().setVisible(true);
        
        new ProductListView().setVisible(true);
    }
}
