package admin_panel;

import database.Database;
//import databasetest.JDBC;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class AdminHistoryViewForm extends javax.swing.JPanel {
    private static Connection conn = Database.getInstance();
    /**
     * Creates new form HistoryViewForm
     */
    public AdminHistoryViewForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        tfBookingStatus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfTotalPrice = new javax.swing.JTextField();
        tfMovieTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfBookingType = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfCustomerName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfTicketID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfStaffName = new javax.swing.JTextField();
        tfBookingDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));

        btnRefresh.setBackground(new java.awt.Color(223, 177, 96));
        btnRefresh.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setBorder(null);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tbHistory.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TicketID", "Booking Date", "Booking Status", "Total Price", "Movie Title", "Customer Name", "Staff Name", "Booking Type"
            }
        ));
        tbHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHistory);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel3.setText("Booking Status");

        btnClear.setBackground(new java.awt.Color(125, 225, 154));
        btnClear.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(null);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tfBookingStatus.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel12.setText("Movie Title");

        tfTotalPrice.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        tfMovieTitle.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel4.setText("Total Price");

        jLabel8.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel8.setText("Booking Type");

        tfBookingType.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel10.setText("Customer Name");

        tfCustomerName.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel11.setText("Staff Name");

        jLabel1.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel1.setText("TicketID");

        tfTicketID.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel2.setText("Booking Date");

        tfStaffName.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        tfBookingDate.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(93, 202, 209));
        btnSearch.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfBookingDate)
                                    .addComponent(tfTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tfBookingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMovieTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBookingType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(tfTicketID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(tfMovieTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(tfStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfBookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfBookingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(tfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(tfBookingType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        RefreshButton();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void RefreshButton() {
        try {
            
            String query = 
                "SELECT t.TicketID, t.BookingDate, t.BookingStatus, t.TotalPrice, " +
                "m.Title AS MovieName, c.Name AS CustomerName, s.Name AS StaffName, t.BookingType " +
                "FROM [Ticket] t " +
                "LEFT JOIN [TicketSeat] ts ON t.TicketID = ts.TicketID " +
                "LEFT JOIN [SeatSchedule] ss ON ts.ScheduleSeatID = ss.ScheduleSeatID " +
                "LEFT JOIN [Schedule] sch ON ss.ScheduleID = sch.ScheduleID " +
                "LEFT JOIN [Movie] m ON sch.MovieID = m.MovieID " +
                "LEFT JOIN [Customer] c ON t.CustomerID = c.CustomerID " +
                "LEFT JOIN [Staff] s ON t.StaffID = s.StaffID ";
            
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tbHistory.getModel();
            model.setRowCount(0); 
            
            while (result.next()) {
                Object[] row = {
                    result.getInt("TicketID"),
                    result.getString("BookingDate"),
                    result.getString("BookingStatus"),
                    result.getDouble("TotalPrice"),
                    result.getString("MovieName"),
                    result.getString("CustomerName"),
                    result.getString("StaffName"),
                    result.getString("BookingType")
                };
                model.addRow(row);
            }
            
            
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error occurred while fetching data: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void tbHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHistoryMouseClicked
        int selectedRow = tbHistory.getSelectedRow();
        if (selectedRow >= 0) {
            tfTicketID.setText(tbHistory.getValueAt(selectedRow, 0).toString());
            tfBookingDate.setText(tbHistory.getValueAt(selectedRow, 1).toString());
            tfBookingStatus.setText(tbHistory.getValueAt(selectedRow, 2).toString());
            tfTotalPrice.setText(tbHistory.getValueAt(selectedRow, 3).toString());
            tfMovieTitle.setText(tbHistory.getValueAt(selectedRow, 4) != null
                ? tbHistory.getValueAt(selectedRow, 4).toString()
                : "");
            tfCustomerName.setText(tbHistory.getValueAt(selectedRow, 5) != null
                ? tbHistory.getValueAt(selectedRow, 5).toString()
                : "");
            tfStaffName.setText(tbHistory.getValueAt(selectedRow, 6) != null
                ? tbHistory.getValueAt(selectedRow, 6).toString()
                : "");
            tfBookingType.setText(tbHistory.getValueAt(selectedRow, 7).toString());
        }
    }//GEN-LAST:event_tbHistoryMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tfTicketID.setText("");
        tfBookingDate.setText("");
        tfBookingStatus.setText("");
        tfTotalPrice.setText("");
        tfMovieTitle.setText("");
        tfCustomerName.setText("");
        tfStaffName.setText("");
        tfBookingType.setText("");
        RefreshButton();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            

            // Base query
            String query = 
                "SELECT t.TicketID, t.BookingDate, t.BookingStatus, t.TotalPrice, " +
                "m.Title AS MovieName, c.Name AS CustomerName, s.Name AS StaffName, t.BookingType " +
                "FROM [Ticket] t " +
                "LEFT JOIN [TicketSeat] ts ON t.TicketID = ts.TicketID " +
                "LEFT JOIN [SeatSchedule] ss ON ts.ScheduleSeatID = ss.ScheduleSeatID " +
                "LEFT JOIN [Schedule] sch ON ss.ScheduleID = sch.ScheduleID " +
                "LEFT JOIN [Movie] m ON sch.MovieID = m.MovieID " +
                "LEFT JOIN [Customer] c ON t.CustomerID = c.CustomerID " +
                "LEFT JOIN [Staff] s ON t.StaffID = s.StaffID WHERE 1=1";

            // Append conditions based on input
            if (!tfTicketID.getText().trim().isEmpty()) {
                query += " AND t.TicketID = " + tfTicketID.getText().trim();
            }
            if (!tfBookingDate.getText().trim().isEmpty()) {
                query += " AND t.BookingDate LIKE '%" + tfBookingDate.getText().trim() + "%'";
            }
            if (!tfBookingStatus.getText().trim().isEmpty()) {
                query += " AND t.BookingStatus LIKE '%" + tfBookingStatus.getText().trim() + "%'";
            }
            if (!tfTotalPrice.getText().trim().isEmpty()) {
                query += " AND t.TotalPrice = " + tfTotalPrice.getText().trim();
            }
            if (!tfMovieTitle.getText().trim().isEmpty()) {
                query += " AND m.Title LIKE '%" + tfMovieTitle.getText().trim() + "%'";
            }
            if (!tfCustomerName.getText().trim().isEmpty()) {
                query += " AND c.Name LIKE '%" + tfCustomerName.getText().trim() + "%'";
            }
            if (!tfStaffName.getText().trim().isEmpty()) {
                query += " AND s.Name LIKE '%" + tfStaffName.getText().trim() + "%'";
            }
            if (!tfBookingType.getText().trim().isEmpty()) {
                query += " AND t.BookingType LIKE '%" + tfBookingType.getText().trim() + "%'";
            }

            // Execute query
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            // Update the table
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tbHistory.getModel();
            model.setRowCount(0); // Clear existing rows

            while (result.next()) {
                Object[] row = {
                    result.getInt("TicketID"),
                    result.getString("BookingDate"),
                    result.getString("BookingStatus"),
                    result.getDouble("TotalPrice"),
                    result.getString("MovieName"),
                    result.getString("CustomerName"),
                    result.getString("StaffName"),
                    result.getString("BookingType")
                };
                model.addRow(row);
            }

            
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error occurred while searching: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHistory;
    private javax.swing.JTextField tfBookingDate;
    private javax.swing.JTextField tfBookingStatus;
    private javax.swing.JTextField tfBookingType;
    private javax.swing.JTextField tfCustomerName;
    private javax.swing.JTextField tfMovieTitle;
    private javax.swing.JTextField tfStaffName;
    private javax.swing.JTextField tfTicketID;
    private javax.swing.JTextField tfTotalPrice;
    // End of variables declaration//GEN-END:variables
}
