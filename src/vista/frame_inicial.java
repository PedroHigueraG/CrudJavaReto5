package vista;

import controlador.click_listener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author PedroH
 */
public class frame_inicial extends JFrame{
    
    //Atributos
    private panel_inicial panelInicial;
    private panel_productos panelProductos;
    private panel_nuevo panelNuevo;
    private panel_editar panelEditar;
    private click_listener listener;

    //Constructor
    public frame_inicial() {
        initComponents();
    }    
    
    //Componente
    void initComponents(){
        
        //Look and Feel de Windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Propiedades
        setSize(300, 280);
        setTitle("Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        //Instancia del listener
        listener = new click_listener(this);
        
        //Paneles
        panelInicial = new panel_inicial();
        panelInicial.setVisible(true);
        getContentPane().add(panelInicial);
        
        panelProductos = new panel_productos();
        panelProductos.setVisible(false);
        getContentPane().add(panelProductos);

        panelNuevo = new panel_nuevo();
        panelNuevo.setVisible(false);
        getContentPane().add(panelNuevo);
        
        panelEditar = new panel_editar();
        panelEditar.setVisible(false);
        getContentPane().add(panelEditar);
            
        //Listeners
        panelInicial.getSalir().addActionListener(listener);
        panelInicial.getListaProducto().addActionListener(listener);
        panelInicial.getNuevoProducto().addActionListener(listener);
        
        panelProductos.getAtras().addActionListener(listener);
        panelProductos.getBuscar().addActionListener(listener);
        panelProductos.getEditar().addActionListener(listener);
        panelProductos.getEliminar().addActionListener(listener);
        
        panelNuevo.getAtras().addActionListener(listener);
        panelNuevo.getAgregar().addActionListener(listener);
        
        panelEditar.getAtras().addActionListener(listener);
        panelEditar.getEditar().addActionListener(listener);
        
    }

    //Getters
    public panel_inicial getPanelInicial() {
        return panelInicial;
    }

    public panel_productos getPanelProductos() {
        return panelProductos;
    }

    public panel_nuevo getPanelNuevo() {
        return panelNuevo;
    }

    public panel_editar getPanelEditar() {
        return panelEditar;
    }
               
}