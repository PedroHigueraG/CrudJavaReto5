package controlador;

import datos.ProductoDAO;
import java.util.ArrayList;
import modelo.ModeloProducto;

/**
 *
 * @author PedroH
 */
public class controlador_inicial {
    
    //Atributos
    private ArrayList<ModeloProducto> productos = null;
    private ProductoDAO productoDAO = new ProductoDAO();

    //Constructor
    public controlador_inicial() {
        
        productos = productoDAO.getProductos();
        
    }
    
    
    //Getters y setters
    public ArrayList<ModeloProducto> getProductos() {
        productos = productoDAO.getProductos();
        return productos;
    }
    
    public boolean existeProducto(String nombre){
        return productoDAO.existeProducto(nombre);
    }
    
    public String buscarProducto(String nombre){
        return productoDAO.buscarProducto(nombre);
    }
    
    public void insertarProducto(String nombre, float precio){
        productoDAO.insertarProducto(new ModeloProducto(nombre,precio));
    }
    
    public void editarProducto(String nombreActual,String nombre, float precio){
        productoDAO.actualizarProducto(nombreActual, nombre, precio);
    }
    
    public void eliminarProducto(String nombre){
        productoDAO.borrarProducto(nombre);
    }
}
