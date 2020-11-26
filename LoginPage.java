import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class LoginPage implements ActionListener
{
	JFrame frameLoginPage;
	JLabel lbl_userName,lbl_password,lbl_error_msg;
	JTextField txt_userName;
	JPasswordField txt_password;
	JButton btn_login,btn_signUp;

	LoginPage()
	{
	
		Font font = new Font("Times New Roman",Font.BOLD,25);
		frameLoginPage = new JFrame("Login Window");
		lbl_userName = new JLabel("User Name");
		lbl_password = new JLabel("Password");
		btn_signUp = new JButton("Create New Account");
		lbl_error_msg = new JLabel("");
		txt_userName = new JTextField();
		txt_password = new JPasswordField(); 
		btn_login = new JButton("Login");

		frameLoginPage.setSize(800,700);
		frameLoginPage.setLayout(null);
	

		lbl_userName.setBounds(200,140,120,30);
		lbl_password.setBounds(200,200,120,30);
		btn_signUp.setBounds(260,400,300,50);
		lbl_error_msg.setBounds(270,250,250,30);
		txt_userName.setBounds(350,140,200,30);
		txt_password.setBounds(350,200,200,30);
		btn_login.setBounds(330,300,150,35);

		lbl_userName.setBackground(Color.black);
		lbl_userName.setForeground(Color.black);
		lbl_userName.setFont(font);

		lbl_password.setBackground(Color.black);
		lbl_password.setForeground(Color.black);
		lbl_password.setFont(font);

		btn_signUp.setBackground(new Color(224,224,224));
		btn_signUp.setForeground(Color.black);
		btn_signUp.setFont(font);
		btn_signUp.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lbl_error_msg.setBackground(Color.black);
		lbl_error_msg.setForeground(Color.black);
		lbl_error_msg.setFont(font);

		txt_userName.setBackground(Color.white);
		txt_userName.setForeground(Color.black);
		txt_userName.setCaretColor(Color.black);
		txt_userName.setFont(font);

		txt_password.setBackground(Color.white);
		txt_password.setForeground(Color.black);
		txt_password.setCaretColor(Color.black);
		txt_password.setEchoChar('*');
		txt_password.setFont(font);

		btn_login.setBackground(Color.white);
		btn_login.setForeground(Color.black);
		btn_login.setFont(font);

		frameLoginPage.add(lbl_userName);
		frameLoginPage.add(lbl_password);
		frameLoginPage.add(lbl_error_msg);
		frameLoginPage.add(btn_signUp);
		frameLoginPage.add(txt_userName);
		frameLoginPage.add(txt_password);
		frameLoginPage.add(btn_login);
		
		lbl_error_msg.setVisible(false);

		frameLoginPage.getContentPane().setBackground(new Color(119, 223, 239));
		frameLoginPage.setResizable(false);
		frameLoginPage.setVisible(true);

		btn_login.addActionListener(this);
		btn_signUp.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				frameLoginPage.dispose();
				new SignUp();
			}
		});

		frameLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_login)
		{
				lbl_error_msg.setVisible(false);
				if(txt_userName.getText().trim().equals(""))
				{
					lbl_error_msg.setVisible(true);
					lbl_error_msg.setText("Please enter username!");
				}
				else if(txt_password.getText().trim().equals(""))
				{
					lbl_error_msg.setVisible(true);
					lbl_error_msg.setText("Please enter password!");
				}
				else
				{
					frameLoginPage.dispose();
					new MainPage(txt_userName.getText().trim());
				}
					
		}
	}

	public static void main(String args[])
	{
		new LoginPage();
	}
}

class MainPage implements ActionListener
{
	JFrame frameMainPage;
	public static JLabel lbl_welcome,lbl_toUser,lbl_sub,lbl_msg,lbl_sent,lbl_Cc;
	public static JButton btn_addUser,btn_show,btn_delete,btn_createMail,btn_Logout;
	String userName;
	Font font,font1;
	

