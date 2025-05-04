package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ruiboticas
 * @version 1.0.0
 */
public class ResultSetTableModel extends AbstractTableModel {

    private final ArrayList<String> columnNames = new ArrayList<>();
    private ResultSet rs = null;

    /**
     *
     * @param rs
     * @throws SQLException
     */
    public ResultSetTableModel(ResultSet rs) throws SQLException {
        this.rs = rs;

        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            columnNames.add(rs.getMetaData().getColumnName(i + 1));
        }
    }

    @Override
    public int getRowCount() {
        int res = 0;
        try {
            rs.last();
            res = rs.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int getColumnCount() {
        try {
            return rs.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String res = "";

        try {
            rs.absolute(rowIndex + 1);
            res = rs.getString(columnIndex + 1);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
