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
import org.makerminds.internship.java.restaurantpoint.controller.RestaurantManagerController;
import org.makerminds.internship.java.restaurantpoint.controller.TableManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Restaurant;
import org.makerminds.internship.java.restaurantpoint.model.Tables;

public class TableManagerView {
	private static JLabel lblNewLabel=new JLabel("TABLE MANAGER");
	private static JButton addButton=new JButton("ADD");
	private static JButton updateButton=new JButton("UPDATE");
	private static JButton deleteButton=new JButton("DELETE");
private static DefaultTableModel tableDataModel=new DefaultTableModel();
private static TableManagerController tableManagerController=new TableManagerController();
private static List<List<Tables>> listOfTables=tableManagerController.getListofTables();
private static List<Tables>list1=listOfTables.get(0);
private static List<Tables>list2=listOfTables.get(1);
private static List<Tables>list3=listOfTables.get(2);
private static 	JTextField textField=new JTextField();
private static JTextField textField1=new JTextField();
private static String [][] multidimensionalArray;
private static 	JTable tabTable=new JTable(tableDataModel);
private static JComboBox<Restaurant> listComboBox=new JComboBox<>();
private static RestaurantManagerController restaurantManagerController=new RestaurantManagerController();
private static List<Restaurant>listOfRestaurants=restaurantManagerController.getListOfRestaurants();
	public static JPanel createContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266,0,904,482);
		
		 lblNewLabel.setBounds(59, 18, 803, 32);
		 lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBackground(new Color(51,153,255));
		 lblNewLabel.setOpaque(true);
		 contentPanel.add(lblNewLabel);
		
		TitledBorder titledBorder=BorderFactory.createTitledBorder("TM");
	
		contentPanel.setBorder(titledBorder);
		
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
		
		JLabel label=new JLabel("Table id");
		label.setBounds(38,50,200,30);
		managPanel.add(label);
		
	
		textField.setBounds(40, 80, 200, 30);
		managPanel.add(textField);
		
		JLabel label2=new JLabel("Seats");
		label2.setBounds(38,135,200,30);
		managPanel.add(label2);
		
		
		textField1.setBounds(40, 160, 200, 30);
		managPanel.add(textField1);
		
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
			 
			 
			 
			listComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						prepareTableDataTable();
					}
					});
			 
			
			 TitledBorder titledBorder4=BorderFactory.createTitledBorder("TABLE LIST");
			 JScrollPane scrollPane=new JScrollPane(tabTable);
			 scrollPane.setBounds(510,318,380,120);
			 scrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder4));
			contentPanel.add(scrollPane);
			
			tabTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableDataModel=(DefaultTableModel)tabTable.getModel();
					int selectedRowIndex=tabTable.getSelectedRow();
					textField.setText(tableDataModel.getValueAt(selectedRowIndex, 0).toString());
					textField1.setText(tableDataModel.getValueAt(selectedRowIndex, 1).toString());
				}
			});
		
			 
			 return contentPanel;
			 
	}
	
	private static void prepareTableDataTable() {
		String []  tableHeader= {"ID","CAPACITY"};
			String [][] menuItemListMultidimensionalArray= createTableArray();
			
		tableDataModel.setDataVector(menuItemListMultidimensionalArray, tableHeader);
		}

	private static String[][] createTableArray() {
		int j= listComboBox.getSelectedIndex();
		if(j==0) {
			multidimensionalArray=new String[list1.size()][2];
			int i=0;
			for(Tables tables:list1) {
				multidimensionalArray[i][0]=Integer.toString(tables.getTableNumber());  
			multidimensionalArray[i][1]=Integer.toString(tables.getTableCapacity());  
			i++;
			
		}
	}
		else if(j==1) {
			multidimensionalArray=new String[list2.size()][2];
			int i=0;
			for(Tables tables:list2) {
				multidimensionalArray[i][0]=Integer.toString(tables.getTableNumber());  
			multidimensionalArray[i][1]=Integer.toString(tables.getTableCapacity());  
			i++;
			}
		}
		else if(j==2) {
			multidimensionalArray=new String[list3.size()][2];
			int i=0;
			for(Tables tables:list3) {
				multidimensionalArray[i][0]=Integer.toString(tables.getTableNumber());  
			multidimensionalArray[i][1]=Integer.toString(tables.getTableCapacity());  
			i++;
			}
		}
		return multidimensionalArray;
	}
	private static void addButtonFunction(){
		addButton.addActionListener(new ActionListener() {
    
		@Override
		public void actionPerformed(ActionEvent e) {
			int j= listComboBox.getSelectedIndex();
			if(j==0) {
				list1.add(new Tables(Integer.valueOf(textField.getText()) ,Integer.valueOf(textField1.getText())));
			}
			else if(j==1) {
				list2.add(new Tables(Integer.valueOf(textField.getText()) ,Integer.valueOf(textField1.getText())));
			}
			else if(j==2) {
				list3.add(new Tables(Integer.valueOf(textField.getText()) ,Integer.valueOf(textField1.getText())));
			}
			prepareTableDataTable();
			JOptionPane.showMessageDialog(null,"NEW TABLE ADDED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			
			
		}
		});
}
	private static void deleteButtonFunction(){
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i=tabTable.getSelectedRow();
				tableDataModel.removeRow(i);
				listOfTables.remove(i);
				JOptionPane.showMessageDialog(null,"TABLE DELETED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
	}
	
	private static void updateButtonFunction() {
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s1=Integer.valueOf(textField.getText());
				int s2=Integer.valueOf(textField1.getText());
				tableDataModel.setValueAt(s1,tabTable.getSelectedRow(), 0);
				tableDataModel.setValueAt(s2,tabTable.getSelectedRow(), 1);
			
				}	
		});
	
	}
	
}
