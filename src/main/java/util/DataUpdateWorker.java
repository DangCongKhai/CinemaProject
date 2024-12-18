package util;

import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDR. H
 */
public class DataUpdateWorker  extends SwingWorker<Void, Void> {
    private JTable table;
    private AdminHistoryDataFetcher dataFetcher;
    private int refreshInterval;
    
    public DataUpdateWorker(JTable table, AdminHistoryDataFetcher dataFetcher, int refreshInterval) {
        this.table = table;
        this.dataFetcher = dataFetcher;
        this.refreshInterval = refreshInterval; // in seconds
    }
    
    @Override
    protected Void doInBackground() {
        while (!isCancelled()) {
            try {
                refreshData();
                TimeUnit.SECONDS.sleep(refreshInterval); // Refresh every specified seconds
            } catch (InterruptedException e) {
                break;
            }
        }
        return null;
    }

    private void refreshData() {
        try {
            List<Object[]> history = dataFetcher.getAllTicketHistory();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Object[] row : history) {
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(table,
                    "Error occurred while fetching data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    protected void done() {
        // Handle any cleanup here if necessary
    }    
}
