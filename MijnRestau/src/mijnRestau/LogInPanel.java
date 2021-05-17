package mijnRestau;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import mijnRestau.Database.DbKlant;
import mijnRestau.models.WachtwoordResetDb;

public class LogInPanel extends JFrame {
	private JPanel signInPanel;
	private JPanel signUpPanel;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel HoofdPanel;
	private JCheckBox toonPasChkBox1;
	private JTextField signInEmailField;
	private JPasswordField signInPasField;
	private JButton LogInButton;
	private JButton LogUpButton;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	public JLabel waarschuwlbl;
	public JLabel lbl;
	public static JLabel waarschuwlbl1;
	private JTextField signUpNaamField;
	private JTextField signUpVoornaamField;
	private JTextField signUpEmailField;
	private JPasswordField signUpPasswordField;
	private JTextField straatField;
	private JTextField HuisnrField;
	private JCheckBox toonPasChkBox;
	private JTextField PostCodeField;
	private JTextField stadField;
	static boolean signInStatus = false;
	static String inlogger;
	static int verkeerdeWwoord = 0;

	public LogInPanel() {
		initComponents();
	}

	private void initComponents() {		
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		signInPanel = new JPanel();
		signUpPanel = new JPanel();		
		HoofdPanel = new JPanel();
		PostCodeField = new JTextField();
		straatField = new JTextField();
		HuisnrField = new JTextField();
		stadField = new JTextField();
		signUpNaamField = new JTextField();
		signUpVoornaamField = new JTextField();
		signUpEmailField = new JTextField();
		signInEmailField = new JTextField();
		signUpPasswordField = new JPasswordField();
		toonPasChkBox1 = new JCheckBox();
		toonPasChkBox = new JCheckBox();		
		signInPasField = new JPasswordField();
		LogInButton = new JButton();
		LogUpButton = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		jLabel9 = new JLabel();
		jLabel10 = new JLabel();
		jLabel11 = new JLabel();
		waarschuwlbl = new JLabel();
		waarschuwlbl1 = new JLabel();
		lbl = new JLabel();
		
		// de benodigde velden en knoppen voor de registratiepanel
		jLabel1.setText("Naam");
		jLabel2.setText("Voornaam");
		jLabel3.setText("Email");	
		jLabel4.setText("Wachtwoord");
		jLabel5.setText("PostCode");
		jLabel6.setText("Straat");
		jLabel7.setText("Huisnummer");		
		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jLabel8.setText("Stad");
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel8);
		jPanel1.add(signUpNaamField);
		jPanel1.add(signUpVoornaamField);
		jPanel1.add(signUpEmailField);
		jPanel1.add(waarschuwlbl1);
		jPanel1.add(HuisnrField);
		jPanel1.add(PostCodeField);
		jPanel1.add(signUpPasswordField);
		jPanel1.add(straatField);
		jPanel1.add(toonPasChkBox);
		jPanel1.add(LogUpButton);
		jPanel1.add(stadField);
		signInPanel.add(lbl);
		
