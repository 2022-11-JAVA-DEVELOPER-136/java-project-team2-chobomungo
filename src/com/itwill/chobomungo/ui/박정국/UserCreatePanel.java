package com.itwill.chobomungo.ui.박정국;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class UserCreatePanel extends JPanel {
	public JTextField userIDTF;
	public JTextField userNameTF;
	public JTextField userPhoneTF;
	public JTextField userAddressTF;
	public JTextField userEmailTF;

	/**
	 * Create the panel
	 */
	public ChobomungoMainFrame mainFrame;
	
	public JButton idCheckBtn;
	public JButton pwCheckBtn;
	public JButton memberJoinBtn;
	public JButton goMainBtn;
	private JLabel userNameLB;
	private JLabel userPhoneLB;
	private JLabel userAddressLB;
	private JLabel userEmailLB;
	private JPasswordField userPwTF;
	private JPasswordField userPWCheckTF;
	
	public UserCreatePanel() throws Exception {
		setPreferredSize(new Dimension(400, 620));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 400, 620);
		add(panel);
		panel.setLayout(null);
		
		JLabel panelTitle = new JLabel("회원가입");
		panelTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.setBounds(102, 10, 159, 29);
		panel.add(panelTitle);
		
		userIDTF = new JTextField();
		userIDTF.setFont(new Font("Dialog", Font.ITALIC, 12));
		userIDTF.setText("2글자 이상 16글자 이하");
		userIDTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userIDTF.setText("");
				
			}
		});
		userIDTF.setBounds(95, 49, 192, 21);
		panel.add(userIDTF);
		userIDTF.setColumns(10);
		
		
		userNameTF = new JTextField();
		userNameTF.setFont(new Font("Dialog", Font.ITALIC, 12));
		userNameTF.setText("홍길동");
		userNameTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userNameTF.setText("");				
			}
		});
		userNameTF.setBounds(95, 177, 192, 21);
		panel.add(userNameTF);
		userNameTF.setColumns(10);
		
		userPhoneTF = new JTextField();
		userPhoneTF.setFont(new Font("Dialog", Font.ITALIC, 12));
		userPhoneTF.setText("010-0000-0000");
		userPhoneTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userPhoneTF.setText("");
			}
		});
		userPhoneTF.setBounds(95, 208, 192, 21);
		panel.add(userPhoneTF);
		userPhoneTF.setColumns(10);
		
		userAddressTF = new JTextField();
		userAddressTF.setFont(new Font("Dialog", Font.ITALIC, 12));
		userAddressTF.setText("서울시 종로구 사직로 161");
		userAddressTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userAddressTF.setText("");
			}
		});
		userAddressTF.setBounds(95, 239, 192, 21);
		panel.add(userAddressTF);
		userAddressTF.setColumns(10);
		
		userEmailTF = new JTextField();
		userEmailTF.setText("example@example.com");
		userEmailTF.setFont(new Font("Dialog", Font.ITALIC, 12));
		userEmailTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userEmailTF.setText("");
			}
		});
		userEmailTF.setBounds(95, 270, 192, 21);
		panel.add(userEmailTF);
		userEmailTF.setColumns(10);
		
		memberJoinBtn = new JButton("회원가입");
		memberJoinBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/******TextField로부터 데이터 얻기*****/
					String id = userIDTF.getText();
					String password=userPwTF.getText();
					String name=userNameTF.getText();
					String phone=userPhoneTF.getText();
					String address=userAddressTF.getText();
					String email=userEmailTF.getText();
					/***********유효성체크****************/					
					
					User newMember=new User(id,password,name,phone,address,email);
					joinValidation(newMember);
					
				}catch (Exception e1) {
					System.out.println("회원가입-->"+e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(102, 315, 152, 21);
		panel.add(memberJoinBtn);
		
		goMainBtn = new JButton("가입취소");
		goMainBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		goMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userIDTF.setText("2글자 이상 16글자 이하");
				userPwTF.setText("******");
				userPWCheckTF.setText("******");
				userNameTF.setText("홍길동");
				userPhoneTF.setText("010-0000-0000");
				userAddressTF.setText("서울시 종로구 사직로 161");
				userEmailTF.setText("example@example.com");
				
				mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
				mainFrame.userTabbedPane.setSelectedIndex(0);
			}
		});
		goMainBtn.setBounds(102, 346, 152, 21);
		panel.add(goMainBtn);
		
		idCheckBtn = new JButton("아이디 중복확인");
		idCheckBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		idCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userIDTF.getText();
				boolean isAdd;
				try {
					isAdd = mainFrame.userService.idCheck(id);
					if(id.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
						userIDTF.requestFocus();
						userIDTF.setSelectionStart(0);
						userIDTF.setSelectionEnd(id.length());
					}
					else if(isAdd==false) {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						userIDTF.requestFocus();
						userIDTF.setSelectionStart(0);
						userIDTF.setSelectionEnd(id.length());
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용하고 있는 아이디입니다.");
					userIDTF.requestFocus();
					userIDTF.setSelectionStart(0);
					userIDTF.setSelectionEnd(id.length());
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		idCheckBtn.setBounds(95, 73, 118, 21);
		panel.add(idCheckBtn);
		
		pwCheckBtn = new JButton("비밀번호 확인");
		pwCheckBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
		pwCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1=userPwTF.getText();
				String password2=userPWCheckTF.getText();
				boolean isAdd = password1.equals(password2);
				if(password1.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					userPwTF.requestFocus();
					userPwTF.setSelectionStart(0);
					userPwTF.setSelectionEnd(password1.length());
				}
				else if(isAdd) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
					userPwTF.requestFocus();
					userPwTF.setSelectionStart(0);
					userPwTF.setSelectionEnd(password1.length());
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					userPwTF.requestFocus();
					userPwTF.setSelectionStart(0);
					userPwTF.setSelectionEnd(password1.length());
				}
			}
		});
		pwCheckBtn.setBounds(95, 153, 118, 21);
		panel.add(pwCheckBtn);
		
		JLabel userIdLB = new JLabel("아이디");
		userIdLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userIdLB.setBounds(12, 52, 57, 15);
		panel.add(userIdLB);
		
		JLabel userPwLB = new JLabel("패스워드");
		userPwLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userPwLB.setBounds(12, 101, 57, 15);
		panel.add(userPwLB);
		
		JLabel userPwCheckLB = new JLabel("패스워드확인");
		userPwCheckLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userPwCheckLB.setBounds(12, 132, 83, 15);
		panel.add(userPwCheckLB);
		
		userNameLB = new JLabel("이름");
		userNameLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userNameLB.setBounds(12, 180, 72, 15);
		panel.add(userNameLB);
		
		userPhoneLB = new JLabel("연락처");
		userPhoneLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userPhoneLB.setBounds(12, 211, 72, 15);
		panel.add(userPhoneLB);
		
		userAddressLB = new JLabel("주소");
		userAddressLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userAddressLB.setBounds(12, 242, 72, 15);
		panel.add(userAddressLB);
		
		userEmailLB = new JLabel("이메일");
		userEmailLB.setFont(new Font("Dialog", Font.PLAIN, 12));
		userEmailLB.setBounds(12, 273, 72, 15);
		panel.add(userEmailLB);
		
		userPwTF = new JPasswordField();
		userPwTF.setText("******");
		userPwTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userPwTF.setText("");
			}
		});
		userPwTF.setBounds(95, 98, 192, 21);
		panel.add(userPwTF);
		
		userPWCheckTF = new JPasswordField();
		userPWCheckTF.setText("******");
		userPWCheckTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userPWCheckTF.setText("");
			}
		});
		userPWCheckTF.setBounds(95, 126, 192, 21);
		panel.add(userPWCheckTF);
		
	/*****생성자 끝******/
	}
	
	//회원가입시 유효성체크
	public void joinValidation(User joinUser) throws Exception {
		int isAdd = mainFrame.userService.create(joinUser);
		if(isAdd==1) {
			//로그인화면전환
			JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
			userIDTF.setText("");
			userPwTF.setText("");
			userPWCheckTF.setText("");
			userNameTF.setText("");
			userPhoneTF.setText("");
			userAddressTF.setText("");
			userEmailTF.setText("");
			mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
			mainFrame.userTabbedPane.setSelectedIndex(0);
		}else if(isAdd == -1){
			JOptionPane.showMessageDialog(null, "아이디가 존재합니다.");
			userIDTF.requestFocus();
			userIDTF.setSelectionStart(0);
			userIDTF.setSelectionEnd(joinUser.getUserId().length());
		}else if(isAdd == -2) {
			JOptionPane.showMessageDialog(null, "유효하지 않은 비밀번호입니다.");
			userIDTF.requestFocus();
			userPwTF.setSelectionStart(0);
			userPwTF.setSelectionEnd(joinUser.getUserPw().length());
		}else if(isAdd == -3) {
			JOptionPane.showMessageDialog(null, "이메일이 존재합니다.");
			userEmailTF.requestFocus();
			userEmailTF.setSelectionStart(0);
			userEmailTF.setSelectionEnd(joinUser.getUserEmail().length());
		}
	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
