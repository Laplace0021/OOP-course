package report;

import controller.PenjualanController;
import model.DetailPenjualan;
import model.Penjualan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LaporanPenjualan extends JFrame {

    private final PenjualanController controller = new PenjualanController();

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID Transaksi", "Tanggal", "Pelanggan", "Kasir", "Total"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    private final DefaultTableModel detailModel = new DefaultTableModel(
            new Object[]{"Kode Barang", "Nama Barang", "Harga", "Qty", "Subtotal"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable detailTable = new JTable(detailModel);

    public LaporanPenjualan() {
        setTitle("Laporan Penjualan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);

        JButton btnRefresh = new JButton("Muat Ulang");
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnRefresh);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(table), new JScrollPane(detailTable));
        splitPane.setResizeWeight(0.5);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);

        btnRefresh.addActionListener(e -> muatLaporan());
        table.getSelectionModel().addListSelectionListener(e -> muatDetail());

        muatLaporan();
    }

    private void muatLaporan() {
        try {
            List<Penjualan> list = controller.getLaporanPenjualan();
            model.setRowCount(0);
            for (Penjualan p : list) {
                model.addRow(new Object[]{p.getIdPenjualan(), p.getTanggal(),
                        p.getNamaPelanggan(), p.getUsername(), p.getTotal()});
            }
            detailModel.setRowCount(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat laporan: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void muatDetail() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        int idPenjualan = (int) model.getValueAt(row, 0);
        try {
            List<DetailPenjualan> list = controller.getDetail(idPenjualan);
            detailModel.setRowCount(0);
            for (DetailPenjualan d : list) {
                detailModel.addRow(new Object[]{d.getKodeBarang(), d.getNamaBarang(),
                        d.getHarga(), d.getQty(), d.getSubtotal()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat detail: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}