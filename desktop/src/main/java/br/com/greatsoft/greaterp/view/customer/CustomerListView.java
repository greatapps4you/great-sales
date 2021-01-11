package br.com.greatsoft.greaterp.view.customer;

import br.com.greatsoft.greaterp.controller.bean.CustomerBean;
import us.greatapps4you.greatsales.entities.sale.Customer;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class CustomerListView extends JDialog {
    private CustomerListTM modelo;
    private CustomerBean customerBean;
    private JButton atualizarTabelaJB;
    private JTable customerJT;
    private JButton excluirJB;
    private JScrollPane jScrollPane1;
    private JButton novoJB;

    public CustomerListView(Frame parent, boolean modal) {
        super(parent, modal);
        this.inicializarModelo();
        this.initComponents();
        this.addDuploClickTabela();
    }

    private void editar() {
        int linha = this.customerJT.getSelectedRow();
        long id = (Long)this.modelo.getValueAt(linha, 7);
        CustomerEditView editDlg = new CustomerEditView(new JFrame(), true, id);
        editDlg.setVisible(true);
    }

    private void novo() {
        CustomerEditView editDlg = new CustomerEditView(new JFrame(), false, 0L);
        editDlg.setVisible(true);
    }

    private void excluir() {
        int option = JOptionPane.showConfirmDialog(this.rootPane, "Tem certeza que deseja excluir o cliente selecionado?");
        if (option == 0) {
            try {
                int linha = this.customerJT.getSelectedRow();
                long id = (Long)this.modelo.getValueAt(linha, 7);
                CustomerBean vendorDelBean = new CustomerBean();
                //FIXME: Review this code
                //Customer customerDelete = (Customer)(new CustomerRn()).carregar("id", id);
                //FIXME: Review this code
                /*if (vendorDelBean.excluir(customerDelete)) {
                    this.atualizarTabela();
                    JOptionPane.showMessageDialog(this.rootPane, "Excluído com sucesso");
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Registro não pode ser excluído\npois está sendo referenciado em outra tabela!");
                }*/
            } catch (Exception var7) {
                System.out.println("Tentou excluir registro sem selecionar linha.");
            }
        }

    }

    private void atualizarTabela() {
        this.inicializarModelo();
        this.modelo.fireTableDataChanged();
        this.customerJT.setModel(this.modelo);
    }

    private void addDuploClickTabela() {
        this.customerJT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    CustomerListView.this.editar();
                }

            }
        });
    }

    private void inicializarModelo() {
        this.customerBean = new CustomerBean();
        List<Customer> customers = this.customerBean.getLista();
        if (customers != null) {
            this.modelo = new CustomerListTM(customers);
        }

    }

    private void initComponents() {
        this.novoJB = new JButton();
        this.excluirJB = new JButton();
        this.atualizarTabelaJB = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.customerJT = new JTable();
        this.setDefaultCloseOperation(2);
        this.setTitle("Lista de Clientes");
        this.novoJB.setText("Novo");
        this.novoJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerListView.this.novoJBActionPerformed(evt);
            }
        });
        this.excluirJB.setText("Excluir");
        this.excluirJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerListView.this.excluirJBActionPerformed(evt);
            }
        });
        this.atualizarTabelaJB.setText("Atuallizar Tabela");
        this.atualizarTabelaJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerListView.this.atualizarTabelaJBActionPerformed(evt);
            }
        });
        this.customerJT.setModel(this.modelo);
        this.jScrollPane1.setViewportView(this.customerJT);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.novoJB).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.excluirJB).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.atualizarTabelaJB).addContainerGap(-1, 32767)).addComponent(this.jScrollPane1, -1, 796, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.novoJB).addComponent(this.excluirJB).addComponent(this.atualizarTabelaJB)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 367, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void novoJBActionPerformed(ActionEvent evt) {
        this.novo();
    }

    private void excluirJBActionPerformed(ActionEvent evt) {
        this.excluir();
    }

    private void atualizarTabelaJBActionPerformed(ActionEvent evt) {
        this.atualizarTabela();
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
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerListView dialog = new CustomerListView(new JFrame(), true);
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
