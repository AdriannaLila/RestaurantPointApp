package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;


public class SplitPanelLayout{
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
					SplitPanelLayout window = new SplitPanelLayout();
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
	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(40, 30,1200, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel navigationBar=createNavigationBarPanel();
	contentPanel=createWelcomeContentPanel();
		layeredPane.setBackground(new Color(64, 128, 128));
	
		layeredPane.add(contentPanel);
		
		frame.getContentPane().add(navigationBar);
		frame.getContentPane().add(layeredPane);
		
	}
	public static JPanel createWelcomeContentPanel() {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,900,450);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("WELCOME");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel("RESTAURANT SOFTWARE");
	contentLabel.setFont(GENERAL_LABEL_FONT);
		contentPanel.add(contentLabel);
		return contentPanel;
	}

	public static JPanel createNavigationBarPanel() {
		JPanel  navigationBar=new JPanel();
		navigationBar.setBounds(0,0,266,445);
		
		TitledBorder  navigationBarTitleBorder=BorderFactory.createTitledBorder("OPTIONS");
		navigationBar.setBorder(navigationBarTitleBorder);
		
		navigationBar.setLayout(null);
		
		JLabel navigatioBarLabel=new JLabel("Navigation Bar Buttons here...");
		navigatioBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		navigationBar.add(navigatioBarLabel);
		
		//Panel
		List<JButton>navigationBarPanelButtons=SplitPanelLayout.createNavigationBarPanelButtons();
		for(JButton navigationBarPanelButton : navigationBarPanelButtons) {
			navigationBar.add(navigationBarPanelButton);
			navigationBarPanelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		}
		
		return navigationBar;
	}
	public static JPanel createContentPanel(String contentPanelText) {
		JPanel contentPanel=new JPanel();
		contentPanel.setBounds(266,0,1050,1000);
		
		TitledBorder contentPanelTitledBorder=BorderFactory.createTitledBorder("Content Panel");
		contentPanel.setBorder(contentPanelTitledBorder);
		
		JLabel contentLabel=new JLabel(contentPanelText);
		contentPanel.add(contentLabel);
		
		return contentPanel;
	}

	public static  List<JButton> createNavigationBarPanelButtons() {
		List<JButton>navigationBarPanelButtons=new ArrayList<>();
		JButton navigationBarPanelButton=null;
		 int navigationItemVerticalPosition=0;
		 int navigationItemSpacing=60;
		 
		 for(int i=1;i<7;i++) {
			 navigationBarPanelButton=new JButton();
			
			 navigationItemVerticalPosition+=navigationItemSpacing;
			 navigationBarPanelButton.setBounds(5,navigationItemVerticalPosition,250,48);
			 if(i==1) {
				 JButton  navigationBarButton=new JButton("RESTAURANT POINT");
				 navigationBarButton.setBackground(CORPORATE_BLUE);
				 navigationBarButton.setForeground(Color.WHITE);
				 navigationBarPanelButton.setBackground(CORPORATE_BLUE);
			 navigationBarPanelButton.add(navigationBarButton);
			navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
			 
			 if(i==2) {
				 JButton navigationBarItemButton2=new JButton("RESTAURANT MANAGER");
				 navigationBarItemButton2.setBackground(CORPORATE_BLUE);
				 navigationBarItemButton2.setForeground(Color.WHITE);
				 navigationBarPanelButton.setBackground(CORPORATE_BLUE);
			navigationBarPanelButton.add(navigationBarItemButton2);
			navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemButton2.addMouseListener(new MouseAdapter() {
				 @Override
					public void mouseClicked(MouseEvent e) {
					 contentPanel=RestaurantManagerView1.createContentPanel();
					 clickNavigationBarItem(contentPanel);
				 }
				 
			 });

			 }
			 
			 if(i==3) {
				 JButton navigationBarItemButton3=new JButton("MENU MANAGER");
				 navigationBarPanelButton.setBackground(CORPORATE_BLUE);
				 navigationBarItemButton3.setForeground(Color.WHITE);
				 navigationBarItemButton3.setBackground(CORPORATE_BLUE);
			 navigationBarPanelButton.add(navigationBarItemButton3);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemButton3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						contentPanel=MenuManagerView.createContentPanel();
						clickNavigationBarItem(contentPanel);
					
				}
			 });
			 }
			 if(i==4) {
				 JButton navigationBarItemButton4=new JButton("MENU ITEM MANAGER");
				 navigationBarItemButton4.setBackground(CORPORATE_BLUE);
				 navigationBarItemButton4.setForeground(Color.WHITE);
				 navigationBarPanelButton.setBackground(CORPORATE_BLUE);
			 navigationBarPanelButton.add(navigationBarItemButton4);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemButton4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						contentPanel=MenuItemManagerView.createContentPanel();
						clickNavigationBarItem(contentPanel);
					
				}
			 });
			 
			 }
			 if(i==5) {
				JButton navigationBarItemButton5=new JButton("TABLE MANAGER");
				navigationBarItemButton5.setBackground(CORPORATE_BLUE);
				navigationBarPanelButton.setBackground(CORPORATE_BLUE);
				navigationBarItemButton5.setForeground(Color.WHITE);
			 navigationBarPanelButton.add(navigationBarItemButton5);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemButton5.addMouseListener(new MouseAdapter() {
					@Override
					
					public void mouseClicked(MouseEvent e) {	
						
						contentPanel=TableManagerView.createContentPanel();
						clickNavigationBarItem(contentPanel);
					
				}
			 });
			 }
			 if(i==6) {
				 JButton navigationBarItemButton6=new JButton("SIGN OUT");
			 navigationBarPanelButton.add(navigationBarItemButton6);
			 navigationBarItemButton6.setForeground(Color.WHITE);
			 navigationBarItemButton6.setBackground(CORPORATE_BLUE);
			navigationBarPanelButton.setBackground(CORPORATE_BLUE);
			navigationBarPanelButtons.add(navigationBarPanelButton);
			 navigationBarItemButton6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						signOutFunction();
						LoginView loginView=new LoginView();
						loginView.prepareView();
						
				}
			 });
			 }
			 
			 JPanel contentPanel=SplitPanelLayout.createContentPanel("RESTAURANT POINT");
			 prepareNavigationBarItemMouseListener(navigationBarPanelButton,contentPanel);
			 navigationBarPanelButtons.add(navigationBarPanelButton);
			 }
	
		return navigationBarPanelButtons;
	}

	public static void prepareNavigationBarItemMouseListener(JButton navigationBarPanelButton, JPanel contentPanel) {
		
		navigationBarPanelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				navigationBarPanelButton.setBackground(CORPORATE_BLUE);
				clickNavigationBarItem(contentPanel);
			}
		});
		
	}
	
	public static void signOutFunction() {
		frame.dispose();
	}

	public static void clickNavigationBarItem(JPanel contentPanel) {
		layeredPane.removeAll();
		layeredPane.add(contentPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

}

