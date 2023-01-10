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

public class UserCreatePanel extends JPanel {
	public JTextField userIDTF;
	public JTextField userPwTF;
	public JTextField userPWCheckTF;
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
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	
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
		userIDTF.setText("아이디");
		userIDTF.setBounds(95, 49, 192, 21);
		panel.add(userIDTF);
		userIDTF.setColumns(10);
		
		
		userPwTF = new JTextField();
		userPwTF.setText("비밀번호");
		userPwTF.setBounds(95, 98, 192, 21);
		panel.add(userPwTF);
		userPwTF.setColumns(10);
		
		userPWCheckTF = new JTextField();
		userPWCheckTF.setText("비밀번호 확인");
		userPWCheckTF.setBounds(95, 129, 192, 21);
		panel.add(userPWCheckTF);
		userPWCheckTF.setColumns(10);
		
		
		userNameTF = new JTextField();
		userNameTF.setText("이름");
		userNameTF.setBounds(95, 177, 192, 21);
		panel.add(userNameTF);
		userNameTF.setColumns(10);
		
		userPhoneTF = new JTextField();
		userPhoneTF.setText("연락처");
		userPhoneTF.setBounds(95, 208, 192, 21);
		panel.add(userPhoneTF);
		userPhoneTF.setColumns(10);
		
		userAddressTF = new JTextField();
		userAddressTF.setText("주소");
		userAddressTF.setBounds(95, 239, 192, 21);
		panel.add(userAddressTF);
		userAddressTF.setColumns(10);
		
		userEmailTF = new JTextField();
		userEmailTF.setText("이메일");
		userEmailTF.setBounds(95, 270, 192, 21);
		panel.add(userEmailTF);
		userEmailTF.setColumns(10);
		
		memberJoinBtn = new JButton("회원가입 완료");
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
					int isAdd = mainFrame.userService.create(newMember);
					if(isAdd==1) {
						//로그인화면전환
						System.out.println("생성완료.");
						JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
						userIDTF.requestFocus();
						userIDTF.setSelectionStart(0);
						userIDTF.setSelectionEnd(id.length());
						
						userIDTF.setText("");
						userPwTF.setText("");
						userPWCheckTF.setText("");
						userNameTF.setText("");
						userPhoneTF.setText("");
						userAddressTF.setText("");
						userEmailTF.setText("");
						mainFrame.chobomungoTabbedPane.setSelectedIndex(isAdd);
						mainFrame.userTabbedPane.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "다시 확인해주세요.");
						userIDTF.requestFocus();
						userIDTF.setSelectionStart(0);
						userIDTF.setSelectionEnd(id.length());
					}
				}catch (Exception e1) {
					System.out.println("회원가입-->"+e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(102, 338, 152, 21);
		panel.add(memberJoinBtn);
		
		goMainBtn = new JButton("가입취소");
		goMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
				mainFrame.userTabbedPane.setSelectedIndex(0);
			}
		});
		goMainBtn.setBounds(102, 369, 152, 21);
		panel.add(goMainBtn);
		
		idCheckBtn = new JButton("아이디 중복확인");
		idCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userIDTF.getText();
				boolean isAdd;
				try {
					isAdd = mainFrame.userService.idCheck(id);
					if(isAdd==false) {
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
		pwCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1=userPwTF.getText();
				String password2=userPWCheckTF.getText();
				boolean isAdd = password1.equals(password2);
				if(isAdd) {
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
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 52, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(12, 101, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("패스워드확인");
		lblNewLabel_1_1.setBounds(12, 132, 83, 15);
		panel.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("이름");
		lblNewLabel_1_2.setBounds(12, 180, 72, 15);
		panel.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("연락처");
		lblNewLabel_1_3.setBounds(12, 211, 72, 15);
		panel.add(lblNewLabel_1_3);
		
		lblNewLabel_1_4 = new JLabel("주소");
		lblNewLabel_1_4.setBounds(12, 242, 72, 15);
		panel.add(lblNewLabel_1_4);
		
		lblNewLabel_1_5 = new JLabel("이메일");
		lblNewLabel_1_5.setBounds(12, 273, 72, 15);
		panel.add(lblNewLabel_1_5);
		
	
	}
	
	public void createFormEnable(boolean b) {
		if (b) {
			// 활성화
			userIDTF.setEditable(true);
			userPwTF.setEditable(true);
			userPWCheckTF.setEditable(true);
			userNameTF.setEditable(true);
			userPhoneTF.setEditable(true);
			userAddressTF.setEditable(true);
			userEmailTF.setEditable(true);
			
		} else {
			// 비활성화
			userIDTF.setEditable(false);
			userPwTF.setEditable(false);
			userPWCheckTF.setEditable(false);
			userNameTF.setEditable(false);
			userPhoneTF.setEditable(false);
			userAddressTF.setEditable(false);
			userEmailTF.setEditable(false);
			
		}

	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
