package br.com.greatsoft.greaterp.view.product;

import br.com.greatsoft.greaterp.controller.bean.ProductBean;
import br.com.greatsoft.greaterp.model.entity.inventory.Product;
import br.com.greatsoft.greaterp.model.entity.supply.Vendor;
import br.com.greatsoft.greaterp.model.persistence.rn.VendorRn;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProductEditView extends JDialog {
    private ProductBean productBean;
    private Product product;
    private DefaultComboBoxModel modelFornecedorJCB = new DefaultComboBoxModel();
    private JTextField caracteristicasJTF;
    private JTextField codBarrasJTF;
    private JTextField descricaoJTF;
    private JComboBox fornecedorJCB;
    private JLabel jLabel1;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JButton salvarJB;

    public ProductEditView(Frame parent, boolean modal, Product produto) {
        super(parent, modal);
        this.initFornecedorCombo();
        this.initComponents();
        this.productBean = new ProductBean();
        if (produto != null) {
            this.product = this.productBean.getProduct(produto.getId());
            this.initFields();
        } else {
            this.product = new Product();
        }

    }

    private void initFields() {
        this.codBarrasJTF.setText(this.product.getBarCode());
        this.descricaoJTF.setText(this.product.getDescription());
        this.caracteristicasJTF.setText(this.product.getCharacteristics());
        this.fornecedorJCB.setSelectedItem(this.product.getVendor());
    }

    private void initBean() {
        this.product.setBarCode(this.codBarrasJTF.getText());
        this.product.setDescription(this.descricaoJTF.getText());
        this.product.setCharacteristics(this.caracteristicasJTF.getText());
        this.product.setVendor((Vendor)this.modelFornecedorJCB.getSelectedItem());
    }

    private void initFornecedorCombo() {
        try {
            this.modelFornecedorJCB.removeAllElements();
            new ArrayList();
            List<Vendor> vendors = (new VendorRn()).listar();
            Iterator var2 = vendors.iterator();

            while(var2.hasNext()) {
                Vendor v = (Vendor)var2.next();
                this.modelFornecedorJCB.addElement(v);
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
        this.jLabel3 = new JLabel();
        this.salvarJB = new JButton();
        this.descricaoJTF = new JTextField();
        this.jLabel13 = new JLabel();
        this.fornecedorJCB = new JComboBox();
        this.setDefaultCloseOperation(2);
        this.setTitle("Produto");
        this.setModal(true);
        this.setResizable(false);
        this.jLabel1.setText("Cód. Barras");
        this.jLabel2.setText("Especificação");
        this.jLabel3.setText("Fornecedor");
        this.salvarJB.setText("Salvar");
        this.salvarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductEditView.this.salvarJBActionPerformed(evt);
            }
        });
        this.jLabel13.setText("Descrição");
        this.fornecedorJCB.setModel(this.modelFornecedorJCB);
        this.fornecedorJCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductEditView.this.fornecedorJCBActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(597, 597, 597).addComponent(this.salvarJB)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, Alignment.TRAILING).addComponent(this.jLabel13, Alignment.TRAILING).addComponent(this.jLabel3, Alignment.TRAILING))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2))).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.codBarrasJTF, -2, 199, -2).addComponent(this.descricaoJTF, -2, 521, -2).addComponent(this.caracteristicasJTF, -2, 522, -2).addComponent(this.fornecedorJCB, -2, 521, -2)))).addGap(22, 22, 22)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.codBarrasJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.descricaoJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.caracteristicasJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel3).addComponent(this.fornecedorJCB, -2, -1, -2)).addGap(8, 8, 8).addComponent(this.salvarJB).addGap(23, 23, 23)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void salvarJBActionPerformed(ActionEvent evt) {
        this.salvar();
    }

    private void fornecedorJCBActionPerformed(ActionEvent evt) {
    }

    public static void main(String[] args) {
    }
}
