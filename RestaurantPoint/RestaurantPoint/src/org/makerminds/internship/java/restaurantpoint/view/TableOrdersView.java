package org.makerminds.internship.java.restaurantpoint.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableModel;

import org.makerminds.internship.java.restaurantpoint.controller.TableManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Tables;

public class TableOrdersView {
	private static JButton nextButton=new JButton("NEXT");
	private static DefaultTableModel tableDataModel=new DefaultTableModel();
	private static 	JTable tabTable=new JTable(tableDataModel);
	private static JLabel lblNewLabel=new JLabel("TABLE ORDER MANAGER");
	private static String [][] multidimensionalArray;
	private static TableManagerController tableManagerController=new TableManagerController();
	private static List<Tables>listOfTables=tableManagerController.getTablesForWaiterView();
	
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

		
		
		prepareTableDataTable();
		 TitledBorder titledBorder4=BorderFactory.createTitledBorder("TABLE LIST");
		 titledBorder4.setBorder(BorderFactory.createLineBorder(new Color(51,153,255)));
		 JScrollPane scrollPane=new JScrollPane(tabTable);
		 scrollPane.setBounds(220,110,500,200);
		 scrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder4));
		 contentPanel.add(scrollPane);
	
		 tabTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableOrderDetailsView.createContentPanel();
				}
				});
	
		 
		 contentPanel.add(nextButton);
			nextButton.setBounds(450,360,100,30);
			nextButton.setBackground((new Color(51,153,255)));
		nextButton.setForeground(Color.WHITE);
		nextMove();

		
		

		return contentPanel;
	}


	private static void prepareTableDataTable() {
		String []  tableHeader= {"CHOOSE A TABLE"};
			String [][] tableItemListMultidimensionalArray= createTableArray();
			
		tableDataModel.setDataVector(tableItemListMultidimensionalArray, tableHeader);
		}


	private static String[][] createTableArray() {
		multidimensionalArray=new String[listOfTables.size()][1];
		Iterator<Tables>it=listOfTables.iterator();
		int i=0;
		while(it.hasNext()) {
			Tables table=it.next();
			multidimensionalArray[i][0]=table.getName();
			i++;
		}
		return multidimensionalArray;
	}
	
	private static void nextMove() {
		
	nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//TableOrderDetailsView.createContentPanel();
				createContentPanel2();
				
			}
			
		});
		
	}
	
	
	private static JPanel createContentPanel2() {
		/*JPanel contentNextPanel=new JPanel();
		contentNextPanel.setLayout(null);
		contentNextPanel.setBounds(266,0,904,482);*/
		return MenuItemManagerView.createContentPanel();
	}
	
}

