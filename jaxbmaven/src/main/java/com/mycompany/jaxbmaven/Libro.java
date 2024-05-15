/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jaxbmaven;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro {
   private String titulo;
   private int paginas;
   
   
    @XmlElement(name="titulo")
    public String getTitulo() {
        return titulo;
    } 
    public Libro(String titulo, int paginas) {
        super();
        this.titulo = titulo;
        this.paginas = paginas;
    }
    
    public Libro() {
        super();
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
   
    @XmlElement(name="numeroPaginas")
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    
}
/*
Hemos añadido dos anotaciones @XmlRootElement que especifica la clase raiz que vamos a convertir a XML . 
Por otro lado @XmlElement permite cambiar el nombre de los elementos cuando el fichero XML se construya.
Es momento de generar el fichero XML .










*/