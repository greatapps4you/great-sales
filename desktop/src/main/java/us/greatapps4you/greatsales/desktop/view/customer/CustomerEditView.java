/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.customer;

import us.greatapps4you.greatsales.desktop.controller.bean.CustomerBean;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import us.greatapps4you.greatsales.entities.sale.Customer;

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

public class CustomerEditView extends JDialog {
    CustomerBean customerBean;
    Customer customer;
    private JTextField bairroJTF;
    private JTextField celularJTF;
    private JTextField cepJTF;
    private JTextField cidadeJTF;
    private JTextField cnpjJTF;
    private JTextField complementoJTF;
    private JTextField emailJTF;
    private JTextField endCobrancaJTF;
    private JTextField estadoJTF;
    private JTextField ieJTF;
    private JTextField inscMunJTF;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
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

    public CustomerEditView(Frame parent, boolean modal, long customerId) {
        super(parent, modal);
        this.initComponents();
        this.customerBean = new CustomerBean();
        if (customerId > 0L) {
            //this.customer = this.customerBean.getCustomer(customerId);
            this.initFields();
        } else {
            this.customer = new Customer();
        }

    }

    private void initFields() {
        /*this.nomeJTF.setText(this.customer.getIdentification().getNomeFantasia());
        this.razaoJTF.setText(this.customer.getIdentification().getRazaoSocial());
        this.cnpjJTF.setText(this.customer.getIdentification().getCnpj());
        this.ieJTF.setText(this.customer.getIdentification().getInscEst());
        this.inscMunJTF.setText(this.customer.getIdentification().getInscMun());
   */     this.cepJTF.setText(this.customer.getAddress().getZip());
        this.ruaJTF.setText(this.customer.getAddress().getStreet());
        this.numeroJTF.setText(this.customer.getAddress().getNumber());
        this.complementoJTF.setText(this.customer.getAddress().getComplement());
        this.bairroJTF.setText(this.customer.getAddress().getNeighborhood());
        this.cidadeJTF.setText(this.customer.getAddress().getCity());
        this.estadoJTF.setText(this.customer.getAddress().getCountryState());
        this.paisJTF.setText(this.customer.getAddress().getCountry());
        this.telefoneJTF.setText(this.customer.getAddress().getPhone());
        this.celularJTF.setText(this.customer.getAddress().getCellPhone());
        this.emailJTF.setText(this.customer.getAddress().getEmail());
        this.siteJTF.setText(this.customer.getAddress().getWebsite());
       // this.endCobrancaJTF.setText(this.customer.getEndCobranca());
    }

    private void initBean() {
        Identification ident = new Identification();
      /*  ident.setNomeFantasia(this.nomeJTF.getText());
        ident.setRazaoSocial(this.razaoJTF.getText());
        ident.setCnpj(this.cnpjJTF.getText());
        ident.setInscEst(this.ieJTF.getText());
        ident.setInscMun(this.inscMunJTF.getText());
*/        Address address = new Address();
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
        this.customer.setIdentification(ident);
        this.customer.setAddress(address);
        //this.customer.setEndCobranca(this.endCobrancaJTF.getText());
    }

    private void salvar() {
        this.initBean();
        //this.customerBean.setCustomer(this.customer);
        this.customerBean.salvar();
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
        this.inscMunJTF = new JTextField();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.endCobrancaJTF = new JTextField();
        this.setTitle("Cliente");
        this.setModal(true);
        this.setResizable(false);
        this.jLabel1.setText("Nome/Fantasia");
        this.jLabel2.setText("CPF/CNPJ");
        this.jLabel3.setText("RG/IE");
        this.jLabel4.setText("CEP");
        this.jLabel5.setText("Logradouro");
        this.jLabel6.setText("Bairro");
        this.jLabel7.setText("Cidade");
        this.jLabel8.setText("UF");
        this.paisJTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerEditView.this.paisJTFActionPerformed(evt);
            }
        });
        this.jLabel9.setText("País");
        this.jLabel10.setText("Telefone");
        this.jLabel11.setText("Celular");
        this.jLabel12.setText("site");
        this.salvarJB.setText("Salvar");
        this.salvarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerEditView.this.salvarJBActionPerformed(evt);
            }
        });
        this.jLabel13.setText("Razão Social");
        this.jLabel14.setText("Email (DANFE)");
        this.jLabel15.setText("Número");
        this.jLabel16.setText("Complemento");
        this.inscMunJTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerEditView.this.inscMunJTFActionPerformed(evt);
            }
        });
        this.jLabel17.setText("Insc. Mun.");
        this.jLabel18.setText("End. Cobrança");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, Alignment.TRAILING).addComponent(this.jLabel2, Alignment.TRAILING).addComponent(this.jLabel13, Alignment.TRAILING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel5).addGap(12, 12, 12))).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel17, Alignment.TRAILING).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel7).addComponent(this.jLabel16)).addComponent(this.jLabel9, Alignment.TRAILING).addComponent(this.jLabel11, Alignment.TRAILING).addComponent(this.jLabel12, Alignment.TRAILING).addComponent(this.jLabel18, Alignment.TRAILING)).addPreferredGap(ComponentPlacement.RELATED))).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.endCobrancaJTF).addGroup(layout.createSequentialGroup().addComponent(this.ruaJTF, -2, 361, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel15).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.numeroJTF)).addGroup(layout.createSequentialGroup().addComponent(this.complementoJTF, -2, 199, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel6).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.bairroJTF, -2, 259, -2)).addGroup(layout.createSequentialGroup().addComponent(this.cidadeJTF).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel8).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.estadoJTF, -2, 49, -2)).addComponent(this.nomeJTF).addComponent(this.razaoJTF).addComponent(this.siteJTF).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.paisJTF, -2, 243, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel10).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.telefoneJTF, -2, 199, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.cnpjJTF, -2, 230, -2).addComponent(this.inscMunJTF, -2, 230, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel4)).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.cepJTF, -2, 240, -2)).addGroup(layout.createSequentialGroup().addComponent(this.celularJTF, -2, 173, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel14).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.emailJTF, -2, 243, -2)))).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.ieJTF, Alignment.TRAILING, -2, 240, -2).addComponent(this.salvarJB, Alignment.TRAILING)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.nomeJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.razaoJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.cnpjJTF, -2, -1, -2).addComponent(this.ieJTF, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.inscMunJTF, -2, -1, -2).addComponent(this.cepJTF, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.ruaJTF, -2, -1, -2).addComponent(this.jLabel15).addComponent(this.numeroJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.complementoJTF, -2, -1, -2).addComponent(this.jLabel6).addComponent(this.bairroJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.cidadeJTF, -2, -1, -2).addComponent(this.jLabel8).addComponent(this.estadoJTF, -2, -1, -2)).addGap(12, 12, 12).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.paisJTF, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.telefoneJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.celularJTF, -2, -1, -2).addComponent(this.jLabel14).addComponent(this.emailJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.siteJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.endCobrancaJTF, -2, -1, -2).addComponent(this.jLabel18)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.salvarJB).addContainerGap(-1, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void paisJTFActionPerformed(ActionEvent evt) {
    }

    private void salvarJBActionPerformed(ActionEvent evt) {
        this.salvar();
    }

    private void inscMunJTFActionPerformed(ActionEvent evt) {
    }

    public static void main(String[] args) {
    }
}
