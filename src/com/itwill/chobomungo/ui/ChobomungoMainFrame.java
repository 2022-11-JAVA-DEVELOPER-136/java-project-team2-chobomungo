package com.itwill.chobomungo.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.ui.이원호.OrderPanel;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.itwill.chobomungo.ui.박준식.LoginPanel;
import com.itwill.chobomungo.ui.손동필.UserUpdatePanel;
import com.itwill.chobomungo.ui.박정국.UserCreatePanel;
import com.itwill.chobomungo.ui.jihyun.ProductDetailPanel;
import com.itwill.chobomungo.ui.송도현.Product_ListPanel_1차_송도현;

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
	/******************************************/
	
	private JPanel contentPane;
	private JTextField globalSerchTF;
	
	private JTabbedPane productTabbedPane;
	private JTabbedPane userTabbedPane;
	private JTabbedPane chobomungoTabbedPane;
	private OrderPanel orderPanel;
	private LoginPanel loginPanel;
	
	
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		chobomungoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(chobomungoTabbedPane, BorderLayout.CENTER);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		ProductDetailPanel productDetailPanel = new ProductDetailPanel();
		productTabbedPane.addTab("New tab", null, productDetailPanel, null);
		
		Product_ListPanel_1차_송도현 product_ListPanel_1차_송도현 = new Product_ListPanel_1차_송도현();
		productTabbedPane.addTab("New tab", null, product_ListPanel_1차_송도현, null);
		
		userTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("유저", null, userTabbedPane, null);
		
		loginPanel = new LoginPanel();
		userTabbedPane.addTab("로그인", null, loginPanel, null);
		
		orderPanel = new OrderPanel();
		chobomungoTabbedPane.addTab("주문", null, orderPanel, null);
		
		JPanel globalNorthPanel = new JPanel();
		globalNorthPanel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(globalNorthPanel, BorderLayout.NORTH);
		
		globalSerchTF = new JTextField();
		globalSerchTF.setDisabledTextColor(Color.WHITE);
		globalNorthPanel.add(globalSerchTF);
		globalSerchTF.setColumns(10);
		
		JButton globalSerchBTN = new JButton("검색");
		globalNorthPanel.add(globalSerchBTN);
		
		JButton globalCartBTN = new JButton("카트");
		globalCartBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chobomungoTabbedPane.setSelectedIndex(3);
			}
		});
		globalNorthPanel.add(globalCartBTN);
		
		JPanel globalSouthPanel = new JPanel();
		globalSouthPanel.setPreferredSize(new Dimension(10, 70));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		
		JButton globalOrderBTN = new JButton("주문");
		globalOrderBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chobomungoTabbedPane.setSelectedIndex(2);
			}
		});
		globalSouthPanel.add(globalOrderBTN);
		
		JButton globalHomeBTN = new JButton("홈");
		globalHomeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chobomungoTabbedPane.setSelectedIndex(0);
			}
		});
		globalSouthPanel.add(globalHomeBTN);
		
		JButton globalUserBTN = new JButton("유저");
		globalUserBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginUser==null) {
					chobomungoTabbedPane.setSelectedIndex(0);
					//login_idTF.requestFocus();
				}else {
					//chobomungoTabbedPane.setSelectedIndex(1);
					
				}
			}
		});
		globalSouthPanel.add(globalUserBTN);
		
		
		
		loginPanel.setMainFrame(this);
		
		UserCreatePanel userCreatePanel = new UserCreatePanel();
		userTabbedPane.addTab("회원가입", null, userCreatePanel, null);
		
		UserUpdatePanel userUpdatePanel = new UserUpdatePanel();
		userTabbedPane.addTab("회원정보", null, userUpdatePanel, null);
		orderPanel.setMainFrame(this);
		
		
		/***********서비스객체 생성**************/
		userService = new UserService();
		productService = new ProductService();
		cartService = new CartService();
		orderService = new OrderService();
		/****************************************/
		
	//생성자끝	
	}
	
	/*************패널변경메쏘드**************/
	public void changePanel(int panel_no) {
		if(panel_no == PANEL_PRODUCT_LIST) {
			chobomungoTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(0);
		}else if(panel_no == PANEL_PRODUCT_DETAIL){
			chobomungoTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(1);
		}else if(panel_no == PANEL_USER_LOGIN){
			chobomungoTabbedPane.setSelectedIndex(1);
			userTabbedPane.setSelectedIndex(0);
		}else if(panel_no == PANEL_USER_JOIN){
			chobomungoTabbedPane.setSelectedIndex(1);
			userTabbedPane.setSelectedIndex(1);
		}else if(panel_no == PANEL_USER_UPDATE){
			chobomungoTabbedPane.setSelectedIndex(1);
			userTabbedPane.setSelectedIndex(2);
		}
	
	}
}
