/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriaut8_2.modelo;

/**
 *
 * @author Dell
 */
public class Cliente {

    /**
     * ***********ATRIBUTOS**********
     */
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNac;

    /**
     * ***********CONSTRUCTOR**********
     */
    
    public Cliente() {}

    public Cliente(int id, String nombre, String direccion, 
            String telefono, String fechaNac) 
    {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }

    /**
     * ***********GETTERS & SETTERS**********
     */
    public int getId() {
        return id;
    }

    public int setId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion.toString();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaNac=" + fechaNac + '}';
    }

    
}

