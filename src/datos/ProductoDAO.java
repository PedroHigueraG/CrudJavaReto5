package datos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModeloProducto;
import utils.ConexionBD;

/**
 *
 * @author PedroH
 */
public class ProductoDAO {
    
    //Atributos
    private Connection con = null;
    
    //Metodos para el CRUD de Productos
    //CREATE
    public void insertarProducto(ModeloProducto producto){
        
        try {
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Inserta
            String insert = "INSERT INTO producto (nombre,precio) VALUES (?,?);";
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, producto.getNombre());
            statement.setFloat(2, producto.getPrecio());
            
            //Comprueba la insercion
            if(statement.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            }
            
            //Cierra la conexion
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }
    }
    
    //READ
    public ArrayList<ModeloProducto> getProductos(){
        
        //Array donde guardará los productos
        ArrayList<ModeloProducto> productos = new ArrayList();
        
        //Se realiza la consulta
        try {
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Consulta
            String query = "select idproducto,nombre,precio from producto order by nombre;";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            //Ejecutar mientras halla siguiente
            while (result.next()) {
                //Se crea el objeto producto
                ModeloProducto producto = new ModeloProducto(result.getInt(1),result.getString(2),result.getFloat(3));
                
                //Lo agrega a la lista}
                productos.add(producto);
            }
            
            //Cierra la conexion
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }
        
        return productos;
    }
    
    //UPDATE
    public void actualizarProducto(String nombreActual,String nombre, float precio){
        
        try{
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Actualizacion
            String sql = "update producto set nombre=?,precio=? where nombre=?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setFloat(2, precio);
            statement.setString(3, nombreActual);
            
            if(statement.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            }
            
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }
        
    }
    
    //DELETE
    public void borrarProducto(String nombre){
        
        try{
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Actualizacion
            String sql = "delete from producto where nombre=?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nombre);
            
            if(statement.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            }
            
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }
    }
    //Buscar por nombre si el producto existe
    public boolean existeProducto(String nombre){
        
        boolean existe = false;
        
        try {
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Consulta
            String query = "select count(nombre) from producto where nombre =\""+nombre+"\";";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            
            if(result.getInt(1)>0){
                existe=true;
            }
            
            //Cierra la conexion
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }
        
        return existe;
    }
    
    //Buscar
    public String buscarProducto(String nombre){
        
        boolean existe = false;
        ModeloProducto producto = null;
        
        try {
            
            //Si no se ha conectado lo hace
            if(con == null || con.isClosed()){
                con = ConexionBD.getConnection();
            }
            
            //Consulta
            String query = "select idproducto,nombre,precio from producto where nombre =\""+nombre+"\";";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            producto = new ModeloProducto(result.getInt(1),result.getString(2),result.getFloat(3));
            
            //Cierra la conexion
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()+"\nError :" + e.getMessage());
        }

        
        return producto.toString();
    }
    
}
