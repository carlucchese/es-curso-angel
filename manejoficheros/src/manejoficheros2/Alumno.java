/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoficheros2;

import java.io.Serializable;

public class Alumno implements Serializable{
    public String nombre;
    public String apellido;
    public int edad;
    public String toString() {
    return "Nombre: " + this.nombre + " Apellidos:" + this.apellido + " Edad:" + this.edad;
  }
    
}

