package mijnRestau;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import mijnRestau.Database.DbKlant;
import mijnRestau.Database.DrankDB;
import mijnRestau.Database.FactuurDb;
import mijnRestau.Database.GerechtenDb;
import mijnRestau.Database.KinderMenuDb;
import mijnRestau.models.Factuur;
import mijnRestau.models.Klant;
import mijnRestau.models.ProductLijst;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
	boolean imageChooser = false;
	String path;
	
	public AdminPanel() {
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		
	}

	private void initComponents() {
	
		jpanel1 = new JPanel();
		jpanel2 = new JPanel();
		AchtergrondPanl = new JPanel();
		updatePanel = new JPanel();
		checkVooraadPanel = new JPanel();
		facturatiePanel = new JPanel();		
		adrespanel = new JPanel();		
		new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jlabel7 = new JLabel();
		jlabel8 = new JLabel();
		jlabel9 = new JLabel();
		jlabel10 = new JLabel();
		jlabel11 = new JLabel();		
		selectedPhoto = new JLabel();		
		updateButton = new JButton();
		checkVooraadButton = new JButton();
		adresButton = new JButton();
		factuurButton = new JButton();
		photoSelect = new JButton();
		voegButton = new JButton();
		updateVooraadButton = new JButton();
		verwijder1 = new JButton();
		verwijder2 = new JButton();		
		updateGegevens = new JButton();		
		gaNaar = new JButton();		
		mGerecht = new JTextField();
		mQty = new JTextField();
		UpdateGerecht = new JTextField();
		delGerecht = new JTextField();
		mPrijs = new JTextField();		
		mFotoPath = new JTextField();
		UpdateQty = new JTextField();
		mCat = new JComboBox<>();
		VooraadStatusCat = new JComboBox<>();
		delUpdateCat = new JComboBox<>();		
		jScrollPane1 = new JScrollPane();
		mBeschrijving = new JTextArea();		
		jScrollPane3 = new JScrollPane();
		jScrollPane4 = new JScrollPane();
		adressenTable = new JTable();
		checkVooraadTable = new JTable();
		factuurtbl = new JTable();
		jScrollPane2 = new JScrollPane();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//jpanel2.setMinimumSize(new Dimension(70,50));
		
	
		updateButton.setText("Nieuwe invoer");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateButtonActionPerformed(evt);}});
		
		gaNaar.setText("Menu");
		gaNaar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gaNaarButtonActionPerformed(evt);}});

		checkVooraadButton.setText("Controleer voorraad");
		checkVooraadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				checkVooraadButtonActionPerformed(evt);}});

		factuurButton.setText("Facturatie");
		factuurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				factuurButtonActionPerformed(evt);}});
		
		adresButton.setText("Adressen");
		adresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				adresButtonActionPerformed(evt);}});

		// panelMenu(new entry, check Vooraad, billing,..)
		GroupLayout jpanel1Layout = new GroupLayout(jpanel1);
		jpanel1.setLayout(jpanel1Layout);
		jpanel1.setBorder(BorderFactory.createTitledBorder("jpanel1"));
		jpanel1Layout.setHorizontalGroup(jpanel1Layout.createParallelGroup()	
						.addComponent(updateButton,200,200,200)
						.addComponent(checkVooraadButton,200,200,200)
						.addComponent(factuurButton,200,200,200)
						.addComponent(adresButton,200,200,200)
						.addComponent(gaNaar,200,200,200));
		jpanel1Layout.setVerticalGroup(jpanel1Layout.createSequentialGroup()					
						.addComponent(factuurButton,65,65,65)							
						.addComponent(checkVooraadButton,65,65,65)
						.addComponent(updateButton,65,65,65)
						.addComponent(adresButton,65,65,65)
						.addComponent(gaNaar,65,65,65));
		jpanel2.add(jpanel1);	
		AchtergrondPanl.setLayout(new CardLayout());

		// panel product details
	
		updatePanel.add(jLabel1);	
		updatePanel.add(jLabel2);
		updatePanel.add(jLabel3);
		updatePanel.add(jLabel4);
		updatePanel.add(jLabel5);
		updatePanel.add(jLabel6);
		updatePanel.add(mCat);
		updatePanel.add(selectedPhoto);
		updatePanel.add(mPrijs);		
		updatePanel.add(mGerecht);
		updatePanel.add(mQty);
		updatePanel.add(mFotoPath);
		
		jLabel1.setText("Productdetails");
		jLabel2.setText("Gerecht:");
		jLabel3.setText("categorie:");	
		jLabel4.setText("Prijs:");
		jLabel5.setText("Hoeveelheid:");
		jLabel6.setText("Gerecht beschrijving:");
		mFotoPath.setText("Foto uploaden:");
		voegButton.setText("Update");		
		jlabel7.setText("Gerecht:");
		jlabel10.setText("Gerecht:");		
		jlabel8.setText("Vooraad bijwerken:");
		jlabel9.setText("Verwijderen:");				
		jlabel11.setText("Hoeveelheid: ");
		mFotoPath.setEditable(false);
		mCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));
		jScrollPane1.setViewportView(mBeschrijving);
		selectedPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		selectedPhoto.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_Add_Image_100px.png")));
		
		photoSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				photoSelectActionPerformed(evt);
			}
		});
		updatePanel.add(photoSelect);

		voegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				voegButtonActionPerformed(evt);
			}
		});
		updatePanel.add(voegButton);
		AchtergrondPanl.add(updatePanel);

		// Tabel checkvoorraad
		checkVooraadTable.setModel(new DefaultTableModel(new Object[][] {
		}, new String[] { "Gerecht", "Vooraad", "categorie" }));
		checkVooraadTable.setEnabled(false);
		checkVooraadTable.setRowHeight(20);
		jScrollPane3.setViewportView(checkVooraadTable);
				
	// adressentabel
		adressenTable.setColumnSelectionAllowed(true);
		
		adressenTable.setModel(new DefaultTableModel(new Object[][] {
			
		}, new String[] { "ID", "naam", "voornaam", "email", "straat", "huisnummer", "postcode", "stad" }));
	
		adressenTable.setEnabled(true);
		adressenTable.setRowHeight(20);
		jScrollPane4.setViewportView(adressenTable);

		VooraadStatusCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));

		updateVooraadButton.setText("Update Vooraad");
		updateVooraadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateVooraadButtonActionPerformed(evt);
			}
		});

		verwijder1.setText("Verwijderen");
		verwijder1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				verwijder1ActionPerformed(evt);
			}
		});
		delUpdateCat.setModel(new DefaultComboBoxModel<>(new String[] { "Gerechten", "Drank", "Kids" }));

		// updatePanel-------------------------------------------
		GroupLayout updatepanelLayout = new GroupLayout(updatePanel);
		updatePanel.setBorder(BorderFactory.createTitledBorder("updatepanel"));
		updatePanel.setLayout(updatepanelLayout);
		updatepanelLayout.setHorizontalGroup(updatepanelLayout.createSequentialGroup().addGap(140, 140, 140)
				.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel1,150,150,150)
								.addComponent(jLabel2,200,200,200)
								.addComponent(jLabel3,200,200,200)
								.addComponent(jLabel4,200,200,200)
								.addComponent(jLabel5,200,200,200)
								.addComponent(jLabel6,200,200,200)
								.addComponent(mFotoPath,200,200,200))
				.addGroup(updatepanelLayout.createParallelGroup()					
								.addComponent(mGerecht,200,200,200)
								.addComponent(mCat,200,200,200)
								.addComponent(mPrijs,200,200,200)
								.addComponent(mQty,200,200,200)
								.addComponent(mBeschrijving,200,200,200)
								.addGap(150, 150, 150)
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(photoSelect,200,200,200)
								.addComponent(selectedPhoto,200,200,200)))
				.addGap(250, 250, 250).addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(voegButton,200,200,200)));
		updatepanelLayout.setVerticalGroup(updatepanelLayout.createSequentialGroup()
				.addGroup(updatepanelLayout.createSequentialGroup()
								.addComponent(jLabel1,30,30,30)
								.addGap(40, 40, 40)				
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel2,30,30,30)
								.addComponent(mGerecht,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel3,30,30,30)
								.addComponent(mCat,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel4,30,30,30)
								.addComponent(mPrijs,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel5,30,30,30)
								.addComponent(mQty,30,30,30))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(jLabel6,30,30,30)
								.addComponent(mBeschrijving,120,120,120))
						.addGroup(updatepanelLayout.createParallelGroup()
								.addComponent(mFotoPath,30,30,30)
								.addComponent(photoSelect,200,200,200)
								.addGroup(updatepanelLayout.createSequentialGroup()
								.addComponent(selectedPhoto,200,200,200)))
						.addGap(20, 20, 20)
						.addComponent(voegButton,50,50,50)));

		AchtergrondPanl.add(updatePanel);

		// check Vooraad
		GroupLayout checkVooraadPanelLayout = new GroupLayout(checkVooraadPanel);
		checkVooraadPanel.setLayout(checkVooraadPanelLayout);
		checkVooraadPanelLayout.setHorizontalGroup(checkVooraadPanelLayout
				.createParallelGroup().addComponent(jScrollPane3,1000,1000,1000)
				.addGroup(checkVooraadPanelLayout.createSequentialGroup()
						.addGroup(checkVooraadPanelLayout.createParallelGroup()
								.addGroup(checkVooraadPanelLayout.createSequentialGroup()
										.addComponent(jlabel9,117,117,117).addGap(25,25,25)
										.addComponent(jlabel10,50,50,50)
										.addComponent(delGerecht,165,165,165)
										.addComponent(delUpdateCat,145,145,145).addGap(25,25,25)
										.addComponent(verwijder1,171,171,171))
								.addGroup(checkVooraadPanelLayout.createSequentialGroup()
										.addComponent(jlabel8,117,117,117).addGap(25,25,25)
										.addComponent(jlabel7,50,50,50)
										.addComponent(UpdateGerecht,165,165,165)
										.addComponent(VooraadStatusCat,145,145,145).addGap(25,25,25)
										.addComponent(jlabel11,50,50,80)
										.addComponent(UpdateQty,165,165,165).addGap(25,25,25)))
										.addComponent(updateVooraadButton)));
		checkVooraadPanelLayout.setVerticalGroup(checkVooraadPanelLayout.createParallelGroup()
							.addGroup(checkVooraadPanelLayout.createSequentialGroup()
									   .addComponent(jScrollPane3,350,350,350)
						    .addGroup(checkVooraadPanelLayout.createParallelGroup()
							.addGroup(checkVooraadPanelLayout.createSequentialGroup()
							.addGroup(checkVooraadPanelLayout.createParallelGroup()
									   .addComponent(jlabel7,30,30,30)
									   .addComponent(UpdateGerecht,30,30,30)
									   .addComponent(jlabel8,30,30,30)))
								.addGroup(checkVooraadPanelLayout.createSequentialGroup()
								.addGroup(checkVooraadPanelLayout.createParallelGroup()
									   .addComponent(VooraadStatusCat,30,30,30)
									   .addComponent(jlabel11,30,30,30)
									   .addComponent(UpdateQty,30,30,30)
									   .addComponent(updateVooraadButton)))).addGap(25,25,25)
						.addGroup(checkVooraadPanelLayout.createParallelGroup()
					.addGroup(checkVooraadPanelLayout.createParallelGroup()
									   .addComponent(jlabel10,30,30,30)
									   .addComponent(delGerecht,30,30,30)
									   .addComponent(jlabel9,30,30,30))
								.addGroup(checkVooraadPanelLayout.createParallelGroup()
									   .addComponent(delUpdateCat,30,30,30)
									   .addComponent(verwijder1,30,30,30)))));
		AchtergrondPanl.add(checkVooraadPanel);

		factuurtbl.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Serial", "Username", "Totale factuur in €", "Tijd & datum" }));
		jScrollPane2.setViewportView(factuurtbl);
	//	verwijder2.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_Delete_24px.png")));
		verwijder2.setText("Delete Log");
		verwijder2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				verwijder2ActionPerformed(evt);
			}
		});
		updateGegevens.setText("Updaten");
		updateGegevens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateGegevens();
			}
		});
		
		// adresPanel	
		GroupLayout adrespanelLayout = new GroupLayout(adrespanel);
		adrespanel.setLayout(adrespanelLayout);
		adrespanelLayout.setHorizontalGroup(adrespanelLayout.createParallelGroup()
						.addComponent(jScrollPane4,1000,1000,1000)
				.addGroup(adrespanelLayout.createSequentialGroup()
						.addComponent(updateGegevens,175,175,175)));
		adrespanelLayout.setVerticalGroup(adrespanelLayout.createParallelGroup()
				.addGroup(adrespanelLayout.createSequentialGroup()
						.addComponent(jScrollPane4,495,495,495)
						.addComponent(updateGegevens,45,45,45)));

		AchtergrondPanl.add(adrespanel);
		jpanel2.add(AchtergrondPanl);
				
		// facturatiePanel
		GroupLayout facturatiePanelLayout = new GroupLayout(facturatiePanel);
		facturatiePanel.setLayout(facturatiePanelLayout);
		facturatiePanelLayout.setHorizontalGroup(facturatiePanelLayout.createParallelGroup()
						.addComponent(jScrollPane2,1000,1000,1000)
				.addGroup(facturatiePanelLayout.createSequentialGroup()
						.addComponent(verwijder2,175,175,175)));
		facturatiePanelLayout.setVerticalGroup(facturatiePanelLayout.createParallelGroup()
				.addGroup(facturatiePanelLayout.createSequentialGroup()
						.addComponent(jScrollPane2,495,495,495)
						.addComponent(verwijder2,45,45,45)));
		AchtergrondPanl.add(facturatiePanel);
		jpanel2.add(AchtergrondPanl);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup()
				.addComponent(jpanel2)
				.addComponent(AchtergrondPanl)));
		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(jpanel2)
				.addComponent(AchtergrondPanl));
		pack();
	}
	
	//
	private void adresButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(adrespanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) adressenTable.getModel();
		model.setRowCount(0);
		Object[] data = new Object[8];
		ArrayList<Klant> list1 = new ArrayList<>();
		list1 = DbKlant.MaakTabelKlant();
		for (int i = 0; i < list1.size(); i++) {			
			data[0] = i+1;
			data[1] = list1.get(i).getNaam();
			data[2] = list1.get(i).getVoornaam();
			data[3] = list1.get(i).getEmail();
			data[4] = list1.get(i).getStraat();
			data[5] = list1.get(i).getHuisnummer();
			data[6] = list1.get(i).getPostCode();
			data[7] = list1.get(i).getStad();
			model.addRow(data);
			adressenTable.setRowHeight(20);
		}
	}
	
	

	private void gaNaarButtonActionPerformed(ActionEvent evt) {
		Restaurant rest = new Restaurant();
		rest.setVisible(true);
	}
		private void factuurButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(facturatiePanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) factuurtbl.getModel();
		model.setRowCount(0);
		Object[] data = new Object[4];
		ArrayList<Factuur> list = new ArrayList<>();
		list = FactuurDb.facturen();
		for (int i = 0; i < list.size(); i++) {
			data[0] = i + 1;
			data[1] = list.get(i).getUname();
			data[2] = list.get(i).getBedrag();
			data[3] = list.get(i).getDate();
			model.addRow(data);
			factuurtbl.setRowHeight(20);
		}
	}
	
