import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JSpinner spnCodigo;
    private JComboBox cboMarca;
    private JTextField txtIP;
    private JTextField txtPrecio;
    private JButton btnIngresar;
    private JButton btnListar;
    private JButton btnOrdenar;
    private JList lstOrdenar;
    private JTextArea txtListar;
    private JButton btnSumar;
    private JComboBox cboSumatoria;
    private JPanel Router;
    private Lista routers = new Lista();
    private void llenarJlist(){
        List<PuntoAcceso> listado = routers.getRouters();
        DefaultListModel dlm = new DefaultListModel();
        for(PuntoAcceso j:listado){
            dlm.addElement(j.toString());
        }
        lstOrdenar.setModel(dlm);
    }
    public Ventana() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spnCodigo.getValue().toString());
                String marca = cboMarca.getSelectedItem().toString();
                String ip = txtIP.getText();
                float precio = Float.parseFloat(txtPrecio.getText());
                PuntoAcceso puntoAcceso = new PuntoAcceso(codigo,marca,ip,precio);
                routers.agregar(puntoAcceso);
                JOptionPane.showMessageDialog(null,"Registrado");
                txtIP.setText("");
                txtPrecio.setText("");
            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routers.ordenarInsercion();
                llenarJlist();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText("");
                //routers.predefinir();//
                for (PuntoAcceso puntoAcceso : routers.routers) {
                    txtListar.append(puntoAcceso.toString() + "\n");
                }
            }
        });
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaSeleccionada = cboSumatoria.getSelectedItem().toString();
                float suma = routers.sumarPreciosPorMarca(routers.getRouters(), marcaSeleccionada);
                JOptionPane.showMessageDialog(null, "La suma de los precios de la marca " + marcaSeleccionada + " es: " + suma);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Router);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
