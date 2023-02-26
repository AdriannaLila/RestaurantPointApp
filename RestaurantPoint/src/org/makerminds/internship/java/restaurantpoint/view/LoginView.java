package org.makerminds.internship.java.restaurantpoint.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import org.makerminds.internship.java.restaurantpoint.controller.LoginController;
import org.makerminds.internship.java.restaurantpoint.model.User;

public class LoginView {

	private static final Font GENERAL_LABEL_FONT = new Font("Arial",Font.PLAIN,15);
	private static final Color CORPORATE_BLUE = Color.decode("#4285f4");
	private  JFrame frame;
	private JTextField usernameTextField=new JTextField();
	private JPasswordField passwordTextField;
    private  JLabel loginResultLabel;
    public JLayeredPane layeredPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.prepareView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initializeLoginFrame() {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setBounds(100,100,450,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
	}

	protected void prepareView() {
		initializeLoginFrame();
		createLoginComponents();
	}

	private void createLoginComponents() {
	createUsernameComponent();
	createPasswordFieldComponent();
	createLoginButton();
	createLoginResultLabel();
	createShowHidePasswordComponents();
	
	}

	private void createUsernameComponent() {
		JLabel usernameLabel =createUsernameTextFieldLabel();
		createUsernameTextField();
		frame.getContentPane().add(usernameLabel);
		frame.getContentPane().add(usernameTextField);
		
	}

	private JLabel createUsernameTextFieldLabel() {
		JLabel usernameLabel =new JLabel("Username: ");
		usernameLabel.setFont(GENERAL_LABEL_FONT);
		usernameLabel.setBackground(CORPORATE_BLUE);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(0,57,91,26);
		return usernameLabel;
		
	}
	
	private void createUsernameTextField() {
		usernameTextField.setColumns(10);
		usernameTextField.setFont(GENERAL_LABEL_FONT);
		usernameTextField.setBounds(87,50,300,40);
	}


	private void createPasswordFieldComponent() {
		JLabel  passwordLabel=createPasswordFieldLabel();
		createPasswordTextField();
		frame.getContentPane().add(passwordLabel);
		frame.getContentPane().add(passwordTextField);
	}
	
	private JLabel createPasswordFieldLabel() {
		JLabel passwordLabel=new JLabel ("Password: ");
		passwordLabel.setFont(GENERAL_LABEL_FONT);
		passwordLabel.setBackground(CORPORATE_BLUE);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(0,105,91,26);
		return passwordLabel;
	}
	
	private void createPasswordTextField() {
		passwordTextField=new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setFont(GENERAL_LABEL_FONT);
		passwordTextField.setBounds(87,98,306,40);
		passwordTextField.setEchoChar('*');
	}

	private void createLoginButton() {
		JButton btnLogin =new JButton("Login");
		btnLogin.setFont(GENERAL_LABEL_FONT);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(CORPORATE_BLUE);
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				loginWithProvidedCredentials();
				
			}
			
		});
		btnLogin.setBounds(157,157,108,37);
		frame.getContentPane().add(btnLogin);
	
	}
	public void loginWithProvidedCredentials() {
		LoginController.getInstance();
		String username=usernameTextField.getText();
		String password=String.valueOf(passwordTextField.getPassword());
		
		boolean credentialIsProvided=isCredentialProvided(username,password);
		if(credentialIsProvided) {
			LoginController.getInstance().loginUser(username, password);			
			User loggedInUser=LoginController.getInstance().getLoggedInUser();
			handleWrongCredentials(loggedInUser);
			createNextFrame();
		}
	}
	
	
	private boolean isCredentialProvided(String username, String password) {
			LoginController loginController=LoginController.getInstance();
		if(loginController.isStringNullOrBlank(username)) {
			loginResultLabel.setText("Please provide your username.");
			return false;
		}else if(loginController.isStringNullOrBlank(password)) {
			loginResultLabel.setText("Please provide your password");
			return false;
		}
		return true;
	}
	
	public void handleWrongCredentials(User loggedInUser) {
	if(loggedInUser==null) {
		loginResultLabel.setText("Username or Password is wrong");
		passwordTextField.setText("");
		usernameTextField.setText("");
	}else {
		loginResultLabel.setText("Login successful");
}
	}
	
	private void createLoginResultLabel() {
		loginResultLabel=new JLabel("");
		loginResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginResultLabel.setFont(GENERAL_LABEL_FONT);
		loginResultLabel.setBounds(102,205,250,40);
		frame.getContentPane().add(loginResultLabel);
		
	}
	
	private void createShowHidePasswordComponents() {
		
		JRadioButton hidePasswordReadButton=new JRadioButton("Hide");
		hidePasswordReadButton.setBackground(new Color(128, 128, 128));
		JRadioButton showPasswordRadioButton =new JRadioButton("Show");
		showPasswordRadioButton.setBackground(new ColorUIResource(128,128,128));
		
		setupHidePasswordRadioButton(hidePasswordReadButton,showPasswordRadioButton);
		setupShowPasswordRadioButton(hidePasswordReadButton,showPasswordRadioButton);
		
		frame.getContentPane().add(hidePasswordReadButton);
		frame.getContentPane().add(showPasswordRadioButton);
	
	}
	private void setupShowPasswordRadioButton(JRadioButton hidePasswordReadButton,
			JRadioButton showPasswordRadioButton) {
		showPasswordRadioButton.setBounds(333, 145, 77, 23);
		
		// TODO Auto-generated method stub
		showPasswordRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passwordTextField.setEchoChar((char)0);
			}
			
		});
	}
	private void setupHidePasswordRadioButton(JRadioButton hidePasswordReadButton,
			JRadioButton showPasswordRadioButton) {
		// TODO Auto-generated method stub
		hidePasswordReadButton.setBounds(40, 145, 77, 23);
		
		hidePasswordReadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passwordTextField.setEchoChar('*');
			}
			
		});

		
	}
	
	
	private  void createNextFrame() {
		
		frame=new JFrame("Restaurant Point");
		frame.add(SplitPanelLayout.createWelcomeContentPanel());
		frame.getContentPane().setLayout(null);
		frame.setBounds(0,0,1000,498);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.getContentPane().add(SplitPanelLayout.createNavigationBarPanel());
		
	}
	
	
}

