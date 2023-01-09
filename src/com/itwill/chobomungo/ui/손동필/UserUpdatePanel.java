package com.itwill.chobomungo.ui.손동필;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;



public class UserUpdatePanel extends JPanel {
	private JTextField updateID_TF;
	private JPasswordField updatePassword_TF;
	private JTextField updatePhone_TF;
	private JTextField updateEmail_TF;
	private JTextField updateName_TF;
	private JTextField updateLoc_TF;
	private JTextField idTF;
	private JLabel idMsgLB;

	/********** 멤버서비스 객체선언 *************/
	private UserService userService;

	/********** 로그인한 회원 ******************/
	private User loginUser;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public UserUpdatePanel() throws Exception {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel updateTitle_LB = new JLabel("회원정보수정");
		updateTitle_LB.setBounds(99, 73, 188, 40);
		updateTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		updateTitle_LB.setFont(new Font("Dialog", Font.BOLD, 25));
		add(updateTitle_LB);

		JLabel updateID_LB = new JLabel("아이디");
		updateID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_LB.setBounds(50, 160, 57, 15);
		add(updateID_LB);

		updateID_TF = new JTextField();
		updateID_TF.setBackground(new Color(245, 245, 245));
		updateID_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_TF.setColumns(10);
		updateID_TF.setBounds(150, 160, 143, 21);
		add(updateID_TF);

		JLabel updatePassword_LB = new JLabel("비밀번호변경");
		updatePassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePassword_LB.setBounds(34, 200, 97, 15);
		add(updatePassword_LB);

		updatePassword_TF = new JPasswordField();
		updatePassword_TF.setColumns(20);
		updatePassword_TF.setBackground(new Color(245, 245, 245));
		updatePassword_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePassword_TF.setBounds(150, 199, 143, 21);
		add(updatePassword_TF);

		JLabel updatePhone_LB = new JLabel("핸드폰");
		updatePhone_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_LB.setBounds(50, 320, 57, 15);
		add(updatePhone_LB);

		updatePhone_TF = new JTextField();
		updatePhone_TF.setBackground(new Color(245, 245, 245));
		updatePhone_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_TF.setColumns(10);
		updatePhone_TF.setBounds(150, 240, 143, 21);
		add(updatePhone_TF);

		JLabel updateEmail_LB = new JLabel("이메일");
		updateEmail_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_LB.setBounds(50, 360, 57, 15);
		add(updateEmail_LB);

		updateEmail_TF = new JTextField();
		updateEmail_TF.setBackground(new Color(245, 245, 245));
		updateEmail_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_TF.setColumns(10);
		updateEmail_TF.setBounds(150, 320, 143, 21);
		add(updateEmail_TF);

		JLabel updateName_LB = new JLabel("이름");
		updateName_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateName_LB.setBounds(50, 240, 57, 15);
		add(updateName_LB);

		updateName_TF = new JTextField();
		updateName_TF.setBackground(new Color(245, 245, 245));
		updateName_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateName_TF.setColumns(10);
		updateName_TF.setBounds(150, 280, 142, 21);
		add(updateName_TF);

		JLabel updateLoc_LB = new JLabel("주소");
		updateLoc_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_LB.setBounds(50, 280, 57, 15);
		add(updateLoc_LB);

		updateLoc_TF = new JTextField();
		updateLoc_TF.setBackground(new Color(245, 245, 245));
		updateLoc_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_TF.setColumns(10);
		updateLoc_TF.setBounds(150, 360, 142, 21);
		add(updateLoc_TF);

		JButton updateBtn = new JButton("회원정보 수정하기");
		updateBtn.setBounds(137, 413, 180, 23);
		add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					String pw = new String(updatePassword_TF.getPassword());
					String name = updateName_TF.getText();
					String phoneNumber = updatePhone_TF.getText();
					String loc = updateLoc_TF.getText();
					String email = updateEmail_TF.getText();

					if (id.equals("") || pw.equals("") || name.equals("") || phoneNumber.equals("") || loc.equals("")
							|| email.equals("")) {
						idMsgLB.setText("내용을 입력하세요.");
						 updateID_TF.requestFocus();
						return;
					}
					User updateUser2 = new User(id, pw, name, phoneNumber, loc, email);
					int updateCheck =0;

					updateCheck = userService.update(updateUser2);

					if (updateCheck == -1) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
					} else if (updateCheck == -2) {
						JOptionPane.showMessageDialog(null, "비밀번호 8~16 길이로 사용하세요");
					} else if (updateCheck == -3) {
						JOptionPane.showMessageDialog(null, "대소문자 각 하나 이상 사용하세요.");
					} else if (updateCheck == -4) {
						JOptionPane.showMessageDialog(null, "특수문자 !,~,@,#,$,*,^ 사용하세요");
					} else {
						JOptionPane.showMessageDialog(null, "회원정보 수정완료");
					}
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});

		JButton updateCancleBtn = new JButton("메인으로");
		updateCancleBtn.setBounds(137, 511, 180, 23);
		add(updateCancleBtn);

		JButton deleteBtn = new JButton("회원 탈퇴하기");
		deleteBtn.setBounds(137, 464, 180, 23);
		add(deleteBtn);
	
	


	
		
		
		loginUser = new User("son", null, null, null, null, null);
	

	
	
	
		userService = new UserService();
	}
}