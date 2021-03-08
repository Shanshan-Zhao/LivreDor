/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tplivoripm.metier;

/**
 *
 * @author ZssSy
 */
public class MessageDor {
    // propriétés
    private int id;
    private String pseudo;
    private String texte;

    //constructeurs
    public MessageDor(int id, String pseudo, String texte) {
        this.id = id;
        this.pseudo = pseudo;
        this.texte = texte;
    }
    
    public MessageDor(String pseudo, String texte) {
        this.pseudo = pseudo;
        this.texte = texte;
    }
    
    public MessageDor() {
    }
    
    // setter / getter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getPseudo() {return pseudo;}
    public void setPseudo(String pseudo) {this.pseudo = pseudo;}
    public String getTexte() {return texte;}
    public void setTexte(String texte) {this.texte = texte;}
    
    // méthodes redéfinies
    @Override
    public String toString() {
        return "MessageDor{" + "id=" + id + ", pseudo=" + pseudo + ", texte=" + texte + '}';
    }
    
}
