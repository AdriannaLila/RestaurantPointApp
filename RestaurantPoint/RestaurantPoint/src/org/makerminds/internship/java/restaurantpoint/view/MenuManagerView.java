package org.makerminds.internship.java.restaurantpoint.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.makerminds.internship.java.restaurantpoint.controller.MenuManagerController;
import org.makerminds.internship.java.restaurantpoint.controller.RestaurantManagerController;
import org.makerminds.internship.java.restaurantpoint.model.*;


public class MenuManagerView {
	private static JButton addButton=new JButton("ADD");
	private static JButton updateButton=new JButton("UPDATE");
	private static JButton deleteButton=new JButton("DELETE");
	private static MenuManagerController menuManagerController=new MenuManagerController();
	private static List<List<Menu>> list=menuManagerController.getListOfMenus();
	private static List<Menu>lista1=list.get(0);
	private static List<Menu>lista2=list.get(1);
	private static List<Menu>lista3=list.get(2);
	private static String [][] multidimensionalArray;
	private static JTextField textField=new JTextField();
	private static DefaultTableModel menuItemTableModel=new DefaultTableModel();
	private static JTable restaurantTable=new JTable(menuItemTableModel);
	private static JComboBox<Restaurant> listComboBox=new JComboBox<>();
private static RestaurantManagerController restaurantManagerController=new RestaurantManagerController();
private static List<Restaurant>listOfRestaurants=restaurantManagerController.getListOfRestaurants();
private final static JLabel lblNewLabel = new JLabel("MENU MANAGER");


	static JPanel createContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266,0,904,482);
	
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
			 
			 listComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
							 prepareMenuDataTable();
						
					}
				});
			 
			 //prepareMenuDataTable();
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
	int j=listComboBox.getSelectedIndex();
	if(j==0) {
		multidimensionalArray=new String[lista1.size()][1];
		int i=0;
		for(Menu menu:lista1) {
			multidimensionalArray[i][0]=menu.getName();
			i++;
		}
	}
	if(j==1) {
		multidimensionalArray=new String[lista2.size()][1];
		int i=0;
		for(Menu menu:lista2) {
			multidimensionalArray[i][0]=menu.getName();
			i++;
		}
	}
	if(j==2) {
		multidimensionalArray=new String[lista3.size()][1];
		int i=0;
		for(Menu menu:lista3) {
			multidimensionalArray[i][0]=menu.getName();
			i++;
		}
	}
	return multidimensionalArray;
		
		
	}
	private static void addButtonFunction(){
		addButton.addActionListener(new ActionListener() {
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				//list.add(new Menu(textField.getText()));
				int j=listComboBox.getSelectedIndex();
				if(j==0) {
					lista1.add(new Menu(textField.getText()));
				}
				//prepareMenuDataTable();
				if(j==1) {
					lista2.add(new Menu(textField.getText()));
				}
				
				if(j==2) {
					lista3.add(new Menu(textField.getText()));
				}
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
