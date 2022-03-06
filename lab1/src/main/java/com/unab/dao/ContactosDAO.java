package com.unab.dao;

import com.unab.conexion.Conexion;
import com.unab.entidades.ContactoPersonas;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContactosDAO {

    Conexion cn = new Conexion();
    Connection con = cn.retornarConexion();

    public void insertContact(ContactoPersonas contact) {
        try {
            CallableStatement statement = con.prepareCall("call SP_I_CONTACTO(?,?,?,?)");
            statement.setString("Cnom", contact.getNombre());
            statement.setInt("Cedad", contact.getEdad());
            statement.setString("Cemail", contact.getEmail());
            statement.setString("Cnum", contact.getNumeroDeTelefono());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos almacenados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos" + e);

        }

    }

    public void updateContactos(ContactoPersonas contact) {
        try {
            CallableStatement statement = con.prepareCall("call SP_U_CONTACTO(?,?,?,?,?)");
            statement.setString("Cnom", contact.getNombre());
            statement.setInt("idCon", contact.getIdContactos());
            statement.setInt("Cedad", contact.getEdad());
            statement.setString("Cemail", contact.getEmail());
            statement.setString("Cnum", contact.getNumeroDeTelefono());

            statement.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");

        }

    }

    public void deleteContactos(ContactoPersonas contact) {
        try {
            CallableStatement statement = con.prepareCall("call SP_D_CONTACTOS(?)");
            statement.setInt("idCon", contact.getIdContactos());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Datos eliminados");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos " + e);

        }
    }

    public ArrayList<ContactoPersonas> mostrarDatos() {
        var listado = new ArrayList<ContactoPersonas>();
        try {
            CallableStatement statement = con.prepareCall("SELECT idContactos, Nombre, Edad, Email, NumeroDeTelefono FROM contactos");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                ContactoPersonas contact = new ContactoPersonas();
                contact.setIdContactos(res.getInt("idContactos"));
                contact.setNombre(res.getString("Nombre"));
                contact.setEdad(res.getInt("Edad"));
                contact.setEmail(res.getString("Email"));
                contact.setNumeroDeTelefono(res.getString("NumeroDeTelefono"));

                listado.add(contact);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Datos " + e);
        }

        return listado;
    }
}
