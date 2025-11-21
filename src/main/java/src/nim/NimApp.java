package src.nim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class NimApp extends Application {
  private  Commande commande =  new Commande();
    String resultatAllumetes;
    char[] tabAllumettes;
    private int nombreAllumettes = 0;
    private int jeux = 0;
    private char [] allumetttes;
    String nomJoueur1;
    String nomJoueur2;
    @Override
    public void start(Stage primarystage) throws Exception {

        // Scene 1
        // titre
        Label titre = new Label("Bienvenue dans le jeux de Nim");
        //parametrer la taille du titre
        titre.setStyle("-fx-font-size: 20");
        //feedback
        Label feedback = new Label();
        //nom du joueur 1
        Label nomJ = new Label("Nom joueur 1 :");
        // field pour le joueur 1
        TextField nomJInput = new TextField();
        // max taille largeur
        nomJInput.setMaxWidth(150);
        //nom du joueur 1
        Label nomJ2 = new Label("Nom joueur 2 :");
        // field pour le joueur 2
        TextField nomJInput2 = new TextField();
        // max taille largeur
        nomJInput2.setMaxWidth(150);
        // label
        Label label = new Label("\nEntrez un nombre d'allumettes (minimum 10) : ");
        // field pour le nombre d'allumettes
        TextField nombre = new TextField();
        // max taille largeur du field nombre
        nombre.setMaxWidth(100);
    // bouton ok
        Button ok = new Button("Ok");
        // vbox
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(titre,nomJ,nomJInput,nomJ2,nomJInput2, label, nombre,ok,feedback);
        vbox.setAlignment(Pos.CENTER);
        // scene 1
        Scene scene = new Scene(vbox,700,500);


        //SCENE 2

        //feedback pour le nombre d'allumettes
        Label allumettes = new Label();
        Label feedback2 = new Label();
        Label joueur = new Label();
        TextField joueur1Input = new TextField();
        joueur1Input.setMaxWidth(100);

        Label joueur2 = new Label("Tu veux enlever combien d'allumettes joueurs 2"+nomJoueur2+" ? (entre 1 et 3) : ");
        TextField joueur2Input = new TextField();
        joueur2Input.setMaxWidth(100);

        Button  joueurButton = new Button("Ok");
        Button  joueur2Button = new Button("Ok");

        Label feedback3 = new Label();
        VBox vbox2 = new VBox(5);
        vbox2.getChildren().addAll(allumettes,joueur,joueur1Input,joueurButton,joueur2,joueur2Input, joueur2Button,feedback2,feedback3);
        vbox2.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(vbox2,700,500);



        // SCENE 3

        Label titre3 = new Label("FIN DU JEUX !!");
        Label gagnant = new Label();
        Button recommencer = new Button("Recommencer");
        Button quitter = new Button("Quitter");

        VBox vbox3 = new VBox(5);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().addAll(titre3,gagnant,recommencer,quitter);
        Scene scene3 = new Scene(vbox3,700,500);

        quitter.setOnAction(e -> {primarystage.close();});

        nombre.setOnAction(e -> {
            ok.fire();
        });
        ok.setOnAction(e -> {
            try{
                nombreAllumettes = Integer.parseInt(nombre.getText());
                if(nombreAllumettes >= 10) {
                    commande.afficherAllumettes(nombreAllumettes,allumettes);
                    joueur2.setDisable(true);
                    joueur2Input.setDisable(true);
                    nomJoueur1 = nomJInput.getText();
                    nomJoueur2 = nomJInput2.getText();
                    joueur.setText("Tu veux enlever combien d'allumettes "+nomJoueur1+"  ? (entre 1 et 3) : ");
                    joueur2.setText("Tu veux enlever combien d'allumettes "+nomJoueur2+"  ? (entre 1 et 3) : ");
                    primarystage.setScene(scene2);
                }{
                    feedback.setText("Entrez un nombre correct ! Minimum 10 ! ");
                }
            }catch(NumberFormatException ex){
                feedback.setText("Entrez un nombre ! ");
            }
        });
        joueurButton.setOnAction(e -> {
            try {
                int nbjoueur1 = Integer.parseInt(joueur1Input.getText());
                if (1 <= nbjoueur1 && nbjoueur1 <= 3) {
                    if(nombreAllumettes-nbjoueur1<=0){
                        nombreAllumettes += nbjoueur1;
                        feedback2.setDisable(true);
                        feedback3.setText("Tu peux pas");
                    }{
                        nombreAllumettes -=  nbjoueur1;
                        feedback2.setText(nomJoueur1+" a enlevé : "+nbjoueur1);
                    }

                    System.out.println("Nombre joueur 2 : " + nbjoueur1);
                    System.out.println("Nombre enlever allumettes apres que  le joueur 2 a enlever " + nombreAllumettes);
                    commande.afficherAllumettes(nombreAllumettes, allumettes);
                    if (nombreAllumettes == 1) {
                        feedback2.setText("Tu as perdu "+nomJoueur2);
                        gagnant.setText("Le gagnant est "+nomJoueur1);
                        joueur2Button.setDisable(true);
                        joueurButton.setDisable(true);
                        joueurButton.setDisable(true);
                        primarystage.setScene(scene3);
                    }
                    joueur.setDisable(true);
                    joueur1Input.setDisable(true);
                    joueurButton.setDisable(true);

                    joueur2Input.setDisable(false);
                    joueur2Button.setDisable(false);

                } else {
                    feedback2.setText("Entrez un nombre entre 1 et 3");
                }
            }catch (Exception ex) {
                feedback2.setText("Entrez un nombre ! ");
            }
             });

        joueur2Button.setOnAction(e -> {
           try {
               int nbjoueur2 = Integer.parseInt(joueur2Input.getText());
               if (1 <= nbjoueur2 && nbjoueur2 <= 3) {
                   if(nombreAllumettes-nbjoueur2<=0){
                       feedback2.setVisible(false);
                       feedback3.setText("Tu peux pas");
                       nombreAllumettes += nbjoueur2;
                   }{
                       nombreAllumettes -=  nbjoueur2;
                       feedback2.setText(nomJoueur2+" a enlevé : "+nbjoueur2);
                   }

                   System.out.println("Nombre joueur 2 : " + nbjoueur2);
                   System.out.println("Nombre enlever allumettes apres que  le joueur 2 a enlever " + nombreAllumettes);
                   commande.afficherAllumettes(nombreAllumettes, allumettes);
                   if (nombreAllumettes == 1) {
                       feedback2.setText("Tu as perdu "+nomJoueur1);
                       gagnant.setText("Le gagnant est "+nomJoueur2);
                       joueur2Button.setDisable(true);
                       joueurButton.setDisable(true);
                       joueurButton.setDisable(true);
                       primarystage.setScene(scene3);
                   }
                   joueur.setDisable(false);
                   joueur1Input.setDisable(false);
                   joueurButton.setDisable(false);

                   joueur2Input.setDisable(true);
                   joueur2Button.setDisable(true);

               } else {
                   feedback2.setText("Entrez un nombre entre 1 et 3");
               }
           }catch (Exception ex) {
               feedback2.setText("Entrez un nombre ! ");
           }
        });

        joueur1Input.setOnAction(e -> {joueurButton.fire();
        });
        joueur2Input.setOnAction(e -> {joueur2Button.fire();});
        recommencer.setOnAction(e -> {
            nombre.clear();
            feedback.setText("");
            feedback2.setText("");
            joueur1Input.clear();
            joueur2Input.clear();
            nomJInput.clear();
            nomJInput2.clear();


            joueur.setDisable(false);
            joueur1Input.setDisable(false);
            joueurButton.setDisable(false);



            primarystage.setScene(scene);
        });
        // Stage
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.setTitle("Jeux de Nim");
        primarystage.show();



    }
}
