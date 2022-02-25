public class TNPEtu{
    Etudiant[] tab;
    int nbEl;

    TNPEtu(){
        this.tab = new Etudiant[200];
        this.nbEl = 0;
    }

    TNPEtu(int pfTaille){
        this.tab = new Etudiant[pfTaille];
        this.nbEl = 0;
    }

    TNPEtu(Etudiant[] pfTab, int pfTaille){
        this.tab = pfTab;
        this.nbEl = 0;
    }

    /**
     * Fonction affichant un TNPEtu avec un element par ligne
     * affiche seulement les attributs NOM et PRENOM
     * @param tnp IN: Le TNP que l'on veut afficher
     */
    public static void printTNP(TNPEtu tnp){
        for(int i=0; i<tnp.nbEl; i++){
            System.out.println(i+" : "+tnp.tab[i].nom +" "+tnp.tab[i].prenom );
        }
    }
}