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
import com.itwill.chobomungo.user.UserService;

import javax.swing.ImageIcon;

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

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductDetailPanel() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		productService = new ProductService();
		
		JScrollPane ProductDetailScrollPane = new JScrollPane();
		add(ProductDetailScrollPane, BorderLayout.CENTER);
		
		JPanel ProductDetailPanel = new JPanel();
		ProductDetailScrollPane.setViewportView(ProductDetailPanel);
		ProductDetailPanel.setLayout(null);
		
		/***************상품정보****************/		
		
		productTitleLB = new JLabel("소설5");
		productTitleLB.setFont(new Font("Dialog", Font.BOLD, 20));
		productTitleLB.setBounds(41, 35, 295, 29);
		ProductDetailPanel.add(productTitleLB);
		
		productImg = new JLabel("\\book.png");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/chobomungo/ui/jihyun/sample.png")));
		productImg.setBounds(41, 83, 160, 200);
		ProductDetailPanel.add(productImg);
		
		JLabel productDescMainLB = new JLabel("상품상세정보");
		productDescMainLB.setBounds(41, 316, 74, 21);
		ProductDetailPanel.add(productDescMainLB);
		
		productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(41, 346, 300, 144);
		ProductDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescScrollPane.setViewportView(productDescTA);
		productDescTA.setText("상품설명");
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(226, 81, 61, 16);
		ProductDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000원");
		productPriceLB.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		productPriceLB.setBounds(261, 112, 87, 16);
		ProductDetailPanel.add(productPriceLB);
		
		/****************************************************/
		displayProductDetail(3);
		
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(226, 150, 61, 16);
		ProductDetailPanel.add(productAmountLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setBounds(265, 170, 66, 29);
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
		productCartBtn.setBounds(230, 210, 100, 35);
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
		productOrderBtn.setBounds(230, 250, 100, 35);
		ProductDetailPanel.add(productOrderBtn);

	}
	
	
	private void displayProductDetail(int p_no) throws Exception{
		
		selectProduct = productService.bookSearchNumber(p_no);
		productTitleLB.setText(selectProduct.getP_title());
		productImg.setText(selectProduct.getP_image());
		productDescTA.setText(selectProduct.getP_desc());
		productPriceLB.setText(selectProduct.getP_price()+"원");
		
	}

}
