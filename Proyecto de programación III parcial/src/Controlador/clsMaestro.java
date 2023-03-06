/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.List;
import Modelo.daoMaestro;
/**
 *
 * @author visitante
 */
//clsMaestros, Hecho por Nelson Josué Pineda Culajay, 9959-21-10015
public class clsMaestro {
    private String CodMaestro;
    private String NombreMaestro;
    private String DireccionMaestro;
    private String TelMaestro;
    private String EmailMaestro;
    private String EstatusMaestro;

    public clsMaestro() {
    }


    public clsMaestro(String NombreMaestro, String DireccionMaestro, String TelMaestro, String EmailMaestro, String EstatusMaestro) {
        this.NombreMaestro = NombreMaestro;
        this.DireccionMaestro = DireccionMaestro;
        this.TelMaestro = TelMaestro;
        this.EmailMaestro = EmailMaestro;
        this.EstatusMaestro = EstatusMaestro;
    }

  

    public String getCodMaestro() {
        return CodMaestro;
    }

    public void setCodMaestro(String CodMaestro) {
        this.CodMaestro = CodMaestro;
    }

    public String getNombreMaestro() {
        return NombreMaestro;
    }

    public void setNombreMaestro(String NombreMaestro) {
        this.NombreMaestro = NombreMaestro;
    }

    public String getDireccionMaestro() {
        return DireccionMaestro;
    }

    public void setDireccionMaestro(String DireccionMaestro) {
        this.DireccionMaestro = DireccionMaestro;
    }

    public String getTelMaestro() {
        return TelMaestro;
    }

    public void setTelMaestro(String TelMaestro) {
        this.TelMaestro = TelMaestro;
    }

    public String getEmailMaestro() {
        return EmailMaestro;
    }

    public void setEmailMaestro(String EmailMaestro) {
        this.EmailMaestro = EmailMaestro;
    }

    public String getEstatusMaestro() {
        return EstatusMaestro;
    }

    public void setEstatusMaestro(String EstatusMaestro) {
        this.EstatusMaestro = EstatusMaestro;
    }

   

    @Override
    public String toString() {
        return "clsMaestros{" + "CodMaestro=" + CodMaestro + ", NombreMaestro=" + NombreMaestro + ", DireccionMaestro=" + DireccionMaestro + ", TelMaestro=" + 
                TelMaestro + ", EmailMaestro=" + EmailMaestro + ", EstatusMaestro=" + EstatusMaestro + '}';
    }
    //Metodos de acceso a la capa controlador
   public clsMaestro getBuscarInformacionMaestroPorNombre(clsMaestro maestro)
    {
        daoMaestro daomaestro  = new daoMaestro();
        return daomaestro.consultaMaestrosPorNombre(maestro);
    }
    public clsMaestro getBuscarInformacionMaestroPorId(clsMaestro maestro)
    {
        daoMaestro  daomaestro  = new daoMaestro ();
        return daomaestro.consultaMaestrosPorId(maestro);
    }    
    public List<clsMaestro> getListadoMaestros()
    {
        daoMaestro  daomaestros  = new daoMaestro();
        List<clsMaestro> listadoMaestros = daomaestros.consultaMaestros();
        return listadoMaestros;
    }
    public int setBorrarMaestro(clsMaestro maestro)
    {
        daoMaestro  daomaestros  = new daoMaestro ();
        return daomaestros.borrarMaestros(maestro);
    }          
    public int setIngresarMaestro(clsMaestro maestro)
    {
        daoMaestro daomaestro = new daoMaestro ();
        return  daomaestro.ingresaMaestros(maestro);
    }              
    public int setModificarMaestro(clsMaestro maestro)
    {
        daoMaestro   daomaestro  = new daoMaestro ();
        return  daomaestro.actualizaMaestros(maestro);
    }               
}
