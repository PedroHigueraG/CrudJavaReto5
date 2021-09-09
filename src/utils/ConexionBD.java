package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author PedroH
 */
public class ConexionBD {
    
    //Metodo para obtener conexion
    public static Connection getConnection(){
        
        //Atributos necesarios para hacer la conexion
        JSONParser parser = new JSONParser();
        Connection con = null;
        
        //Conexion
        try{
            //Guarda la direccion completa de las credenciales y la convierte la direccion en objeto json
            String credenciales = System.getProperty("user.dir")+"/src/utils/credenciales.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credenciales));
            
            //Guarda cada dato del json
            String host = (String)jsonObject.get("db_ip");
            String port = (String)jsonObject.get("db_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String dbUrl = "jdbc:mysql://"+host+":"+port+"/tablas";
            
            //Se realiza la conexion con la base de datos
            con = DriverManager.getConnection(dbUrl,username,password);
            
        }
        catch(SQLException | FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException | ParseException ex){
            ex.printStackTrace();
        }
        
        return con;
        
    }

}
