package org.makerminds.internship.java.restaurantpoint.view;


import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Color;


public class SplitPanelLayout{
	private static final Color CORPORATE_BLUE = Color.decode("#4285f4");
	private static JFrame frame;
	private static JLayeredPane layeredPane;
	private static JPanel contentPanel;
	//private static JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SplitPanelLayout window = new SplitPanelLayout();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplitPanelLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,994, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel navigationBar=createNavigationBarPanel();
		//JPanel contentPanel=createContentPanel();
	contentPanel=createWelcomeContentPanel();
		layeredPane=new JLayeredPane();
		layeredPane.add(contentPanel);
		
		
		
		frame.getContentPane().add(navigationBar);
		frame.getContentPane().add(layeredPane);
		
	}

	public static JPanel createWelcomeContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,904,582);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("WELCOME");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel("Welcome to RestaurantPoint");
		contentPanel.add(contentLabel);
		return contentPanel;
	}

	public static JPanel createNavigationBarPanel() {
		JPanel  navigationBar=new JPanel();
		navigationBar.setBounds(0,0,266,582);
		
		TitledBorder  navigationBarTitleBorder=BorderFactory.createTitledBorder("OPTIONS");
		navigationBar.setBorder(navigationBarTitleBorder);
		
		navigationBar.setLayout(null);
		
		JLabel navigatioBarLabel=new JLabel("Navigation Bar Buttons here...");
		navigatioBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		navigationBar.add(navigatioBarLabel);
		
		
		List<JPanel>navigationBarPanelButtons=SplitPanelLayout.createNavigationBarPanelButtons();
		for(JPanel navigationBarPanelButton : navigationBarPanelButtons) {
			navigationBar.add(navigationBarPanelButton);
			navigationBarPanelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		}
		
		return navigationBar;
	}
	private static JPanel createContentPanel(String contentPanelText) {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,950,498);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("Content Panel");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel(contentPanelText);
		contentPanel.add(contentLabel);
		
		return contentPanel;
	}

	private static  List<JPanel> createNavigationBarPanelButtons() {
		List<JPanel>navigationBarPanelButtons=new ArrayList<>();
		 JPanel navigationBarPanelButton=null;
		 
		 int navigationItemVerticalPosition=0;
		 int navigationItemSpacing=60;
		 
		 for(int i=1;i<7;i++) {
			 navigationBarPanelButton=new JPanel();
			 navigationItemVerticalPosition+=navigationItemSpacing;
			 navigationBarPanelButton.setBounds(5,navigationItemVerticalPosition,250,48);
			 if(i==1) {
				 JLabel navigationBarItemLabel=new JLabel("Resaturant Point");
			 navigationBarPanelButton.add(navigationBarItemLabel);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
			 
			 ////////////KETU E KAM THIRRUR METODEN
			 if(i==2) {
				 JLabel navigationBarItemLabel2=new JLabel("Restaurant Manager");
			 navigationBarPanelButton.add(navigationBarItemLabel2);
			 navigationBarPanelButtons.add(navigationBarPanelButton);

			 }
			 
			 if(i==3) {
				 JLabel navigationBarItemLabel3=new JLabel("Menu Manager");
			 navigationBarPanelButton.add(navigationBarItemLabel3);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemLabel3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						contentPanel=MenuManagerView.createContentPanel();
						clickNavigationBarItem(contentPanel);
					
				}
			 });
			 }
			 if(i==4) {
				 JLabel navigationBarItemLabel4=new JLabel("Menu Item Manager");
			 navigationBarPanelButton.add(navigationBarItemLabel4);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
			 if(i==5) {
				 JLabel navigationBarItemLabel5=new JLabel("Table Manager");
			 navigationBarPanelButton.add(navigationBarItemLabel5);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
			 if(i==6) {
				 JLabel navigationBarItemLabel6=new JLabel("Sign out");
			 navigationBarPanelButton.add(navigationBarItemLabel6);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
			 
			 JPanel contentPanel=SplitPanelLayout.createContentPanel("content");
			 prepareNavigationBarItemMouseListener(navigationBarPanelButton,contentPanel);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
	
		return navigationBarPanelButtons;
	}

	private static void prepareNavigationBarItemMouseListener(JPanel navigationBarPanelButton, JPanel contentPanel) {
		
		navigationBarPanelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				navigationBarPanelButton.setBackground(CORPORATE_BLUE);
				clickNavigationBarItem(contentPanel);
			}
			  public void mouseReleased(MouseEvent e) {
		            navigationBarPanelButton.setBackground(Color.WHITE);
		            
		        }
		});
		
	}

	private static void clickNavigationBarItem(JPanel contentPanel) {
		layeredPane.removeAll();
		layeredPane.add(contentPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	
	////KETU E KAM KRIJU METODEN
	/*private static void createRestaurantFrame() {
 frame1=new JFrame("Restaurant Point");
		//frame1.add(RestaurantManagerView.createContentPanel());
		frame1.getContentPane().setLayout(null);
		frame1.setBounds(237,0,560,498);
		frame1.setBackground(Color.BLACK);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setResizable(true);
		frame.getContentPane().add(RestaurantManagerView1.createContentPanel());
	
	}
*/
}

