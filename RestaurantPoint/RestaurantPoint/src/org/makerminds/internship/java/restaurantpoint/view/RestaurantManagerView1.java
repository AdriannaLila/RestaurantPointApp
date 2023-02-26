package org.makerminds.internship.java.restaurantpoint.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.makerminds.internship.java.restaurantpoint.controller.RestaurantManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Restaurant;
import javax.swing.JTable;
public class RestaurantManagerView1 {
	private static JPanel restaurantManagerPanel;
	private static JPanel contentPanel=new JPanel();
	private static JPanel  managPanel=new JPanel();
	private static JButton addButton=new JButton("ADD");
	private static JButton updateButton=new JButton("UPDATE");
	private static JButton deleteButton=new JButton("DELETE");
	private static DefaultTableModel tableModel=new DefaultTableModel();
	private static JTable restaurantTable=new JTable(tableModel);
	private static JTextField textField=new JTextField();
	private static JTextField textField1=new JTextField();
	private static RestaurantManagerController restaurantManagerController=new RestaurantManagerController();
	private static List<Restaurant>list=restaurantManagerController.getListOfRestaurants();
	private final static JLabel lblNewLabel = new JLabel("RESTAURANT MANAGER");
	private static JScrollPane scrollPane=new JScrollPane(restaurantTable);
	private static TitledBorder titledBorder=BorderFactory.createTitledBorder("RM");

	public static JPanel createRestaurantManagerView() {
		restaurantManagerPanel.add(createContentPanel());
		return restaurantManagerPanel;
	}

	public static JPanel createContentPanel() {
	
		contentPanel.setLayout(null);
		contentPanel.setBounds(266,0,904,482);
		
		 lblNewLabel.setBounds(68, 18, 803, 32);
		 lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBackground(new Color(51,153,255));
		 lblNewLabel.setOpaque(true);
		 contentPanel.add(lblNewLabel);
	
		contentPanel.setBorder(titledBorder);
		
		addButton.setBounds(20,320,100,30);
		addButton.setBackground((new Color(51,153,255)));
		addButton.setForeground(Color.WHITE);
		addButtonFunction();
		
		updateButton.setBounds(140,320,100,30);
		updateButton.setBackground((new Color(51,153,255)));
	    updateButton.setForeground(Color.WHITE);
		deleteButtonFunction();
		
		deleteButton.setBounds(260,320,100,30);
		deleteButton.setBackground((new Color(51,153,255)));
		deleteButton.setForeground(Color.WHITE);
		updateButtonFunction();
		
	
		//JPanel  managPanel=new JPanel();
		managPanel.setLayout(null);
		managPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		managPanel.setBounds(10,80,386,380);
		TitledBorder titledBorder1=BorderFactory.createTitledBorder("MANAGEMENT PANEL");
		managPanel.setBorder(titledBorder1);
		
		
		managPanel.add(addButton);
		managPanel.add(updateButton);
		managPanel.add(deleteButton);
		
		JLabel label=new JLabel("Restaurant name");
		label.setBounds(38,50,200,30);
		managPanel.add(label);
		
		JLabel label2=new JLabel("Restaurant address");
		label2.setBounds(38,135,200,30);
		managPanel.add(label2);
	
		textField.setBounds(40, 80, 200, 30);
		managPanel.add(textField);
	
		textField1.setBounds(40, 160, 200, 30);
		managPanel.add(textField1);
		
		contentPanel.add(managPanel);
		
	
		 TitledBorder titledBorder2=BorderFactory.createTitledBorder("RESTAURANT LIST");
		 prepareRestaurantDataTable();
		
		 scrollPane.setBounds(510,80,380,130);
		 scrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder2));
		
		 contentPanel.add(scrollPane);
		 
		restaurantTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableModel=(DefaultTableModel)restaurantTable.getModel();
					int selectedRowIndex=restaurantTable.getSelectedRow();
					textField.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
					textField1.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
				}
			});
		
		return contentPanel;
	}
	
	private static void prepareRestaurantDataTable() {
		String [] tableHeader= {"NAME","ADDRESS"};
		String [][] restaurantListMultidimensionalArray=createRestaurantArray();
		tableModel.setDataVector(restaurantListMultidimensionalArray, tableHeader);
	}

	
	private static String[][] createRestaurantArray() {
		String[][] multidimensionalArray=new String[list.size()][2];
		int i=0;
		Iterator<Restaurant>it=list.iterator();
		while(it.hasNext()) {
			Restaurant restaurant=it.next();
			multidimensionalArray[i][0]=restaurant.getName();
			multidimensionalArray[i][1]=restaurant.getAddress();
			i++;
		}
		return multidimensionalArray;
	}
	
	
	private static void addButtonFunction(){
		addButton.addActionListener(new ActionListener() {
    
		@Override
		public void actionPerformed(ActionEvent e) {
			list.add(new Restaurant(textField.getText(), textField1.getText()));
			prepareRestaurantDataTable();
			JOptionPane.showMessageDialog(null,"NEW RESTAURANT ADDED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
			
			
		}
		});
}
	
	private static void deleteButtonFunction(){
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i=restaurantTable.getSelectedRow();
				tableModel.removeRow(i);
				list.remove(i);
				JOptionPane.showMessageDialog(null,"RESTAURANT DELETED","CONFIRMATION",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
	}
	
	private static void updateButtonFunction() {
		
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s1=textField.getText();
				String s2=textField1.getText();
				tableModel.setValueAt(s1,restaurantTable.getSelectedRow(), 0);
				tableModel.setValueAt(s2,restaurantTable.getSelectedRow(), 1);
			
				}	
		});
	
	}
	
}