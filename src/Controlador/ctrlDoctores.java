
package Controlador;

import Modelo.mdlDoctores;
import Vista.frmDoctores;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlDoctores implements MouseListener{
    
    private mdlDoctores modelo;
    private frmDoctores vista;
    
           //2- crear el constructor 
    public ctrlDoctores (mdlDoctores modelo, frmDoctores vista){
        
        this.modelo = modelo;
        this.vista = vista;
        
        
        modelo.Mostrar(vista.jtbDoctores);
        vista.btnAgregar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.jtbDoctores.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnAgregar){
            
            
            modelo.setNombreDoctor(vista.txtNombre.getText());
            modelo.setEdadDoctor(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setPesoDoctor(Double.valueOf(vista.txtPeso.getText()));
            modelo.setCorreoDoctor(vista.txtCorreo.getText());

            
            modelo.Guardar();   
            modelo.Mostrar(vista.jtbDoctores);
        }
        
        if(e.getSource() == vista.btnEliminar){
            modelo.Eliminar(vista.jtbDoctores);
            modelo.Mostrar(vista.jtbDoctores);
        }        

        if(e.getSource() == vista.jtbDoctores){
            modelo.cargarDatosTabla(vista);
        }
        
        if(e.getSource() == vista.btnActualizar){
            
            modelo.setNombreDoctor(vista.txtNombre.getText());
            modelo.setEdadDoctor(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setPesoDoctor(Double.valueOf(vista.txtPeso.getText()));
            modelo.setCorreoDoctor(vista.txtCorreo.getText());
            
            modelo.Actualizar(vista.jtbDoctores);
            modelo.Mostrar(vista.jtbDoctores);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }    
}
