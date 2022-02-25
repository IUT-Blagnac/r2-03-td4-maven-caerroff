import java.io.FileWriter;

public class TriEtudiants{

    public static void main(String[] args){
        String[][] listeEtu = getListe();
        TNPEtu tnp = creerListe();
        for(int i=0; i<listeEtu.length; i++){
            Etudiant etu = creerEtudiant(listeEtu[i]);
            ajouterEtu(tnp, etu);
        }

        noterResultats();


    }

    public static void noterResultats(){
        Etudiant test = new Etudiant("test","test","test",'A');
        try {
            FileWriter fw = new FileWriter("results.txt",true);


            fw.write("______________________________________\n");
            fw.write("Test pour un tableau de 10, 100 essais\n");
            fw.write("______________________________________\n");
            for(int i=0; i<100; i++) {
                fw.write("\n");
                TNPEtu dix = new TNPEtu(10);
                TestTri.placerTestMilieu(dix);
                TriSimple(dix);
                fw.write(chercherEtuSimple(dix, test,fw)+"\n");
                fw.write(chercherEtuOpti(dix, test,fw)+"\n");
                fw.write(chercherDichotomie(dix, test,fw)+"\n");
                fw.write("\n");
            }


            fw.write("______________________________________\n");
            fw.write("Test pour un tableau de 100, 100 essais\n");
            fw.write("______________________________________\n");
            for(int i=0; i<100; i++) {
                fw.write("\n");
                TNPEtu cent = new TNPEtu(100);
                TestTri.placerTestMilieu(cent);
                TriSimple(cent);
                fw.write(chercherEtuSimple(cent, test,fw)+"\n");
                fw.write(chercherEtuOpti(cent, test,fw)+"\n");
                fw.write(chercherDichotomie(cent, test,fw)+"\n");
                fw.write("\n");
            }


            fw.write("______________________________________\n");
            fw.write("Test pour un tableau de 1000, 100 essais\n");
            fw.write("______________________________________\n");
            for(int i=0; i<100; i++) {
                fw.write("\n");
                TNPEtu mille = new TNPEtu(1000);
                TestTri.placerTestMilieu(mille);
                TriSimple(mille);
                fw.write(chercherEtuSimple(mille, test,fw)+"\n");
                fw.write(chercherEtuOpti(mille, test,fw)+"\n");
                fw.write(chercherDichotomie(mille, test,fw)+"\n");
                fw.write("\n");
            }

            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * retourne un tableau a deux entrees en fonction d'un fichier CSV avec les Etudiants
     * @return le tableau
     */
    public static String[][] getListe(){
        try {
            String[][] liste = ListeEtudiants.getListe("listenomssansaccent.csv", ",");
            return liste;
        }catch(Exception e) {
            e.printStackTrace();
        }
        String[][] listeVide = new String[0][0];
        return listeVide;

    }

    /**
     * Cree un Etudiant par un tableau a une entree de String
     * @param liste IN: Le tableau avec l'etudiant
     * @return Objet Etudiant avec les caracteristiques du tableau
     */
    public static Etudiant creerEtudiant(String[] liste){
        Etudiant a = new Etudiant();
        a.nom = liste[0];
        a.prenom = liste[1];
        a.TD = liste[3].charAt(1);
        a.TP = liste[2];
        return a;
    }

    /**
     * Fonction simplifiant la creation d'un TNPEtu
     * @return le TNP vide
     */
    public static TNPEtu creerListe(){
        TNPEtu liste = new TNPEtu();
        return liste;
    }

    /**
     * Fonction ajoutant un Etudiant a la fin d'un TNPEtu
     * @param pfTNP
     * @param pfEtu
     */
    public static void ajouterEtu(TNPEtu pfTNP, Etudiant pfEtu){
        pfTNP.tab[pfTNP.nbEl] = pfEtu;
        pfTNP.nbEl++;
    }

    /**
     * Cree un TNPEtu de la taille donnee
     * @param taille IN: la taille
     * @return le TNP cree
     */
    public static TNPEtu creerTNPTaille(int taille){
        TNPEtu tnp = new TNPEtu(taille+1);
        for(int i=0; i<taille; i++){
            Etudiant etu = new Etudiant();
            ajouterEtu(tnp, etu);
        }
        Etudiant test = new Etudiant("test","test","test",'A');
        ajouterEtu(tnp, test);
        return tnp;

    }

    /**
     * Tri un TNP par ordre alphabetique
     * @param tnp IN/OUT: Le TNP que l'on veut trier
     */
    public static void TriSimple(TNPEtu tnp){

        for(int i = 0 ; i < tnp.nbEl - 1 ; i++){
            for(int j = i + 1 ; j < tnp.nbEl ; j++){
                if(Etudiant.comparer(tnp.tab[i], tnp.tab[j]) > 0){
                    Etudiant echange = tnp.tab[i];
                    tnp.tab[i] = tnp.tab[j];
                    tnp.tab[j] = echange;
                }
            }
        }
    }

    /**
     * Algorithme simple de recherche d'un Etudiant dans un TNPEtu sans rupture
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherEtuSimple(TNPEtu pfTNP, Etudiant pfEtu){
        System.out.println("Recherche Simple");
        int compteurFor = 0;
        int indice = -1;
        for(int i=0; i< pfTNP.nbEl; i++){
            compteurFor++;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                indice = i;
            }
        }
        System.out.println("For : "+compteurFor);
        return indice;
    }

    /**
     * Algorithme simple de recherche d'un Etudiant dans un TNPEtu sans rupture
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @param fw IN: Fichier texte pour ecrire le debug
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherEtuSimple(TNPEtu pfTNP, Etudiant pfEtu, FileWriter fw){
        try {
            fw.write("Recherche Simple\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        int compteurFor = 0;
        int indice = -1;
        for(int i=0; i< pfTNP.nbEl; i++){
            compteurFor++;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                indice = i;
            }
        }
        try {
            fw.write("For : " + compteurFor+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        return indice;
    }

    /**
     * Algorithme simple de recherche d'un Etudiant dans un TNPEtu avec rupture
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherEtuOpti(TNPEtu pfTNP, Etudiant pfEtu){
        System.out.println("Recherche Optimisée");
        int compteurFor = 0;
        boolean trouve = false;
        int indice = -1;
        for(int i=0; i< pfTNP.nbEl && !trouve; i++){
            compteurFor++;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                trouve=true;
                indice = i;
            }
        }
        System.out.println("For : "+compteurFor);
        return indice;
    }

    /**
     * Algorithme simple de recherche d'un Etudiant dans un TNPEtu avec rupture
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @param fw IN: Fichier stockant les resultats
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherEtuOpti(TNPEtu pfTNP, Etudiant pfEtu, FileWriter fw){
        try {
            fw.write("Recherche Optimisee\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        int compteurFor = 0;
        boolean trouve = false;
        int indice = -1;
        for(int i=0; i< pfTNP.nbEl && !trouve; i++){
            compteurFor++;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                trouve=true;
                indice = i;
            }
        }
        try {
            fw.write("For : " + compteurFor+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }

        return indice;
    }

    /**
     * Algorithme de recherche par dichotomie d'un Etudiant dans un TNPEtu
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherDichotomie(TNPEtu pfTNP, Etudiant pfEtu){
        //Pour le Debug
        System.out.println("Recherche par Dichotomie");
        //Initialisation des variables
            //Entiers
        int indice = -1;
        int iMax = pfTNP.nbEl-1;
        int iDeb = 0;
        int i;
        int nbWhile = 0;
            //Booléens
        boolean estDedans = false;
        boolean arret = false;

        //Corps de Fonction
        while(!estDedans && !arret){
            nbWhile ++;
            i = (iDeb+iMax)/2;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                estDedans = true;
                indice = i;
            } else if(Etudiant.comparer(pfTNP.tab[i],pfEtu) < 0){
                iDeb = i + 1;
            }else{
                iMax = i - 1;
            }
            if(iDeb > iMax){
                arret = true;
            }
        }
        //Retour des résultats
        System.out.println("While :"+nbWhile);
        return indice;
    }

    /**
     * Algorithme de recherche par dichotomie d'un Etudiant dans un TNPEtu
     * @param pfTNP IN: Le TNP dans lequel on cherche
     * @param pfEtu IN: L'Etudiant que l'on cherche
     * @param fw IN: Fichier stockant les resultats
     * @return l'indice de l'Etudiant s'il a ete trouve, -1 sinon
     */
    public static int chercherDichotomie(TNPEtu pfTNP, Etudiant pfEtu, FileWriter fw){
        //Pour le Debug
        try {
            fw.write("Recherche par Dichotomie\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        //Initialisation des variables
        //Entiers
        int indice = -1;
        int iMax = pfTNP.nbEl-1;
        int iDeb = 0;
        int i;
        int nbWhile = 0;
        //Booléens
        boolean estDedans = false;
        boolean arret = false;

        //Corps de Fonction
        while(!estDedans && !arret){
            nbWhile ++;
            i = (iDeb+iMax)/2;
            if(Etudiant.equal(pfTNP.tab[i],pfEtu)){
                estDedans = true;
                indice = i;
            } else if(Etudiant.comparer(pfTNP.tab[i],pfEtu) < 0){
                iDeb = i + 1;
            }else{
                iMax = i - 1;
            }
            if(iDeb > iMax){
                arret = true;
            }
        }
        //Retour des résultats
        try {
            fw.write("While :" + nbWhile+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        return indice;
    }



    /**
     * Algo de test de la recherche non optimisee, utile a des fins de debugging
     * @param pfTnp IN: Un TNP avec au moins un Etudiant
     * @return le resultat du test : true si reussi, false sinon
     */
    public static boolean testRecherche(TNPEtu pfTnp){
        boolean testReussi = true;
        String erreurs = "";
        try {
            if(chercherEtuSimple(pfTnp, pfTnp.tab[pfTnp.nbEl-1]) != pfTnp.nbEl-1){
                testReussi = false;
                erreurs += "Lorsque l'on recherche le dernier Etudiant du tableau, on ne tombe pas sur son indice\n";
            }
        }catch(Exception e){
            e.printStackTrace();
            testReussi = false;
            erreurs += "Exception lors de la recherche du dernier Etudiant du tableau\n";
        }

        Etudiant etuTest = new Etudiant("test","test","test",'A');
        if(chercherEtuSimple(pfTnp, etuTest) != -1){
            testReussi = false;
            erreurs += "Lorsque l'on recherche un étudiant qui n'existe pas, le programme de recherche ne renvoit pas -1\n";
        };

        if(erreurs.compareTo("") != 0) {
            System.out.println(erreurs);
        }
        return testReussi;


    }

}