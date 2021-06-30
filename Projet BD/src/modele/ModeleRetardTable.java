package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleRetardTable extends DefaultTableModel{

	String[] intitules = {"TITRE","DATE_EMP","NOM","PRENOM","EMAIL"};
	int nbLignes;
	int nbColonnes = 5;
	public ModeleRetardTable(Retard[] data) {
		this.nbLignes = data.length;
		this.setColumnIdentifiers(intitules);
		this.setRowCount(nbLignes);
		//System.out.println(data.length+" "+data[0].getId_et());
		for(int i = 0; i < data.length; i++) {
			setValueAt(data[i].getTitre(),i,0);
			setValueAt(data[i].getDate_emp(),i,1);
			setValueAt(data[i].getNom(),i,2);
			setValueAt(data[i].getPrenom(),i,3);
			setValueAt(data[i].getEmail(),i,4);
			
		}
	}
}

