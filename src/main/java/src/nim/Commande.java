package src.nim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Commande {
    public void afficherAllumettes(int nbA,Label label){
        char [] tabA =  new char[nbA];
        for (int i = 0; i < nbA; i++) {
            tabA[i] = '|';
        }
        String allumettes =  new String(tabA);
        label.setText("Nombres d'allumettes : "+nbA+"\n"+allumettes);
        label.setStyle("-fx-background-color: #FF0000;");
        label.setStyle("-fx-font-size: 20");

    }

    public void finduJeuX(int nbA, String nomJ1, String nomJ2, Label g, Button j1, Button j2, Label feed, Stage stage, Scene scene,String gagnant){

        if (nbA == 1) {
            g.setText("Le gagnant est "+gagnant);
            j2.setDisable(true);
            j1.setDisable(true);
            j1.setDisable(true);
            stage.setScene(scene);
        }
    }

}
