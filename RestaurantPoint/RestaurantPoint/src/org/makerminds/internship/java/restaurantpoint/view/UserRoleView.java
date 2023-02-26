package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.Color;
import java.awt.EventQueue;
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
import org.makerminds.internship.java.restaurantpoint.controller.AuthorizationService;
import org.makerminds.internship.java.restaurantpoint.controller.LoginController;
import org.makerminds.internship.java.restaurantpoint.model.UserFeatures;
import org.makerminds.internship.java.restaurantpoint.model.UserRole;

public class UserRoleView {

	private static JFrame frame = new JFrame();
	// private static final Color CORPORATE_BLUE = Color.decode("#4285f4");
//			private static final Font GENERAL_LABEL_FONT = new Font("Arial",Font.PLAIN,15);
	private JLayeredPane layeredPane;
	private LoginController loginController = LoginController.getInstance();
	private UserRole userRole = loginController.getLoggedInUser().getUserRole();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRoleView userRoleView = new UserRoleView();
					userRoleView.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void prepareUserRoleView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		initializeMainFrame();

		// LoginUser

		// LoginController loginController=LoginController.getInstance();
		// UserRole userRole=loginController.getLoggedInUser().getUserRole();

		// use Authorization service to get the user role based features

		AuthorizationService authorizationService = new AuthorizationService();
		List<UserFeatures> userFeatures = authorizationService.getUserFeaturesByUserRole(userRole);

		JPanel navigationBar = createNavigationBarPanel(userFeatures);
		JPanel contentPanel = createWelcomeContentPanel();

		layeredPane = new JLayeredPane();
		layeredPane.add(contentPanel);

		frame.getContentPane().add(navigationBar);
		frame.getContentPane().add(layeredPane);
	}

	private JPanel createWelcomeContentPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(266, 0, 900, 850);

		TitledBorder contentPanelTitledBorder = BorderFactory.createTitledBorder("WELCOME");
		contentPanel.setBorder(contentPanelTitledBorder);

		JLabel contentLabel = new JLabel("Welcome to Company Management System");
		contentPanel.add(contentLabel);
		return contentPanel;
	}

	private JPanel createNavigationBarPanel(List<UserFeatures> userFeatures) {
		JPanel navigationBar = new JPanel();
		navigationBar.setBounds(0, 0, 266, 445);

		TitledBorder navigationBarTitleBorder = BorderFactory.createTitledBorder("OPTIONS");
		navigationBar.setBorder(navigationBarTitleBorder);
		navigationBar.setLayout(null);

		JLabel navigatioBarLabel = new JLabel("Navigation Bar");
		navigatioBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		navigationBar.add(navigatioBarLabel);

		// Panel
		List<JPanel> navigationBarPanelButtons = createNavigationBarPanelButtons(userFeatures);
		for (JPanel navigationBarPanelButton : navigationBarPanelButtons) {
			navigationBar.add(navigationBarPanelButton);
			navigationBarPanelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}

		return navigationBar;
	}

	private List<JPanel> createNavigationBarPanelButtons(List<UserFeatures> userFeatures) {
		List<JPanel> navigationBarPanelButtons = new ArrayList<>();
		JPanel navigationBarPanelButton = null;

		// initial dimension setup
		int navigationItemVerticalPosition = 0;
		int navigationItemSpacing = 60;

		for (UserFeatures userFeature : userFeatures) {
			navigationBarPanelButton = new JPanel();

			navigationItemVerticalPosition += navigationItemSpacing;
			navigationBarPanelButton.setBounds(5, navigationItemVerticalPosition, 250, 48);

			// JLabel navigationBarItemLabel=new JLabel(userFeature.name());
			String userFeatureLabel = UserFeatureLabelResolver.getUserFeatureLabel(userFeature);
			JLabel navigationBarItemLabel = new JLabel(userFeatureLabel);
			navigationBarPanelButton.add(navigationBarItemLabel);

			switch (userRole) {
			case WAITER: {

				if (userFeatures.indexOf(userFeature) == 0) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(TableOrdersView.createContentPanel());
						}
					});
				}
				if (userFeatures.indexOf(userFeature) == 1) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(TableOrderDetailsView.createContentPanel());
						}
					});
				}
				if (userFeatures.indexOf(userFeature) == 2) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(OrderStatusView.createContentPanel());
						}
					});
				}
			}
				break;
				
			case RESTAURANT_ADMIN:
				if(userFeatures.indexOf(userFeature)==1) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(RestaurantManagerView1.createContentPanel());
						}
					});
				}
				if(userFeatures.indexOf(userFeature)==2) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(MenuManagerView.createContentPanel());
						}
					});
				}
				if(userFeatures.indexOf(userFeature)==3) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(MenuItemManagerView.createContentPanel());
						}
					});
				}
				if(userFeatures.indexOf(userFeature)==4) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							clickNavigationBarItem(TableManagerView.createContentPanel());
						}
					});
				}
				if(userFeatures.indexOf(userFeature)==5) {
					navigationBarItemLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						signOutFunction();
						LoginView loginView=new LoginView();
						loginView.prepareView();
						
						}
					});
				}
				
			}

			JPanel contentPanel = createContentPanel(userFeatureLabel + " Content");
			prepareNavigationBarItemMouseListener(navigationBarPanelButton, contentPanel);
			navigationBarPanelButtons.add(navigationBarPanelButton);
		}

		return navigationBarPanelButtons;
	}

	private JPanel createContentPanel(String contentPanelText) {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(266, 0, 1050, 1000);

		TitledBorder contentPanelTitledBorder = BorderFactory.createTitledBorder("Content Panel");
		contentPanel.setBorder(contentPanelTitledBorder);

		JLabel contentLabel = new JLabel(contentPanelText);
		contentPanel.add(contentLabel);

		return contentPanel;
	}

	private void prepareNavigationBarItemMouseListener(JPanel navigationBarPanelButton, JPanel contentPanel) {
		navigationBarPanelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickNavigationBarItem(contentPanel);
			}
		});

	}

	public void clickNavigationBarItem(JPanel contentPanel) {
		layeredPane.removeAll();
		layeredPane.add(contentPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public static void signOutFunction() {
		frame.dispose();
	}
	private void initializeMainFrame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}