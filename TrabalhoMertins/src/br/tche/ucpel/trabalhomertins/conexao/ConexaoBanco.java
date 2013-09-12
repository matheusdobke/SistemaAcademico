/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tche.ucpel.trabalhomertins.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natanael
 */
public class ConexaoBanco {
 private Connection conexao;

    public ConexaoBanco() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    public void conecta() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:postgresql://localhost/BaseUCPel", "aluno", "qpwo");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    public void close() {
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
