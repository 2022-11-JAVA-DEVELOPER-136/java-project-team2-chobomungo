package com.itwill.chobomungo.ui.jihyun;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.cart.CartService;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;

import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductDetailPanel extends JPanel {
	
	private ProductService productService;
	private CartService cartService;
	private Product Product;
	
	private JLabel productTitleLB;
	private JLabel productImg;
	private JLabel productPriceLB;
	private JComboBox productAmountCB;
	private JButton productCartBtn;
	private JButton productOrderBtn;
	private JTextArea productDescTA;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductDetailPanel() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		productService = new ProductService();
		
		JScrollPane productDetailScrollPane = new JScrollPane();
		add(productDetailScrollPane, BorderLayout.EAST);
		
		JPanel productDetailPanel = new JPanel();
		add(productDetailPanel, BorderLayout.CENTER);
		productDetailPanel.setLayout(null);
		
		productCartBtn = new JButton("장바구니");
		
		productCartBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			//로그인 된 상태일 경우  
				
				/******카트에 상품 추가********
				
		
				//메세지 출력
				JOptionPane.showMessageDialog(null, "장바구니에 상품이 추가되었습니다.");

			//로그인 안했을 때 
				/********로그인 창 띄우기*******/
			
				
			}
		});
		productCartBtn.setBounds(240, 194, 117, 40);
		productDetailPanel.add(productCartBtn);
		
		productOrderBtn = new JButton("구매하기");

		productOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//로그인 된 상태일 경우 
				/*******주문페이지로 이동********/
				
				
			//로그인 안했을 때 
				/********로그인 창 띄우기*******/
			}
		});
		
		Product p = Product;
		
		productOrderBtn.setBounds(240, 248, 117, 40);
		productDetailPanel.add(productOrderBtn);
		
		
		productImg = new JLabel("");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/chobomungo/ui/jihyun/sample.png")));
		productImg.setBounds(40, 58, 180, 230);
		productDetailPanel.add(productImg);
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource(productService.bookSearchNumber(9).getP_image())));
		//productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource(productService.bookSearchNumber(p.get_no()).getP_image())));
		
		
		productTitleLB = new JLabel("상품명");
		productTitleLB.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		productTitleLB.setBounds(40, 17, 309, 29);
		productDetailPanel.add(productTitleLB);
		//productTitleLB.setText(productService.bookSearchNumber(p.getP_no()).getP_title());
		productTitleLB.setText(productService.bookSearchNumber(1).getP_title());
		
		
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(250, 64, 61, 16);
		productDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000000");
		productPriceLB.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		productPriceLB.setBounds(270, 97, 87, 16);
		productDetailPanel.add(productPriceLB);
		productPriceLB.setText(productService.bookSearchNumber(1).getP_price()+"원");
		//productPriceLB.setText(productService.bookSearchNumber(p.getP_no()).getP_price()+"원");
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(250, 125, 61, 16);
		productDetailPanel.add(productAmountLB);
		
		JLabel productDescMainLB = new JLabel("상품상세정보");
		productDescMainLB.setBounds(40, 305, 74, 21);
		productDetailPanel.add(productDescMainLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		productAmountCB.setBounds(270, 153, 66, 29);
		productDetailPanel.add(productAmountCB);
		
		JScrollPane productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(40, 327, 310, 144);
		productDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescTA.setText("상\n품\n정\n보\n상\n품\n상\n세\n설\n명\n책\n줄\n거\n리\n등\n등\n이\n렇\n게\n하\n면\n되\n나");
		productDescScrollPane.setColumnHeaderView(productDescTA);
		productDescTA.setText(productService.bookSearchNumber(1).getP_desc());
		//productDescTA.setText(productService.bookSearchNumber(p.getP_no()).getP_desc());

	}
	


	
}
