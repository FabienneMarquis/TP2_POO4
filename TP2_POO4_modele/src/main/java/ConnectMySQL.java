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
    private static String URL = "jdbc:mysql://localhost/tp6";
    private static String UTILISATEUR = "javauser";
    private static String MOT_DE_PASSE = "TP6";

   public void addStatistic(int  num, int tempX, int delta, int stock, int ruptureStock, int quantityRuptureStock, int costPenalit,int averageStock ) {
       Connection connexion = null;

       String insertlist = "Insert into film values ('" + num + "' , '" + tempX + "','" + delta + "','" + stock + "','"
               + ruptureStock + "','" + quantityRuptureStock + "','" + costPenalit + "','" + averageStock + "')";
       try {
           connexion = DriverManager.getConnection(URL, UTILISATEUR,
                   MOT_DE_PASSE);
			/* Création de l'objet gérant les requêtes */
           Statement statement = connexion.createStatement();
           int statut = statement.executeUpdate(insertlist);
			/* Récupération des données du résultat de la requête de lecture */

           if (statut == 1) {

               /*JOptionPane.showMessageDialog(null,
                       "Le film fut ajouté avec succès!","SUCCESS!",JOptionPane.INFORMATION_MESSAGE);*/

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

                Result result = new Result((Integer.parseInt(resultat.getString("num"))),(Integer.parseInt(resultat.getString("tempX"))),(Integer.parseInt(resultat.getString("delta"))),
                        (Integer.parseInt(resultat.getString("stock"))),(Integer.parseInt(resultat.getString("ruptureStock"))),(Integer.parseInt(resultat.getString("quantityRuptureStock"))),
                        (Integer.parseInt(resultat.getString("costPenalit"))),(Integer.parseInt(resultat.getString("averageStock"))));
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
