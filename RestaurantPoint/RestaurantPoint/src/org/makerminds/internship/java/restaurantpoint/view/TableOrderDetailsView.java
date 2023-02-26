package org.makerminds.internship.java.restaurantpoint.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.makerminds.internship.java.restaurantpoint.controller.MenuManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Menu;
import org.makerminds.internship.java.restaurantpoint.model.MenuItem;
import org.makerminds.internship.java.restaurantpoint.model.Products;


public class TableOrderDetailsView {

	private final static double vatValue=0.18;
	private static DefaultTableModel menuItemTableModel = new DefaultTableModel();
	private static DefaultTableModel orderItemTableModel = new DefaultTableModel();
	private static JTable orderTable = new JTable(orderItemTableModel);
	private static JTable menuJTable = new JTable(menuItemTableModel);
	private static JLabel lblNewLabel = new JLabel("TABLE ORDER DETAILS");
	private static JLabel orderOverviewLabel = new JLabel("ORDER OVERVIEW");

	private static JComboBox<Menu> listMenuComboBox = new JComboBox<>();
	private static MenuManagerController managerController = new MenuManagerController();
	private static List<Menu> list = managerController.getMenuListWaiter();
	private static String[][] menuItemListMultidimensionalArray;
	private static MenuItem menu = new MenuItem();
	private static List<List<Products>> listOfLists = menu.getListOfListsOfProductsList();
	private static List<Products> list1 = listOfLists.get(0);
	private static List<Products> list2 = listOfLists.get(1);
	private static JButton addButton = new JButton("ADD");
	private static JButton deleteButton = new JButton("DELETE");
	private static JButton invoiceButton = new JButton("PRINT INVOICE");
	private static JButton orderButton=new JButton("ORDER");
	private static JLabel label=new JLabel("Sub-Total:");
	private static JLabel label1=new JLabel("VAT(18%):");
	private static JLabel label2=new JLabel("TOTAL:");
	private static List<Products> listOfSelectedProducts = new ArrayList<>();
	private static JPanel contentPanel;
	public static JPanel createContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266, 0, 904, 482);

		lblNewLabel.setBounds(59, 18, 803, 32);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setOpaque(true);
		contentPanel.add(lblNewLabel);

		orderOverviewLabel.setBounds(450, 100, 320, 25);
		orderOverviewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderOverviewLabel.setForeground(Color.WHITE);
		orderOverviewLabel.setBackground(new Color(51, 153, 255));
		orderOverviewLabel.setOpaque(true);
		contentPanel.add(orderOverviewLabel);
		
	label.setBounds(550, 250, 180, 25);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.BLACK);
		label.setOpaque(true);
	

		
		contentPanel.add(label);
		
		label1.setBounds(550, 285, 180, 25);
		label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
	label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		contentPanel.add(label1);
		
		label2.setBounds(550, 320, 180, 25);
		label2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
	label2.setForeground(Color.BLACK);
		label2.setOpaque(true);
		contentPanel.add(label2);
		
		contentPanel.add(orderButton);
		orderButton.setBounds(575, 355, 130, 30);
		orderButton.setBackground((new Color(51, 153, 255)));
		orderButton.setForeground(Color.WHITE);
		orderButtonFunction();

		

		TitledBorder titledBorder = BorderFactory.createTitledBorder("TM");

		contentPanel.setBorder(titledBorder);

		JPanel restLiJPanel = new JPanel();
		restLiJPanel.setLayout(null);
		restLiJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		restLiJPanel.setBounds(40, 60, 320, 90);

		TitledBorder titledBorder2 = BorderFactory.createTitledBorder("MENU SELECTION");
		titledBorder2.setTitleColor(Color.BLACK);
		titledBorder2.setTitleFont(null);
		restLiJPanel.setBorder(titledBorder2);

		listMenuComboBox.setBounds(62, 30, 180, 27);
		listMenuComboBox.setModel(new DefaultComboBoxModel<Menu>(list.toArray(new Menu[0])));
		listMenuComboBox.setSelectedItem(null);

		listMenuComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuJTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int clicked = 0;
						int i = menuJTable.getSelectedRow();
						if(i != -1) {
							clicked++;
							listOfSelectedProducts.add(new Products(menuJTable.getValueAt(i, 0).toString(), Double.valueOf(clicked),
									Double.valueOf(menuJTable.getValueAt(i, 1).toString())));
							
							
						}
					}
				});
				prepareMenuDataTable();
				
				
			}
		});
		
	label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double d=calculateOrder();
				String s=Double.toString(d);
				label.setText(label.getText()+" "+s+" $");
				
			}
		});
	label1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			double d=calculateWithVat();
			String s=Double.toString(d);
			label1.setText(label1.getText()+" "+s+" $");
			
		}
	});
	
	label2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			double d=sumOfOrder();
			String s=Double.toString(d);
			label2.setText(label2.getText()+" "+s+" $");
			
		}
	});
	
		restLiJPanel.add(listMenuComboBox);

		contentPanel.add(addButton);
		addButton.setBounds(20, 320, 100, 30);
		addButton.setBackground((new Color(51, 153, 255)));
		addButton.setForeground(Color.WHITE);
		addButtonFunction();

		contentPanel.add(deleteButton);
		deleteButton.setBounds(140, 320, 100, 30);
		deleteButton.setBackground((new Color(51, 153, 255)));
		deleteButton.setForeground(Color.WHITE);
		deleteButtonFunction();

		contentPanel.add(invoiceButton);
		invoiceButton.setBounds(260, 320, 130, 30);
		invoiceButton.setBackground((new Color(51, 153, 255)));
		invoiceButton.setForeground(Color.WHITE);
		invoiceButtonFunction();

		contentPanel.add(restLiJPanel);

		TitledBorder titledBorder4 = BorderFactory.createTitledBorder("");
		titledBorder4.setTitleColor(Color.BLACK);
		titledBorder4.setTitleFont(null);
		JScrollPane jScrollPane = new JScrollPane(menuJTable);
		jScrollPane.setBounds(40, 158, 320, 102);
		jScrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder4));

		contentPanel.add(jScrollPane);

		prepareOrderOverview();

		TitledBorder titledBorder5 = BorderFactory.createTitledBorder("");
		titledBorder5.setTitleColor(Color.BLACK);
		titledBorder5.setTitleFont(null);
		JScrollPane jScrollPane1 = new JScrollPane(orderTable);
		jScrollPane1.setBounds(450, 128, 320, 102);
		jScrollPane1.setBorder(BorderFactory.createTitledBorder(titledBorder5));

		contentPanel.add(jScrollPane1);

		return contentPanel;
	}


	private static void prepareMenuDataTable() {
		String[] tableHeader = { "PRODUCT", "PRICE" };
		String[][] menuItemListMultidimensionalArray = createMenuArray();
		menuItemTableModel.setDataVector(menuItemListMultidimensionalArray, tableHeader);
	}

	private static String[][] createMenuArray() {
		int j = listMenuComboBox.getSelectedIndex();
		if (j == 0) {
			menuItemListMultidimensionalArray = new String[list1.size()][2];
			int i = 0;
			for (Products product : list1) {
				menuItemListMultidimensionalArray[i][0] = product.getName();
				menuItemListMultidimensionalArray[i][1] = Double.toString(product.getPrice());
				i++;
			}
		}
		if (j == 1) {
			int i = 0;
			menuItemListMultidimensionalArray = new String[list2.size()][2];
			for (Products product : list2) {
				menuItemListMultidimensionalArray[i][0] = product.getName();
				menuItemListMultidimensionalArray[i][1] = Double.toString(product.getPrice());
				i++;
			}
		}
		return menuItemListMultidimensionalArray;
	}

	

	private static void prepareOrderOverview() {
		String[] tableHeader = { "PRODUCT", "QUANTITY", "PRICE" };
		String[][] orderMultiDimensionalArray = createOrderArray();
		orderItemTableModel.setDataVector(orderMultiDimensionalArray, tableHeader);
	}

	private static String[][] createOrderArray() {
		listOfSelectedProducts = getListOfSelectedProductsFromTable();
		//Iterator<Products> iterator = listOfSelectedProducts.iterator();
		String[][] multidimensionalArray = new String[listOfSelectedProducts.size()][3];
		for(Products products : listOfSelectedProducts) {
			multidimensionalArray[listOfSelectedProducts.indexOf(products)][0] = products.getName();
			multidimensionalArray[listOfSelectedProducts.indexOf(products)][1] = Double.toString(products.getQuantity());
			multidimensionalArray[listOfSelectedProducts.indexOf(products)][2] = Double.toString(products.getPrice());
		}
		return multidimensionalArray;
	}

	public static List<Products> getListOfSelectedProductsFromTable() {
		return listOfSelectedProducts;
	}
	private static void addButtonFunction() {
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				prepareOrderOverview();
			}
		});
	}
	private static void invoiceButtonFunction() {
		// TODO Auto-generated method stub

	}

	private static void deleteButtonFunction() {
deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int i=orderTable.getSelectedRow();
				listOfSelectedProducts.remove(i);
				orderItemTableModel.removeRow(i);
				JOptionPane.showMessageDialog(null,"ITEM DELETED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			}
});
}
	private static void orderButtonFunction() {
		// TODO Auto-generated method stub
orderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"ITEMS ORDERED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			}
});
	}

	
	private static double calculateOrder() {
		double sum=0;
		for(int i=0;i<orderTable.getRowCount();i++) {
			double value=Double.parseDouble((String) orderTable.getValueAt(i, 2));
			sum+=value;
			
		}
		return sum;
	}
	
	private static double calculateWithVat() {
	double valueOfSum=calculateOrder();
	
	double valueOfSumWithVAT=valueOfSum*vatValue;
	return valueOfSumWithVAT;
	
	}
	
	private static double sumOfOrder() {
		double valueOfSum=calculateOrder();
		double sumWithVAT=calculateWithVat();
		
		double totalSum=valueOfSum+sumWithVAT;
		return totalSum;
		
	}
}