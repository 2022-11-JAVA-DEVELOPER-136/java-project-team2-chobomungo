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
	public JTextField user_id;
	public JTextField user_pw;
	public JTextField user_pw_check;
	public JTextField user_name;
	public JTextField user_phone;
	public JTextField user_address;
	public JTextField user_email;

	/**
	 * Create the panel
	 */
	public ChobomungoMainFrame mainFrame;
	
	public JButton idCheckBtn;
	public JButton pwCheckBtn;
	public JButton memberJoinBtn;
	public JButton goMainBtn;
	
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
		
		user_id = new JTextField();
		user_id.setText("아이디");
		user_id.setBounds(75, 49, 212, 21);
		panel.add(user_id);
		user_id.setColumns(10);
		
		
		user_pw = new JTextField();
		user_pw.setText("비밀번호");
		user_pw.setBounds(75, 98, 212, 21);
		panel.add(user_pw);
		user_pw.setColumns(10);
		
		user_pw_check = new JTextField();
		user_pw_check.setText("비밀번호 확인");
		user_pw_check.setBounds(75, 129, 212, 21);
		panel.add(user_pw_check);
		user_pw_check.setColumns(10);
		
		
		user_name = new JTextField();
		user_name.setText("이름");
		user_name.setBounds(75, 177, 212, 21);
		panel.add(user_name);
		user_name.setColumns(10);
		
		user_phone = new JTextField();
		user_phone.setText("연락처");
		user_phone.setBounds(75, 208, 212, 21);
		panel.add(user_phone);
		user_phone.setColumns(10);
		
		user_address = new JTextField();
		user_address.setText("주소");
		user_address.setBounds(75, 239, 212, 21);
		panel.add(user_address);
		user_address.setColumns(10);
		
		user_email = new JTextField();
		user_email.setText("이메일");
		user_email.setBounds(75, 270, 212, 21);
		panel.add(user_email);
		user_email.setColumns(10);
		
		memberJoinBtn = new JButton("회원가입 완료");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/******TextField로부터 데이터 얻기*****/
					String id = user_id.getText();
					String password=user_pw.getText();
					String name=user_name.getText();
					String phone=user_phone.getText();
					String address=user_address.getText();
					String email=user_email.getText();
					/***********유효성체크****************/					
					
					User newMember=new User(id,password,name,phone,address,email);
					int isAdd = mainFrame.userService.create(newMember);
					if(isAdd==1) {
						//로그인화면전환
						System.out.println("생성완료.");
						JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
						user_id.requestFocus();
						user_id.setSelectionStart(0);
						user_id.setSelectionEnd(id.length());
						
						user_id.setText("");
						user_pw.setText("");
						user_pw_check.setText("");
						user_name.setText("");
						user_phone.setText("");
						user_address.setText("");
						user_email.setText("");
						
						createFormEnable(false);
						//memberTabbedPane.setSelectedIndex(1);
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
		memberJoinBtn.setBounds(102, 338, 152, 21);
		panel.add(memberJoinBtn);
		
		goMainBtn = new JButton("메인으로");
		goMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFrame frame = new 메인클래스(); //메인 탭으로 이동
		        //frame.setVisible(true);
			}
		});
		goMainBtn.setBounds(102, 369, 152, 21);
		panel.add(goMainBtn);
		
		idCheckBtn = new JButton("아이디 중복확인");
		idCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = user_id.getText();
				boolean isAdd;
				try {
					isAdd = mainFrame.userService.idCheck(id);
					if(isAdd==false) {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						user_id.requestFocus();
						user_id.setSelectionStart(0);
						user_id.setSelectionEnd(id.length());
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용하고 있는 아이디입니다.");
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
		idCheckBtn.setBounds(75, 73, 128, 21);
		panel.add(idCheckBtn);
		
		pwCheckBtn = new JButton("비밀번호 확인");
		pwCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1=user_pw.getText();
				String password2=user_pw_check.getText();
				boolean isAdd = password1.equals(password2);
				if(isAdd) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
					user_pw.requestFocus();
					user_pw.setSelectionStart(0);
					user_pw.setSelectionEnd(password1.length());
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					user_pw.requestFocus();
					user_pw.setSelectionStart(0);
					user_pw.setSelectionEnd(password1.length());
				}
			}
		});
		pwCheckBtn.setBounds(75, 153, 128, 21);
		panel.add(pwCheckBtn);
		
	
	}
	
	public void createFormEnable(boolean b) {
		if (b) {
			// 활성화
			user_id.setEditable(true);
			user_pw.setEditable(true);
			user_pw_check.setEditable(true);
			user_name.setEditable(true);
			user_phone.setEditable(true);
			user_address.setEditable(true);
			user_email.setEditable(true);
			
		} else {
			// 비활성화
			user_id.setEditable(false);
			user_pw.setEditable(false);
			user_pw_check.setEditable(false);
			user_name.setEditable(false);
			user_phone.setEditable(false);
			user_address.setEditable(false);
			user_email.setEditable(false);
			
		}

	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
}
