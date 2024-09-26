
package Modelo;

import Vista.frmDoctores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Doctores {
    
    private String NombreDoctor;
    private int EdadDoctor;
    private Double PesoDoctor;
    private String CorreoDoctor; 
    
    public String getNombreDoctor() {
        return NombreDoctor;
    }

    public void setNombreDoctor(String NombreDoctor) {
        this.NombreDoctor = NombreDoctor;
    }

    public int getEdadDoctor() {
        return EdadDoctor;
    }

    public void setEdadDoctor(int EdadDoctor) {
        this.EdadDoctor = EdadDoctor;
    }

    public Double getPesoDoctor() {
        return PesoDoctor;
    }

    public void setPesoDoctor(Double PesoDoctor) {
        this.PesoDoctor = PesoDoctor;
    }

    public String getCorreoDoctor() {
        return CorreoDoctor;
    }

    public void setCorreoDoctor(String CorreoDoctor) {
        this.CorreoDoctor = CorreoDoctor;
    }

   
    
    public void Guardar(){
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = Conexion.getConexion();   
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO Doctor (NombreDoctor, EdadDoctor, PesoDoctor, CorreoDoctor) VALUES(?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, getNombreDoctor());
            addProducto.setInt(2, getEdadDoctor());
            addProducto.setDouble(3, getPesoDoctor());
            addProducto.setString(4, getCorreoDoctor());
 
            //Ejecutar la consulta
            addProducto.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

     public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = Conexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();

        modeloDeDatos.setColumnIdentifiers(new Object[]{"IdDoctor", "NombreDoctor", "EdadDoctor", "PesoDoctor","CorreoDoctor"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Doctor");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{
                    rs.getString("IdDoctor"), 
                    rs.getString("NombreDoctor"), 
                    rs.getString("EdadDoctor"), 
                    rs.getInt("PesoDoctor"),
                    rs.getString("CorreoDoctor")
                }); 
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
     
    public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = Conexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //borramos 
        try {
            PreparedStatement deleteDoctor = conexion.prepareStatement("delete from Doctor where IdDoctor = ?");
            deleteDoctor.setString(1, miId);
            deleteDoctor.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void cargarDatosTabla(frmDoctores vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbDoctores.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String nombreD = vista.jtbDoctores.getValueAt(filaSeleccionada, 1).toString();
            String edadD = vista.jtbDoctores.getValueAt(filaSeleccionada, 2).toString();
            String pesoD = vista.jtbDoctores.getValueAt(filaSeleccionada, 3).toString();
            String correoD = vista.jtbDoctores.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vista.txtNombre.setText(nombreD);
            vista.txtEdad.setText(edadD);
            vista.txtPeso.setText(pesoD);
            vista.txtCorreo.setText(correoD);

        }
    }
    
    public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = Conexion.getConexion();
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String idDoctor = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("UPDATE FROM Doctor SET NombreDoctor = ?, EdadDoctor = ?, PesoDoctor = ?, CorreoDoctor = ? WHERE IdDoctor = ?");
                updateUser.setString(1, getNombreDoctor());
                updateUser.setInt(2, getEdadDoctor());
                updateUser.setDouble(3, getPesoDoctor());
                updateUser.setString(4, getCorreoDoctor());
                updateUser.setString(5, idDoctor);
                updateUser.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }

    public void set(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
