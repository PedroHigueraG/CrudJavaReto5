package modelo;

/**
 *
 * @author PedroH
 */
public class ModeloProducto {
    
    //Atributos
    private int id_producto;
    private String nombre;
    private float precio;


    //Constructores
    public ModeloProducto(int id_producto, String nombre, float precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
    }   
    
    //Este se usar para usar como parametro
    public ModeloProducto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }  
    
    //Getters y setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    //ToString
    @Override
    public String toString() {
        String temp="Id: "+id_producto+"\nNombre: "+nombre+"\nPrecio: "+precio;
        return temp;
    }
    
    //ToArray
    public Object[] toArray(){
        Object[] data = {id_producto,nombre,precio};
        return data;
    }
}
