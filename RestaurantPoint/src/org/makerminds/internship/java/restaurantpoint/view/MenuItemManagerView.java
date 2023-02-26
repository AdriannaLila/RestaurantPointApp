package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.makerminds.internship.java.restaurantpoint.controller.MenuManagerController;
import org.makerminds.internship.java.restaurantpoint.controller.RestaurantManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Menu;
import org.makerminds.internship.java.restaurantpoint.model.MenuItem;
import org.makerminds.internship.java.restaurantpoint.model.Products;
import org.makerminds.internship.java.restaurantpoint.model.Restaurant;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class MenuItemManagerView {

	private JFrame frame;
	private static JButton addButton=new JButton("ADD");
	private static JButton updateButton=new JButton("UPDATE");
	private static JButton deleteButton=new JButton("DELETE");
	private static DefaultTableModel menuItemTableModel=new DefaultTableModel();
	private static JTable restaurantTable =new JTable(menuItemTableModel);
	private static MenuItem menu=new MenuItem();
	//private static HashMap<Integer,Products> menuItems=menu.getMenuItems();
	private static List<Products>menuItems=menu.getList();
	private static 	JTextField textField=new JTextField();
	private static 	JTextField textField2=new JTextField();
	private static 	JTextField textField3=new JTextField();
	private static JComboBox<Restaurant> listComboBox=new JComboBox<>();
	private static RestaurantManagerController restaurantManagerController=new RestaurantManagerController();
	private static List<Restaurant>listOfRestaurants=restaurantManagerController.getListOfRestaurants();
	private static JComboBox<Menu> listMenuComboBox=new JComboBox<>();
	private static MenuManagerController managerController=new MenuManagerController();
	private static List<Menu>listOfMenus=managerController.getListOfMenus();
	private final static JLabel lblNewLabel = new JLabel("MENU ITEM MANAGER");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuItemManagerView window = new MenuItemManagerView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuItemManagerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 984, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPanel=createContentPanel();
		frame.getContentPane().add(contentPanel);
	}

	private static JPanel createContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266,0,704,582);
		 
		lblNewLabel.setBounds(59, 18, 803, 32);
		 lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBackground(new Color(51,153,255));
		 lblNewLabel.setOpaque(true);
		 contentPanel.add(lblNewLabel);
		 
		
		TitledBorder titledBorder=BorderFactory.createTitledBorder("MENU MANAGER");
	
		contentPanel.setBorder(titledBorder);
		
		addButton.setBounds(20,320,100,30);
		
		updateButton.setBounds(140,320,100,30);
		deleteButton.setBounds(260,320,100,30);
	
		JPanel  managPanel=new JPanel();
		managPanel.setLayout(null);
		managPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		managPanel.setBounds(10,80,386,380);
		TitledBorder titledBorder1=BorderFactory.createTitledBorder("MANAGEMENT PANEL");
		managPanel.setBorder(titledBorder1);
		
		managPanel.add(addButton);
		addButton.setBackground((new Color(51,153,255)));
		addButton.setForeground(Color.WHITE);
		addButtonFunction();
		
		managPanel.add(updateButton);
		updateButton.setBackground((new Color(51,153,255)));
		updateButton.setForeground(Color.WHITE);
		updateButtonFunction();
		
		managPanel.add(deleteButton);
		deleteButton.setBackground((new Color(51,153,255)));
		deleteButton.setForeground(Color.WHITE);
		deleteButtonFunction();
		
		JLabel label=new JLabel("Menu Item ID");
		label.setBounds(38,40,200,30);
		managPanel.add(label);
		
	     textField.setBounds(38, 68, 200, 30);
		managPanel.add(textField);
		
		JLabel label2=new JLabel("Menu Item Name");
		label2.setBounds(38,100,200,30);
		managPanel.add(label2);
		 textField2.setBounds(38, 125, 200, 30);
			managPanel.add(textField2);
		
		
			JLabel label3=new JLabel("Menu Item Price");
			label3.setBounds(38,154,200,30);
			managPanel.add(label3);
			 textField3.setBounds(38, 177, 200, 30);
				managPanel.add(textField3);
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Meal");
				rdbtnNewRadioButton.setBounds(38, 256, 111, 23);
				managPanel.add(rdbtnNewRadioButton);
				
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Drink");
				rdbtnNewRadioButton_1.setBounds(38, 288, 111, 23);
				managPanel.add(rdbtnNewRadioButton_1);
			
				restaurantTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						menuItemTableModel=(DefaultTableModel)restaurantTable.getModel();
						int selectedRowIndex=restaurantTable.getSelectedRow();
						textField.setText(menuItemTableModel.getValueAt(selectedRowIndex, 0).toString());
						textField2.setText(menuItemTableModel.getValueAt(selectedRowIndex, 1).toString());
						textField3.setText(menuItemTableModel.getValueAt(selectedRowIndex, 2).toString());
					}
				});
			
				
		contentPanel.add(managPanel);
		  JPanel restLiJPanel=new JPanel();
			 restLiJPanel.setLayout(null);
			 restLiJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			 restLiJPanel.setBounds(510,80,380,110);

		TitledBorder titledBorder2=BorderFactory.createTitledBorder("RESTAURANT SELECTION");
			 titledBorder2.setTitleColor(Color.BLACK);
			 titledBorder2.setTitleFont(null);
			 restLiJPanel.setBorder(titledBorder2);
			
			 
				listComboBox.setModel(new DefaultComboBoxModel<Restaurant>(listOfRestaurants.toArray(new Restaurant[0])));
				listComboBox.setSelectedItem(null);
			 listComboBox.setBounds(98, 46, 180, 27);
			 restLiJPanel.add(listComboBox);
			
			 contentPanel.add(restLiJPanel);
		
			 JPanel menuListJPanel=new JPanel();
			 menuListJPanel.setLayout(null);
			 menuListJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			 menuListJPanel.setBounds(510,200,380,110);
			 
			 TitledBorder titledBorder3=BorderFactory.createTitledBorder("MENU SELECTION");
			 menuListJPanel.setBorder(titledBorder3);
			 titledBorder3.setTitleColor(Color.BLACK);
			 titledBorder3.setTitleFont(null);
			
			listMenuComboBox.setModel(new DefaultComboBoxModel<Menu>(listOfMenus.toArray(new Menu[0])));
			listMenuComboBox.setSelectedItem(null);
			 listMenuComboBox.setBounds(98, 46, 180, 27);
			 menuListJPanel.add(listMenuComboBox);
			 
			 contentPanel.add(menuListJPanel);
				 
			 TitledBorder titledBorder4=BorderFactory.createTitledBorder("MENU ITEM LSIT");
			 titledBorder4.setTitleColor(Color.BLACK);
			 titledBorder4.setTitleFont(null);
			 prepareMenuDataTable();
			
			 JScrollPane jScrollPane=new JScrollPane(restaurantTable);
			jScrollPane.setBounds(510,318,380,140);
			jScrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder4));
			
			 contentPanel.add(jScrollPane);
			 
		
		return contentPanel;
	}
	
	private static void prepareMenuDataTable() {
		String  [] tableHeader= {"ID","Name","Price"};
			String [] [] menuItemListMultidimensionalArray= createMenuArray();
			menuItemTableModel.setDataVector(menuItemListMultidimensionalArray, tableHeader);	
		}

	private static String[][] createMenuArray() {
	
		String [][]  menuItemListMultidimensionalArray =new String[menuItems.size()][3];
		int i=0;
		//for(Entry<Integer,Products>menuItem : menuItems.entrySet()) {
		for(Products product : menuItems) {
			//Products product= menuItem.getValue();
			menuItemListMultidimensionalArray[i][0] = Integer.toString(product.getProductId());
			menuItemListMultidimensionalArray[i][1]=product.getName();
			menuItemListMultidimensionalArray[i][2]=Double.toString(product.getPrice());
			i++;
			
		}
		return menuItemListMultidimensionalArray;
	}
	
	private static void addButtonFunction(){
	
		addButton.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
		//menuItems.put(Integer.valueOf(textField.getText()), new Products(textField.getText(),Integer.valueOf(textField2.getText()), Double.valueOf(textField3.getText())));
	menuItems.add(new Products(textField2.getText(),Integer.valueOf(textField.getText()), Double.valueOf(textField3.getText())));
	prepareMenuDataTable();
				JOptionPane.showMessageDialog(null,"NEW MENU ITEM ADDED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			}
	});
}
	
	private static void deleteButtonFunction(){
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i=restaurantTable.getSelectedRow();
			menuItemTableModel.removeRow(i);
			menuItems.remove(i);
				JOptionPane.showMessageDialog(null,"MENU ITEM DELETED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
	}
	
private static void updateButtonFunction() {
		
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s1=textField2.getText();
				Integer i2=Integer.valueOf(textField.getText());
				Double d3=Double.valueOf(textField3.getText());
			menuItemTableModel.setValueAt(i2,restaurantTable.getSelectedRow(), 0);
			menuItemTableModel.setValueAt(s1,restaurantTable.getSelectedRow(), 1);
			menuItemTableModel.setValueAt(d3,restaurantTable.getSelectedRow(), 2);
			
				}	
		});
	
	}
	
	
}
