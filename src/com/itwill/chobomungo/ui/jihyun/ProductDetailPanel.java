package com.itwill.chobomungo.ui.jihyun;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;

import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductDetailPanel extends JPanel {
	
	private JLabel productTitleLB;
	private JLabel productImg;
	private JLabel productPriceLB;
	private JComboBox productAmountCB;
	private JButton productCartBtn;
	private JButton productOrderBtn;
	private JTextArea productDescTA;
	
	private ProductDetailMainFrame productDetailMainFrame;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane productDetailScrollPane = new JScrollPane();
		add(productDetailScrollPane, BorderLayout.EAST);
		
		JPanel productDetailPanel = new JPanel();
		add(productDetailPanel, BorderLayout.CENTER);
		productDetailPanel.setLayout(null);
		
		productCartBtn = new JButton("장바구니");
		productCartBtn.addActionListener(new ActionListener() {
			/******카트에 상품 추가********/
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		productCartBtn.setBounds(240, 194, 117, 40);
		productDetailPanel.add(productCartBtn);
		
			/*******주문페이지로 이동********/
		productOrderBtn = new JButton("구매하기");

		productOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		productOrderBtn.setBounds(240, 248, 117, 40);
		productDetailPanel.add(productOrderBtn);
		
		
		
		
		productImg = new JLabel("");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/chobomungo/ui/jihyun/sample.png")));
		productImg.setBounds(44, 58, 180, 230);
		productDetailPanel.add(productImg);
		
		productTitleLB = new JLabel("상품명");
		productTitleLB.setFont(new Font("D2Coding", Font.BOLD, 20));
		productTitleLB.setBounds(48, 23, 309, 29);
		productDetailPanel.add(productTitleLB);
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(250, 64, 61, 16);
		productDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000000");
		productPriceLB.setFont(new Font("D2Coding", Font.BOLD, 15));
		productPriceLB.setBounds(270, 97, 87, 16);
		productDetailPanel.add(productPriceLB);
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(250, 125, 61, 16);
		productDetailPanel.add(productAmountLB);
		
		JLabel productDescMainLB = new JLabel("상품정보");
		productDescMainLB.setFont(new Font("D2Coding", Font.PLAIN, 15));
		productDescMainLB.setBounds(44, 302, 74, 21);
		productDetailPanel.add(productDescMainLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		productAmountCB.setBounds(270, 153, 66, 29);
		productDetailPanel.add(productAmountCB);
		
		JScrollPane productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(51, 329, 310, 144);
		productDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescTA.setText("상\n품\n정\n보\n상\n품\n상\n세\n설\n명\n책\n줄\n거\n리\n등\n등\n이\n렇\n게\n하\n면\n되\n나");
		productDescScrollPane.setViewportView(productDescTA);

	}
	
	/******* Product 값 불러오기 *********/

	
}
