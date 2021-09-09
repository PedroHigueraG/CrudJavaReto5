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
public class panel_nuevo extends JPanel {

    //Constructor
    public panel_nuevo() {
        initComponents();
    }

    //Atributos
    private JLabel titulo;
    private JLabel inserteNombre;
    private JLabel insertePrecio;
    private JTextField nuevoNombre;
    private JTextField nuevoPrecio;
    private JButton agregar;
    private JButton atras;
    private controlador_inicial controlador;

    //Iniciar componentes
    void initComponents() {

        //Se establecen propiedades
        setSize(300, 350);
        setBackground(Color.WHITE);
        setLayout(null);

        //Se instancia el controlador
        controlador = new controlador_inicial();

        //Se establecen componentes
        titulo = new JLabel("--- Nuevo producto ---");
        titulo.setBounds(90, 30, 120, 30);

        inserteNombre = new JLabel("Inserte el nombre del producto");
        inserteNombre.setBounds(75, 70, 150, 30);

        nuevoNombre = new JTextField();
        nuevoNombre.setBounds(78, 110, 140, 30);

        insertePrecio = new JLabel("Inserte el precio del producto");
        insertePrecio.setBounds(78, 150, 150, 30);

        nuevoPrecio = new JTextField();
        nuevoPrecio.setBounds(78, 190, 140, 30);

        agregar = new JButton("Agregar");
        agregar.setBounds(50, 250, 100, 30);

        atras = new JButton("Atras");
        atras.setBounds(150, 250, 100, 30);

        //Se agregan al panel
        add(titulo);
        add(inserteNombre);
        add(nuevoNombre);
        add(insertePrecio);
        add(nuevoPrecio);
        add(agregar);
        add(atras);
    }

    //Metodo agregar llamado desde el click listener
    public void agregar() {

        //Si alguno de los campos es vacio
        if (nuevoNombre.getText().length() == 0 || nuevoPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se puede agregar ya que hay uno o más campos vacíos");
        } else {
            //Si existe el producto no lo agregue, si no entonces agreguelo
            if (controlador.existeProducto(nuevoNombre.getText())) {
                JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
            } else {
                if(esNumerico(nuevoPrecio.getText())){
                    controlador.insertarProducto(nuevoNombre.getText(), Float.parseFloat(nuevoPrecio.getText()));
                }else{
                    JOptionPane.showMessageDialog(null, "El campo de precio solo admite números");
                }
                
            }
        }

    }

    //Comprobar que el campo solo contiene numeros
    public static boolean esNumerico(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public JTextField getNuevoNombre() {
        return nuevoNombre;
    }

    public JTextField getNuevoPrecio() {
        return nuevoPrecio;
    }

    public JButton getAgregar() {
        return agregar;
    }

    public JButton getAtras() {
        return atras;
    }

}
