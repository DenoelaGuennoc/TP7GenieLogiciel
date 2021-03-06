package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final LinkedList<Stationnement> myStationnements;

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}
		immatriculation = i;
                myStationnements = new LinkedList<>();
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?
                if(this.estDansUnGarage()){
                    throw new Exception("Cette voiture est déjà dans un garage");
                }
                else {
                    Stationnement s = new Stationnement(this, g);
                    myStationnements.add(s);
                }
	}

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
                if (this.estDansUnGarage()){
                    myStationnements.peekLast().terminer();
                }
                else{
                    throw new Exception("La voiture doit être dans un garage pour pouvoir en sortir");
                }
                
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté
                Set<Garage> listGarage = new HashSet<>();
                for (int i=0; i < myStationnements.size(); i++){
                    if(!listGarage.contains(myStationnements.get(i).getGarage())){
                        listGarage.add(myStationnements.get(i).getGarage());
                    }
                }
                return listGarage;
                
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
                // Vrai si le dernier stationnement est en cours
                if (myStationnements.isEmpty()){
                    return false;
                }
                else {
                    if(myStationnements.getLast().getFin() == null){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
                for (Garage vGarage : this.garagesVisites()){
                    out.println("Garage " + vGarage.getName() + ":");
                    for (int i=0; i < myStationnements.size(); i++){
                        if (vGarage.equals(myStationnements.get(i).getGarage())){
                            out.println(myStationnements.get(i).toString());
                        }
                    }
                }
        }

}
