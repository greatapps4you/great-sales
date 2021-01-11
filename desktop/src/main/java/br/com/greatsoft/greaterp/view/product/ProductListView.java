package br.com.greatsoft.greaterp.view.product;

import br.com.greatsoft.greaterp.common.FileUtil;
import br.com.greatsoft.greaterp.controller.bean.ProductBean;
import us.greatapps4you.greatsales.entities.inventory.Product;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
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

public class ProductListView extends JDialog {
    private ProductListTM modelo;
    private ProductBean productBean;
    private JButton atualizarTabelaJB;
    private JButton excluirJB;
    private JScrollPane jScrollPane1;
    private JButton novoJB;
    private JTable productJT;

    public ProductListView(Frame parent, boolean modal) {
        super(parent, modal);
        this.inicializarModelo();
        this.initComponents();
        this.addDuploClickTabela();
    }

    private void editar() {
        int linha = this.productJT.getSelectedRow();
        Product produto = (Product)this.modelo.getValueAt(linha, 1);
        //ProductEditView editDlg = new ProductEditView(new JFrame(), true, produto);
        //editDlg.setVisible(true);
    }

    private void novo() {
        //ProductEditView editDlg = new ProductEditView(new JFrame(), true, (Product)null);
        //editDlg.setVisible(true);
    }

    private void excluir() {
        int option = JOptionPane.showConfirmDialog(this.rootPane, "Tem certeza que deseja excluir o produto selecionado?");
        if (option == 0) {
            try {
                int linha = this.productJT.getSelectedRow();
                Product productDelete = (Product)this.modelo.getValueAt(linha, 1);
                ProductBean productDelBean = new ProductBean();
                if (productDelBean.excluir(productDelete)) {
                    this.atualizarTabela();
                    JOptionPane.showMessageDialog(this.rootPane, "Excluído com sucesso");
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Registro não pode ser excluído\npois está sendo referenciado em outra tabela!");
                }
            } catch (HeadlessException var5) {
                System.out.println("Tentou excluir registro sem selecionar linha.");
                FileUtil.log(var5);
            }
        }

    }

    private void atualizarTabela() {
        this.inicializarModelo();
        this.modelo.fireTableDataChanged();
        this.productJT.setModel(this.modelo);
    }

    private void addDuploClickTabela() {
        this.productJT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ProductListView.this.editar();
                }

            }
        });
    }

    private void inicializarModelo() {
        this.productBean = new ProductBean();
        List<Product> products = this.productBean.getLista();
        if (products != null) {
            this.modelo = new ProductListTM(products);
        }

    }

    private void initComponents() {
        this.novoJB = new JButton();
        this.excluirJB = new JButton();
        this.atualizarTabelaJB = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.productJT = new JTable();
        this.setDefaultCloseOperation(2);
        this.setTitle("Lista de Produtos");
        this.novoJB.setText("Novo");
        this.novoJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductListView.this.novoJBActionPerformed(evt);
            }
        });
        this.excluirJB.setText("Excluir");
        this.excluirJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductListView.this.excluirJBActionPerformed(evt);
            }
        });
        this.atualizarTabelaJB.setText("Atualizar Tabela");
        this.atualizarTabelaJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductListView.this.atualizarTabelaJBActionPerformed(evt);
            }
        });
        this.productJT.setModel(this.modelo);
        this.jScrollPane1.setViewportView(this.productJT);
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
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var5) {
            FileUtil.log(var5);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductListView dialog = new ProductListView(new JFrame(), true);
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
