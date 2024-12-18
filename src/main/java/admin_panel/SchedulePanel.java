/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin_panel;

import datechooser.SelectedDate;
import cms.component.TableHeader;
import controller.AdminController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Movie;
import model.Schedule;
import model.Screen;
import static util.Util.hourMinuteToTime;
import static util.Util.longInput;
/**
 *
 * @author OS
 */
public class SchedulePanel extends javax.swing.JPanel {
    private ArrayList<Movie> movies_list = new ArrayList<>();
//    private static final ArrayList<Screen> screens_list = new ArrayList<>();
    private static AdminController admin_controller = AdminController.getInstance();
    private static DefaultTableModel table_model = new DefaultTableModel();
    private DefaultComboBoxModel<String> combo_box_movies;
    private static ArrayList<Schedule> schedules_list = new ArrayList<>();
    private datechooser.DateChooser date_chooser;
    private DocumentListener docListener;
    private static String original_movie;
    private static SelectedDate original_selected_date;
    private static String original_hour;
    private static String original_minute;
    private static long original_price;
    private static int original_screen_number;
    private static boolean isUpdating = false;
    private static ActionListener combo_action_listener;
    private static DocumentListener doc_listener;
    /** 
     * Creates new form P3_Schedule
     */
    public SchedulePanel() {
        initComponents();
        initializeDocListener();
        date_chooser = new datechooser.DateChooser();
        date_chooser.setTextRefernce(tf_date);
        movies_list = admin_controller.getExistingMovie();
        combo_box_movies = new DefaultComboBoxModel();
        
        for (Movie movie : movies_list){ 
            combo_box_movies.addElement(movie.getTitle());
        } 
        comboBoxMovie.setModel(combo_box_movies);
        
        table_model.setDataVector( new Object[][]{}, new String [] {
        "Title", "ShowDate", "Start Time", "End Time", "Price", "Screen"
        });
        
        ResultSet result = admin_controller.getAvailableSchedule();
        try {
            while(result.next()){  
            
                int scheduleID = result.getInt("ScheduleID");
                String title = result.getString("Title");
                java.util.Date util_date = result.getDate("ShowDate");

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String d = df.format(util_date);
                int DAY = Integer.valueOf(d.split("-")[0]);
                int MONTH = Integer.valueOf(d.split("-")[1]);
                int YEAR = Integer.valueOf(d.split("-")[2]);
                SelectedDate selected_date = new SelectedDate(DAY, MONTH, YEAR);
                String start_time = hourMinuteToTime(result.getInt("StartTime"));
                String end_time = hourMinuteToTime(result.getInt("StartTime") + result.getInt("Duration"));
                long price = result.getLong("Price");
                int screen_number = result.getInt("ScreenID");
                schedules_list.add(new Schedule(scheduleID, title, selected_date, start_time, end_time, price, screen_number));
                Object[] row = {title, selected_date, start_time, end_time, price,screen_number};
                table_model.addRow(row);    
            }
        } catch (SQLException ex) {            
//            Logger.getLogger(SchedulePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(230, 230, 230));
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
                TableHeader header = new TableHeader(o + "");
//                if (col == 4) {
                  header.setHorizontalAlignment(JLabel.CENTER);
//                }
                return header;
            }
        });
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        
        table.setRowHeight(40);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int row, int col) {
                
//                Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, row, col);
                JTextArea com = new JTextArea(o.toString());
                com.setLineWrap(true);  // Enable text wrapping
                com.setWrapStyleWord(true);  // Wrap at word boundaries
                com.setOpaque(true);
                
//                com.set
//                com.setHorizontalAlignment(JLabel.CENTER);
                setBorder(noFocusBorder);
                int rowHeight = com.getHeight();
                if (table.getRowHeight(row) < rowHeight) {
                    table.setRowHeight(row, rowHeight + 10);
                }
                
                com.setForeground(new Color(102, 102, 102));
                
                
                if (selected) {
                    com.setBackground(new Color(239, 244, 255));
                } else {
                    com.setBackground(Color.WHITE);
                }
                return com;
                
            }
        }
        );
        table.setModel(table_model);
        bt_update.setEnabled(false);
        bt_delete.setEnabled(false);
        initializeComboBoxPerformed();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        comboBoxMovie = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        comboBoxScreen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboBoxHour = new javax.swing.JComboBox<>();
        comboBoxMinute = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_date = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bt_add = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1098, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(368, 650));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel2.setText("Select Movie");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel3.setText("Select ShowDate");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel4.setText("Select start time");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel5.setText("Select Price");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel1.setText("Select Screen");

        comboBoxScreen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1","2", "3", "4"}));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("VND");

        comboBoxHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        comboBoxMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45"}));

        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel7.setText(".000");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Movie");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Schedule");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bt_add.setBackground(new java.awt.Color(223, 177, 96));
        bt_add.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_add.setText("Add");
        bt_add.setBorder(null);
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        bt_update.setBackground(new java.awt.Color(223, 177, 96));
        bt_update.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_update.setText("Update");
        bt_update.setBorder(null);
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setBackground(new java.awt.Color(223, 177, 96));
        bt_delete.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.setBorder(null);
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_clear.setBackground(new java.awt.Color(223, 177, 96));
        bt_clear.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        bt_clear.setText("Clear");
        bt_clear.setBorder(null);
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(156, 156, 156))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxMovie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxScreen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(13, 13, 13)
                                        .addComponent(comboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))))
                            .addComponent(tf_date))))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(35, 35, 35)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 402));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title", "ShowDate", "Start Time", "End Time", "Price", "Screen"
            })
            {public boolean isCellEditable(int row, int column) {
                return false;
            }}
        );
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
//        // TODO add your handling code here:
        int selected_movie_index = comboBoxMovie.getSelectedIndex();
        // Get movie title
        String title = (String) comboBoxMovie.getSelectedItem();

        SelectedDate date = date_chooser.getSelectedDate();
        
        if (date == null){
            JOptionPane.showMessageDialog(this, "Please choose the date for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
            return;
        }    
        // Get hour and minute start time
        String start_hour = (String) comboBoxHour.getSelectedItem();
        if (start_hour.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please choose the start hour for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String start_minute = (String) comboBoxMinute.getSelectedItem();
        if (start_minute.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please choose the start minute for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int duration = movies_list.get(selected_movie_index).getDuration();
        int start_time_int = Integer.parseInt(start_hour) * 60 + Integer.parseInt(start_minute);
        int end_time_int = start_time_int + duration;
        
        String start_time_text = start_hour + ":" + start_minute;
        String end_time_text = hourMinuteToTime(end_time_int);
        
        String price_text = tf_price.getText();
        if (price_text.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please choose the price for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
            return;
        }
        long price;
        try{
            price = longInput(price_text + "000");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Please enter integer price for your movie schedule", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
        int screen_number = Integer.parseInt((String) comboBoxScreen.getSelectedItem());
        Object[] row = {title, date, start_time_text, end_time_text, price, screen_number};
        String confirm_messsage = String.format("Are you sure to add this movie schedule? \n Title: %s \n ShowDate: %s \n Show Time: %s-%s \n Price: %d \n Screen: %d", title, date.toString(), start_time_text, end_time_text, price, screen_number );
        int result = JOptionPane.showConfirmDialog(this, confirm_messsage, "Confirm schedule", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            Schedule schedule = new Schedule(title, date, start_time_text, end_time_text, price, screen_number );
            Schedule returned_schedule = admin_controller.insertSchedule(schedule);
            if (!returned_schedule.equals(null)){
                schedules_list.add(returned_schedule);
                table_model.addRow(row);
                JOptionPane.showMessageDialog(this, "Successfully adding schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Fail to add new schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }
        
        }
        clear();
        
            
        
        
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete this schedule?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == 0){
            int selected_index = table.getSelectedRow();
            table_model.removeRow(selected_index);
            Schedule deleted_schedule = schedules_list.get(selected_index);
            schedules_list.remove(selected_index);
            if (admin_controller.deleteSchedule(deleted_schedule)){
                JOptionPane.showMessageDialog(this, "Sucessful deleting schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Fail to delete schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }
        }
        clear();
       
        
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        // TODO add your handling code here:
        String confirm_messsage ="Are you sure to update this schedule? ";
        int result = JOptionPane.showConfirmDialog(this, confirm_messsage, "Confirm schedule", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
             int selected_row = table.getSelectedRow();
            Schedule old_schedule = schedules_list.get(selected_row);

            int selected_movie_index = comboBoxMovie.getSelectedIndex();
            // Get movie title
            String title = (String) comboBoxMovie.getSelectedItem();
            SelectedDate date = date_chooser.getSelectedDate();

            if (date == null){
                JOptionPane.showMessageDialog(this, "Please choose the date for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
                return;
            }    
            // Get hour and minute start time
            String start_hour = (String) comboBoxHour.getSelectedItem();
            if (start_hour.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please choose the start hour for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String start_minute = (String) comboBoxMinute.getSelectedItem();
            if (start_minute.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please choose the start minute for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duration = movies_list.get(selected_movie_index).getDuration();
            int start_time_int = Integer.parseInt(start_hour) * 60 + Integer.parseInt(start_minute);
            int end_time_int = start_time_int + duration;

            String start_time_text = start_hour + ":" + start_minute;
            String end_time_text = hourMinuteToTime(end_time_int);

            String price_text = tf_price.getText();
            if (price_text.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please choose the price for your movie schedule", "Missing information", JOptionPane.ERROR_MESSAGE);
                return;
            }
            long price;
            try{
                price = longInput(price_text + "000");
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter integer price for your movie schedule", "Invalid input", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int screen_number = Integer.parseInt((String) comboBoxScreen.getSelectedItem());

            Object[] row = {title, date, start_time_text, end_time_text, price, screen_number};
         
            
            Schedule new_schedule = new Schedule(title, date, start_time_text, end_time_text, price, screen_number );
            
            if(admin_controller.updateNewSchedule(old_schedule, new_schedule)){
                for (int col = 0; col < row.length; col++){
                    table_model.setValueAt(row[col], selected_row, col);
                }
                new_schedule.setScheduleID(old_schedule.getScheduleID());
                schedules_list.set(selected_row, new_schedule);
                JOptionPane.showMessageDialog(this, "Successfully updateing schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Fail to update schedule", "Status", JOptionPane.PLAIN_MESSAGE);
            }
            
            clear();
     
        }
        
   
       
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_bt_clearActionPerformed
    private void clear(){
        tf_date.setText("");
        tf_price.setText("");
        bt_delete.setEnabled(false);
        bt_update.setEnabled(false);
        deletePropertyUpdate();
    }
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
//        tf_date.setEnabled(true);
        int selected_row= table.getSelectedRow();
        
        original_movie = (String) table_model.getValueAt(selected_row, 0);
        original_selected_date =  (SelectedDate) table_model.getValueAt(selected_row, 1);
        
        String start_time_text =  (String) table_model.getValueAt(selected_row, 2);
        original_hour = start_time_text.substring(0,2);
        original_minute = start_time_text.substring(3);     
        
        original_price = (long) table_model.getValueAt(selected_row, 4);
        original_screen_number = (Integer) table_model.getValueAt(selected_row, 5);
        
        comboBoxMovie.setSelectedItem(original_movie);
        
        date_chooser.setSelectedDate(original_selected_date);
        comboBoxHour.setSelectedItem(original_hour);
        comboBoxMinute.setSelectedItem(original_minute);
        tf_price.setText(String.valueOf(original_price / 1000));
        comboBoxScreen.setSelectedItem(String.valueOf(table_model.getValueAt(selected_row, 5)));
        bt_delete.setEnabled(true);
        addPropertyUpdate();
    }//GEN-LAST:event_tableMouseClicked
    

    private class ComboBoxActionListener implements ActionListener{
        public ComboBoxActionListener(){        
        }
        @Override
        public void actionPerformed(ActionEvent e){
           
            bt_update.setEnabled(true);
        }
        
        
    }
    private void initializeComboBoxPerformed(){
        combo_action_listener = new ComboBoxActionListener();
    }
    private void initializeDocListener(){
        if (docListener == null) { 
        docListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkForChanges();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkForChanges();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkForChanges();
        }
        };
        }
    }
    private void checkForChanges() {
    // Compare current values with original values
    boolean isChanged = !tf_date.getText().equals(original_selected_date.toString()) ||
                        !(tf_price.getText()+"000").equals(String.valueOf(original_price));
    
    // Enable or disable the Update button
    bt_update.setEnabled(isChanged);
}
    private void addPropertyUpdate(){
        comboBoxMovie.addActionListener(combo_action_listener);
        comboBoxScreen.addActionListener(combo_action_listener);
        comboBoxMinute.addActionListener(combo_action_listener);
        comboBoxHour.addActionListener(combo_action_listener);
        comboBoxScreen.addActionListener(combo_action_listener);
        tf_date.getDocument().addDocumentListener(docListener);
        tf_price.getDocument().addDocumentListener(docListener);
    }
    private void deletePropertyUpdate(){
         comboBoxMovie.removeActionListener(combo_action_listener);
        comboBoxScreen.removeActionListener(combo_action_listener);
        comboBoxMinute.removeActionListener(combo_action_listener);
        comboBoxHour.removeActionListener(combo_action_listener);
        comboBoxScreen.removeActionListener(combo_action_listener);
        tf_date.getDocument().removeDocumentListener(docListener);
        tf_price.getDocument().removeDocumentListener(docListener);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_update;
    private javax.swing.JComboBox<String> comboBoxHour;
    private javax.swing.JComboBox<String> comboBoxMinute;
    private javax.swing.JComboBox<String> comboBoxMovie;
    private javax.swing.JComboBox<String> comboBoxScreen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_date;
    private javax.swing.JTextField tf_price;
    // End of variables declaration//GEN-END:variables
}
