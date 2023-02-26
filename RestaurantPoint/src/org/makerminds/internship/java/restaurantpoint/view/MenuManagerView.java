package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import org.makerminds.internship.java.restaurantpoint.model.*;


public class MenuManagerView {

	private JFrame frame;
	private static JButton addButton=new JButton("ADD");
	private static JButton updateButton=new JButton("UPDATE");
	private static JButton deleteButton=new JButton("DELETE");
	private static MenuManagerController menuManagerController=new MenuManagerController();
	private static List<Menu>list=menuManagerController.getListOfMenus();
	private static JTextField textField=new JTextField();
	private static DefaultTableModel menuItemTableModel=new DefaultTableModel();
	private static JTable restaurantTable=new JTable(menuItemTableModel);
	private static JComboBox<Restaurant> listComboBox=new JComboBox<>();
private static RestaurantManagerController restaurantManagerController=new RestaurantManagerController();
private static List<Restaurant>listOfRestaurants=restaurantManagerController.getListOfRestaurants();
private final static JLabel lblNewLabel = new JLabel("MENU MANAGER");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuManagerView window = new MenuManagerView();
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
	public MenuManagerView() {
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

	static JPanel createContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266,0,704,582);
	
		TitledBorder titledBorder=BorderFactory.createTitledBorder("MENU MANAGER");
		contentPanel.setBorder(titledBorder);
		 lblNewLabel.setBounds(59, 18, 803, 32);
		 lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBackground(new Color(51,153,255));
		 lblNewLabel.setOpaque(true);
		 contentPanel.add(lblNewLabel);
		
		addButton.setBounds(20,320,100,30);
		addButton.setBackground((new Color(51,153,255)));
		addButton.setForeground(Color.WHITE);
		addButtonFunction();
		
		updateButton.setBounds(140,320,100,30);
		updateButton.setBackground((new Color(51,153,255)));
	    updateButton.setForeground(Color.WHITE);
        updateButtonFunction();
        
		deleteButton.setBounds(260,320,100,30);
		deleteButton.setBackground((new Color(51,153,255)));
		deleteButton.setForeground(Color.WHITE);
		deleteButtonFunction();
	
		JPanel  managPanel=new JPanel();
		managPanel.setLayout(null);
		managPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		managPanel.setBounds(10,80,386,380);
		TitledBorder titledBorder1=BorderFactory.createTitledBorder("MANAGEMENT PANEL");
		managPanel.setBorder(titledBorder1);
		
		managPanel.add(addButton);
		managPanel.add(updateButton);
		managPanel.add(deleteButton);
		
		JLabel label=new JLabel("Menu name");
		label.setBounds(38,50,200,30);
		managPanel.add(label);
		
		
		textField.setBounds(40, 80, 200, 30);
		managPanel.add(textField);
		
		contentPanel.add(managPanel);
		
		  JPanel restLiJPanel=new JPanel();
			 restLiJPanel.setLayout(null);
			 restLiJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			 restLiJPanel.setBounds(510,80,380,120);

		TitledBorder titledBorder2=BorderFactory.createTitledBorder("RESTAURANT SELECTION");
			 titledBorder2.setTitleColor(Color.BLACK);
			 titledBorder2.setTitleFont(null);
			 restLiJPanel.setBorder(titledBorder2);
			 
			
			listComboBox.setModel(new DefaultComboBoxModel<Restaurant>(listOfRestaurants.toArray(new Restaurant[0])));
			 listComboBox.setSelectedItem(null);
			 listComboBox.setBounds(98, 46, 190, 29);
			 restLiJPanel.add(listComboBox);
			
			 contentPanel.add(restLiJPanel);
		
			 TitledBorder titledBorder3=BorderFactory.createTitledBorder("MENU LIST");
		
			 titledBorder3.setTitleColor(Color.BLACK);
			 titledBorder3.setTitleFont(null);
			 prepareMenuDataTable();
			 JScrollPane scrollPane=new JScrollPane(restaurantTable);
			 scrollPane.setBounds(510,278,380,180);
			 scrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder3));
		
			 contentPanel.add(scrollPane);
				restaurantTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					menuItemTableModel=(DefaultTableModel)restaurantTable.getModel();
						int selectedRowIndex=restaurantTable.getSelectedRow();
						textField.setText(menuItemTableModel.getValueAt(selectedRowIndex, 0).toString());
					}
				});
		return contentPanel;
	}

	private static void prepareMenuDataTable() {
		String []  tableHeader= {"MENU OPTIONS"};
			String [][] menuItemListMultidimensionalArray= createMenuArray();
			menuItemTableModel.setDataVector(menuItemListMultidimensionalArray, tableHeader);
		}

	private static String[][] createMenuArray() {
		
		String[][] multidimensionalArray=new String[list.size()][1];
		Iterator<Menu>it=list.iterator();
		int i=0;
		while(it.hasNext()) {
			Menu menu=it.next();
			multidimensionalArray[i][0]=menu.getName();
			i++;
		}
		return multidimensionalArray;
	}
	
	
	private static void addButtonFunction(){
		addButton.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				list.add(new Menu(textField.getText()));
				prepareMenuDataTable();
				JOptionPane.showMessageDialog(null,"NEW MENU ADDED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			}
	});
}
private static void deleteButtonFunction(){
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i=restaurantTable.getSelectedRow();
				menuItemTableModel.removeRow(i);
				list.remove(i);
				JOptionPane.showMessageDialog(null,"MENU DELETED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
	}
private static void updateButtonFunction() {
	
	updateButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s1=textField.getText();
		menuItemTableModel.setValueAt(s1,restaurantTable.getSelectedRow(), 0);
		
			}	
	});

}
}
