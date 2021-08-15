
package com.mycompany.phone_book;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



class Table extends JFrame{
    
    
     String url = "jdbc:sqlite:res/Users.db";
     String qury = "SELECT * FROM users";
     Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     DefaultTableModel dtm = null;

    Table() {
       super("Table");
        try {     
            conn = DriverManager.getConnection(url);
            pstmt = conn.prepareStatement(qury);
            dtm = new DefaultTableModel();
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int col = 1; col <= rsmd.getColumnCount(); col++){
                    dtm.addColumn(rsmd.getColumnName(col));
                }
                  while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    for (int col = 1; col <= rsmd.getColumnCount(); col++){
                       int type = rsmd.getColumnType(col);
                       switch (type) {
                            case Types.INTEGER:
                                row.add(new Integer(rs.getInt(col)).toString());
                                break;
                            case Types.VARCHAR:
                                row.add(rs.getString(col));
                                break;
                        }
                    }
                    dtm.addRow(row);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString()); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            try{
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }      
        JTable grid = new JTable();
        grid.setModel(dtm);
        JScrollPane jsp = new JScrollPane(grid);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jsp);
        setResizable(false);
        setVisible(true);
    }
}
