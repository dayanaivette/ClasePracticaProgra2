/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.*;

/**
 *
 * @author dayan
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Profesor extends Persona{
    private int idProfesor;
    private int idPersonaProfesor;
    private String DUI;
    private String Usuario;
    private String Pass;
}
