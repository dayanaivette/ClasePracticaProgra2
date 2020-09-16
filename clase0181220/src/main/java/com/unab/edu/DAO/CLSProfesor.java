/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Profesor;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dayan
 */
public class CLSProfesor {
    ConexionBd claseConectar = new ConexionBd();
        Connection conectar = claseConectar.retornarConexion();
        
    public boolean LoguinProfesor(String Usuario, String Pass) {
        ArrayList<Profesor> ListaUsuarios = new ArrayList<>();
        ArrayList<Profesor> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call SP_S_LOGUINPROFESOR(?,?)");

            st.setString("pusuario", Usuario);
            st.setString("ppass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Profesor prof = new Profesor();
                prof.setUsuario(rs.getNString("Usuario"));
                prof.setPass(rs.getNString("Pass"));
                ListaUsuarios.add(prof);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsuario();
                passdebasededatos = iterador.getPass();

            }
            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIPPROFESOR(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Profesor escrip = new Profesor();

                escrip.setPass(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }
            String passcrip = null;
            for (var iterador : ListarContra) {
                passcrip = iterador.getPass();
                Pass = passcrip;
            }
            if(usuariodebasedatos!=null &&passdebasededatos!=null ){
            if (usuariodebasedatos.equals(Usuario) && passdebasededatos.equals(Pass)) {
                return true;
            }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
    
    public ArrayList<Profesor> MostrarProfesor() {
        ArrayList<Profesor> prof = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_PROFESOR");
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {
                Profesor profe = new Profesor();
                profe.setIdProfesor(resultadoConsulta.getInt("idProfesor"));
                profe.setIdPersonaProfesor(resultadoConsulta.getInt("idPersona"));
                profe.setNombre(resultadoConsulta.getString("Nombre"));
                profe.setUsuario(resultadoConsulta.getString("Usuario"));
                profe.setPass(resultadoConsulta.getString("Pass"));
                profe.setDUI(resultadoConsulta.getString("DUI"));
                
              
                prof.add(profe);
            }
             conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return prof;
    }
    public void AgregarProfesor(Profesor prof){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_I_PROFESOR(?,?,?,?)");
           Statement.setInt("PidPersonaProfesor", prof.getIdPersonaProfesor());
           Statement.setString("PUsuario", prof.getUsuario());
           Statement.setString("PPass", prof.getPass());
           Statement.setString("PDUI", prof.getDUI());
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Profesor guardado");
           
           conectar.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarProfesor(Profesor prof){
        try {
           CallableStatement Statement = conectar.prepareCall("call SP_D_PROFESOR(?)");
        
           Statement.setInt("pidProfesor", prof.getIdProfesor());
           
           
           Statement.execute();
           JOptionPane.showMessageDialog(null, "Profesor eliminado");
           
           conectar.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarProfesor(Profesor prof) {
         try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_PROFESOR(?,?,?,?,?)");
            Statement.setInt("pidProfesor", prof.getIdProfesor());
            Statement.setInt("pidPersonaProfesor", prof.getIdPersonaProfesor());
            Statement.setString("pUsuario", prof.getUsuario());
            Statement.setString("pPass", prof.getPass());
            Statement.setString("pDUI", prof.getDUI());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Profesor actualizado");

            conectar.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
