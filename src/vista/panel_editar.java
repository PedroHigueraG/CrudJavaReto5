package vista;

import controlador.controlador_inicial;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PedroH
 */
public class panel_editar extends JPanel {

    //Constructor
    public panel_editar() {
        initComponents();
    }

    //Elementos del panel
    private JLabel titulo;
    private JLabel inserteActual;
    private JLabel inserteNombre;
    private JLabel insertePrecio;
    private JTextField nombreActual;
    private JTextField nuevoNombre;
    private JTextField nuevoPrecio;
    private JButton editar;
    private JButton atras;
    private controlador_inicial controlador;

    //Metodo de iniciar
    void initComponents() {

        //Se establece propiedades del panel
        setSize(300, 420);
        setBackground(Color.WHITE);
        setLayout(null);

        //Se instancia el controlador
        controlador = new controlador_inicial();

        //Se ajustan los componentes
        titulo = new JLabel("--- Editar producto ---");
        titulo.setBounds(90, 30, 120, 30);

        inserteActual = new JLabel("Inserte el nombre actual del producto");
        inserteActual.setBounds(55, 70, 180, 30);

        nombreActual = new JTextField();
        nombreActual.setBounds(78, 110, 140, 30);

        inserteNombre = new JLabel("Inserte el nombre del producto");
        inserteNombre.setBounds(75, 150, 150, 30);

        nuevoNombre = new JTextField();
        nuevoNombre.setBounds(78, 190, 140, 30);

        insertePrecio = new JLabel("Inserte el precio del producto");
        insertePrecio.setBounds(78, 230, 150, 30);

        nuevoPrecio = new JTextField();
        nuevoPrecio.setBounds(78, 270, 140, 30);

        editar = new JButton("Editar");
        editar.setBounds(50, 320, 100, 30);

        atras = new JButton("Atras");
        atras.setBounds(150, 320, 100, 30);

        //Se agregan al panel
        add(titulo);
        add(inserteActual);
        add(nombreActual);
        add(inserteNombre);
        add(nuevoNombre);
        add(insertePrecio);
        add(nuevoPrecio);
        add(editar);
        add(atras);
    }

    //Se llama este metodo desde el click listener, muestra el respectivoo mensaje al editar un producto
    public void editar() {

        //Si alguno de los campos está vacio
        if (nombreActual.getText().length()==0 || nuevoNombre.getText().length() == 0 || nuevoPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se puede agregar ya que hay uno o más campos vacíos");
        } else {
            //Si existe el producto editelo
            if (controlador.existeProducto(nombreActual.getText())) {
                if(esNumerico(nuevoPrecio.getText())){
                    controlador.editarProducto(nombreActual.getText(), nuevoNombre.getText(), Float.parseFloat(nuevoPrecio.getText()));
                }else{
                    JOptionPane.showMessageDialog(null, "El campo de precio solo admite números");
                }                
            } else {
                JOptionPane.showMessageDialog(null, "No existe un producto con ese nombre");
            }
        }

    }
    
    //Para comprobar de que el campo de precio solo tiene numeros
    public static boolean esNumerico(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //Getters y setters
    public JTextField getNombreActual() {
        return nombreActual;
    }

    public JTextField getNuevoNombre() {
        return nuevoNombre;
    }

    public JTextField getNuevoPrecio() {
        return nuevoPrecio;
    }

    public JButton getEditar() {
        return editar;
    }

    public JButton getAtras() {
        return atras;
    }

}
