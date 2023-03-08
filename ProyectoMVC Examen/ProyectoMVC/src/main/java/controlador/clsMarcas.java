/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoMarcas;
/**
 *
 * @author visitante
 */
public class clsMarcas {
    private String CodMarca;
    private String NombreMarca;
    private String EstatusMarca;

    public clsMarcas() {
    }

    public clsMarcas(String CodMarca, String NombreMarca, String EstatusMarca) {
        this.CodMarca = CodMarca;
        this.NombreMarca = NombreMarca;
        this.EstatusMarca = EstatusMarca;
    }

    public String getCodMarca() {
        return CodMarca;
    }

    public void setCodMarca(String CodMarca) {
        this.CodMarca = CodMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }

    public String getEstatusMarca() {
        return EstatusMarca;
    }

    public void setEstatusMarca(String EstatusMarca) {
        this.EstatusMarca = EstatusMarca;
    }

   

  
    
    
    @Override
    public String toString() {
        return "clsMarcas{" + "CodMarca=" + CodMarca + ", NombreMarca=" + NombreMarca + ", EstatusMarca=" + EstatusMarca + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMarcas getBuscarInformacionMarcaPorNombre(clsMarcas marca)
    {
        daoMarcas daomarca = new daoMarcas();
        return daomarca.consultaMarcasPorNombre(marca);
    }
    public clsMarcas getBuscarInformacionMarcaPorId(clsMarcas marca)
    {
        daoMarcas daomarca = new daoMarcas();
        return daomarca.consultaMarcasPorId(marca);
    }    
    public List<clsMarcas> getListadoMarcas()
    {
        daoMarcas daomarca = new daoMarcas();
        List<clsMarcas> listadoMarcas = daomarca.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarca(clsMarcas marca)
    {
        daoMarcas daomarca = new daoMarcas();
        return daomarca.borrarMarcas(marca);
    }          
    public int setIngresarMarca(clsMarcas marca)
    {
        daoMarcas daomarca= new daoMarcas();
        return daomarca.ingresaMarcas(marca);
    }              
    public int setModificarMarca(clsMarcas marca)
    {
        daoMarcas daomarca = new daoMarcas();
        return daomarca.actualizaMarcas(marca);
    }              
}