		waarschuwlbl1.setForeground(new Color(255,0,0));
		toonPasChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				toonPasChkBoxActionPerformed(evt);				
			}
		});

		LogUpButton.setIcon(new ImageIcon(getClass().getResource("/icons/btn_check.png")));
		LogUpButton.setText("Sign Up");
		LogUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					LogUpButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
				
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setBorder(BorderFactory.createTitledBorder(" jPanel1----"));
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
				.addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(jLabel1,80, 80, 80).addComponent(jLabel2,80, 80, 80)
						.addComponent(jLabel3,80, 80, 80).addComponent(jLabel4, 80, 80, 80)
						.addComponent(jLabel5,80, 80, 80).addComponent(jLabel6, 80, 80, 80)
						.addComponent(jLabel7,80, 80, 80).addGap(80, 80, 80)
						.addComponent(jLabel8, 80, 80, 80))
				.addGroup(jPanel1Layout.createParallelGroup()
						.addComponent(signUpNaamField, 250, 250, 250).addComponent(signUpVoornaamField, 250, 250, 250)
						.addComponent(signUpEmailField, 250, 250, 250).addComponent(signUpPasswordField, 250, 250, 250)
						.addComponent(straatField, 250, 250, 250).addComponent(HuisnrField, 250, 250, 250)
						.addComponent(toonPasChkBox, 130, 130, 130).addComponent(PostCodeField, 250, 250, 250)
						.addComponent(stadField, 250, 250, 250)
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(LogUpButton, 150, 150, 150).addComponent(jLabel8, 250, 250, 250)
								.addComponent(waarschuwlbl1, 320, 320, 320))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(jLabel1, 30, 30, 30).addComponent(signUpNaamField, 30, 30, 30))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(jLabel2, 30, 30, 30).addComponent(signUpVoornaamField, 30, 30, 30))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(jLabel3, 30, 30, 30).addComponent(signUpEmailField, 30, 30, 30))
					.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup().addGap(10,10,10)
								.addComponent(jLabel4, 30, 30, 30).addComponent(signUpPasswordField, 30, 30, 30).addGap(50)
								.addComponent(toonPasChkBox, 70, 70, 70))
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(jLabel5, 30, 30, 30).addComponent(PostCodeField, 30, 30, 30))
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(straatField, 30, 30, 30).addComponent(jLabel6, 30, 30, 30))
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(HuisnrField, 30, 30, 30).addComponent(jLabel7, 30, 30, 30))
						.addGroup(jPanel1Layout.createParallelGroup()
								.addComponent(jLabel8, 30, 30, 30).addComponent(stadField, 30, 30, 30))
						.addGroup(jPanel1Layout.createParallelGroup()
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(LogUpButton, 45, 45, 45)
										.addGap(20, 20, 20).addComponent(waarschuwlbl1, 30, 30, 30))));
		

		signUpPanel.add(jPanel1);
		HoofdPanel.add(signUpPanel, "card6");

		jLabel9.setText("Email");
		jPanel2.add(jLabel9);

		jPanel2.add(signInEmailField);

		jLabel10.setText("Wachtwoord");
		jPanel2.add(jLabel10);

		jLabel11.setText("Heb je nog geen account? Maak nu uw account aan!");
		jPanel2.add(jLabel11);

		jPanel2.add(signInPasField);

		LogInButton.setText("Log in");
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				LogInButtonActionPerformed(evt);}
		});
		jPanel2.add(LogInButton);

		toonPasChkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				toonPasChkBox1ActionPerformed(evt);
			}
		});
		jPanel2.add(toonPasChkBox1);
		waarschuwlbl.setForeground(new Color(255,0,0));
		jPanel2.add(waarschuwlbl);
		signInPanel.add(jPanel2);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setBorder(BorderFactory.createTitledBorder("jPanel2"));
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup()
								.addComponent(jLabel9, 200, 200, 200).addComponent(signInEmailField, 200, 200, 200)
								.addComponent(jLabel10, 200, 200, 200).addComponent(signInPasField, 200, 200, 200)
								.addComponent(toonPasChkBox1).addComponent(LogInButton, 200, 200, 200)
								.addComponent(jLabel11, 300, 300, 300).addComponent(waarschuwlbl, 350, 350, 350)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
				.addComponent(waarschuwlbl, 30, 30, 30)
				.addComponent(jLabel9, 30, 30, 30).addComponent(signInEmailField, 30, 30, 30)
				.addComponent(jLabel10, 30, 30, 30).addComponent(signInPasField, 30, 30, 30)
				.addComponent(toonPasChkBox1, 30, 30, 30).addComponent(LogInButton, 30, 30, 30)
				.addComponent(jLabel11, 30, 30, 30));
		HoofdPanel.add(signInPanel, "card7");
		//HoofdPanel.setBackground(new Color(255,0,0));
		HoofdPanel.add(lbl);
