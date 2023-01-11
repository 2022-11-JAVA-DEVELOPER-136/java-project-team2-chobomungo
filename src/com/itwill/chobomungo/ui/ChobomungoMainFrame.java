package com.itwill.chobomungo.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import com.itwill.chobomungo.cart.CartService;
import com.itwill.chobomungo.order.OrderService;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.ui.이원호.OrderPanel;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import com.itwill.chobomungo.ui.박준식.LoginPanel;
import com.itwill.chobomungo.ui.손동필.UserUpdatePanel;
import com.itwill.chobomungo.ui.박정국.UserCreatePanel;
import com.itwill.chobomungo.ui.jihyun.ProductDetailPanel;
import com.itwill.chobomungo.ui.송도현.ProductMainListPanel;
import com.itwill.chobomungo.ui.이수현.CartPannel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class ChobomungoMainFrame extends JFrame {
	/*
	 * Panel상수
	 */
	public static final int PANEL_PRODUCT_LIST = 1;
	public static final int PANEL_PRODUCT_DETAIL = 2;
	
	public static final int PANEL_USER_LOGIN = 3;
	public static final int PANEL_USER_JOIN = 4;
	public static final int PANEL_USER_UPDATE = 5;
	
	/**************서비스객체선언*****************/
	public ProductService productService;
	public OrderService orderService;
	public CartService cartService;
	public UserService userService;
	/*********************************************/
	/*****로그인 user 객체 저장할 user객체*****/
	public User loginUser=null;
	public Product product = null;
	/******************************************/
	
	public JPanel contentPane;
	public JTextField globalSerchTF;
	
	public JTabbedPane productTabbedPane;
	public JTabbedPane userTabbedPane;
	public JTabbedPane chobomungoTabbedPane;
	public OrderPanel orderPanel;
	public LoginPanel loginPanel;
	public CartPannel cartPannel;
	public ProductDetailPanel productDetailPanel;
	public ProductMainListPanel productMainListPanel;
	private UserUpdatePanel userUpdatePanel;
	private UserCreatePanel userCreatePanel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChobomungoMainFrame frame = new ChobomungoMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ChobomungoMainFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		chobomungoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(chobomungoTabbedPane, BorderLayout.CENTER);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		productMainListPanel = new ProductMainListPanel();
		productTabbedPane.addTab("메인", null, productMainListPanel, null);
		
		productDetailPanel = new ProductDetailPanel();
		productDetailPanel.setEnabled(false);
		productTabbedPane.addTab("상품상세", null, productDetailPanel, null);
		
		userTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("유저", null, userTabbedPane, null);
		
		loginPanel = new LoginPanel();
		userTabbedPane.addTab("로그인", null, loginPanel, null);
		
		cartPannel = new CartPannel();
		cartPannel.setEnabled(false);
		chobomungoTabbedPane.addTab("카트", null, cartPannel, null);
		
		orderPanel = new OrderPanel();
		orderPanel.setEnabled(false);
		chobomungoTabbedPane.addTab("주문", null, orderPanel, null);
		
		userCreatePanel = new UserCreatePanel();
		userTabbedPane.addTab("회원가입", null, userCreatePanel, null);
		
		userUpdatePanel = new UserUpdatePanel();
		userTabbedPane.addTab("회원정보", null, userUpdatePanel, null);
		
		JPanel globalNorthPanel = new JPanel();
		globalNorthPanel.setBackground(Color.WHITE);
		globalNorthPanel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(globalNorthPanel, BorderLayout.NORTH);
		globalNorthPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 8, 30, 30);
		lblNewLabel.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/book30.png")));
		globalNorthPanel.add(lblNewLabel);
		
		globalSerchTF = new JTextField();
		globalSerchTF.setBounds(89, 11, 179, 24);
		globalSerchTF.setDisabledTextColor(Color.WHITE);
		globalNorthPanel.add(globalSerchTF);
		globalSerchTF.setColumns(10);
		
		JButton globalSerchBTN = new JButton("");
		globalSerchBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalSerchBTN.setBackground(Color.WHITE);
		globalSerchBTN.setBounds(273, 13, 21, 21);
		globalSerchBTN.setBorder(null);
		globalSerchBTN.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/search20.png")));
		globalSerchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					productService.bookSearchName(globalSerchTF.getText());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		globalNorthPanel.add(globalSerchBTN);
		
		JButton globalCartBTN = new JButton("");
		globalCartBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalCartBTN.setBackground(Color.WHITE);
		globalCartBTN.setBounds(331, 8, 31, 31);
		globalCartBTN.setBorder(null);
		globalCartBTN.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/cart30.png")));
		globalCartBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginUser == null) {
					chobomungoTabbedPane.setSelectedIndex(1);
					userTabbedPane.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
					loginPanel.loginIdTF.requestFocus();
				} else {
					chobomungoTabbedPane.setSelectedIndex(2);
				}
			}
		});
		globalNorthPanel.add(globalCartBTN);
		
		JPanel globalSouthPanel = new JPanel();
		globalSouthPanel.setBackground(Color.WHITE);
		globalSouthPanel.setPreferredSize(new Dimension(10, 70));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		
		JButton globalOrderBTN = new JButton("");
		globalOrderBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalOrderBTN.setBackground(Color.WHITE);
		globalOrderBTN.setBounds(45, 9, 51, 51);
		globalOrderBTN.setBorder(null);
		globalOrderBTN.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/buy_button50.png")));
		globalOrderBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chobomungoTabbedPane.setSelectedIndex(2);
			}
		});
		globalSouthPanel.setLayout(null);
		globalSouthPanel.add(globalOrderBTN);
		
		JButton globalHomeBTN = new JButton("");
		globalHomeBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalHomeBTN.setBackground(Color.WHITE);
		globalHomeBTN.setBounds(155, 9, 51, 51);
		globalHomeBTN.setBorder(null);
		globalHomeBTN.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/home50.png")));
		globalHomeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chobomungoTabbedPane.setSelectedIndex(0);
				productTabbedPane.setSelectedIndex(0);
			}
		});
		globalSouthPanel.add(globalHomeBTN);
		
		JButton globalUserBTN = new JButton("");
		globalUserBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalUserBTN.setBackground(Color.WHITE);
		globalUserBTN.setBounds(270, 10, 51, 51);
		globalUserBTN.setBorder(null);
		globalUserBTN.setIcon(new ImageIcon(ChobomungoMainFrame.class.getResource("/image/uuser50.png")));
		globalUserBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginUser==null) {
					chobomungoTabbedPane.setSelectedIndex(1);
					userTabbedPane.setSelectedIndex(0);
				}else {
					userUpdatePanel.displayMemberInfo(loginUser); 
					chobomungoTabbedPane.setSelectedIndex(1);
					userTabbedPane.setSelectedIndex(2);
				}
			}
		});
		globalSouthPanel.add(globalUserBTN);
		
		/***********서비스객체 생성**************/
		userService = new UserService();
		productService = new ProductService();
		cartService = new CartService();
		orderService = new OrderService();
		/****************************************/
		
		loginPanel.setMainFrame(this);
		orderPanel.setMainFrame(this);
		cartPannel.setMainFrame(this);
		productMainListPanel.setMainFrame(this);
		productDetailPanel.setMainFrame(this);
		userUpdatePanel.setMainFrame(this);
		userCreatePanel.setMainFrame(this);
		
	//생성자끝	
	}
	
	public void serchBook() throws Exception {
		
		List<Product> serchProduct = productService.bookSearchName(globalSerchTF.getText());
		if(serchProduct.size()>=2) {
			for(Product product : serchProduct) {
				globalSerchTF.setText(product.getP_title()+"\n");
				globalSerchTF.requestFocus();
				
			}
		}
	}
}
