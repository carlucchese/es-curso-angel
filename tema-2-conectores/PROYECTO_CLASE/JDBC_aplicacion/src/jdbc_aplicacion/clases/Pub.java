
package jdbc_aplicacion.clases;

import java.util.Date;


public class Pub {
    private String cod_pub;
    private String licencia_fiscal;
    private String domicilio;
    private Date  fapertura;
    private Localidad localidad;
    private String nombre;
    public static enum tipo_horario {MAÑANA,TARDE};
    private tipo_horario horario;
    public Pub() {}
    public Pub(String cod_pub, String licencia_fiscal, String domicilio, Date fapertura, Localidad loc, String nombre, tipo_horario horario) {
        this.cod_pub = cod_pub;
        this.licencia_fiscal = licencia_fiscal;
        this.domicilio = domicilio;
        this.fapertura = fapertura;
        this.localidad=loc;
        this.nombre = nombre;
        this.horario = horario;
    }
    

    public String getCod_pub() {
        return cod_pub;
    }

    public void setCod_pub(String cod_pub) {
        this.cod_pub = cod_pub;
    }

    public String getLicencia_fiscal() {
        return licencia_fiscal;
    }

    public void setLicencia_fiscal(String licencia_fiscal) {
        this.licencia_fiscal = licencia_fiscal;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFapertura() {
        return fapertura;
    }

    public void setFapertura(Date fapertura) {
        this.fapertura = fapertura;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String  getHorario() {
        return horario.name();

    }

    public void setHorario(tipo_horario horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString()
    {  
      String pub="Código " + this.cod_pub;
      pub+="\n Nombre " + this.nombre;
      pub += "\nLicencia: " + this.licencia_fiscal;
      pub += "\nFecha Apertura: " + this.fapertura;
      pub += "\nDomicilio "  + this.domicilio;
      pub+="\nLocalidad " +this.getLocalidad().getNombre();
      pub+= "\nHorario " + horario;
      return pub;
    
    }
    
            
    
}
