/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.sales;

import us.greatapps4you.greatsales.desktop.controller.bean.ProductBean;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsales.entities.purchase.Vendor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PdvView extends JDialog {
    private ProductBean productBean;
    private Product product;
    private DefaultComboBoxModel modelFornecedorlJCB = new DefaultComboBoxModel();
    private JTextField caracteristicasJTF;
    private JTextField caracteristicasJTF1;
    private JTextField caracteristicasJTF2;
    private JTextField caracteristicasJTF3;
    private JTextField caracteristicasJTF4;
    private JTextField caracteristicasJTF5;
    private JTextField caracteristicasJTF6;
    private JTextField codBarrasJTF;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JList jList1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public PdvView(Frame parent, boolean modal, long customerId) {
        super(parent, modal);
        this.initFornecedorCombo();
        this.initComponents();
        this.productBean = new ProductBean();
        if (customerId > 0L) {
            this.product = this.productBean.getProduct(customerId);
            this.initFields();
        } else {
            this.product = new Product();
        }

    }

    private void initFields() {
     /*   this.codBarrasJTF.setText(this.product.getBarCode());
        this.caracteristicasJTF.setText(this.product.getCharacteristics());
*/    }

    private void initBean() {
    /*    this.product.setBarCode(this.codBarrasJTF.getText());
        this.product.setCharacteristics(this.caracteristicasJTF.getText());
        this.product.setVendor((Vendor)this.modelFornecedorlJCB.getSelectedItem());
*/    }

    private void initFornecedorCombo() {
        try {
            this.modelFornecedorlJCB.removeAllElements();
            new ArrayList();
            List<Vendor> vendors = null;
                    //(new VendorRn()).listar();
            Iterator var2 = vendors.iterator();

            while(var2.hasNext()) {
                Vendor v = (Vendor)var2.next();
                this.modelFornecedorlJCB.addElement(v);
            }
        } catch (Exception var4) {
            System.out.println("Erro em ProductEditView.initFornecedorCombo()");
        }

    }

    private void salvar() {
        this.initBean();
        this.productBean.setProduct(this.product);
        this.productBean.salvar();
        JOptionPane.showMessageDialog(this.rootPane, "Salvo com sucesso!");
        this.dispose();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.codBarrasJTF = new JTextField();
        this.jLabel2 = new JLabel();
        this.caracteristicasJTF = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.jList1 = new JList();
        this.caracteristicasJTF1 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.caracteristicasJTF2 = new JTextField();
        this.caracteristicasJTF3 = new JTextField();
        this.caracteristicasJTF4 = new JTextField();
        this.jLabel5 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel6 = new JLabel();
        this.caracteristicasJTF5 = new JTextField();
        this.jLabel7 = new JLabel();
        this.caracteristicasJTF6 = new JTextField();
        this.setDefaultCloseOperation(2);
        this.setTitle("Compra");
        this.setModal(true);
        this.setResizable(false);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setText("Código");
        this.codBarrasJTF.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setText("Quantidade");
        this.caracteristicasJTF.setFont(new Font("Arial", 1, 14));
        this.jList1.setFont(new Font("Arial", 1, 14));
        this.jList1.setModel(new AbstractListModel() {
            String[] strings = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return this.strings.length;
            }

            public Object getElementAt(int i) {
                return this.strings[i];
            }
        });
        this.jScrollPane1.setViewportView(this.jList1);
        this.caracteristicasJTF1.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setText("Valor Unitário");
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setText("Valor Total");
        this.caracteristicasJTF2.setFont(new Font("Arial", 1, 14));
        this.caracteristicasJTF3.setFont(new Font("Arial", 1, 24));
        this.caracteristicasJTF3.setForeground(new Color(255, 3, 0));
        this.caracteristicasJTF4.setFont(new Font("Arial", 1, 24));
        this.jLabel5.setFont(new Font("Arial", 1, 14));
        this.jLabel5.setText("Produto");
        this.jPanel1.setBackground(new Color(76, 76, 194));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 0, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 113, 32767));
        this.jLabel6.setFont(new Font("Arial", 1, 14));
        this.jLabel6.setText("Dinheiro");
        this.caracteristicasJTF5.setFont(new Font("Arial", 1, 14));
        this.caracteristicasJTF5.setForeground(new Color(48, 31, 144));
        this.jLabel7.setFont(new Font("Arial", 1, 14));
        this.jLabel7.setText("Troco");
        this.caracteristicasJTF6.setFont(new Font("Arial", 1, 16));
        this.caracteristicasJTF6.setForeground(new Color(255, 3, 0));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane1, -2, 407, -2).addComponent(this.caracteristicasJTF4, -2, 400, -2).addComponent(this.jLabel5)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.caracteristicasJTF3).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jPanel1, Alignment.TRAILING, -1, -1, 32767).addComponent(this.codBarrasJTF).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.caracteristicasJTF).addComponent(this.jLabel3).addComponent(this.caracteristicasJTF1).addComponent(this.jLabel4).addComponent(this.caracteristicasJTF2, Alignment.TRAILING, -1, 209, 32767).addComponent(this.jLabel6)).addGap(0, 0, 0)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.caracteristicasJTF5, Alignment.TRAILING, -2, 209, -2).addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.caracteristicasJTF6, Alignment.TRAILING, -2, 209, -2))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.codBarrasJTF, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.caracteristicasJTF, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.caracteristicasJTF1, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.caracteristicasJTF2, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.caracteristicasJTF3, -2, 45, -2)).addComponent(this.jScrollPane1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel6)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.caracteristicasJTF5, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel7).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.caracteristicasJTF6, -2, -1, -2)).addComponent(this.caracteristicasJTF4)).addContainerGap()));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    public static void main(String[] args) {
        PdvView editDlg = new PdvView(new JFrame(), true, 0L);
        editDlg.setVisible(true);
    }
}
