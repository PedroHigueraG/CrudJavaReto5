package vista;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author PedroH
 */
public class panel_inicial extends JPanel{
    
    //Atributos
    private JButton nuevoProducto;
    private JButton listaProducto;
    private JButton salir;
    
    //Constructor
    public panel_inicial(){
        initComponents();
    }
    
    //Metodo
    void initComponents(){
        
        //Se establecen propiedades
        setSize(300, 280);
        setBackground(Color.white);
        setLayout(null);
                
        //Se instancian
        nuevoProducto = new JButton("Nuevo producto");
        nuevoProducto.setBounds(40, 50, 200, 40);

        listaProducto = new JButton("Lista de productos");
        listaProducto.setBounds(40, 100, 200, 40);
        
        salir = new JButton("Salir");
        salir.setBounds(40, 150, 200, 40);
              
        //Se agregan al panel
        add(nuevoProducto);
        add(listaProducto);
        add(salir);
        
    }
    
    //Getters y setters
    public JButton getNuevoProducto() {
        return nuevoProducto;
    }

    public void setNuevoProducto(JButton nuevoProducto) {
        this.nuevoProducto = nuevoProducto;
    }

    public JButton getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(JButton listaProducto) {
        this.listaProducto = listaProducto;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }
    
}