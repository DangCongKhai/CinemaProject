package main_view;

import cms.component.MainForm;
import main_view.*;
import main_view.*;
import admin_panel.MovieManagementPanel;
import admin_panel.SchedulePanel;
import com.formdev.flatlaf.FlatIntelliJLaf;
import cms.component.Header;
import cms.component.Menu;
import event_interface.EventMenuSelected;
import event_interface.EventShowPopupMenu; 
import swing_component.MenuItem;
import swing_component.PopupMenu;

import customer_panel.BookingHistoryPanel;
import customer_panel.EditInfoPanel;
import customer_panel.FrequentlyAskedQuestionPanel;
import customer_panel.MovieDisplayPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Customer;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import static util.Util.runMyScheduler;

public class CustomerView extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    private Customer customer;

    public CustomerView(Customer customer) {
        this.customer = customer;
//        runMyScheduler();
        initComponents();
        init();
    }
    public Customer getCustomer(){
        return customer;
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
       
        header = new Header();
        header.setUserName(customer.getName());
        header.setRole("Customer");
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new MovieDisplayPanel(CustomerView.this));
                }else if(menuIndex == 1){
                    main.showForm(new FrequentlyAskedQuestionPanel());
                }else if (menuIndex == 2){
                    main.showForm(new EditInfoPanel(CustomerView.this.customer));

                }else if (menuIndex == 3){
                    main.showForm(new BookingHistoryPanel(CustomerView.this.customer));
                }else{
                    new Guest().setVisible(true);
                    CustomerView.this.setVisible(false);
                    
                    
                    
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(CustomerView.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = CustomerView.this.getX() + 52;
                int y = CustomerView.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.setTextTitle("Customer UI");
        menu.addMenu(new ModelMenu(new ImageIcon(System.getProperty("user.dir") +"/src/main/java/com/raven/icon/1.png"), "HomePage"));
        menu.addMenu(new ModelMenu(new ImageIcon(System.getProperty("user.dir") +"/src/main/java/com/raven/icon/4.png"), "FAQ"));
        menu.addMenu(new ModelMenu(new ImageIcon(System.getProperty("user.dir") +"/src/main/java/com/raven/icon/edit.png"), "Edit information"));
        menu.addMenu(new ModelMenu(new ImageIcon(System.getProperty("user.dir") +"/src/main/java/com/raven/icon/8.png"), "Booking History"));
        menu.addMenu(new ModelMenu(new ImageIcon(System.getProperty("user.dir") +"/src/main/java/com/raven/icon/5.png"), "Log out"));
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });

        //  Start with this form
        main.showForm(new MovieDisplayPanel(CustomerView.this));
    }
    public MainForm getMainForm(){
        return main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1300, 700));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
