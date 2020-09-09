/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.OperacionesBD;

import com.unab.edu.DAO.CLSEstudiante;
import com.unab.edu.DAO.CLSPersona;
import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.Entidades.Persona;
import com.unab.edu.conexionmysql.ConexionBd;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dayan
 */
public class FrmCrudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form FrmCrudEstudiante
     */
    public FrmCrudEstudiante() {
        initComponents();
        
        MostrarTablaEstudiante();
        MostrarPersonaSeleccionada();
        limpiardatos();
    }
        
    void MostrarTablaEstudiante() {

        String TITULOS[] = {"ID ESTUDIANTE", "MATRICULA", "ID PERSONA","NOMBRE", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        CLSEstudiante claseEstudiante = new CLSEstudiante();
        var MostrarTablaEstudiante = claseEstudiante.MostrarEstudiante();
        String filas[] = new String[8];

        for (var iterarDatosEstudiante : MostrarTablaEstudiante) {
            filas[0] = String.valueOf(iterarDatosEstudiante.getId());
            filas[1] = String.valueOf(iterarDatosEstudiante.getMatricula());
            filas[2] = String.valueOf(iterarDatosEstudiante.getIdPersona());
            filas[3] = iterarDatosEstudiante.getNombre();
            filas[4] = iterarDatosEstudiante.getUsu();
            filas[5] = iterarDatosEstudiante.getPass();
            filas[6] = String.valueOf(iterarDatosEstudiante.getNIE());
            
            ModeloTabla.addRow(filas);
        }

        tb_Estudiante.setModel(ModeloTabla);
    }
    
    void MostrarPersonaSeleccionada(){
    String TITULOS[] = {"ID", "NOMBRE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        CLSPersona clasePersona = new CLSPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        String filas[] = new String[3];
        for (var IterarDatosPersona : Personas) {
            filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
            filas[1] = IterarDatosPersona.getNombre();
            ModeloTabla.addRow(filas);
        }
        tb_SeleccionarPersona.setModel(ModeloTabla);  
    } 
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMostrar = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Estudiante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtIdPersona = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtIdEstudiante = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        PASS = new javax.swing.JLabel();
        btnConector = new javax.swing.JButton();
        lblSexo2 = new javax.swing.JLabel();
        txtNIE = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_SeleccionarPersona = new javax.swing.JTable();
        lblID1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpMostrar.setBackground(new java.awt.Color(204, 204, 255));
        tpMostrar.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        tb_Estudiante.setBackground(new java.awt.Color(204, 204, 255));
        tb_Estudiante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tb_Estudiante.setForeground(new java.awt.Color(255, 255, 255));
        tb_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE PERSONA", "USUARIO", "PASSWORD", "NIE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Estudiante.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tb_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Estudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpMostrar.addTab("Mostrar Datos", jPanel2);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtMatricula.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtIdPersona.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtPass.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtIdEstudiante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID ESTUDIANTE");

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("MATRICULA");

        lblApellidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidos.setText("ID PERSONA");

        lblEdad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("USUARIO");

        PASS.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PASS.setForeground(new java.awt.Color(255, 255, 255));
        PASS.setText("PASSWORD");

        btnConector.setBackground(new java.awt.Color(255, 255, 255));
        btnConector.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnConector.setText("Conectar");
        btnConector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectorActionPerformed(evt);
            }
        });

        lblSexo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSexo2.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo2.setText("NIE");

        txtNIE.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        tb_SeleccionarPersona.setAutoCreateRowSorter(true);
        tb_SeleccionarPersona.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        tb_SeleccionarPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdPersona", "Nombre Persona"
            }
        ));
        tb_SeleccionarPersona.setGridColor(new java.awt.Color(0, 0, 0));
        tb_SeleccionarPersona.setSelectionBackground(new java.awt.Color(255, 0, 255));
        tb_SeleccionarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SeleccionarPersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_SeleccionarPersona);

        lblID1.setBackground(new java.awt.Color(153, 153, 255));
        lblID1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblID1.setForeground(new java.awt.Color(255, 255, 255));
        lblID1.setText("SELECCIONA LA PERSONA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnGuardar)
                .addGap(40, 40, 40)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnConector)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblID)
                    .addComponent(lblNombre)
                    .addComponent(lblApellidos)
                    .addComponent(lblEdad)
                    .addComponent(PASS)
                    .addComponent(lblSexo2)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(txtUsuario)
                    .addComponent(txtIdPersona)
                    .addComponent(txtMatricula)
                    .addComponent(txtIdEstudiante)
                    .addComponent(txtNIE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblID1)
                .addGap(265, 265, 265))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEdad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(PASS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSexo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnConector))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tpMostrar.addTab("Operación de CRUD", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_EstudianteMouseClicked
        //Modificacion de TabPena.
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jPanel1));
        //Obtener la fila actual que el usuario selecionó
        int filas = tb_Estudiante.getSelectedRow();

        //Sirve para capturar datos de las tablas, pasandole filas y columnas.
        String IdEstudiante = String.valueOf(tb_Estudiante.getValueAt(filas, 0));
        String Matricula = String.valueOf(tb_Estudiante.getValueAt(filas, 1));
        String IdPersona = String.valueOf(tb_Estudiante.getValueAt(filas, 2));
        String Usuario = String.valueOf(tb_Estudiante.getValueAt(filas,4));
        String Pass = String.valueOf(tb_Estudiante.getValueAt(filas, 5));
        String Nie = String.valueOf(tb_Estudiante.getValueAt(filas, 6));

        txtIdEstudiante.setText(IdEstudiante);
        txtMatricula.setText(Matricula);
        txtIdPersona.setText(IdPersona);
        txtUsuario.setText(Usuario);
        txtPass.setText(Pass);
        txtNIE.setText(Nie);
    }//GEN-LAST:event_tb_EstudianteMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        CLSEstudiante estudiante = new CLSEstudiante();
        Estudiante est = new Estudiante();

        est.setMatricula(Integer.parseInt(txtMatricula.getText()));
        est.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        est.setUsu(txtUsuario.getText());
        est.setPass(txtPass.getText());
        est.setNIE(Integer.parseInt(txtNIE.getText()));

        estudiante.AgregarEstudiante(est);
        MostrarTablaEstudiante();
        limpiardatos();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CLSEstudiante estudiante = new CLSEstudiante();
        Estudiante est = new Estudiante();

        est.setId(Integer.parseInt(txtIdEstudiante.getText()));
        est.setMatricula(Integer.parseInt(txtMatricula.getText()));
        est.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        est.setUsu(txtUsuario.getText());
        est.setPass(txtPass.getText());
        est.setNIE(Integer.parseInt(txtNIE.getText()));

        estudiante.ActualizarEstudiante(est);
        MostrarTablaEstudiante();
        limpiardatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        CLSEstudiante estudiante = new CLSEstudiante();
        Estudiante est = new Estudiante();

        est.setId(Integer.parseInt(txtIdEstudiante.getText()));

        estudiante.BorrarEstudiante(est);
        MostrarTablaEstudiante();
        limpiardatos();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectorActionPerformed
        ConexionBd classConectar = new ConexionBd();
        Connection conectar = classConectar.retornarConexion();

    }//GEN-LAST:event_btnConectorActionPerformed

    private void tb_SeleccionarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SeleccionarPersonaMouseClicked
        //MOVILIZACION DE TBPANE
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jPanel1));
        //OBTENER LA FILA ACTUAL QUE EL USUARIO SELECCIONO
        int fila = tb_SeleccionarPersona.getSelectedRow();

        //GEVALUEAT SIRVE PARA CAPTURAR DATOS DE LAS TABLAS
        String ID = String.valueOf(tb_SeleccionarPersona.getValueAt(fila, 0));

        txtIdPersona.setText(ID);

    }//GEN-LAST:event_tb_SeleccionarPersonaMouseClicked

     void limpiardatos()
        {
            txtIdEstudiante.setText("");
            txtMatricula.setText("");
            txtIdPersona.setText("");
            txtUsuario.setText("");
            txtPass.setText("");
            txtNIE.setText("");
            
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCrudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PASS;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConector;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo2;
    private javax.swing.JTable tb_Estudiante;
    private javax.swing.JTable tb_SeleccionarPersona;
    private javax.swing.JTabbedPane tpMostrar;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtIdPersona;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNIE;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
