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
public class CLSEstudiante {
    ConexionBd claseConectar = new ConexionBd();
        Connection conectar = claseConectar.retornarConexion();
    
    public  boolean LoguinEstudiante(String Usuario, String Pass){
    ArrayList<Estudiante> ListaUsuarioPass = new ArrayList<> ();
    
    try{
        CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINESTUDIANTE(?,?)");
        Statement.setString("pUsuario", Usuario);
        Statement.setString("pPass", Pass);
        ResultSet resultadoConsulta = Statement.executeQuery();
          
          while(resultadoConsulta.next()){
             Estudiante es = new Estudiante();
             
             es.setUsu(resultadoConsulta.getString("Usu"));
             es.setPass(resultadoConsulta.getString("Pass"));
             
             ListaUsuarioPass.add(es);
          }
          
          String usuarioBaseDatos = null;
          String passBaseDatos = null; 
          for(var iterador : ListaUsuarioPass){
              usuarioBaseDatos = iterador.getUsu();
              passBaseDatos = iterador.getPass();   
          }if(usuarioBaseDatos.equals(Usuario) && passBaseDatos.equals(Pass)){
              return true;
          }
          conectar.close();
         
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return false;
    }
    
    public ArrayList<Estudiante> MostrarEstudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_ESTUDIANTE");
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultadoConsulta.getInt("idEstudiante"));
                estudiante.setMatricula(resultadoConsulta.getInt("Matricula"));
                estudiante.setIdPersona(resultadoConsulta.getInt("idPersona"));
                estudiante.setNombre(resultadoConsulta.getString("Nombre"));
                estudiante.setUsu(resultadoConsulta.getString("Usu"));
                estudiante.setPass(resultadoConsulta.getString("Pass"));
                estudiante.setNIE(resultadoConsulta.getInt("NIE"));
                
                estudiantes.add(estudiante);
            }
             conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estudiantes;
    }
    public void AgregarEstudiante(Estudiante est){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_I_ESTUDIANTE(?,?,?,?,?)");
           Statement.setInt("pMatricula", est.getMatricula());
           Statement.setInt("pidPersona", est.getIdPersona());
           Statement.setString("pUsu", est.getUsu());
           Statement.setString("pPass", est.getPass());
           Statement.setInt("pNIE", est.getNIE());
           
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Estudiante guardado");
           
           conectar.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarEstudiante(Estudiante est){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_D_ESTUDIANTE(?)");
        
           Statement.setInt("pidEstudiante", est.getIdPersona());
           
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Estudianate eliminado");
           
           conectar.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarEstudiante(Estudiante est) {
         try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_ESTUDIANTE(?,?,?,?,?,?)");
            Statement.setInt("pidEstudiante", est.getId());
            Statement.setInt("pMatricula", est.getMatricula());
            Statement.setInt("pidPersona", est.getIdPersona());
            Statement.setString("pUsu", est.getUsu());
            Statement.setString("pPass", est.getPass());
            Statement.setInt("pNIE", est.getNIE());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Estudiante actualizado");

            conectar.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
