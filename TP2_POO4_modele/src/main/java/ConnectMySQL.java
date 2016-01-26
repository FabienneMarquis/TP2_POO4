package main.java;



import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by 1494778 on 2016-01-21.
 */
public class ConnectMySQL {
    private static String URL = "jdbc:mysql://localhost/tp2_simulation_stock";
    private static String UTILISATEUR = "root";
    private static String MOT_DE_PASSE = "";


    private int year;

    public ConnectMySQL(){
        year = Calendar.getInstance().get(Calendar.YEAR);
        addYear(year);
    }


    public void addYear(int year){
        Connection connexion = null;
//voir pour l'année actuel?? idSim, Id thred (T1 ou T2), QTe (delta), Stock, nmb RuptureStock, Qte_RS, Penalité, QTe
        String insertlist = "Insert into `annee`  values(" + year +");";
        System.out.println(insertlist);
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connexion = DriverManager.getConnection(URL, UTILISATEUR,
                    MOT_DE_PASSE);
			/* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();

            int statut = statement.executeUpdate(insertlist);

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (connexion != null)
                try {
					/* Fermeture de la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
					/*
					 * Si une erreur survient lors de la fermeture, il suffit de
					 * l'ignorer.
					 */
                }
        }
    }

   public void addStatistic( int num, String tempX, int delta, int stock, int ruptureStock, int quantityRuptureStock, int costPenality,int averageStock) {
       Connection connexion = null;
//voir pour l'année actuel?? idSim, Id thred (T1 ou T2), QTe (delta), Stock, nmb RuptureStock, Qte_RS, Penalité, QTe
       String insertlist = "Insert into `simulation`( `idSimulation`, `idThread`, `Qte`, `Stock`, `Nombre_RS`, `Qte_RS`, `Penalité`, `QteMoy`, `Annee`)  values(" + num + " , '" + tempX + "'," + delta + " ," + stock + ","
               + ruptureStock + "," + quantityRuptureStock + "," + costPenality + "," + averageStock + ", "+year+");";
       System.out.println(insertlist);
       try {
           try {
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }

           connexion = DriverManager.getConnection(URL, UTILISATEUR,
                   MOT_DE_PASSE);
			/* Création de l'objet gérant les requêtes */
           Statement statement = connexion.createStatement();

           int statut = statement.executeUpdate(insertlist);

       } catch (SQLException e) {
           System.out.println(e.toString());
       } finally {
           if (connexion != null)
               try {
					/* Fermeture de la connexion */
                   connexion.close();
               } catch (SQLException ignore) {
					/*
					 * Si une erreur survient lors de la fermeture, il suffit de
					 * l'ignorer.
					 */
               }
       }
   }

    private List<Result> getStatistic() {
		/* Connexion à la base de données */
        List<Result> statistique = new ArrayList<>();
        Connection connexion = null;

        //FXCollections.observableArrayList Liste ;
        try {
            connexion = DriverManager.getConnection(URL, UTILISATEUR,
                    MOT_DE_PASSE);
			/* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement
                    .executeQuery("SELECT * FROM simulation;");
			/* Récupération des données du résultat de la requête de lecture */
            while (resultat.next()) {

                Result result = new Result((Integer.parseInt(resultat.getString("num"))),(resultat.getString("tempX")),(Integer.parseInt(resultat.getString("delta"))),
                        (Integer.parseInt(resultat.getString("stock"))),(Integer.parseInt(resultat.getString("ruptureStock"))),(Integer.parseInt(resultat.getString("quantityRuptureStock"))),
                        (Integer.parseInt(resultat.getString("costPenality"))),(Integer.parseInt(resultat.getString("averageStock"))));
                statistique.add(result);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (connexion != null)
                try {
					/* Fermeture de la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
					/*
					 * Si une erreur survient lors de la fermeture, il suffit de
					 * l'ignorer.
					 */
                }
        }
        return statistique;
}
}
