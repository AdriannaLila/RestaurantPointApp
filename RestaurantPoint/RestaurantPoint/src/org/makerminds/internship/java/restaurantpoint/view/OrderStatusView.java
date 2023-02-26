package org.makerminds.internship.java.restaurantpoint.view;
import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.makerminds.internship.java.restaurantpoint.controller.TableManagerController;
import org.makerminds.internship.java.restaurantpoint.model.Tables;

public class OrderStatusView {
	private static JPanel contentPanel;
	private static DefaultTableModel tableItemTableModel = new DefaultTableModel();
	private static JTable tabTable = new JTable(tableItemTableModel);
	private static JLabel lblNewLabel = new JLabel("TABLE ORDER DETAILS");
	private static JLabel orderOverviewLabel = new JLabel("ORDER OVERVIEW");
	private static JButton refreshButton=new JButton("REFRESH");
	private static TableManagerController tableManagerController=new TableManagerController();
	private static List<Tables>listOfTables=tableManagerController.getTablesForWaiterView();
	private static String [][] multidimensionalArray;
	private static JComboBox<String> comboBox=new JComboBox<String>();
	
	public static JPanel createContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(266, 0, 904, 482);
		
		lblNewLabel.setBounds(59, 18, 803, 25);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setOpaque(true);
		contentPanel.add(lblNewLabel);
		
		
		orderOverviewLabel.setBounds(179, 70, 573, 28);
		orderOverviewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderOverviewLabel.setForeground(Color.WHITE);
		orderOverviewLabel.setBackground(new Color(51, 153, 255));
		orderOverviewLabel.setOpaque(true);
		contentPanel.add(orderOverviewLabel);
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(" ");
		

		prepareTableDataTable();
		 TitledBorder titledBorder4=BorderFactory.createTitledBorder("");
		 titledBorder4.setBorder(BorderFactory.createLineBorder(new Color(51,103,225)));
		 JScrollPane scrollPane=new JScrollPane(tabTable);
		 scrollPane.setBounds(220,110,500,180);
		 scrollPane.setBorder(BorderFactory.createTitledBorder(titledBorder4));
		 contentPanel.add(scrollPane);
	
	String [] enumsAsStrings=Arrays.stream(WaiterEnum.values()).map(e -> e.toString()).toArray(String[]::new);
		comboBox=new JComboBox<String>(enumsAsStrings);
		TableColumn status=tabTable.getColumnModel().getColumn(1);
		status.setCellEditor(new DefaultCellEditor(comboBox));
		contentPanel.setBorder(titledBorder);
		
		
		contentPanel.add(refreshButton);
		refreshButton.setBounds(558, 305, 100, 30);
		refreshButton.setBackground((new Color(51, 153, 255)));
		refreshButton.setForeground(Color.WHITE);
		
		return contentPanel;
	}
	
	private static void prepareTableDataTable() {
		String []  tableHeader= {"TABLE.NR","STATUS"};
			String [][] tableItemListMultidimensionalArray= createTableArray();
			
			 tableItemTableModel.setDataVector(tableItemListMultidimensionalArray, tableHeader);
		}

	private static String[][] createTableArray() {
		multidimensionalArray=new String[listOfTables.size()][2];
		Iterator<Tables>it=listOfTables.iterator();
		int i=0;
		while(it.hasNext()) {
			Tables table=it.next();
			multidimensionalArray[i][0]=table.getName();
			i++;
		}
		return multidimensionalArray;
	}

}
