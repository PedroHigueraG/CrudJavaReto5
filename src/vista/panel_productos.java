package vista;

import controlador.controlador_inicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.ModeloProducto;

/**
 *
 * @author PedroH
 */
public class panel_productos extends JPanel {

    //Atributos
    private JTable tabla;
    private JScrollPane scroll;
    private JButton buscar;
    private JButton atras;
    private JButton editar;
    private JButton eliminar;
    private controlador_inicial controlador;
    
    //Constructor
    public panel_productos() {
        initComponents();
    }

    //Metodo
    void initComponents() {

        //Se establecen propiedades
        setSize(500, 500);
        setBackground(Color.WHITE);
        
        //Se instancia el controlador
        controlador = new controlador_inicial();
        
        //Se establecen los componentes
        tabla = new JTable();
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setEnabled(false);
        tabla.setSize(500, 500);
       
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(450,400));
        
        //Se llena la tabla con los datos del controlador
        llenarTabla(controlador.getProductos());
        
        buscar = new JButton("Buscar");
        editar = new JButton("Editar");
        eliminar = new JButton("Eliminar");
        atras = new JButton("Atrás");

        //Se agrega al panel
        add(scroll);
        add(buscar);
        add(editar);
        add(eliminar);
        add(atras);
        
    }

    //Llenar tabla
    public void llenarTabla(ArrayList<ModeloProducto> productos){
        String[] cabecera = {"Id","Nombre","Precio"};
        tabla.removeAll();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cabecera);
        tableModel.fireTableDataChanged();
        
        tabla.setModel(tableModel);
        
        for(int i=0; i<productos.size();i++){
            tableModel.addRow(productos.get(i).toArray());
        }

        
    }
    
    //Metodo llamado desde el click listener
    public void buscarProducto(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        if(controlador.existeProducto(nombre)){//Si existe muestre los dato
            JOptionPane.showMessageDialog(null, "El producto se encuentra en la lista.\n"+controlador.buscarProducto(nombre));
        }else{
            JOptionPane.showMessageDialog(null, "El producto no se encuentra en la lista");
        }
    }
    
    //Borrar llamado desde el click listener
    public void borrarProducto(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        if(controlador.existeProducto(nombre)){
            //Si existe entonces borrarlo
            if(JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el producto?")== JOptionPane.YES_OPTION){
                controlador.eliminarProducto(nombre);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El producto no se encuentra en la lista");
        }
    }
    
    //Getters
    public JTable getTabla() {
        return tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getAtras() {
        return atras;
    }

    public controlador_inicial getControlador() {
        return controlador;
    }

    public JButton getEditar() {
        return editar;
    }

    public JButton getEliminar() {
        return eliminar;
    }
    
}
