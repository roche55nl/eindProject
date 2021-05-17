package mijnRestau.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mijnRestau.models.ProductLijst;

public class GerechtenDb {
	   public static boolean flag = false;
	    //product toevoegen db  
	    public static void voegInGerechtenDB(String gerecht, double prijs, int qty, String beschrijving, String imagePad) throws IOException{
	    	try {	            
	        	Connection con=DbKlant.DBConnection();	         
	            PreparedStatement ps = con.prepareStatement("INSERT INTO gerechtendb(gerecht, prijs,"
	                    + "qty, beschrijving, imagePad) VALUES(?,?,?,?,?)");            
	            ps.setString(1, gerecht);
	            ps.setDouble(2, prijs);
	            ps.setInt(3, qty);
	            ps.setString(4, beschrijving);
	            ps.setString(5, imagePad);                       
	            if(ps.executeUpdate()==1)
	                JOptionPane.showMessageDialog(null, "Product toegevoegd!");	            
	        } catch (SQLException ex) {
	            Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
	      }	    
	    }
	    
	    //update product
	    public static void updateGerechtenDB(String gerecht, int qty){
	         try {
	        		Connection con=DbKlant.DBConnection();	            
	            PreparedStatement ps = con.prepareStatement("UPDATE gerechtendb SET qty=? WHERE gerecht=?");	            
	            ps.setInt(1, qty);
	            ps.setString(2, gerecht);
	            if(ps.executeUpdate()==0)
	                JOptionPane.showMessageDialog(null, "Item bestaat niet!");
	            else if(ps.executeUpdate()==1 && flag){
	                JOptionPane.showMessageDialog(null, "Voorraad met succes ge�pdatet!");
	                flag = false;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    }
	    
	    //gegevens ophalen
	    public static ArrayList<ProductLijst> MaakTabel(){
	        ArrayList<ProductLijst> list = new ArrayList<>();
	        try {
	        	Connection con=DbKlant.DBConnection();
	            Statement ps = con.createStatement();
	            ResultSet rs = ps.executeQuery("SELECT gerecht, prijs,qty, beschrijving, imagePad FROM gerechtendb");           
	            ProductLijst pl;	            
	            while(rs.next()){
	                pl = new ProductLijst(rs.getString("gerecht"),
	                        rs.getBigDecimal("prijs"),rs.getInt("qty"),rs.getString("beschrijving"),
	                        rs.getString("imagePad"));	                
	                list.add(pl);
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return list;
	}

	  //check voorraad   
	   public static ArrayList<ProductLijst> checkVoorraad(){
	        ArrayList<ProductLijst> list = new ArrayList<>();
	        try {
	        	Connection con=DbKlant.DBConnection();
	            Statement ps = con.createStatement();
	            ResultSet rs = ps.executeQuery("SELECT gerecht, prijs, qty FROM gerechtendb");	            
	            ProductLijst pl;	            
	            while(rs.next()){
	                pl = new ProductLijst(rs.getString("gerecht"),
	                        null, rs.getInt("qty"),null, null);	                
	                list.add(pl);
	            }	            
	        } catch (SQLException ex) {
	            Logger.getLogger(DrankDB.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return list;
	   }
	    
	 //verwijderen	   
	   public static void delete(String gerecht){
	        try {
	        	Connection con=DbKlant.DBConnection();
	            PreparedStatement ps = con.prepareStatement("DELETE FROM gerechtendb WHERE gerecht=?");
	            ps.setString(1, gerecht);
	            if(ps.executeUpdate()==0)
	                JOptionPane.showMessageDialog(null, "Product bestaat niet!");
	            else
	                JOptionPane.showMessageDialog(null, "Product verwijderd!");	            
	        } catch (SQLException ex) {
	            Logger.getLogger(GerechtenDb.class.getName()).log(Level.SEVERE, null, ex);
	        }            
	   }	    
}
