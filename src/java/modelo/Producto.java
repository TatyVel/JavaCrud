
package modelo;
import java.sql.Date;

/**
 *
 * @author tatiana
 */
public class Producto {
    //Mapeo de tabla
    
    private int Id;
    private String nombre_prod;
    private int codigo_prod;
    private Date caducidad;
    private String proveedor;


    public Producto(int Id) {
        this.Id = Id;
 
        long hr = System.currentTimeMillis();
        this.caducidad = new Date(hr); 
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public int getCodigo_prod() {
        return codigo_prod;
    }

    public void setCodigo_prod(int codigo_prod) {
        this.codigo_prod = codigo_prod;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    
}
