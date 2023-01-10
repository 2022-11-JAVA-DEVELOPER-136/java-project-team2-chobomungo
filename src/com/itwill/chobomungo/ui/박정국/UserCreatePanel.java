package com.itwill.chobomungo.ui.박정국;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserCreatePanel extends JPanel {
	private JTextField user_id;
	private JTextField user_pw;
	private JTextField user_pw_check;
	private JTextField user_name;
	private JTextField user_phone;
	private JTextField user_address;
	private JTextField user_email;

	/**
	 * Create the panel
	 */
	
	UserService userService;
	
	public UserCreatePanel() throws Exception {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 620);
		add(panel);
		panel.setLayout(null);
		
		JLabel panelTitle = new JLabel("회원가입");
		panelTitle.setFont(new Font("굴림", Font.PLAIN, 15));
		panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.setBounds(36, 10, 159, 29);
		panel.add(panelTitle);
		
		user_id = new JTextField();
		user_id.setText("아이디");
		user_id.setBounds(12, 49, 212, 21);
		panel.add(user_id);
		user_id.setColumns(10);
		
		
		user_pw = new JTextField();
		user_pw.setText("비밀번호");
		user_pw.setBounds(12, 92, 212, 21);
		panel.add(user_pw);
		user_pw.setColumns(10);
		
		user_pw_check = new JTextField();
		user_pw_check.setText("비밀번호 확인");
		user_pw_check.setBounds(12, 123, 212, 21);
		panel.add(user_pw_check);
		user_pw_check.setColumns(10);
		
		
		user_name = new JTextField();
		user_name.setText("이름");
		user_name.setBounds(12, 170, 212, 21);
		panel.add(user_name);
		user_name.setColumns(10);
		
		user_phone = new JTextField();
		user_phone.setText("연락처");
		user_phone.setBounds(12, 201, 212, 21);
		panel.add(user_phone);
		user_phone.setColumns(10);
		
		user_address = new JTextField();
		user_address.setText("주소");
		user_address.setBounds(12, 232, 212, 21);
		panel.add(user_address);
		user_address.setColumns(10);
		
		user_email = new JTextField();
		user_email.setText("이메일");
		user_email.setBounds(12, 263, 212, 21);
		panel.add(user_email);
		user_email.setColumns(10);
		
		JButton memberJoinBtn = new JButton("회원가입 완료");
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
					int isAdd = userService.create(newMember);
					if(isAdd==1) {
						//로그인화면전환
						System.out.println("생성완료.");
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
		memberJoinBtn.setBounds(36, 304, 152, 21);
		panel.add(memberJoinBtn);
		
		JButton goMainBtn = new JButton("메인으로");
		goMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFrame frame = new 메인클래스(); //메인 탭으로 이동
		        //frame.setVisible(true);
			}
		});
		goMainBtn.setBounds(36, 335, 152, 21);
		panel.add(goMainBtn);

		JLabel lblNewLabel_1 = new JLabel("아이디 중복확인");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = user_id.getText();
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
		
		lblNewLabel_1.setBounds(12, 74, 97, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호 확인");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
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
		
		lblNewLabel_2.setBounds(12, 149, 105, 15);
		panel.add(lblNewLabel_2);
		
		userService= new UserService();
		
		
	}
}
