package com.itwill.chobomungo.ui.박준식;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
//import java.awt.event.ComponentListener;

public class LoginPanel extends JPanel {
	public JTextField loginIdTF;
	private JPasswordField loginpwTF;
	private JLabel idLB;
	private JLabel pwLB;
	private JButton btnNewButton;
	private JButton joinBtn;
	private JButton searchIDPassword_LB;
	private JLabel loginTitle_LB;
	private ChobomungoMainFrame mainFrame;
	/**
	 * Create the panel.
	 */
	
	/***************** 1.UserService멤버필드 선언 ********************/
	private JButton btnNewButton_1;
	private JLabel loginTitle_LB_1;
	private JPanel loginPanel;
	private JButton loginBtn;
	private JButton searchIDPassword_LB_1;
	private JButton joinBtn_2;
	/******************************************************************/
	
	public LoginPanel() throws Exception{
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(400, 620));
		setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(12, 5, 376, 605);
		add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		idLB.setBounds(41, 131, 57, 15);
		loginPanel.add(idLB);
		
		JLabel pwLB = new JLabel("비밀번호");
		pwLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		pwLB.setBounds(41, 178, 57, 15);
		loginPanel.add(pwLB);
		
		JTextField loginIdTF = new JTextField();
		loginIdTF.setBounds(122, 128, 116, 21);
		loginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		JPasswordField loginpwTF = new JPasswordField();
		loginpwTF.setBounds(122, 175, 116, 21);
		loginPanel.add(loginpwTF);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		loginBtn.setBounds(12, 253, 151, 23);
		loginPanel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****************** 회원 로그인 ******************/
				try {
					String userId = loginIdTF.getText();
					String userPw = new String(loginpwTF.getPassword());
					
					int result = mainFrame.userService.login(userId, userPw);
					if(result == 0) {
						 //////로그인성공
						loginProcess(userId);
						loginIdTF.setText("");
						loginpwTF.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "아이디또는 비밀번호를 확인하세요");
						loginIdTF.setSelectionStart(0);
						loginIdTF.setSelectionEnd(userId.length());
						loginIdTF.requestFocus();
					} 
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JButton joinBtn_2 = new JButton("회원가입");
		joinBtn_2.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		joinBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
				mainFrame.userTabbedPane.setSelectedIndex(1);
			}
		});
		joinBtn_2.setBounds(175, 253, 151, 23);
		loginPanel.add(joinBtn_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/image/초보3.jpg")));
		lblNewLabel.setBounds(122, 17, 97, 70);
		loginPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPanel.class.getResource("/image/login.png")));
		lblNewLabel_1.setBounds(137, 87, 93, 28);
		loginPanel.add(lblNewLabel_1);
		
		JLabel backgroundLB = new JLabel("");
		backgroundLB.setIcon(new ImageIcon(LoginPanel.class.getResource("/image/grass.png")));
		backgroundLB.setBounds(0, 365, 367, 52);
		loginPanel.add(backgroundLB);
		
		
		
	}
	/**************로그인성공시 호출 메쏘드***************/
	private void loginProcess(String userId) throws Exception{
		
		//로그인성공한 멤버객체 멤버필드에저장
		mainFrame.loginUser = mainFrame.userService.findUser(userId);
		//탭변경
		mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
		mainFrame.productTabbedPane.setSelectedIndex(0);
		// 카트와 오더 패널에 로그인 유저의 리스트 디스플레이
		mainFrame.cartPannel.displayCartList();
		//탭 활성화
		mainFrame.userTabbedPane.setEnabledAt(0, false);
		mainFrame.userTabbedPane.setEnabledAt(1, false);
		mainFrame.userTabbedPane.setEnabledAt(2, true);
		mainFrame.chobomungoTabbedPane.setEnabledAt(2,true);
	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	
}