	MainPage()
	{

	}

	MainPage(String userName)
	{
		frameMainPage= new JFrame("Main Page");
		
		frameMainPage.getContentPane().setBackground(new Color(119, 223, 239));
		frameMainPage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMainPage.setSize(800,700);
		frameMainPage.setResizable(false);
		frameMainPage.setLayout(null);

		font = new Font("Times New Roman",Font.BOLD,30);
		font1 = new Font("Times New Roman",Font.BOLD,25);
		lbl_welcome= new JLabel("Welcome "+userName);
		lbl_sent = new JLabel("Message sent successfully...");
		lbl_toUser = new JLabel();
		lbl_Cc = new JLabel();
		lbl_sub= new JLabel();
		lbl_msg = new JLabel();
		btn_addUser =  new JButton("Add User");
		btn_createMail = new JButton("Compose Mail");
		btn_Logout = new JButton("Logout");
		btn_show= new JButton("Show Full Message");
		btn_delete = new JButton("Delete Message");
	
		lbl_welcome.setBounds(300,10,400,30);
		lbl_welcome.setBackground(Color.black);
		lbl_welcome.setForeground(Color.black);
		lbl_welcome.setFont(font);
		
		lbl_sent.setBackground(new Color(0,0,204));
		lbl_sent.setForeground(new Color(0,0,204));
		lbl_sent.setBounds(20,80,400,30);
		lbl_sent.setVisible(false);
		lbl_sent.setFont(font);

		lbl_toUser.setBackground(new Color(0,0,204));
		lbl_toUser.setForeground(new Color(0,0,204));
		lbl_toUser.setBounds(20,120,500,30);
		lbl_toUser.setVisible(false);
		lbl_toUser.setFont(font1);
		
		lbl_Cc.setBackground(new Color(0,0,204));
		lbl_Cc.setForeground(new Color(0,0,204));
		lbl_Cc.setBounds(20,160,500,30);
		lbl_Cc.setVisible(false);
		lbl_Cc.setFont(font1);

		lbl_sub.setBackground(new Color(0,0,204));
		lbl_sub.setForeground(new Color(0,0,204));
		lbl_sub.setBounds(20,200,300,30);
		lbl_sub.setVisible(false);
		lbl_sub.setFont(font1);

		lbl_msg.setBackground(new Color(0,0,204));
		lbl_msg.setForeground(new Color(0,0,204));
		lbl_msg.setBounds(20,240,500,30);
		lbl_msg.setVisible(false);
		lbl_msg.setFont(font1);
				
		btn_createMail.setBounds(150,450,200,50);
		btn_createMail.setBackground(Color.white);
		btn_createMail.setForeground(Color.black);
		btn_createMail.setFont(font1);
		
		btn_addUser.setBounds(450,450,200,50);
		btn_addUser.setBackground(Color.white);
		btn_addUser.setForeground(Color.black);
		btn_addUser.setFont(font1);
		
		btn_Logout.setBounds(320,550,150,40);
		btn_Logout.setBackground(new Color(224,224,224));
		btn_Logout.setForeground(Color.black);
		btn_Logout.setFont(font1);
		
		btn_show.setBackground(Color.blue);
		btn_show.setForeground(Color.white);
		btn_show.setBounds(20,290,250,30);
		btn_show.setVisible(false);
		btn_show.setFont(font1);

		btn_delete.setBackground(Color.blue);
		btn_delete.setForeground(Color.white);
		btn_delete.setBounds(330,290,250,30);			
		btn_delete.setVisible(false);
		btn_delete.setFont(font1);

		frameMainPage.add(lbl_welcome);
		frameMainPage.add(lbl_sent);
		frameMainPage.add(lbl_toUser);
		frameMainPage.add(lbl_Cc);
		frameMainPage.add(lbl_sub);
		frameMainPage.add(lbl_msg);
		frameMainPage.add(btn_addUser);
		frameMainPage.add(btn_createMail);
		frameMainPage.add(btn_Logout);
		frameMainPage.add(btn_show);
		frameMainPage.add(btn_delete);
		
		frameMainPage.setVisible(true);

		frameMainPage.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					int a = JOptionPane.showConfirmDialog(frameMainPage,"Are you Sure to close? If you will close then you will be automatically logged out.");					

					if(a==JOptionPane.YES_OPTION)
					{
						frameMainPage.dispose();
						new LoginPage();
					}	
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
			}
		});

		btn_createMail.addActionListener(this);
		btn_Logout.addActionListener(this);
		btn_addUser.addActionListener(this);
		btn_show.addActionListener(this);
		btn_delete.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_createMail)
		{
			new CreateMail("new");
		}
		else if(e.getSource()==btn_Logout) 
		{
			try
			{
				int a = JOptionPane.showConfirmDialog(frameMainPage,"Are you Sure to Logout?");					

				if(a==JOptionPane.YES_OPTION)
				{
					frameMainPage.dispose();
					new LoginPage();
				}	
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		else if(e.getSource()==btn_addUser)
		{
			try
			{
				new AddUser();	
			}
			catch(NullPointerException ex)
			{

			}
		}
		else if(e.getSource()==btn_show)
		{
			new CreateMail("show");		
		}
		else if(e.getSource()==btn_delete)
		{
			int a = JOptionPane.showConfirmDialog(frameMainPage,"Are you Sure to delete?");					
	
			if(a==JOptionPane.YES_OPTION)
			{
				lbl_sent.setText("Message deleted Successfully!");
				lbl_toUser.setVisible(false);
				lbl_sub.setVisible(false);
				lbl_Cc.setVisible(false);
				lbl_msg.setVisible(false);
				btn_show.setVisible(false);
				btn_delete.setVisible(false);
			}		
		}
	}
}

