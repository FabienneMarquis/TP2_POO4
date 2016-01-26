package main.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class ConnectMySQL extends Observable{
    private static String URL = "jdbc:mysql://localhost/tp2_simulation_stock";
    private static String UTILISATEUR = "usager_tp2_POO4";
    private static String MOT_DE_PASSE = "1234";
    private int id_simulation;

    public ConnectMySQL(){
    id_simulation=0;
    }

    public int getId_simulation() {
        return id_simulation;
    }

    public void setId_simulation() {

        Connection connexion = null;
        String countIdSimulation ="select count(distinct idSimulation) from simulation ";
        int  numIDsimulation=0 ;
         int id_sim=1;
        try {
            connexion = DriverManager.getConnection(URL, UTILISATEUR,
                    MOT_DE_PASSE);


            if (numIDsimulation !=0){

            } else{
                this.id_simulation = id_sim;
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
    }

   public void addStatistic(int  num, String tempX, int delta, int stock, int ruptureStock, int quantityRuptureStock, int costPenality, int averageStock, String thread ) {
       Connection connexion = null;
       setId_simulation();
       String insertlist = "Insert into simulation values ('" + id_simulation + "' ,'" + thread + "' ,'" + num + "' , '" + tempX + "','" + delta + "','" + stock + "','"
               + ruptureStock + "','" + quantityRuptureStock + "','" + costPenality + "','" + averageStock + "')";
       try {
           connexion = DriverManager.getConnection(URL, UTILISATEUR,
                   MOT_DE_PASSE);
			/* Création de l'objet gérant les requêtes */
           Statement statement = connexion.createStatement();
           int statut = statement.executeUpdate(insertlist);
			/* Récupération des données du résultat de la requête de lecture */

           if (statut == 1) {



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
                    .executeQuery("SELECT * FROM ;");
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
