package datos;

import dominio.Compra;
import java.sql.*;
import java.util.*;

public class CompraDaoJDBC {
    private static final String SQL_SELECT = "SELECT idcompra, idproducto, cantidad, precio_total "
            + " FROM compra";
    private static final String SQL_SELECT_BY_ID = "SELECT idcompra, idproducto, cantidad, precio_total "
            + " FROM compra WHERE idcompra = ?";

    private static final String SQL_INSERT = "INSERT INTO compra(idproducto, cantidad, precio_total) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE compra "
            + " SET idproducto=?, cantidad=?, precio_total=? WHERE idcompra=?";

    private static final String SQL_DELETE = "DELETE FROM compra WHERE idcompra = ?";
    
    public List<Compra> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra = null;
        List<Compra> compras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCompra = rs.getInt("idcompra");
                int idProducto = rs.getInt("idproducto");
                int Cantidad = rs.getInt("cantidad");
                double Precio_Total = rs.getDouble("precio_total");

                compra = new Compra(idCompra, idProducto, Cantidad, Precio_Total);
                compras.add(compra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return compras;
    }
    
    public int insertar(Compra compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, compra.getIdProducto());
            stmt.setInt(2, compra.getCantidad());
            stmt.setDouble(3, compra.getPrecio_Total());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(Compra compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getIdCompra());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
