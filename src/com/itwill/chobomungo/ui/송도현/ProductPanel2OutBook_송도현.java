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
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.user.UserService;
import com.sun.javafx.event.EventQueue;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
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

public class ProductPanel2OutBook_송도현 extends JPanel {
	
	private ProductService productService;
	private UserService userService;
	private CartService cartService;
	private OrderService orderService;
	
	
	private JPanel productPanel1;
	private JPanel productPanel2;
	private JPanel productPanel3;
	private JButton productImage1Btn;
	private JTextPane productSumDesc1Text;
	private JButton productDetailDesc1Btn;
	private JComboBox cartQty1Combo;
	private JButton product1CartAddBtn;
	private JButton productImage2Btn;
	private JTextPane productSumDesc2Text;
	private JButton productDetailDesc2Btn;
	private JComboBox cartQtyCombo2;
	private JButton product2CartAddBtn;
	private JButton productImage3Btn;
	private JTextPane productSumDesc3Text;
	private JButton productDetailDesc3Btn;
	private JComboBox cartQty3Combo;
	private JButton product3CartAddBtn;
	public ProductPanel2OutBook_송도현(JTabbedPane shopTabbedPane) {
		
	}
	/*
	 * application 앱 시작
	 */
	public static void main(String[] args) {
		
	}
	
	
	
	/*
	 * Create the panel->전체도서 탭 디자인 시작
	 */
	
	JPanel productJPanel=new JPanel();
	
	
	
	
	
	public ProductPanel2OutBook_송도현() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel productInBookContentPanel = new JPanel();
		productInBookContentPanel.setBounds(0, 0, 400, 620);
		add(productInBookContentPanel);
		productInBookContentPanel.setLayout(null);
		
		productPanel1 = new JPanel();
		productPanel1.setBackground(Color.WHITE);
		productPanel1.setBounds(0, 23, 400, 176);
		productInBookContentPanel.add(productPanel1);
		productPanel1.setLayout(null);
		
		productImage1Btn = new JButton("");
		productImage1Btn.setBorder(null);
		productImage1Btn.setOpaque(false);
		productImage1Btn.setBackground(Color.WHITE);
		productImage1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
			}
		});
		
		
		productImage1Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productImage1Btn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/product_Image/해외도서1.png")));
		productImage1Btn.setBounds(0, 10, 153, 166);
		productPanel1.add(productImage1Btn);
		
		productSumDesc1Text = new JTextPane();
		productSumDesc1Text.setFont(new Font("굴림", Font.PLAIN, 12));
		productSumDesc1Text.setText("상품번호: 4\r\n상품명: 미드나잇라이브러리\r\n가격: 15,000원");
		productSumDesc1Text.setBounds(164, 47, 160, 75);
		productPanel1.add(productSumDesc1Text);
		
		productDetailDesc1Btn = new JButton("제품상세보기");
		productDetailDesc1Btn.setBackground(new Color(240, 240, 240));
		productDetailDesc1Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productDetailDesc1Btn.setBounds(165, 122, 159, 44);
		productPanel1.add(productDetailDesc1Btn);
		
		cartQty1Combo = new JComboBox();
		cartQty1Combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartQty1Combo.setBounds(164, 20, 42, 29);
		productPanel1.add(cartQty1Combo);
		cartQty1Combo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		product1CartAddBtn = new JButton("");
		product1CartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		product1CartAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">> 카트담기...");
			}
		});
		product1CartAddBtn.setBorder(null);
		product1CartAddBtn.setBounds(206, 10, 42, 50);
		product1CartAddBtn.setBorder(null);
		product1CartAddBtn.setBackground(Color.WHITE);
		product1CartAddBtn.setOpaque(false);
		product1CartAddBtn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/image/smallcart.png")));
		productPanel1.add(product1CartAddBtn);
		
		productPanel2 = new JPanel();
		productPanel2.setLayout(null);
		productPanel2.setBackground(Color.WHITE);
		productPanel2.setBounds(0, 222, 400, 176);
		productInBookContentPanel.add(productPanel2);
		
		productImage2Btn = new JButton("");
		productImage2Btn.setBorder(null);
		productImage2Btn.setOpaque(false);
		productImage2Btn.setBackground(Color.WHITE);
		productImage2Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productImage2Btn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/product_Image/해외도서2.png")));
		productImage2Btn.setBounds(0, 0, 152, 176);
		productPanel2.add(productImage2Btn);
		
		productSumDesc2Text = new JTextPane();
		productSumDesc2Text.setText("상품번호: 5\r\n상품명: 테라피스트\r\n가격: 20,000원");
		productSumDesc2Text.setFont(new Font("굴림", Font.PLAIN, 12));
		productSumDesc2Text.setBounds(164, 47, 159, 63);
		productPanel2.add(productSumDesc2Text);
		
		productDetailDesc2Btn = new JButton("제품상세보기");
		productDetailDesc2Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productDetailDesc2Btn.setBounds(164, 110, 159, 44);
		productPanel2.add(productDetailDesc2Btn);
		
		cartQtyCombo2 = new JComboBox();
		cartQtyCombo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartQtyCombo2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartQtyCombo2.setBounds(164, 20, 42, 29);
		productPanel2.add(cartQtyCombo2);
		
		product2CartAddBtn = new JButton("");
		product2CartAddBtn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/image/smallcart.png")));
		product2CartAddBtn.setOpaque(false);
		product2CartAddBtn.setBorder(null);
		product2CartAddBtn.setBackground(Color.WHITE);
		product2CartAddBtn.setBounds(206, 10, 42, 50);
		productPanel2.add(product2CartAddBtn);
		
		productPanel3 = new JPanel();
		productPanel3.setLayout(null);
		productPanel3.setBackground(Color.WHITE);
		productPanel3.setBounds(0, 420, 400, 176);
		productInBookContentPanel.add(productPanel3);
		
		productImage3Btn = new JButton("");
		productImage3Btn.setBackground(Color.WHITE);
		productImage3Btn.setBorder(null);
		productImage3Btn.setOpaque(false);
		productImage3Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productImage3Btn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/product_Image/해외도서3.png")));
		productImage3Btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		productImage3Btn.setBounds(0, 0, 152, 176);
		productPanel3.add(productImage3Btn);
		
		productSumDesc3Text = new JTextPane();
		productSumDesc3Text.setText("상품번호: 6\r\n상품명: 노르웨이의 숲\r\n가격: 20,000원");
		productSumDesc3Text.setFont(new Font("굴림", Font.PLAIN, 12));
		productSumDesc3Text.setBounds(164, 47, 159, 57);
		productPanel3.add(productSumDesc3Text);
		
		productDetailDesc3Btn = new JButton("제품상세보기");
		productDetailDesc3Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productDetailDesc3Btn.setBounds(164, 110, 159, 44);
		productPanel3.add(productDetailDesc3Btn);
		
		cartQty3Combo = new JComboBox();
		cartQty3Combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartQty3Combo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartQty3Combo.setBounds(164, 20, 42, 29);
		productPanel3.add(cartQty3Combo);
		
		product3CartAddBtn = new JButton("");
		product3CartAddBtn.setIcon(new ImageIcon(ProductPanel2OutBook_송도현.class.getResource("/image/smallcart.png")));
		product3CartAddBtn.setOpaque(false);
		product3CartAddBtn.setBorder(null);
		product3CartAddBtn.setBackground(Color.WHITE);
		product3CartAddBtn.setBounds(206, 10, 42, 50);
		productPanel3.add(product3CartAddBtn);


	
	
	
	}
}