class AddUser extends MainPage implements ActionListener
{
	JFrame frameAddUser;
	JTextField txt_userName;
	JButton btn_addUser,btn_cancel;

	AddUser()
	{
		super();
		frameAddUser = new JFrame("Add User");

		frameAddUser.getContentPane().setBackground(new Color(119, 223, 239));
		frameAddUser.setSize(400,200);
		frameAddUser.setLayout(null);
		frameAddUser.setResizable(false);
		frameAddUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Font font = new Font("Times New Roman",Font.BOLD,20);		
		txt_userName = new JTextField();
		btn_addUser= new JButton("Add");
		btn_cancel = new JButton("Cancel");

		txt_userName.setBounds(10,40,380,40);
		btn_addUser.setBounds(90,100,100,40);
		btn_cancel.setBounds(200,100,100,40);

		txt_userName.setBackground(Color.white);
		txt_userName.setForeground(Color.black);
		txt_userName.setFont(font);

		btn_addUser.setBackground(Color.white);
		btn_addUser.setForeground(Color.black);
		btn_addUser.setFont(font);

		btn_cancel.setBackground(Color.white);
		btn_cancel.setForeground(Color.black);
		btn_cancel.setFont(font);

		frameAddUser.add(txt_userName);		
		frameAddUser.add(btn_addUser);
		frameAddUser.add(btn_cancel);

		frameAddUser.setVisible(true);
			
		btn_addUser.addActionListener(this);
		btn_cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_addUser)
		{
			try
			{
				
			}
			catch(NullPointerException ex)
			{
				System.out.println(ex);
			}
		}
		else if(e.getSource()==btn_cancel)
		{
			frameAddUser.dispose();
		}
	}
}

class CreateMail extends MainPage implements ActionListener
{
	JFrame frameCreateMail;
	JLabel lbl_sendTo,lbl_subject,lbl_message,lbl_error_msg,lbl_cc;
	JTextField txt_sendTo,txt_subject,txt_Cc;
	TextArea txt_message;
	JButton btn_send,btn_cancel,btn_ok;
	public static String sendTo,subject,message,mode,Cc;

