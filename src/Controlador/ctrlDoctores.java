
package Controlador;

import Modelo.Doctores;
import Vista.frmDoctores;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlDoctores  implements MouseListener{
    
    private Doctores modelo;
    private frmDoctores vista;
    
           //2- crear el constructor 
    public ctrlDoctores (Doctores modelo, frmDoctores vista){
        
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnAgregar.addMouseListener(this);
        modelo.Mostrar(vista.jtbDoctores);
        vista.btnActualizar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.jtbDoctores.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnAgregar){
            
            System.out.println("Hola mundo");
            
            modelo.setNombreDoctor(vista.txtNombre.getText());
            modelo.set(Integer.parseInt(vista.txtEdad.getText()));
            modelo.set((int) Double.parseDouble(vista.txtPeso.getText()));
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
            modelo.set(Integer.parseInt(vista.txtEdad.getText()));
            modelo.set((int) Double.parseDouble(vista.txtPeso.getText()));
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
