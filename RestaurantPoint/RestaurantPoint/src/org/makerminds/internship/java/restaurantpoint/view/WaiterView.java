package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class WaiterView {
	private static final Font GENERAL_LABEL_FONT = new Font("Arial",Font.PLAIN,15);
	private static final Color CORPORATE_BLUE = Color.decode("#4285f4");
	private static JFrame frame=new JFrame();
	private static JLayeredPane layeredPane=new JLayeredPane();
	private static JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterView window = new WaiterView();
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
	public WaiterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(40, 30,1200, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel navigationBar=createNavigationBarPanel();
		contentPanel=createWelcomeContentPanel();
			layeredPane.setBackground(new Color(64, 128, 128));
		
			layeredPane.add(contentPanel);
			
			frame.getContentPane().add(navigationBar);
			frame.getContentPane().add(layeredPane);
	}

	private JPanel createWelcomeContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,900,450);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("WAITER MODE");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel("WAITER VIEW");
	contentLabel.setFont(GENERAL_LABEL_FONT);
		contentPanel.add(contentLabel);
		return contentPanel;
	}

	private JPanel createNavigationBarPanel() {
		JPanel  navigationBar=new JPanel();
		navigationBar.setBounds(0,0,266,445);
		
		TitledBorder  navigationBarTitleBorder=BorderFactory.createTitledBorder("OPTIONS");
		navigationBar.setBorder(navigationBarTitleBorder);
		
		navigationBar.setLayout(null);
		
		JLabel navigatioBarLabel=new JLabel("Navigation Bar Buttons here...");
		navigatioBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		navigationBar.add(navigatioBarLabel);
		
		//Panel
		List<JPanel>navigationBarPanelButtons=WaiterView.createNavigationBarPanelButtons();
		for(JPanel navigationBarPanelButton : navigationBarPanelButtons) {
			navigationBar.add(navigationBarPanelButton);
			navigationBarPanelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		}
		
		return navigationBar;
	}
	
	public static JPanel createContentPanel(String contentPanelText) {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,900,450);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("Content Panel");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel(contentPanelText);
		contentPanel.add(contentLabel);
		
		return contentPanel;
	}

	
	public static  List<JPanel> createNavigationBarPanelButtons() {
		List<JPanel>navigationBarPanelButtons=new ArrayList<>();
		JPanel navigationBarPanelButton=null;
		 int navigationItemVerticalPosition=0;
		 int navigationItemSpacing=60;
		 
		 for(int i=1;i<5;i++) {
			 navigationBarPanelButton=new JPanel();
			 navigationItemVerticalPosition+=navigationItemSpacing;
			 navigationBarPanelButton.setBounds(5,navigationItemVerticalPosition,250,48);
			 if(i==1) {
				 JLabel firstLabel=new JLabel("RESTAURANT POINT");
				 navigationBarPanelButton.add(firstLabel);
			 }
			 
			 if(i==2) {
				 JLabel secondLabel=new JLabel("TABLE ORDERS");
				 navigationBarPanelButton.add(secondLabel);
		secondLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {	
							clickNavigationBarItem(TableOrdersView.createContentPanel());
						}
				 });
				
			 }
			 if(i==3) {
				 JLabel thirdLabel=new JLabel("STS");
				 navigationBarPanelButton.add(thirdLabel);
		thirdLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {	
							clickNavigationBarItem(OrderStatusView.createContentPanel());
						}
				 });
				
			 }
			 
			 if(i==4) {
				 JLabel fourthLabel=new JLabel("DETAILS");
				 navigationBarPanelButton.add(fourthLabel);
fourthLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {	
							clickNavigationBarItem(TableOrderDetailsView.createContentPanel());
						}
				 });
				 
			 }
			 JPanel contentPanel=WaiterView.createContentPanel("Content");
			 prepareNavigationBarItemMouseListener(navigationBarPanelButton,contentPanel);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
	
		return navigationBarPanelButtons;
		 }

	private static void prepareNavigationBarItemMouseListener(JPanel navigationBarPanelButton, JPanel contentPanel2) {
		navigationBarPanelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				navigationBarPanelButton.setBackground(CORPORATE_BLUE);
				clickNavigationBarItem(contentPanel2);
			}
		});
	}
	
	
			
	/*private static void signOutFunction() {
		frame.dispose();
	}
*/
	
	private static void clickNavigationBarItem(JPanel contentPanel) {
				layeredPane.removeAll();
				layeredPane.add(contentPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		
		
		
	}


