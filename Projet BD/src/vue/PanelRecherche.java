package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import controleur.Controleur;
import modele.Etudiant;
import modele.ModeleEtudiantTable;
import modele.ModeleRetardTable;
import modele.RequeteSQL;
import modele.Retard;

public class PanelRecherche extends JPanel{
	JPanel panelTable;
	JPanel panelRecherche;
	JPanel panelChoix;
	JLabel labelChoix;
	JComboBox<String> comboChoix;
	JPanel panelCherche;
	JPanel panelBouton;
	JButton boutonEmprunt;
	JTable tableau;
	JLabel imageCherche;
	JTextField champCherche;
	Retard[] data;
	ModeleRetardTable tableauModel;
	ImageIcon imageRecherche = new ImageIcon("images/recherche.png");
	public PanelRecherche(Connection connexion) throws SQLException {
		panelTable = new JPanel();
		add(panelTable);
		
		comboChoix = new JComboBox<>();
		 panelRecherche = new JPanel();
		 panelChoix = new JPanel();
		 labelChoix = new JLabel();
		 panelCherche = new JPanel(); 
		 panelBouton = new JPanel();
		 boutonEmprunt = new JButton();
		 tableau = new JTable();
		 imageCherche = new JLabel(imageRecherche);
		 champCherche = new JTextField();
		
         panelTable.setPreferredSize(new Dimension(805, 800));
         panelTable.setLayout(new BorderLayout());

         panelRecherche.setBackground(new Color(64, 2, 53));
         panelRecherche.setPreferredSize(new Dimension(805, 50));
         panelRecherche.setLayout(new GridBagLayout());

         panelChoix.setBackground(new Color(64, 2, 53));
         panelChoix.setPreferredSize(new Dimension(160, 50));
         panelChoix.setLayout(new GridBagLayout());

         labelChoix.setForeground(new Color(255, 255, 255));
         labelChoix.setText("RETARD");
         GridBagConstraints gridBagConstraints = new GridBagConstraints();
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         panelChoix.add(labelChoix, gridBagConstraints);
         panelRecherche.add(panelChoix,gridBagConstraints);


         panelTable.add(panelRecherche, BorderLayout.NORTH);
         //tableau
 		tableau = new JTable();
 		tableau.setSelectionBackground(new Color(64, 2, 53));
 		tableau.setSelectionForeground(new Color(255,255,255));
 		tableau.getTableHeader().setReorderingAllowed(false);
 		data = RequeteSQL.getRetard(connexion);
 		tableauModel = new ModeleRetardTable(data);
		JScrollPane scroll = new JScrollPane(tableau,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//tableau.setDefaultRenderer(Integer.class,new CelluleRenderer());

		tableau.setModel(tableauModel);
 		
 		
 		/*DefaultTableModel tableauModel = new DefaultTableModel();
 		tableauModel.setColumnIdentifiers(intitulesTab);
 		RequeteSQL.ordreTable(connexion, tableauModel, "normal");
 		
 		tableau.setModel(tableauModel);
 		jScrollPane1.setViewportView(tableau);*/
	    panelTable.add(scroll, BorderLayout.CENTER);
	}
	public void enregistreEcouteur(Controleur parControleur) {
		champCherche.addKeyListener(parControleur);
		boutonEmprunt.addActionListener(parControleur);
		tableau.getSelectionModel().addListSelectionListener(parControleur);
	}
	public JComboBox<String> getComboChoix() {
		return comboChoix;
	}
	public void setComboChoix(JComboBox<String> comboChoix) {
		this.comboChoix = comboChoix;
	}
	public JButton getBoutonEmprunt() {
		return boutonEmprunt;
	}
	public void setBoutonEmprunt(JButton boutonEmprunt) {
		this.boutonEmprunt = boutonEmprunt;
	}
	public JTable getTableau() {
		return tableau;
	}
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}
	public JTextField getChampCherche() {
		return champCherche;
	}
	public void setChampCherche(JTextField champCherche) {
		this.champCherche = champCherche;
	}
}