// getContentPane() layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup()
			.addGroup(layout.createSequentialGroup()
				.addComponent(HoofdPanel, 875, 875, 875)));
		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(HoofdPanel, 505, 505, 505));

	
		pack();
	}

	private void LogInButtonActionPerformed(ActionEvent evt) {
		
		boolean flag = DbKlant.inlogger(signInEmailField.getText(), signInPasField.getText());		
		if (flag && signInEmailField.getText().equals("admin")) {
			AdminPanel AP = new AdminPanel();
			signInStatus = true;
			HoofdPanel.setVisible(false);			
			AP.setVisible(true);			
			Restaurant.jLabel2.setIcon(new ImageIcon(getClass().getResource("/icons/aangemeld.png")));
			inlogger = signInEmailField.getText();		
			waarschuwlbl.setText("");
			signInEmailField.setText("");
			signInPasField.setText("");
			verkeerdeWwoord = 0;
			this.setVisible(false);
		} else {
			if (flag) {		
				signInStatus = true;
				Restaurant rest = new Restaurant();
				rest.setVisible(true);
				Restaurant.jLabel5.setText("U bent aangemeld als: " +signInEmailField.getText());
				Restaurant.jLabel2.setIcon(new ImageIcon(getClass().getResource("/icons/aangemeld.png")));
				inlogger = signInEmailField.getText();
				waarschuwlbl.setText("");
				signInEmailField.setText("");
				signInPasField.setText("");
				verkeerdeWwoord = 0;
				this.setVisible(false);
			}
			else {
				waarschuwlbl.setText("Geen geldige email/wachtwoord!");
				verkeerdeWwoord++;
				if (verkeerdeWwoord >= 3) {
					WachtwoordResetDb.Send(signInEmailField.getText());
		            verkeerdeWwoord = 0;
				}
				signInEmailField.setText("");
				signInPasField.setText("");
			}
		}
	}

	// een klant registreren en opslaan op database
	private void LogUpButtonActionPerformed(ActionEvent evt) throws SQLException {
		if (stadField.getText().equals("") || signUpNaamField.getText().equals("")
				|| signUpVoornaamField.getText().equals("") || signUpEmailField.getText().equals("")
				|| PostCodeField.getText().equals("") || straatField.getText().equals("")
				|| HuisnrField.getText().equals("") || signUpPasswordField.getText().equals("")) {
			waarschuwlbl1.setText("*Een of meer velden zijn leeg!");
		} else {		
			 
			if(DbKlant.checkEmail(signUpNaamField.getText(), signUpVoornaamField.getText(),
			signUpEmailField.getText(), signUpPasswordField.getText(), Integer.parseInt(PostCodeField.getText()),
			straatField.getText(), Integer.parseInt(HuisnrField.getText()), stadField.getText())==true){
			JOptionPane.showMessageDialog(null, "email bestaat al in onze database!");
			signUpEmailField.setText("");
			signUpPasswordField.setText("");}
			else{			
			
			DbKlant.VoegUserToe(signUpNaamField.getText(), signUpVoornaamField.getText(),
			signUpEmailField.getText(), signUpPasswordField.getText(), Integer.parseInt(PostCodeField.getText()),
			straatField.getText(), Integer.parseInt(HuisnrField.getText()), stadField.getText());		
			
			stadField.setText("");
			signUpNaamField.setText("");
			signUpVoornaamField.setText("");
			signUpEmailField.setText("");
			signUpPasswordField.setText("");
			straatField.setText("");
			HuisnrField.setText("");
			PostCodeField.setText("");
			waarschuwlbl1.setText("");
			}
		}
	}

	// wachtwoord tonen of verbergen
	private void toonPasChkBox1ActionPerformed(ActionEvent evt) {
		if (toonPasChkBox1.isSelected()) {
			signInPasField.setEchoChar((char) 0);
		} else
			signInPasField.setEchoChar('*');
	}

	// wachtwoord tonen of verbergen
	private void toonPasChkBoxActionPerformed(ActionEvent evt) {
		if (toonPasChkBox.isSelected()) {
			signUpPasswordField.setEchoChar((char) 0);
		} else
			signUpPasswordField.setEchoChar('*');
	}
	
}
