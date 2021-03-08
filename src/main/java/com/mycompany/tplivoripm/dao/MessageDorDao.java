/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tplivoripm.dao;

import com.mycompany.tplivoripm.metier.MessageDor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ZssSy
 */
public class MessageDorDao {
    // propriété de connexion
    private static String URL = "jdbc:mysql://localhost:3307/db_21809055"; 
    private static String LOGIN = "21809055"; 
    private static String PASSWORD = "T00NO8"; 
    
    // Connexion
    private static Connection CX;
    
    // Méthode de connexion
    private static void connexion () throws Exception{
        // cargement du driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException cnfe){
            throw new Exception("connexion() - " + cnfe.getMessage());
        }
        
        // connexion 
        try{
            CX = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }catch (SQLException sqle){
            throw new Exception("connexion() - creation de la connexion" + sqle.getMessage());
        }
    }
    
    // ajout d'un enregistrement en BD
    public static void creationMessage (MessageDor msg) throws Exception{
        if(CX == null)
            MessageDorDao.connexion();
        
        // préparer la requete
        String sql = "INSERT INTO Message (Pseudo, Texte) VALUES (?, ?)";
        
        // ouverture de l'espace de requete
        try (PreparedStatement st = CX.prepareStatement(sql)){
            // assignement des paramètres de la requete
            st.setString(1, msg.getPseudo());
            st.setString(2, msg.getTexte());
            
            // execute la requete
            st.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("CreateMessage() - " + sqle.getMessage());
        }
    }
    
    // lecture d'un enregistrement
    public static MessageDor loadUnMsg(String id) throws Exception{
        if(CX == null)
            MessageDorDao.connexion();
        
        // préparation de la rqt
        String sql = "SELECT * FROM Message WHERE NumMsg=" + id;
        
        // ouverture de l'espace de rqt
        MessageDor msg = new MessageDor();
        ArrayList<MessageDor> liste = new ArrayList<>();
        try(PreparedStatement st = CX.prepareStatement(sql)){
            // exécution de la rqt
            ResultSet rs = st.executeQuery();
            
            // lecture le résultat
            while(rs.next()){
                liste.add(new MessageDor(rs.getInt(1), rs.getString("Pseudo"), rs.getString("Texte")));
            }
            
            msg = liste.get(0);
        }catch(SQLException sqle){
            throw new Exception("LoadMessage() - " + sqle.getMessage());
        }
        return msg;
    }

    // lecture des enregistrements
    public static ArrayList<MessageDor> loadMessages() throws Exception{
        if(CX == null)
            MessageDorDao.connexion();
        
        // préparation de la rqt
        String sql = "SELECT * FROM Message";
        
        // ouverture de l'espace de rqt
        ArrayList<MessageDor> liste = new ArrayList<>();
        try(PreparedStatement st = CX.prepareStatement(sql)){
            // exécution de la rqt
            ResultSet rs = st.executeQuery();
            
            // lecture le résultat
            while(rs.next()){
                liste.add(new MessageDor(rs.getInt(1), rs.getString("Pseudo"), rs.getString("Texte")));
            }
        }catch(SQLException sqle){
            throw new Exception("LoadMessage() - " + sqle.getMessage());
        }
        return liste;
    }
    
    public static void supprimer(String id)  throws Exception{
        if(CX == null)
            MessageDorDao.connexion();
        
         // préparation de la rqt
        String sql = "DELETE FROM Message WHERE NumMsg=" + id;
        
        // ouverture de l'espace de rqt
        try(PreparedStatement st = CX.prepareStatement(sql)){
            // execute la requete
            st.executeUpdate();
            System.out.println("===================supprimer====================");
        }catch(SQLException sqle){
            throw new Exception("LoadMessage() - " + sqle.getMessage());
        }
    }
    
        public static void modifier(int id, String p, String t)  throws Exception{
        if(CX == null)
            MessageDorDao.connexion();
        
         // préparation de la rqt
        String sql = "UPDATE Message SET Pseudo=?, Texte=? WHERE NumMsg=? ";
        
        // ouverture de l'espace de rqt
        try(PreparedStatement st = CX.prepareStatement(sql)){
           
            st.setString(1, p);
            st.setString(2, t);
            st.setInt(3, id);
            // execute la requete
            st.executeUpdate();
            System.out.println("===================modifier====================");
        }catch(SQLException sqle){
            throw new Exception("ModifierMessage() - " + sqle.getMessage());
        }
    }
    
    // programme de test
    public static void main(String[] args){
        try {
            MessageDorDao.connexion();
            System.out.println("=====================================");
            System.out.println("Cela marche! Connexion réussie");
            
//            MessageDor m = new MessageDor("RH", "CHIDEJIYOUWERIER");
//            MessageDorDao.creationMessage(m);
            
            MessageDorDao.modifier(140, "ddd", "ff");
            
            System.out.println("=====================================");
            for(MessageDor msg : MessageDorDao.loadMessages()){
                System.out.println(msg);
            }
            
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
