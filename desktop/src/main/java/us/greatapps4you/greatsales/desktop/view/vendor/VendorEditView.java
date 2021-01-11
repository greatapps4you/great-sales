/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.vendor;

import us.greatapps4you.greatsales.desktop.controller.bean.VendorBean;
import us.greatapps4you.greatsales.entities.purchase.Vendor;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VendorEditView extends JDialog {
    VendorBean vendorBean;
    Vendor vendor;
    private JTextField bairroJTF;
    private JTextField celularJTF;
    private JTextField cepJTF;
    private JTextField cidadeJTF;
    private JTextField cnpjJTF;
    private JTextField complementoJTF;
    private JTextField emailJTF;
    private JTextField estadoJTF;
    private JTextField ieJTF;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField nomeJTF;
    private JTextField numeroJTF;
    private JTextField paisJTF;
    private JTextField razaoJTF;
    private JTextField ruaJTF;
    private JButton salvarJB;
    private JTextField siteJTF;
    private JTextField telefoneJTF;

    public VendorEditView(Frame parent, boolean modal, long customerId) {
        super(parent, modal);
        this.initComponents();
        this.vendorBean = new VendorBean();
        if (customerId > 0L) {
            this.vendor = this.vendorBean.getVendor(customerId);
            this.initFields();
        } else {
            this.vendor = new Vendor();
        }

    }

    private void initFields() {
        /*this.nomeJTF.setText(this.vendor.getIdentification().getNomeFantasia());
        this.razaoJTF.setText(this.vendor.getIdentification().getRazaoSocial());
        this.cnpjJTF.setText(this.vendor.getIdentification().getCnpj());
        this.ieJTF.setText(this.vendor.getIdentification().getInscEst());
*/        this.cepJTF.setText(this.vendor.getAddress().getZip());
        this.ruaJTF.setText(this.vendor.getAddress().getStreet());
        this.numeroJTF.setText(this.vendor.getAddress().getNumber());
        this.complementoJTF.setText(this.vendor.getAddress().getComplement());
        this.bairroJTF.setText(this.vendor.getAddress().getNeighborhood());
        this.cidadeJTF.setText(this.vendor.getAddress().getCity());
        this.estadoJTF.setText(this.vendor.getAddress().getCountryState());
        this.paisJTF.setText(this.vendor.getAddress().getCountry());
        this.telefoneJTF.setText(this.vendor.getAddress().getPhone());
        this.celularJTF.setText(this.vendor.getAddress().getCellPhone());
        this.emailJTF.setText(this.vendor.getAddress().getEmail());
        this.siteJTF.setText(this.vendor.getAddress().getWebsite());
    }

    private void initBean() {
        Identification ident = new Identification();
       /* ident.setNomeFantasia(this.nomeJTF.getText());
        ident.setRazaoSocial(this.razaoJTF.getText());
        ident.setCnpj(this.cnpjJTF.getText());
        ident.setInscEst(this.ieJTF.getText());
 */       Address address = new Address();
        address.setStreet(this.ruaJTF.getText());
        address.setNumber(this.numeroJTF.getText());
        address.setComplement(this.complementoJTF.getText());
        address.setZip(this.cepJTF.getText());
        address.setNeighborhood(this.bairroJTF.getText());
        address.setCity(this.cidadeJTF.getText());
        address.setCountryState(this.estadoJTF.getText());
        address.setCountry(this.paisJTF.getText());
        address.setPhone(this.telefoneJTF.getText());
        address.setCellPhone(this.celularJTF.getText());
        address.setEmail(this.emailJTF.getText());
        address.setWebsite(this.siteJTF.getText());
        this.vendor.setIdentification(ident);
        this.vendor.setAddress(address);
    }

    private void salvar() {
        this.initBean();
        this.vendorBean.setVendor(this.vendor);
        this.vendorBean.salvar();
        JOptionPane.showMessageDialog(this.rootPane, "Salvo com sucesso!");
        this.dispose();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.nomeJTF = new JTextField();
        this.jLabel2 = new JLabel();
        this.cnpjJTF = new JTextField();
        this.ieJTF = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.cepJTF = new JTextField();
        this.ruaJTF = new JTextField();
        this.jLabel5 = new JLabel();
        this.bairroJTF = new JTextField();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.cidadeJTF = new JTextField();
        this.jLabel8 = new JLabel();
        this.estadoJTF = new JTextField();
        this.paisJTF = new JTextField();
        this.jLabel9 = new JLabel();
        this.telefoneJTF = new JTextField();
        this.jLabel10 = new JLabel();
        this.celularJTF = new JTextField();
        this.jLabel11 = new JLabel();
        this.siteJTF = new JTextField();
        this.jLabel12 = new JLabel();
        this.salvarJB = new JButton();
        this.razaoJTF = new JTextField();
        this.jLabel13 = new JLabel();
        this.emailJTF = new JTextField();
        this.jLabel14 = new JLabel();
        this.numeroJTF = new JTextField();
        this.jLabel15 = new JLabel();
        this.complementoJTF = new JTextField();
        this.jLabel16 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Fornecedor");
        this.setModal(true);
        this.setResizable(false);
        this.jLabel1.setText("Nome/Fantasia");
        this.jLabel2.setText("CPF/CNPJ");
        this.jLabel3.setText("RG/IE");
        this.jLabel4.setText("CEP");
        this.jLabel5.setText("Logradouro");
        this.jLabel6.setText("Bairro");
        this.jLabel7.setText("Cidade");
        this.jLabel8.setText("Estado");
        this.paisJTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VendorEditView.this.paisJTFActionPerformed(evt);
            }
        });
        this.jLabel9.setText("País");
        this.jLabel10.setText("Telefone");
        this.jLabel11.setText("Celular");
        this.jLabel12.setText("site");
        this.salvarJB.setText("Salvar");
        this.salvarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VendorEditView.this.salvarJBActionPerformed(evt);
            }
        });
        this.jLabel13.setText("Razão Social");
        this.jLabel14.setText("Email");
        this.jLabel15.setText("Número");
        this.jLabel16.setText("Complemento");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(593, 593, 593).addComponent(this.salvarJB)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.estadoJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.nomeJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cnpjJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cepJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel15).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.numeroJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.bairroJTF, -2, 197, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.telefoneJTF, -2, 199, -2)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.emailJTF, -2, 199, -2))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel9, Alignment.TRAILING).addComponent(this.jLabel13, Alignment.TRAILING).addComponent(this.jLabel3, Alignment.TRAILING).addComponent(this.jLabel5, Alignment.TRAILING).addComponent(this.jLabel16, Alignment.TRAILING).addComponent(this.jLabel7, Alignment.TRAILING).addComponent(this.jLabel11, Alignment.TRAILING).addComponent(this.jLabel12, Alignment.TRAILING)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.razaoJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.ieJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.ruaJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.complementoJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.cidadeJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.paisJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.celularJTF, Alignment.TRAILING, -2, 199, -2).addComponent(this.siteJTF, Alignment.TRAILING, -2, 199, -2)))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.nomeJTF, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.razaoJTF, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.cnpjJTF, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.ieJTF, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.cepJTF, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.ruaJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.numeroJTF, -2, -1, -2).addComponent(this.jLabel16).addComponent(this.complementoJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.bairroJTF, -2, -1, -2).addComponent(this.jLabel7).addComponent(this.cidadeJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.estadoJTF, -2, -1, -2).addComponent(this.jLabel9).addComponent(this.paisJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.celularJTF, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.telefoneJTF, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.siteJTF, -2, -1, -2).addComponent(this.jLabel14).addComponent(this.emailJTF, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.salvarJB).addContainerGap(-1, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void paisJTFActionPerformed(ActionEvent evt) {
    }

    private void salvarJBActionPerformed(ActionEvent evt) {
        this.salvar();
    }

    public static void main(String[] args) {
    }
}
