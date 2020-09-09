/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dayan
 */
public class CLSJoinnPersonaEstudiante {
    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();
    
    public ArrayList<Estudiante> MostrarJoinEstudiantePersona(){
        ArrayList<Estudiante> lista = new ArrayList<>();
        
        try {
            CallableStatement st = con.prepareCall("call SP_S_JOINPERSONAESTUDIANTE()");
           
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Estudiante es = new Estudiante();
                
                es.setNombre(rs.getString("Nombre"));
                es.setApellido(rs.getString("Apellido"));
                es.setMatricula(rs.getInt("Matricula"));
            
                
                lista.add(es);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return lista;
    }
}
