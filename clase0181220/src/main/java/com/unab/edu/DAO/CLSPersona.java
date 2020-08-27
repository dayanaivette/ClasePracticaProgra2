/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Persona;
import java.util.*;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dayan
 */
public class CLSPersona {
    
    ConexionBd claseConectar = new ConexionBd();
        Connection conectar = claseConectar.retornarConexion();
    
    public  ArrayList<Persona> MostrarPersona(){
    ArrayList<Persona> Personas = new ArrayList<> ();
    
    try{
        CallableStatement Statement = conectar.prepareCall("call SP_S_Persona()");
          ResultSet resultadoConsulta = Statement.executeQuery();
          
          while(resultadoConsulta.next()){
              Persona persona = new Persona();
              persona.setIdPersona(resultadoConsulta.getInt("idPersona"));
              persona.setNombre(resultadoConsulta.getString("Nombre"));
              persona.setApellido(resultadoConsulta.getString("Apellido"));
              persona.setEdad(resultadoConsulta.getInt("Edad"));
              persona.setSexo(resultadoConsulta.getString("Sexo"));
              
              Personas.add(persona);
          }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return Personas;
    }
    
    public void AgregarPersona(Persona per){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_I_Persona(?,?,?,?)");
           Statement.setString("PNombre", per.getNombre());
           Statement.setString("PApellido", per.getApellido());
           Statement.setInt("PEdad", per.getEdad());
           Statement.setString("Psexo", per.getSexo());
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Persona guardada");
           
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarPersona(Persona per){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_D_Persona(?)");
        
           Statement.setInt("PIdPersona", per.getIdPersona());
           
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Persona eliminada");
           
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarPersona(Persona per) {
         try {
           CallableStatement Statement = conectar.prepareCall("call SP_U_Persona(?,?,?,?,?)");
           Statement.setInt("PIdPersona", per.getIdPersona());
           Statement.setString("PNombre", per.getNombre());
           Statement.setString("PApellido", per.getApellido());
           Statement.setInt("PEdad", per.getEdad());
           Statement.setString("Psexo", per.getSexo());
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Persona actualizada");
           
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
        
    }
