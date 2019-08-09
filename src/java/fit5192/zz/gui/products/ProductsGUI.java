/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.products;

import fit5192.zz.repository.ProductRepository;
import fit5192.zz.repository.entities.Product;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dylanz
 */
public class ProductsGUI extends JFrame {

    private final JLabel nameLabel;
    private final JLabel priceLabel;
    private final JLabel categoryLabel;

    private final JTextField nameTextField;
    private final JTextField priceTextField;
    private final JTextField categoryTextField;

    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton updateButton;
    private final JButton searchButton;

    private final JTable table;

    public ProductsGUI(String title, ProductRepository productRepository) {
        super(title);

        this.nameLabel = new JLabel("Name");
        this.priceLabel = new JLabel("Price");
        this.categoryLabel = new JLabel("Category");

        this.nameTextField = new JTextField();
        this.priceTextField = new JTextField();
        this.categoryTextField = new JTextField();

        this.addButton = new JButton();
        this.deleteButton = new JButton();
        this.updateButton = new JButton();
        this.searchButton = new JButton();

        this.table = new JTable(new DefaultTableModel(6, 0));
        this.table.getSelectionModel().addListSelectionListener((event) -> {
            try {
                if (isItemSelected()) {
                    int id = getSelectedId();
                    Product product = productRepository.searchProductById(id);
                    displayProductDetail(product);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        TableColumnModel columnModel = this.table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(50);

        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        this.getContentPane().setLayout(new BorderLayout());
        inputPanel.setLayout(new GridLayout(3, 2));
        buttonPanel.setLayout(new GridLayout(1, 4));

        /**
         * *******************************************
         */
        this.addButton.addActionListener((event) -> {
            
        });

        this.deleteButton.addActionListener((event) -> {
            
        });

        this.updateButton.addActionListener((event) -> {
            
        });

        this.searchButton.addActionListener((event) -> {
            
        });
        /**
         * *******************************************
         */

        inputPanel.add(this.nameLabel);
        inputPanel.add(this.nameTextField);
        inputPanel.add(this.priceLabel);
        inputPanel.add(this.priceTextField);
        inputPanel.add(this.categoryLabel);
        inputPanel.add(this.categoryTextField);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(searchButton);

        this.getContentPane().add(inputPanel, BorderLayout.NORTH);
        this.getContentPane().add(new JScrollPane(this.table), BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public boolean isItemSelected() {
        return (this.table.getSelectedRow() >= 0);
    }

    public int getSelectedId() {
        int i = this.table.getSelectedRow();
        String id = this.table.getValueAt(i, 0).toString();
        return Integer.parseInt(id);
    }

    public void displayProductDetail(Product product) {
        this.nameTextField.setText(product.getName());
        this.priceTextField.setText(String.valueOf(product.getPrice()));
        this.categoryTextField.setText(String.valueOf(product.getCategory()));
    }
}
