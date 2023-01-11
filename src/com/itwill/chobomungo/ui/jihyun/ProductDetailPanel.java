package com.itwill.chobomungo.ui.jihyun;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import com.itwill.chobomungo.cart.CartService;
import com.itwill.chobomungo.order.OrderService;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.UserService;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class ProductDetailPanel extends JPanel {
	
	public ProductService productService;
	public CartService cartService;
	public UserService userService;
	public OrderService orderService;
	public Product product;
	public Product selectProduct;
	
	public JLabel productTitleLB;
	public JLabel productImg;
	public JScrollPane productDescScrollPane;
	public JLabel productPriceLB;
	public JComboBox productAmountCB;
	public JButton productOrderBtn;
	public JTextArea productDescTA;

	public ChobomungoMainFrame mainFrame;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductDetailPanel() throws Exception {
		setPreferredSize(new Dimension(400, 500));
		setLayout(new BorderLayout(0, 0));
		
		productService = new ProductService();
		
		JScrollPane ProductDetailScrollPane = new JScrollPane();
		ProductDetailScrollPane.setPreferredSize(new Dimension(400, 500));
		add(ProductDetailScrollPane, BorderLayout.CENTER);
		
		JPanel ProductDetailPanel = new JPanel();
		ProductDetailPanel.setPreferredSize(new Dimension(400, 500));
		ProductDetailScrollPane.setViewportView(ProductDetailPanel);
		ProductDetailPanel.setLayout(null);
		
		/***************상품정보****************/		
		
		productTitleLB = new JLabel("소설5");
		productTitleLB.setFont(new Font("Dialog", Font.BOLD, 20));
		productTitleLB.setBounds(30, 10, 295, 29);
		ProductDetailPanel.add(productTitleLB);
		
		productImg = new JLabel("\\book.png");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/chobomungo/ui/jihyun/sample.png")));
		productImg.setBounds(30, 58, 160, 200);
		ProductDetailPanel.add(productImg);
		
		JLabel productDescMainLB = new JLabel("상품상세정보");
		productDescMainLB.setBounds(30, 291, 100, 21);
		ProductDetailPanel.add(productDescMainLB);
		
		productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(30, 321, 300, 144);
		ProductDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescScrollPane.setViewportView(productDescTA);
		productDescTA.setText("상품설명");
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(215, 56, 61, 16);
		ProductDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000원");
		productPriceLB.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		productPriceLB.setBounds(250, 87, 87, 16);
		ProductDetailPanel.add(productPriceLB);
		
		/****************************************************/
		displayProductDetail(6);
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(215, 125, 61, 16);
		ProductDetailPanel.add(productAmountLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		productAmountCB.setBounds(254, 145, 66, 29);
		ProductDetailPanel.add(productAmountCB);
		
		JButton productCartBtn = new JButton("장바구니");
		productCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 된 상태일 경우  
				
				/******카트에 상품 추가********/
				
		
				//메세지 출력
				JOptionPane.showMessageDialog(null, "장바구니에 상품이 추가되었습니다.");

			//로그인 안했을 때 
				/********로그인 창 띄우기*******/
			
			}
		});
		productCartBtn.setBounds(219, 185, 100, 35);
		ProductDetailPanel.add(productCartBtn);
		
		productOrderBtn = new JButton("구매하기");
		productOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 된 상태일 경우 
				/*******주문페이지로 이동********/
				
				
			//로그인 안했을 때 
				/********로그인 창 띄우기*******/
			}
		});
		productOrderBtn.setBounds(219, 225, 100, 35);
		ProductDetailPanel.add(productOrderBtn);

	}
	
	
	public void displayProductDetail(int p_no) throws Exception{
		
		selectProduct = productService.bookSearchNumber(p_no);
		productTitleLB.setText(selectProduct.getP_title());
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource(selectProduct.getP_image())));
		productDescTA.setText(selectProduct.getP_desc());
		productPriceLB.setText(selectProduct.getP_price()+"원");
		
	}

	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
