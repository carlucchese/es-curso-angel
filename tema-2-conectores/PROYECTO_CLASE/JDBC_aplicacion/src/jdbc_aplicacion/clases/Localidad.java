
package jdbc_aplicacion.clases;

public class Localidad {
    private int cod_localidad;
    private String nombre;
    
    public Localidad(){
    }

    public Localidad(int cod,String nombre)
    {
      this.cod_localidad=cod;
      this.nombre=nombre;
    
    }
    public int getCod_localidad() {
        return cod_localidad;
    }

    public void setCod_localidad(int cod_localidad) {
        this.cod_localidad = cod_localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    { String info= "Código: " + this.cod_localidad;
     info+="\n Localidad: " + this.nombre;
     return info;    
    }
    
    
}
