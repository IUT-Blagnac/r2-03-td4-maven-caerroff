
/**
 * Indiquer le ou les numeros de TP et d'exercice.
 *
 * @author (votre nom)
 */
public class Etudiant
{
    String nom;
    String prenom;
    String TP;
    char TD;

    Etudiant(){

        this.nom = "";
        this.prenom ="";
        this.TP = "" ;
        this.TD = ' ' ;

    }

    Etudiant(String pfNom, String pfPrenom, String pfTP, char pfTD){

        this.nom = pfNom;
        this.prenom =pfPrenom;
        this.TP = pfTP;
        this.TD = pfTD;
    }

    public static void printEtu(Etudiant pfEtu){
        System.out.println(pfEtu.nom+" "+pfEtu.prenom);
    }

    /**
     * Test de l'egalite entre deux etudiants sur le critere de leur prenom et de leur nom
     * @param pfEtu1 IN: L'Etudiant 1
     * @param pfEtu2 IN: L'Etudiant 2
     * @return true si ils sont egaux, faux sinon
     */
    public static boolean equal(Etudiant pfEtu1, Etudiant pfEtu2){
        boolean equal = true;
        if(pfEtu1.nom.compareTo(pfEtu2.nom) != 0){
            equal = false;
        }
        if(pfEtu1.prenom.compareTo(pfEtu2.prenom) != 0 && equal){
            equal = false;
        }
        if(pfEtu1.TP.compareTo(pfEtu2.TP)!=0 && equal){
            equal = false;
        }
        if(pfEtu1.TD != pfEtu2.TD && equal) {
            equal = false;
        }
        return equal;
    }

    /**
     * Comparaison de l'ordre alphabetique d'un Etudiant, d'abord sur son nom, puis sur son prenom si homonymie
     * @param pfEtu1 IN: L'Etudiant 1
     * @param pfEtu2 IN: L'Etudiant 2
     * @return 1 si pfEtu2 est apres dans l'ordre alphabetique, -1 s'il est avant, 0 s'ils sont egaux
     */
    public static int comparer(Etudiant pfEtu1, Etudiant pfEtu2){
        if(pfEtu1.nom.compareTo(pfEtu2.nom) > 0){
            return 1;
        }else if(pfEtu1.nom.compareTo(pfEtu2.nom) < 0){
            return -1;
        }else{
            if(pfEtu1.prenom.compareTo(pfEtu2.prenom) > 0){
                return 1;
            }else if(pfEtu1.prenom.compareTo(pfEtu2.prenom) < 0){
                return -1;
            }else{
                return 0;
            }
        }
    }
}

