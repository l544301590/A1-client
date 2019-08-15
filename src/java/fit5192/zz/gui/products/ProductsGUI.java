/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.gui.products;

import fit5192.zz.gui.userinfo.UserInfoGUI;
import fit5192.zz.repository.ProductRepository;
import fit5192.zz.repository.UserRepository;
import fit5192.zz.repository.entities.Product;
import fit5192.zz.repository.entities.User_;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
 * @author Zheng Ru
 */
public class ProductsGUI extends JFrame {
    private static final String[] TABLE_COLUMNS = {"ID", "Category", "Name", "Price", "Area"};
    private ProductRepository productRepository;

    private final JLabel nameLabel;
    private final JLabel priceLabel;
    private final JLabel categoryLabel;

    private final JTextField nameTextField;
    private final JTextField priceTextField;
    private final JTextField categoryTextField;

    private final JButton userInfoButton;
    private final JButton searchButton;

    private final JTable table;
    
    
    public ProductsGUI(String title,ProductRepository productRepository,User_ user,UserRepository userRepository) {
        super(title);

        this.nameLabel = new JLabel("Name");
        this.priceLabel = new JLabel("Price");
        this.categoryLabel = new JLabel("Category");

        this.nameTextField = new JTextField();
        this.priceTextField = new JTextField();
        this.categoryTextField = new JTextField();

        this.userInfoButton= new JButton("User's Infomation");
        this.searchButton = new JButton("Search");

        this.table = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.productRepository = productRepository;
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
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnMode = this.table.getColumnModel();
        
        columnMode.getColumn(0).setPreferredWidth(100);
        columnMode.getColumn(1).setPreferredWidth(100);
        columnMode.getColumn(2).setPreferredWidth(100);
        columnMode.getColumn(3).setPreferredWidth(100);
        columnMode.getColumn(4).setPreferredWidth(100);
        //columnModel.getColumn(5).setPreferredWidth(50);
       
        
        
        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        this.getContentPane().setLayout(new BorderLayout());
        inputPanel.setLayout(new GridLayout(3, 2));
        buttonPanel.setLayout(new GridLayout(1, 2));

      

        inputPanel.add(this.nameLabel);
        inputPanel.add(this.nameTextField);
        inputPanel.add(this.priceLabel);
        inputPanel.add(this.priceTextField);
        inputPanel.add(this.categoryLabel);
        inputPanel.add(this.categoryTextField);

        buttonPanel.add(userInfoButton);
        buttonPanel.add(searchButton);

          /**
         * *******************************************
         */
        this.userInfoButton.addActionListener((ActionEvent event) -> {
           new UserInfoGUI("register", userRepository, user);
            //this.dispose();
        });
        this.searchButton.addActionListener((event) -> {
            searchProducts();            
        });
        /**
         * *******************************************
         */
        this.getContentPane().add(inputPanel, BorderLayout.NORTH);
        this.getContentPane().add(new JScrollPane(this.table), BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setVisible(true);
    }


    public JButton getUserInfoButton() {
        return userInfoButton;
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

    private void searchProducts() {
        this.clearTable();
        //this.clearInput();
        //System.out.println("有输出吗:");
        String name = this.nameTextField.getText();
        String price = this.priceTextField.getText();
        String caregory = this.categoryTextField.getText();
        Product product = new Product();
        if (name.length() > 0) {
            product.setName(name);
        }
        if (caregory.length() > 0) {
            product.setCategory(Integer.parseInt(caregory));
        }
        if (price.length() > 0) {
            product.setPrice(Float.parseFloat(price));
        }
        List<Product> products = productRepository.searchProductByAnyAttribute(product);
        //System.out.println("有输出吗:"+ products.toString());
        for(Product p:products){
            ((DefaultTableModel)this.table.getModel()).addRow(new Object[]{p.getId(),
                                                                           p.getCategory(),
                                                                           p.getName(), 
                                                                           p.getPrice(), 
                                                                           p.getArea()});
        }
    }
    public void clearTable() {     
        int numberOfRow = this.table.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }
}