//
	private void checkVooraadButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(checkVooraadPanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
		DefaultTableModel model = (DefaultTableModel) checkVooraadTable.getModel();
		model.setRowCount(0);
		ArrayList<ProductLijst> list = GerechtenDb.checkVoorraad();
		Object data[] = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Gerechten";
			model.addRow(data);
		}

		list.clear();
		list = DrankDB.checkVoorraad();
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Drank";
			model.addRow(data);
		}
		list.clear();
		list = KinderMenuDb.checkVoorraad();
		for (int i = 0; i < list.size(); i++) {
			data[0] = list.get(i).getGerecht();
			data[1] = list.get(i).getQty();
			data[2] = "Kids";
			model.addRow(data);
		}
	}
	
//
	private void updateButtonActionPerformed(ActionEvent evt) {
		AchtergrondPanl.removeAll();
		AchtergrondPanl.add(updatePanel);
		AchtergrondPanl.repaint();
		AchtergrondPanl.revalidate();
	}
	
//
	private void photoSelectActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		File selectedImage = fc.getSelectedFile();
		path = selectedImage.getAbsolutePath();
		try {
			Image img = ImageIO.read(selectedImage);
			mFotoPath.setText(path);
			selectedPhoto.setIcon(new ImageIcon(img.getScaledInstance(selectedPhoto.getWidth(), selectedPhoto.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException ex) {
			Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// gerecht toevoegen in database
	private void voegButtonActionPerformed(ActionEvent evt) {
		try {
			if (mCat.getSelectedItem().equals("Drank")) {
				if (!path.equals(""))
					DrankDB.voegInDrankDb(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);}
			else if (mCat.getSelectedItem().equals("Gerechten")) {
				if (!path.equals(""))
					GerechtenDb.voegInGerechtenDB(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);
			} else if (mCat.getSelectedItem().equals("Kids")) {
				if (!path.equals(""))
					KinderMenuDb.VoegInKidsDb(mGerecht.getText(), Double.parseDouble(mPrijs.getText()),
							Integer.parseInt(mQty.getText()), mBeschrijving.getText(), path);}
			mGerecht.setText("");
			mQty.setText("");
			mPrijs.setText("");
			mBeschrijving.setText("");
			mFotoPath.setText("");
			selectedPhoto.setIcon(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			mGerecht.setText("");
			mQty.setText("");
			mPrijs.setText("");
			mBeschrijving.setText("");
			mFotoPath.setText("");}
		selectedPhoto.setIcon(null);
	}

	// voorraad updaten in database
	private void updateVooraadButtonActionPerformed(ActionEvent evt) {
		try {
			String gerecht = UpdateGerecht.getText();
			int qty = Integer.parseInt(UpdateQty.getText());
			if (VooraadStatusCat.getSelectedItem().equals("Gerechten")) {
				GerechtenDb.flag = true;
				GerechtenDb.updateGerechtenDB(gerecht, qty);
			}
			else if (VooraadStatusCat.getSelectedItem().equals("Drank")) {
				DrankDB.flag = true;
				DrankDB.updateDrankDb(gerecht, qty);
			}
			else if (VooraadStatusCat.getSelectedItem().equals("Kids")) {
				KinderMenuDb.flag = true;
				KinderMenuDb.updateKidsDB(gerecht, qty);
			}
			UpdateGerecht.setText("");
			UpdateQty.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// gerecht verwijderen uit database
	private void verwijder1ActionPerformed(ActionEvent evt) {
		try {
			String del = delGerecht.getText();
			if (delUpdateCat.getSelectedItem().equals("Gerechten")) {
				GerechtenDb.delete(del);
			} else if (delUpdateCat.getSelectedItem().equals("Drank")) {
				DrankDB.delete(del);
			} else if (delUpdateCat.getSelectedItem().equals("Kids")) {
				KinderMenuDb.delete(del);
			}
			delGerecht.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);}
	}

	// gegevens verwijderen uit database
	private void verwijder2ActionPerformed(ActionEvent evt) {
		FactuurDb.deletefactuurdb();
	}

	private void updateGegevens() {
		int selectedRowIndex = adressenTable.getSelectedRow();
		
		try {
System.out.println("testtestestestest1");
		
			int id = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 0).toString());
			String naam = adressenTable.getValueAt(selectedRowIndex, 1).toString();
			String voornaam = adressenTable.getValueAt(selectedRowIndex, 2).toString();
			String email = adressenTable.getValueAt(selectedRowIndex, 3).toString();
			String straat = adressenTable.getValueAt(selectedRowIndex, 4).toString();
			int huisnummer = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 5).toString());
			int postcode = Integer.parseInt(adressenTable.getValueAt(selectedRowIndex, 6).toString());
			String stad = adressenTable.getValueAt(selectedRowIndex, 7).toString();
			System.out.println("testtestestestest2");
/*String naam = "waarde";
String voornaam = "testestes";
String email = "testestes";
String straat = "testestes";
int huisnummer = 10;
int postcode = 2123;
String stad ="testestes";*/
System.out.println("testtestestestest2");
			DbKlant.updateKlant(id,naam, voornaam, email, straat, huisnummer, postcode, stad);
			System.out.println("testtestestestest3");
		} catch (Exception e) {			
			JOptionPane.showMessageDialog(null, "Er is een fout opgetrden!");			
		}
	}
	// Variables declaration

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jlabel7;
	private JLabel jlabel8;
	private JLabel jlabel9;
	private JLabel jlabel10;
	private JLabel jlabel11;
	private JLabel selectedPhoto;
	private JPanel jpanel2;
	private JPanel jpanel1;
	private JPanel AchtergrondPanl;
	private JPanel updatePanel;
	private JPanel facturatiePanel;
	private JPanel adrespanel;
	private JPanel checkVooraadPanel;	
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;	
	private JScrollPane jScrollPane4;	
	private JComboBox<String> mCat;
	private JTextArea mBeschrijving;
	private JTextField mGerecht;
	private JTextField mFotoPath;
	private JTextField mPrijs;
	private JTextField mQty;
	private JTextField UpdateGerecht;
	private JTextField UpdateQty;
	private JTextField delGerecht;
	private JComboBox<String> VooraadStatusCat;
	private JComboBox<String> delUpdateCat;
	private JButton updateButton;
	private JButton updateVooraadButton;
	private JButton voegButton;
	private JButton adresButton;
	private JButton factuurButton;
	private JButton photoSelect;
	private JButton verwijder1;
	private JButton verwijder2;
	private JButton updateGegevens;
	private JButton gaNaar;
	private JButton checkVooraadButton;
	private JTable adressenTable;	
	private JTable checkVooraadTable;	
	private JTable factuurtbl;
}
