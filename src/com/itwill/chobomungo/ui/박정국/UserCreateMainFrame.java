package com.itwill.chobomungo.ui.박정국;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;


public class UserCreateMainFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane memberTabbedPane;
	private JTextField user_id;
	private JTextField user_pw;
	private JTextField user_name;
	private JTextField user_phone;
	private JTextField user_address;
	private JTextField user_email;
	private JButton goMainBtn;
	private JLabel idCheck;
	private JLabel pwCheck;
	private JLabel idMsgLB;
	private JLabel pwMsgLB;
	private JTextField user_pw_check;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	UserService userService;
	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCreateMainFrame frame = new UserCreateMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserCreateMainFrame()throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane membertabbedPane = new JTabbedPane(JTabbedPane.TOP);
		membertabbedPane.setBounds(12, 10, 360, 561);
		contentPane.add(membertabbedPane);
		
		JPanel panel = new JPanel();
		membertabbedPane.addTab("회원가입", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(91, 48, 159, 56);
		panel.add(lblNewLabel);
		
		user_id = new JTextField();
		user_id.setText("아이디");
		user_id.setBounds(67, 114, 212, 29);
		panel.add(user_id);
		user_id.setColumns(10);
		
		user_pw = new JTextField();
		user_pw.setText("비밀번호");
		user_pw.setColumns(10);
		user_pw.setBounds(67, 164, 212, 29);
		panel.add(user_pw);
		
		user_pw_check = new JTextField();
		user_pw_check.setText("비밀번호 확인");
		user_pw_check.setColumns(10);
		user_pw_check.setBounds(67, 203, 212, 29);
		panel.add(user_pw_check);
		
		user_name = new JTextField();
		user_name.setText("이름");
		user_name.setColumns(10);
		user_name.setBounds(67, 254, 212, 29);
		panel.add(user_name);
		
		user_phone = new JTextField();
		user_phone.setText("연락처");
		user_phone.setColumns(10);
		user_phone.setBounds(67, 293, 212, 29);
		panel.add(user_phone);
		
		user_address = new JTextField();
		user_address.setText("주소");
		user_address.setColumns(10);
		user_address.setBounds(67, 332, 212, 29);
		panel.add(user_address);
		
		user_email = new JTextField();
		user_email.setText("이메일");
		user_email.setColumns(10);
		user_email.setBounds(67, 371, 212, 29);
		panel.add(user_email);
		
		JButton memberJoinBtn = new JButton("회원가입 완료");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = user_id.getText();
					String password=user_pw.getText();
					String name=user_name.getText();
					String phone=user_phone.getText();
					String address=user_address.getText();
					String email=user_email.getText();
					/***********유효성체크****************/
					if(id.equals("")) {
						 idMsgLB.setText("ID");
						 user_id.requestFocus();
						return;
					}
					if(password.equals("")) {
						 idMsgLB.setText("PASSWORD");
						 user_id.requestFocus();
						return;
					}
					
					
					User newMember=new User(id,password,name,phone,address,email);
					int isAdd = userService.create(newMember);
					if(isAdd==1) {
						//로그인화면전환
						System.out.println("생성완료.");
						 memberTabbedPane.setSelectedIndex(1);
					}else {
						JOptionPane.showMessageDialog(null, "다시 확인해주세요.");
						user_id.requestFocus();
						user_id.setSelectionStart(0);
						user_id.setSelectionEnd(id.length());
					}
				}catch (Exception e1) {
					System.out.println("회원가입-->"+e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(95, 432, 152, 29);
		panel.add(memberJoinBtn);
		
		goMainBtn = new JButton("메인으로");
		goMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFrame frame = new 다른클래스(); //메인 탭으로 이동
		        //frame.setVisible(true);
			}
		});
		goMainBtn.setBounds(95, 476, 152, 29);
		panel.add(goMainBtn);
		
		idCheck = new JLabel("아이디 중복체크");
		idCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = user_id.getText();
				//User newMember=new User(id,"id","id","id","id","id");
				boolean isAdd;
				try {
					isAdd = userService.idCheck(id);
					if(isAdd==false) {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						user_id.requestFocus();
						user_id.setSelectionStart(0);
						user_id.setSelectionEnd(id.length());
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용하고있는 아이디입니다.");
					user_id.requestFocus();
					user_id.setSelectionStart(0);
					user_id.setSelectionEnd(id.length());
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		idCheck.setBounds(67, 146, 97, 15);
		panel.add(idCheck);
		
		pwCheck = new JLabel("비밀번호 확인");
		pwCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String password1=user_pw.getText();
				String password2=user_pw_check.getText();
				boolean isAdd = password1.equals(password2);
				if(isAdd) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
					user_id.requestFocus();
					user_id.setSelectionStart(0);
					user_id.setSelectionEnd(password1.length());
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					user_id.requestFocus();
					user_id.setSelectionStart(0);
					user_id.setSelectionEnd(password1.length());
				}
			}
		});
		pwCheck.setBounds(67, 235, 105, 15);
		panel.add(pwCheck);
		
//		idMsgLB = new JLabel("");
//		idMsgLB.setBounds(71, 121, 113, 15);
//		panel.add(idMsgLB);
//		
//		pwMsgLB = new JLabel("");
//		pwMsgLB.setBounds(67, 171, 113, 15);
//		panel.add(pwMsgLB);
		
		userService= new UserService();
		
		
		
		
		
		
		
		
	}
}
