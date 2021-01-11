/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.sales;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
import us.greatapps4you.greatsales.desktop.common.MailSender;
import us.greatapps4you.greatsales.entities.sale.Salesman;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class SalesmanView extends JDialog {
    private Salesman salesman;
    private JTextField celular;
    private JPasswordField confirma;
    private JTextField email;
    private JTextField fone;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField nome;
    private JButton salvarJTF;
    private JPasswordField senha;

    public SalesmanView(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.initFields();
    }

    private void initFields() {
        try {
            //FIXME: Review this code
            //this.salesman = (Salesman)(new SalesmanRn()).carregar("id", 1L);
            /*this.nome.setText(this.salesman.getName());
            this.email.setText(this.salesman.getEmail());
            this.senha.setText(this.salesman.getPassword());
            this.fone.setText(this.salesman.getPhone());
            this.celular.setText(this.salesman.getCellPhone());*/
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void initBean() {
        /*this.salesman = new Salesman();
        this.salesman.setEmail(this.email.getText().trim());
        this.salesman.setName(this.nome.getText());
        this.salesman.setPassword(new String(this.senha.getPassword()));
        this.salesman.setPhone(this.fone.getText());
        this.salesman.setCellPhone(this.celular.getText());*/
    }

    private boolean areEmptyFields() {
        return this.nome.getText().isEmpty() || this.email.getText().isEmpty() || this.senha.getText().isEmpty();
    }

    private boolean validateCredentials() {
        if (!this.areEmptyFields()) {
            if (Arrays.equals(this.senha.getPassword(), this.confirma.getPassword())) {
                if (this.validateEmail(this.email.getText().trim())) {
                    String sender = this.email.getText();
                    String password = this.senha.getText();
                    String recipient = this.email.getText();
                    String subject = "Email de Teste do Sistema Gerenciador de Vendas";
                    String messageText = "Se você recebeu este email suas credenciais foram validadas com sucesso! Bom uso do sistema!";

                    try {
                        return MailSender.send(sender, password, recipient, subject, messageText);
                    } catch (Exception var7) {
                        FileUtil.log(var7);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Somente Gmail é suportado!");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this.rootPane, "Senhas não conferem!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "Os campos nome, email e senha são obrigatórios");
            return false;
        }
    }

    private boolean validateEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    private void salvar() {
        if (!this.areEmptyFields() && this.validateCredentials()) {
            this.initBean();
            //FIXME: Review this code
            //(new SalesmanRn()).salvar(this.salesman);
            JOptionPane.showMessageDialog(this.rootPane, "Salvo com sucesso!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "Dados Inválidos!");
        }

    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.nome = new JTextField();
        this.jLabel2 = new JLabel();
        this.email = new JTextField();
        this.jLabel3 = new JLabel();
        this.salvarJTF = new JButton();
        this.jLabel4 = new JLabel();
        this.fone = new JTextField();
        this.celular = new JTextField();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.senha = new JPasswordField();
        this.confirma = new JPasswordField();
        this.setDefaultCloseOperation(2);
        this.jLabel1.setText("Nome");
        this.jLabel2.setText("Email");
        this.jLabel3.setText("Senha");
        this.salvarJTF.setText("Salvar");
        this.salvarJTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesmanView.this.salvarJTFActionPerformed(evt);
            }
        });
        this.jLabel4.setText("Fone");
        this.jLabel5.setText("Cel.");
        this.jLabel6.setText("Confirma");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel4, Alignment.TRAILING).addComponent(this.jLabel5, Alignment.TRAILING).addComponent(this.jLabel1, Alignment.TRAILING).addComponent(this.jLabel2, Alignment.TRAILING).addComponent(this.jLabel6, Alignment.TRAILING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel3).addGap(3, 3, 3))).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.senha, Alignment.LEADING, -1, 424, 32767).addComponent(this.confirma, Alignment.LEADING).addComponent(this.nome, Alignment.LEADING).addComponent(this.celular, Alignment.LEADING).addComponent(this.fone, Alignment.LEADING).addComponent(this.email, Alignment.LEADING)).addContainerGap(-1, 32767)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.salvarJTF).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.email, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.senha, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.confirma, -2, -1, -2).addComponent(this.jLabel6)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.nome, -2, -1, -2).addComponent(this.jLabel1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.fone, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.celular, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.salvarJTF).addContainerGap()));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void salvarJTFActionPerformed(ActionEvent evt) {
        this.salvar();
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var5) {
            FileUtil.log(var5);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesmanView dialog = new SalesmanView(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
