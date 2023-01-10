package com.itwill.chobomungo.ui.손동필;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;


public class UserUpdatePanel extends JPanel {
	public JTextField updateID_TF;
	public JTextField updatePhone_TF;
	public JTextField updateEmail_TF;
	public JTextField updateName_TF;
	public JTextField updateLoc_TF;

	public JLabel updateTitle_LB;
	public JButton updateFormBtn;
	public JButton updateBtn;
	public JTextField idTF;
	public JLabel idMsgLB;

	/********** 멤버서비스 객체선언 *************/
	public UserService userService;

	/********** 로그인한 회원 ******************/
	User loginUser = new User("book3", "1234", "dp", "010", "address", "email");

	public JTextField updatePassword_TF;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public UserUpdatePanel() throws Exception {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		updateTitle_LB = new JLabel("회원정보");
		updateTitle_LB.setBounds(70, 6, 188, 40);
		updateTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		updateTitle_LB.setFont(new Font("Dialog", Font.BOLD, 20));
		add(updateTitle_LB);

		JLabel updateID_LB = new JLabel("아이디");
		updateID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_LB.setBounds(55, 70, 38, 15);
		add(updateID_LB);

		updateID_TF = new JTextField();
		updateID_TF.setEnabled(false);
		updateID_TF.setBackground(Color.WHITE);
		updateID_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_TF.setColumns(10);
		updateID_TF.setBounds(140, 70, 143, 21);
		add(updateID_TF);

		JLabel updatePassword_LB = new JLabel("비밀번호변경");
		updatePassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePassword_LB.setBounds(55, 100, 78, 15);
		add(updatePassword_LB);

		JLabel updatePhone_LB = new JLabel("핸드폰");
		updatePhone_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_LB.setBounds(55, 160, 57, 15);
		add(updatePhone_LB);

		updatePhone_TF = new JTextField();
		updatePhone_TF.setEditable(false);
		updatePhone_TF.setBackground(Color.WHITE);
		updatePhone_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_TF.setColumns(10);
		updatePhone_TF.setBounds(140, 160, 143, 21);
		add(updatePhone_TF);

		JLabel updateEmail_LB = new JLabel("이메일");
		updateEmail_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_LB.setBounds(55, 220, 57, 15);
		add(updateEmail_LB);

		updateEmail_TF = new JTextField();
		updateEmail_TF.setEditable(false);
		updateEmail_TF.setBackground(Color.WHITE);
		updateEmail_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_TF.setColumns(10);
		updateEmail_TF.setBounds(140, 220, 143, 21);
		add(updateEmail_TF);

		JLabel updateName_LB = new JLabel("이름");
		updateName_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateName_LB.setBounds(55, 130, 57, 15);
		add(updateName_LB);

		updateName_TF = new JTextField();
		updateName_TF.setEnabled(false);
		updateName_TF.setBackground(Color.WHITE);
		updateName_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateName_TF.setColumns(10);
		updateName_TF.setBounds(140, 130, 142, 21);
		add(updateName_TF);

		JLabel updateLoc_LB = new JLabel("주소");
		updateLoc_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_LB.setBounds(55, 190, 57, 15);
		add(updateLoc_LB);

		updateLoc_TF = new JTextField();
		updateLoc_TF.setEditable(false);
		updateLoc_TF.setBackground(Color.WHITE);
		updateLoc_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_TF.setColumns(10);
		updateLoc_TF.setBounds(140, 190, 142, 21);
		add(updateLoc_TF);

		updateFormBtn = new JButton("수정폼");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnText = updateFormBtn.getText();
				if (btnText.equals("수정폼")) {
					updateFormEnable(true);
				} else if (btnText.equals("수정취소")) {
					displayMemberInfo(loginUser);
					updateFormEnable(false);
				}

			}
		});

		updateBtn = new JButton("수정");
		updateBtn.setBounds(190, 273, 102, 21);
		add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					String pw = new String(updatePassword_TF.getText());
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
					int updateCheck = 0;

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
					loginUser = userService.findUser(id);
					updateFormEnable(false);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});

		updateFormBtn.setBounds(60, 273, 97, 21);
		add(updateFormBtn);

		updatePassword_TF = new JTextField();
		updatePassword_TF.setEditable(false);
		updatePassword_TF.setBackground(Color.WHITE);
		updatePassword_TF.setFont(new Font("Dialog", Font.PLAIN, 12));
		updatePassword_TF.setBounds(140, 100, 143, 21);
		add(updatePassword_TF);
		updatePassword_TF.setColumns(10);

		userService = new UserService();
	}

	private void updateFormEnable(boolean b) {
		if (b) {
			// 활성화
//			updateID_TF.setEditable(true);
//			updateName_TF.setEditable(true);
			updatePassword_TF.setEditable(true);
			updatePhone_TF.setEditable(true);
			updateLoc_TF.setEditable(true);
			updateEmail_TF.setEditable(true);

			updateFormBtn.setText("수정취소");
			updateTitle_LB.setText("회원정보수정");
			updateBtn.setEnabled(true);
		} else {
			// 불활성화
			updateID_TF.setEnabled(false);
			updateName_TF.setEnabled(false);
			updatePassword_TF.setEditable(false);
			updatePhone_TF.setEditable(false);
			updateLoc_TF.setEditable(false);
			updateEmail_TF.setEditable(false);
			
			
			updateFormBtn.setText("수정폼");
			updateTitle_LB.setText("회원정보");
			updateBtn.setEnabled(false);
		}

	}

	private void displayMemberInfo(User user) {
		/**** 회원상세데이타보여주기 *****/
		updateID_TF.setText(user.getUserId());
		updatePassword_TF.setText(user.getUserPw());
		updateName_TF.setText(user.getUserName());
		updatePhone_TF.setText(user.getUserPhone());
		updateLoc_TF.setText(user.getUserAddress());
		updateEmail_TF.setText(user.getUserEmail());

	}
}