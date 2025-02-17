package prokel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class MinimarketTableModel extends AbstractTableModel {
    private List<Minimarket> dataStokMinimarket = new ArrayList();
    
    public MinimarketTableModel(List<Minimarket> mhs) {
        this.dataStokMinimarket = mhs;
    }
    
    @Override
    public int getRowCount() {
        return dataStokMinimarket.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Minimarket mm = dataStokMinimarket.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mm.getKodeBarang();
            case 1:
                return mm.getNamaBarang();
            case 2:
                return mm.getKategori();
            case 3:
                return mm.getJumlahStok();
            case 4:
                return mm.getHargaSatuan();
            case 5:
                return mm.getSupplier();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODEBARANG";
            case 1:
                return "NAMABARANG";
            case 2:
                return "KATEGORI";
            case 3:
                return "STOKTERSEDIA";
            case 4:
                return "HARGA";
            case 5:
                return "SUPPLIER";
            default:
                return "";
        }
    }
}
