import java.util.Random;

public class TestTri {
    public static void main(String[] args){
        Etudiant etu = creerEtudiantRandom();
        Etudiant.printEtu(etu);

    }

    /**
     * Place un etudiant test au milieu d'un TNPEtu en EFFACANT LE TNP.
     * Si la taille du TNP est paire, le test est place au milieu +1
     * @param pfTnp IN: Le TNP dans lequel on veut placer le test
     */
    public static void placerTestMilieu(TNPEtu pfTnp){
        for(int i=0; i< pfTnp.tab.length/2; i++){
            Etudiant randomEtu = creerEtudiantRandom();
            TriEtudiants.ajouterEtu(pfTnp, randomEtu);

        }
        Etudiant test = new Etudiant("test","test","test",'A');
        TriEtudiants.ajouterEtu(pfTnp, test);
        for(int i=0; i< (pfTnp.tab.length/2)-1; i++){
            Etudiant randomEtu = creerEtudiantRandom();
            TriEtudiants.ajouterEtu(pfTnp, randomEtu);

        }
    }

    /**
     * creer un Etudiant avec des caracteres aleatoires
     * @return l'etudiant cree
     */
    public static Etudiant creerEtudiantRandom(){
        Etudiant random = new Etudiant();
        Random rnd = new Random();
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for(int i=0; i<rnd.nextInt(12); i++) {
            random.nom += alphabet[rnd.nextInt(26)];
        }
        for(int i=0; i<rnd.nextInt(12); i++) {
            random.prenom += alphabet[rnd.nextInt(26)];
        }
        return random;
    }
}
