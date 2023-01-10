package com.itwill.chobomungo.ui.송도현;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.chobomungo.cart.CartService;
import com.itwill.chobomungo.order.OrderService;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;
import com.sun.javafx.event.EventQueue;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class Product_ListPanel_송도현 extends JPanel {
	
	
	//Service 객체 생성
	ProductService productService;
//	UserService userService;
//	CartService cartService;
//	OrderService orderService;
	
	//loginMember 객체 생성
	User user;
	
	//
	private JLabel ProductListLB;
	private JPanel ProductListPanel;
	
	
	/*
	 * create panel
	 * throw exception
	 */
	

	public Product_ListPanel_송도현() throws Exception {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane productTotalListScrollPane = new JScrollPane();
		productTotalListScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productTotalListScrollPane.setPreferredSize(new Dimension(10, 10));
		productTotalListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		productTotalListScrollPane.setBounds(0, 10, 400, 488);
		add(productTotalListScrollPane);
		
		JPanel productListPanel = new JPanel();
		productListPanel.setPreferredSize(new Dimension(10, 700));
		productTotalListScrollPane.setViewportView(productListPanel);
		productListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//제품패널 생성//
		JPanel productPanel1 = new JPanel();
		productPanel1.setBackground(Color.WHITE);
		productPanel1.setPreferredSize(new Dimension(370, 180));
		productPanel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productListPanel.add(productPanel1);
		productPanel1.setLayout(null);
		
		JButton ProductDetailDescBtn = new JButton("제품상세보기");
		ProductDetailDescBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ProductDetailDescBtn.setBounds(162, 118, 176, 41);
		productPanel1.add(ProductDetailDescBtn);
		//->클릭 시 제품 상세페이지로 이동함
		
		JButton InBook1ImageBtn = new JButton("");
		InBook1ImageBtn.setBorder(null);
		InBook1ImageBtn.setIcon(new ImageIcon(Product_ListPanel_송도현.class.getResource("/product_Image/국내도서1.png")));
		InBook1ImageBtn.setOpaque(false);
		InBook1ImageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		InBook1ImageBtn.setBackground(Color.WHITE);
		InBook1ImageBtn.setBounds(12, 0, 138, 180);
		productPanel1.add(InBook1ImageBtn);
		
		JComboBox CartQtyComboBox = new JComboBox();
		CartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		CartQtyComboBox.setBounds(162, 15, 40, 23);
		productPanel1.add(CartQtyComboBox);
		
		JButton CartBtn = new JButton("");
		CartBtn.setBorder(null);
		CartBtn.setBackground(Color.WHITE);
		CartBtn.setOpaque(false);
		CartBtn.setIcon(new ImageIcon(Product_ListPanel_송도현.class.getResource("/image/smallcart.png")));
		CartBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CartBtn.setBounds(207, 10, 40, 28);
		productPanel1.add(CartBtn);
		//->클릭 시 장바구니에 담김: 장바구니 페이지는 안들어가고 장바구니 아이콘 숫자로 수량 증가 확인 가능함
		
		JLabel SumLabel = new JLabel("<html>상품번호: 1<br>상품명: 만일 내가 인생을 다시 산다면<br>가격: 10,000원</html>");
		SumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		SumLabel.setForeground(Color.BLACK);
		SumLabel.setBackground(Color.WHITE);
		SumLabel.setBounds(162, 44, 176, 76);
		productPanel1.add(SumLabel);
		
		//
		productListPanel.add(productPanel1);
		
		
		//객체 생성
		ProductService productService=new ProductService();
		
		user=new User("son", null,null,null,null,null);
		productList();
		
	}

		private void productList() throws Exception {
			List<Product> productList=productService.productList();
			ProductListPanel.removeAll();
			
			for(Product product: productList) {
				JPanel productPanel= new JPanel();
				productPanel.setBackground(Color.WHITE);
				productPanel.setPreferredSize(new Dimension(370, 180));
				productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				ProductListPanel.add(productPanel);
				productPanel.setLayout(null);
				
				JButton ProductDetailDescBtn = new JButton("제품상세보기");
				ProductDetailDescBtn.setBounds(162, 118, 176, 41);
				productPanel.add(ProductDetailDescBtn);
				//버튼 클릭 시 제품 상세보기 페이지로 이동
				
				JButton InBook1ImageBtn = new JButton("");
				InBook1ImageBtn.setBorder(null);
				InBook1ImageBtn.setIcon(new ImageIcon(Product_ListPanel_송도현.class.getResource(product.getP_image())));
				InBook1ImageBtn.setOpaque(false);
				InBook1ImageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				InBook1ImageBtn.setBackground(Color.WHITE);
				InBook1ImageBtn.setBounds(12, 0, 138, 180);
				productPanel.add(InBook1ImageBtn);
				
				JComboBox CartQtyComboBox = new JComboBox();
				CartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				CartQtyComboBox.setBounds(162, 15, 40, 23);
				productPanel.add(CartQtyComboBox);
				
				JButton CartBtn = new JButton("");
				CartBtn.setBorder(null);
				CartBtn.setBackground(Color.WHITE);
				CartBtn.setOpaque(false);
				CartBtn.setIcon(new ImageIcon(Product_ListPanel_송도현.class.getResource("/image/smallcart.png"))); //동일한 장바구니 아이콘
				CartBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				CartBtn.setBounds(207, 10, 40, 28);
				productPanel.add(CartBtn);
				
				JLabel SumLabel = new JLabel("<html>상품번호:"+product.getP_no()+ "<br>상품명: "+product.getP_title()
				+ "<br>가격: "+product.getP_price()+ "</html>");
				SumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
				SumLabel.setForeground(Color.BLACK);
				SumLabel.setBackground(Color.WHITE);
				SumLabel.setBounds(162, 44, 176, 76);
				productPanel.add(SumLabel);
				
				//
				ProductListPanel.add(productPanel);
				
			}
			
	}
}
