package mijnRestau.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mijnRestau.LogInPanel;
import mijnRestau.models.Klant;

public class DbKlant {
	public static Connection DBConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "root", "");
			System.out.print("Database is verbonden!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Do not connect to DB - Error:" + e);
		}
		return conn;
	}
	
	public static boolean checkEmail(String naam, String voornaam, String email, String password, int postcode,
			String straat, int huisnummer, String stad) {
		Connection con1 = DBConnection();
	
		try {
			Statement stmt = con1.createStatement();
			JOptionPane.showMessageDialog(null, "Verbonden met database!");
			String duplikaat = "SELECT * FROM userinfo WHERE email = '" + email + "'";
			
			ResultSet rs = stmt.executeQuery(duplikaat);
			if (rs.next()) {
				
			return true;
			
			}else {
				return false;
			}}
				 catch(SQLException e) {
					 
				 }
		return false;
	}

	// gebruiker toevoegen
	public static int VoegUserToe(String naam, String voornaam, String email, String password, int postcode,
			String straat, int huisnummer, String stad) {
	//	Connection con1 = DBConnection();
		try {
			
				Connection con=DbKlant.DBConnection();
				  PreparedStatement ps = con.prepareStatement(" INSERT INTO userinfo(naam,voornaam,email,password,postcode,straat,huisnummer,stad) VALUES(?,?,?,?,?,?,?,?) ");
				 ps.setString(1, naam);
				  ps.setString(2, voornaam);
				  ps.setString(3, email);
				  ps.setString(4, password);
				  ps.setInt(5, postcode);
				  ps.setString(6, straat);				 
				  ps.setInt(7, huisnummer);				  
				  ps.setString(8, stad);
				  ps.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(null, "U bent met succes geregistreerd!");
			
		} catch (SQLException e) {
			if (e.getErrorCode() == 19) // Duplicate email
				return 19;
			JOptionPane.showMessageDialog(null, "Fout!");
		}
		return 0;
	}

	//gegevens selecteren uit db om een tabel van te maken
	public static ArrayList<Klant> MaakTabelKlant() {
		ArrayList<Klant> list1 = new ArrayList<>();
		try {
			Connection con = DbKlant.DBConnection();
			Statement ps = con.createStatement();
			ResultSet rs = ps
					.executeQuery("SELECT id, naam, voornaam, email, straat, "
							+ "huisnummer, postcode, stad FROM userinfo");
			Klant kl;
			while (rs.next()) {
				kl = new Klant(rs.getInt("id"), rs.getString("naam"), rs.getString("voornaam"), rs.getString("email"),
						rs.getString("straat"), rs.getInt("huisnummer"), rs.getString("postcode"),
						rs.getString("stad"));
				list1.add(kl);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}
		return list1;
	}

	public static void updateKlant(int id, String naam, String voornaam, String email, String straat, int huisnummer, int postcode, String stad) {
		 Connection con=DbKlant.DBConnection(); 	
		
			try {
				
				  PreparedStatement ps = con.prepareStatement(" UPDATE userinfo SET naam=?,voornaam=?,"
				  		+ " email=?, straat=?, "
				  		+ "huisnummer=?, postcode=?, "
				  		+ "stad=? where id='"+id+"'  ");
				//  ps.setInt(1, id);
				  ps.setString(1, naam);
				  ps.setString(2, voornaam);
				  ps.setString(3, email);
				  ps.setString(4, straat);
				  ps.setInt(5, huisnummer);
				  ps.setInt(6, postcode);
				  ps.setString(7, stad);
				  ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	}
	
	// inlogger
	public static boolean inlogger(String email, String pass) {
		Connection con = DBConnection();
		boolean login = false;
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"Select * from userinfo WHERE email = '" + email + "' and Password = '" + pass + "';");
			if (!rs.next())
				login = false;
			else
				login = true;
			con.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return login;
	}
	
}