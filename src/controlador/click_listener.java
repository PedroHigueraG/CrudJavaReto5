package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frame_inicial;

/**
 *
 * @author PedroH
 */
public class click_listener implements ActionListener{

    //Atributos
    private frame_inicial frame;
    
    //Constructor
    public click_listener(frame_inicial frame) {
        this.frame = frame;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.getPanelInicial().getSalir()){//Boton de salir
            frame.dispose();
        }else if(e.getSource()== frame.getPanelInicial().getListaProducto()){//Boton de listas de productos
            frame.getPanelInicial().setVisible(false);
            frame.setSize(500,500); 
            frame.setLocationRelativeTo(null);
            frame.getPanelProductos().setVisible(true);
        }else if(e.getSource()== frame.getPanelInicial().getNuevoProducto()){//Boton para agregar productos
            frame.getPanelInicial().setVisible(false);
            frame.setSize(300,350); 
            frame.setLocationRelativeTo(null);
            frame.getPanelNuevo().setVisible(true);
        }else if(e.getSource()== frame.getPanelProductos().getAtras()){//Boton atras de la lista de productos
            frame.getPanelProductos().setVisible(false);
            frame.setSize(300,280);
            frame.setLocationRelativeTo(null);
            frame.getPanelInicial().setVisible(true);
        }else if(e.getSource() == frame.getPanelProductos().getBuscar()){//Boton buscar de la lista de productos
            frame.getPanelProductos().buscarProducto();
        }else if(e.getSource() == frame.getPanelProductos().getEditar()){//Boton editar de la lista de productos
            frame.getPanelProductos().setVisible(false);
            frame.setSize(300,420); 
            frame.setLocationRelativeTo(null);
            frame.getPanelEditar().setVisible(true);
        }else if(e.getSource() == frame.getPanelProductos().getEliminar()){//Boton eliminar de la lista de productos
            frame.getPanelProductos().borrarProducto();
            frame.getPanelProductos().llenarTabla(frame.getPanelProductos().getControlador().getProductos());
        }else if(e.getSource() == frame.getPanelNuevo().getAtras()){//Boton atras del panel de nuevo producto
            frame.getPanelNuevo().setVisible(false);
            frame.setSize(300,280);
            frame.setLocationRelativeTo(null);
            frame.getPanelInicial().setVisible(true);
        }else if(e.getSource() == frame.getPanelNuevo().getAgregar()){//Boton agregar del panel de nuevo producto
            frame.getPanelNuevo().agregar();
            frame.getPanelProductos().llenarTabla(frame.getPanelProductos().getControlador().getProductos());
        }
        else if(e.getSource() == frame.getPanelEditar().getAtras()){//Boton atras del panel de editar
            frame.getPanelEditar().setVisible(false);
            frame.setSize(500,500);
            frame.setLocationRelativeTo(null);
            frame.getPanelProductos().setVisible(true);
        }
        else if(e.getSource() == frame.getPanelEditar().getEditar()){//Boton editar del panel de editar
            frame.getPanelEditar().editar();
            frame.getPanelProductos().llenarTabla(frame.getPanelProductos().getControlador().getProductos());
        }
    }
    
}