	CreateMail(String mode)
	{
		this.mode=mode;
		frameCreateMail=new JFrame("Create Mail");
		txt_sendTo = new JTextField();
		txt_Cc = new JTextField();
		txt_subject = new JTextField();
		txt_message = new TextArea();
		lbl_sendTo = new JLabel("To");
		lbl_cc = new JLabel("Cc");
		lbl_subject = new JLabel("Subject");
		lbl_message = new JLabel("Message");
		lbl_error_msg = new JLabel();
		btn_send = new JButton("Send");
		btn_cancel = new JButton("Cancel");
		btn_ok = new JButton("Ok");
		Font font = new Font("Times New Roman",Font.BOLD,21);
		Font font1 = new Font("Times New Roman",Font.BOLD,25);

		frameCreateMail.getContentPane().setBackground(new Color(119, 223, 239));
		frameCreateMail.setSize(800,900);
		frameCreateMail.setLayout(null);
		frameCreateMail.setResizable(false);
		frameCreateMail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		lbl_sendTo.setBackground(Color.black);
		lbl_sendTo.setForeground(Color.black);
		lbl_sendTo.setFont(font1);
		lbl_sendTo.setBounds(6,6,100,50);
		
		lbl_cc.setBackground(Color.black);
		lbl_cc.setForeground(Color.black);
		lbl_cc.setFont(font1);
		lbl_cc.setBounds(6,62,100,50);

		lbl_subject.setBackground(Color.black);
		lbl_subject.setForeground(Color.black);
		lbl_subject.setBounds(6,118,100,50);
		lbl_subject.setFont(font1);

		lbl_message.setBackground(Color.black);
		lbl_message.setForeground(Color.black);
		lbl_message.setBounds(6,174,100,50);	
		lbl_message.setFont(font1);
		
		lbl_error_msg.setBackground(Color.black);
		lbl_error_msg.setForeground(Color.black);
		lbl_error_msg.setVisible(false);
		lbl_error_msg.setBounds(250,715,500,40);
		lbl_error_msg.setFont(font);

		txt_sendTo.setBackground(Color.white);
		txt_sendTo.setForeground(Color.blue);
		txt_sendTo.setBounds(150,6,400,50);
		txt_sendTo.setFont(font);
		
		txt_Cc.setBackground(Color.white);
		txt_Cc.setForeground(Color.blue);
		txt_Cc.setBounds(150,62,400,50);
		txt_Cc.setFont(font);

		txt_subject.setBackground(Color.white);
		txt_subject.setForeground(Color.red);	
		txt_subject.setBounds(150,118,400,50);
		txt_subject.setFont(font);

		txt_message.setBackground(Color.white);
		txt_message.setForeground(Color.blue);
		txt_message.setBounds(150,174,600,530);
		txt_message.setFont(font);

		btn_send.setBackground(Color.white);
		btn_send.setForeground(Color.black);
		btn_send.setBounds(270,755,100,40);
		btn_send.setFont(font);

		btn_cancel.setBackground(Color.white);
		btn_cancel.setForeground(Color.black);
		btn_cancel.setBounds(420,755,100,40);
		btn_cancel.setFont(font);
			
		btn_ok.setBackground(Color.black);
		btn_ok.setForeground(Color.cyan);
		btn_ok.setBounds(180,430,100,30);
		btn_ok.setVisible(false);
		btn_ok.setFont(font);

		if(mode=="new")
		{
			txt_sendTo.setText("");
			txt_Cc.setText("");
			txt_subject.setText("");
			txt_message.setText("");
		}
		else if(mode=="show")
		{
			txt_sendTo.setText(sendTo);
			txt_Cc.setText(Cc);
			txt_subject.setText(subject);
			txt_message.setText(message);

			txt_sendTo.setEditable(false);
			txt_Cc.setEditable(false);
			txt_subject.setEditable(false);
			txt_message.setEditable(false);

			btn_send.setVisible(false);
			btn_cancel.setVisible(false);
			btn_ok.setVisible(true);
		}

		frameCreateMail.add(lbl_sendTo);
		frameCreateMail.add(lbl_cc);
		frameCreateMail.add(lbl_subject);
		frameCreateMail.add(lbl_message);
		frameCreateMail.add(lbl_error_msg);
		frameCreateMail.add(txt_sendTo);
		frameCreateMail.add(txt_Cc);
		frameCreateMail.add(txt_subject);
		frameCreateMail.add(txt_message);
		frameCreateMail.add(btn_send);
		frameCreateMail.add(btn_cancel);
		frameCreateMail.add(btn_ok);

		frameCreateMail.setVisible(true);

		btn_send.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_ok.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_send)
		{
			lbl_error_msg.setVisible(false);		
	
			if(txt_sendTo.getText().trim().equals("") || isValidEmail(txt_sendTo.getText())==false)
			{
				lbl_error_msg.setText("Please enter valid email address!");
				lbl_error_msg.setVisible(true);
			}
			else if(isValidEmail(txt_Cc.getText())==false)
			{
				lbl_error_msg.setText("Please enter valid email address in Cc!");
				lbl_error_msg.setVisible(true);
			}
			else if(txt_message.getText().trim().equals(""))
			{
				lbl_error_msg.setText("Please enter message to send!");
				lbl_error_msg.setVisible(true);
			}
			else if(txt_subject.getText().trim().equals(""))
			{
				int a = JOptionPane.showConfirmDialog(frameCreateMail,"Would you like to send message without subject?");					

				if(a==JOptionPane.YES_OPTION)
				{
					try
					{
						MainPage.lbl_sent.setVisible(true);
	
						lbl_toUser.setText("Send to : "+txt_sendTo.getText().trim());
						lbl_toUser.setVisible(true);
						
						lbl_cc.setText("Cc :"+txt_Cc.getText().trim());
						lbl_cc.setVisible(true);
	
						lbl_msg.setText("Message : "+txt_message.getText().trim());
						lbl_msg.setVisible(true);

						btn_show.setVisible(true);
						btn_delete.setVisible(true);
	
						frameCreateMail.setVisible(false);

						sendTo=txt_sendTo.getText().trim();
						Cc=txt_Cc.getText().trim();
						subject=txt_subject.getText().trim();
						message = txt_message.getText().trim();
					}
					catch(NullPointerException ex)
					{
						System.out.println(ex);
					}
				}
			}
			else
			{
				MainPage.lbl_sent.setVisible(true);
	
				lbl_toUser.setText("Sent to : "+txt_sendTo.getText().trim());
				lbl_toUser.setVisible(true);
				
				lbl_Cc.setText("Cc :"+txt_Cc.getText().trim());
				lbl_Cc.setVisible(true);
	
				lbl_sub.setText("Subject : "+txt_subject.getText().trim());
				lbl_sub.setVisible(true);

				lbl_msg.setText("Message : "+txt_message.getText().trim());
				lbl_msg.setVisible(true);

				btn_show.setVisible(true);
				btn_delete.setVisible(true);
	
				frameCreateMail.setVisible(false);

				sendTo=txt_sendTo.getText().trim();
				Cc=txt_Cc.getText().trim();
				subject=txt_subject.getText().trim();
				message = txt_message.getText().trim();

			}
		}
		else if (e.getSource()==btn_cancel)
		{
			try
			{
				if(txt_sendTo.getText().trim().equals("")==false || txt_subject.getText().trim().equals("")==false || txt_message.getText().trim().equals("")==false)
				{
					int a = JOptionPane.showConfirmDialog(frameCreateMail,"Are you Sure? If you will close this window then your data will not be saved as draft");					

					if(a==JOptionPane.YES_OPTION)
					{
						frameCreateMail.dispose();
					}
				}
				else
				{
					frameCreateMail.dispose();
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		else if(e.getSource()==btn_ok)
		{
			frameCreateMail.setVisible(false);	
		}
	}
	public boolean isValidEmail(String email)
	{
		String expression="^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
}

class SignUp implements ActionListener
{
	JFrame frameSignUp;
	JLabel lbl_fName,lbl_lName,lbl_phone,lbl_email,lbl_password,lbl_error_msg;
	JTextField txt_fName,txt_lName,txt_phone,txt_email;
	JPasswordField txt_password;
	JButton btn_signUp,btn_cancel;

	SignUp()
	{
		frameSignUp = new JFrame("Sign Up");
		Font font = new Font("Times New Roman",Font.BOLD,25);

		lbl_fName = new JLabel("First Name ");
		lbl_lName = new JLabel("Last Name");
		lbl_phone = new JLabel("Phone Number");
		lbl_email = new JLabel("E-mail id ");
		lbl_password = new JLabel("Password");
		lbl_error_msg=new JLabel();
		txt_fName =  new JTextField();
		txt_lName = new JTextField();
		txt_phone = new JTextField();
		txt_email = new JTextField();
		txt_password = new JPasswordField();
		btn_signUp = new JButton("Sign Up");
		btn_cancel = new JButton("Cancel");

		frameSignUp.getContentPane().setBackground(new Color(119, 223, 239));
		frameSignUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSignUp.setSize(800,700);
		frameSignUp.setResizable(false);
		frameSignUp.setLayout(null);

		lbl_fName.setBounds(200,60,180,30);
		lbl_lName.setBounds(200,120,180,30);
		lbl_phone.setBounds(200,180,180,30);
		lbl_email.setBounds(200,240,180,30);
		lbl_password.setBounds(200,300,180,30);
		lbl_error_msg.setBounds(270,360,600,30);
		txt_fName.setBounds(400,60,250,30);
		txt_lName.setBounds(400,120,250,30);	
		txt_phone.setBounds(400,180,250,30);
		txt_email.setBounds(400,240,250,30);
		txt_password.setBounds(400,300,250,30);
		btn_signUp.setBounds(240,450,150,35);
		btn_cancel.setBounds(440,450,150,35);

		lbl_fName.setBackground(Color.white);
		lbl_fName.setForeground(Color.black);
		lbl_fName.setFont(font);

		lbl_lName.setBackground(Color.white);
		lbl_lName.setForeground(Color.black);
		lbl_lName.setFont(font);

		lbl_phone.setBackground(Color.white);
		lbl_phone.setForeground(Color.black);
		lbl_phone.setFont(font);

		lbl_email.setBackground(Color.white);
		lbl_email.setForeground(Color.black);
		lbl_email.setFont(font);

		lbl_password.setBackground(Color.white);
		lbl_password.setForeground(Color.black);
		lbl_password.setFont(font);

		lbl_error_msg.setBackground(Color.black);
		lbl_error_msg.setForeground(Color.black);
		lbl_error_msg.setFont(font);
		lbl_error_msg.setVisible(false);
		
		txt_fName.setBackground(Color.white);
		txt_fName.setForeground(Color.black);
		txt_fName.setCaretColor(Color.black);
		txt_fName.setFont(font);

		txt_lName.setBackground(Color.white);
		txt_lName.setForeground(Color.black);
		txt_lName.setCaretColor(Color.black);
		txt_lName.setFont(font);

		txt_phone.setBackground(Color.white);
		txt_phone.setForeground(Color.black);
		txt_phone.setCaretColor(Color.black);
		txt_phone.setFont(font);

		txt_email.setBackground(Color.white);
		txt_email.setForeground(Color.black);
		txt_email.setCaretColor(Color.black);
		txt_email.setFont(font);

		txt_password.setBackground(Color.white);
		txt_password.setForeground(Color.black);
		txt_password.setCaretColor(Color.black);
		txt_password.setFont(font);
		txt_password.setEchoChar('*');

		btn_signUp.setBackground(Color.white);
		btn_signUp.setForeground(Color.black);
		btn_signUp.setFont(font);

		btn_cancel.setBackground(Color.white);
		btn_cancel.setForeground(Color.black);
		btn_cancel.setFont(font);

		frameSignUp.add(lbl_fName);
		frameSignUp.add(lbl_lName);
		frameSignUp.add(lbl_phone);
		frameSignUp.add(lbl_email);
		frameSignUp.add(lbl_password);
		frameSignUp.add(txt_fName);
		frameSignUp.add(txt_lName);
		frameSignUp.add(txt_phone);
		frameSignUp.add(txt_email);
		frameSignUp.add(txt_password);
		frameSignUp.add(btn_signUp);
		frameSignUp.add(btn_cancel);
		frameSignUp.add(lbl_error_msg);

		btn_signUp.addActionListener(this);
		btn_cancel.addActionListener(this);
		
		frameSignUp.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_signUp)
		{
			lbl_error_msg.setVisible(false);

			boolean numeric = true;

			try
			{
				Double num = Double.parseDouble(txt_phone.getText().trim());
			}
			catch(NumberFormatException ex)
			{
				numeric =false;
			}

			if(txt_fName.getText().trim().equals(""))
			{
				lbl_error_msg.setVisible(true);
				lbl_error_msg.setText("Please enter first name!");
			}

			else if(txt_lName.getText().trim().equals(""))
			{
				lbl_error_msg.setVisible(true);
				lbl_error_msg.setText("Please enter last name!");
			}

			else if(txt_phone.getText().trim().equals("") || numeric==false)
			{
				lbl_error_msg.setVisible(true);
				lbl_error_msg.setText("Please enter valid phone number!");
			}

			else if(txt_email.getText().trim().equals("") || isValidEmail(txt_email.getText())==false)
			{
				lbl_error_msg.setVisible(true);
				lbl_error_msg.setText("Please enter vaild email!");
			}

			else if(txt_password.getText().trim().equals(""))
			{
				lbl_error_msg.setVisible(true);
				lbl_error_msg.setText("Please enter password!");
			}

			else
			{
				lbl_error_msg.setVisible(true);	
				lbl_error_msg.setText("Your details are saved. Go to login page and continue.");
				lbl_error_msg.addMouseListener(new MouseAdapter()	
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						frameSignUp.dispose();
						new LoginPage();
					}
				});
			}

		}
		if(e.getSource()==btn_cancel)
		{
			try
			{
				if(txt_fName.getText().trim().equals("")==false || txt_lName.getText().trim().equals("")==false || txt_phone.getText().trim().equals("")==false || txt_email.getText().trim().equals("")==false || txt_password.getText().trim().equals("")==false)
				{
					int a = JOptionPane.showConfirmDialog(frameSignUp,"Are you Sure?");					

					if(a==JOptionPane.YES_OPTION)
					{
						frameSignUp.dispose();
						new LoginPage();
					}
				}
				else
				{
					frameSignUp.dispose();
					new LoginPage();
				}
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
	}

	public boolean isValidEmail(String email)
	{
		String expression="^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
}

class HintTextField extends JTextField implements FocusListener
{
	public final String hint;
	public boolean showingHint;

	public HintTextField(final String hint)
	{
		super(hint);
		this.hint=hint;
		this.showingHint=true;
		this.setText(hint);
		super.addFocusListener(this);
	}

	public void focusGained(FocusEvent e)
	{
		if(this.getText().isEmpty()) 
		{
      			super.setText("");
			showingHint = false;
    		}
	}

	public void focusLost(FocusEvent e) 
	{
		if(this.getText().isEmpty()) 
		{
			super.setText(hint);
			showingHint = true;
    		}
	}

	public String getText() 
	{
		return showingHint ? "" : super.getText();
	}
}