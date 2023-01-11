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
	
	public ChobomungoMainFrame mainFrame;
	
	public JLabel productTitleLB;
	public JLabel productImg;
	public JScrollPane productDescScrollPane;
	public JLabel productPriceLB;
	public JComboBox productAmountCB;
	public JButton productOrderBtn;
	public JTextArea productDescTA;

	private JPanel productDetailPanel;
	private JScrollPane ProductDetailScrollPane;
	private JButton productCartBtn_1;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductDetailPanel() throws Exception {
		setPreferredSize(new Dimension(400, 500));
		setLayout(new BorderLayout(0, 0));
		
		ProductDetailScrollPane = new JScrollPane();
		ProductDetailScrollPane.setPreferredSize(new Dimension(400, 500));
		add(ProductDetailScrollPane, BorderLayout.CENTER);
		
		productDetailPanel = new JPanel();
		productDetailPanel.setPreferredSize(new Dimension(400, 500));
		ProductDetailScrollPane.setViewportView(productDetailPanel);
		productDetailPanel.setLayout(null);
		
		/***************상품정보****************/		
		
		productTitleLB = new JLabel("소설5");
		productTitleLB.setText("");
		productTitleLB.setFont(new Font("Dialog", Font.BOLD, 20));
		productTitleLB.setBounds(30, 10, 295, 29);
		productDetailPanel.add(productTitleLB);
		
		productImg = new JLabel("\\book.png");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/com/itwill/chobomungo/ui/jihyun/sample.png")));
		productImg.setBounds(30, 58, 160, 200);
		productDetailPanel.add(productImg);
		
		JLabel productDescMainLB = new JLabel("상품상세정보");
		productDescMainLB.setBounds(30, 291, 100, 21);
		productDetailPanel.add(productDescMainLB);
		
		productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(30, 321, 300, 144);
		productDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescTA.setText("");
		productDescScrollPane.setViewportView(productDescTA);
		productDescTA.setText("상품설명");
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(215, 56, 61, 16);
		productDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000원");
		productPriceLB.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		productPriceLB.setBounds(250, 87, 87, 16);
		productDetailPanel.add(productPriceLB);
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(215, 125, 61, 16);
		productDetailPanel.add(productAmountLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		productAmountCB.setBounds(254, 145, 66, 29);
		productDetailPanel.add(productAmountCB);
		
		productCartBtn_1 = new JButton("장바구니");
		productCartBtn_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productCartBtn_1.setBounds(219, 185, 100, 35);
		productDetailPanel.add(productCartBtn_1);
		
		productOrderBtn = new JButton("구매하기");
		productOrderBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		productOrderBtn.setBounds(219, 225, 100, 35);
		productDetailPanel.add(productOrderBtn);

	}
	
	//상품 디스플레이 메쏘드
	public void displayProductDetail(int p_no) throws Exception{
		Product selectProduct;
		selectProduct = mainFrame.productService.bookSearchNumber(p_no);
		
		/***************상품정보****************/		
		productDetailPanel.removeAll();
		productTitleLB = new JLabel("소설5");
		productTitleLB.setText(selectProduct.getP_title());
		productTitleLB.setFont(new Font("Dialog", Font.BOLD, 20));
		productTitleLB.setBounds(30, 10, 295, 29);
		productDetailPanel.add(productTitleLB);
		
		productImg = new JLabel("");
		productImg.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/product_image"+selectProduct.getP_image())));
		productImg.setBounds(30, 58, 160, 200);
		productDetailPanel.add(productImg);
		
		JLabel productDescMainLB = new JLabel("상품상세정보");
		productDescMainLB.setBounds(30, 291, 100, 21);
		productDetailPanel.add(productDescMainLB);
		
		productDescScrollPane = new JScrollPane();
		productDescScrollPane.setBounds(30, 321, 300, 144);
		productDetailPanel.add(productDescScrollPane);
		
		productDescTA = new JTextArea();
		productDescTA.setText(selectProduct.getP_desc());
		productDescScrollPane.setViewportView(productDescTA);
		
		JLabel productPriceMainLB = new JLabel("판매가격");
		productPriceMainLB.setBounds(215, 56, 61, 16);
		productDetailPanel.add(productPriceMainLB);
		
		productPriceLB = new JLabel("10000원");
		productPriceLB.setText(selectProduct.getP_price()+"원");
		productPriceLB.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		productPriceLB.setBounds(250, 87, 87, 16);
		productDetailPanel.add(productPriceLB);
		
		JLabel productAmountLB = new JLabel("구매수량");
		productAmountLB.setBounds(215, 125, 61, 16);
		productDetailPanel.add(productAmountLB);
		
		productAmountCB = new JComboBox();
		productAmountCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		productAmountCB.setBounds(254, 145, 66, 29);
		productDetailPanel.add(productAmountCB);
		
		//장바구니 버튼액션시 메쏘드
		final JButton productCartBtn = new JButton("장바구니");
		productCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 된 상태일 경우  
				try {
					if(mainFrame.loginUser!=null) {
						//수량 콤보박스 리터럴 저장
						String cartQtyStr = (String)productAmountCB.getSelectedItem();
						int cartQty = Integer.parseInt(cartQtyStr);
						//카트테이블에 추가
						mainFrame.cartService.addCart(cartQty, mainFrame.loginUser.getUserId(), p_no);
						mainFrame.cartPannel.displayCartList(mainFrame.loginUser);
						mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
						//메세지 출력
						JOptionPane.showMessageDialog(null, "장바구니에 상품이 추가되었습니다.");
						productAmountCB.setSelectedIndex(0);
					}else {
						//로그인 안했을 때 로그인창으로
						mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
						mainFrame.userTabbedPane.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		productCartBtn.setBounds(219, 185, 100, 35);
		productDetailPanel.add(productCartBtn);
		
		//구매하기 버튼 액션시
		productOrderBtn = new JButton("구매하기");
		productOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 된 상태일 경우  
				try {
					if(mainFrame.loginUser!=null) {
						String orderQtyStr = (String)productAmountCB.getSelectedItem();
						int orderQty = Integer.parseInt(orderQtyStr);
						mainFrame.orderService.create(orderQty, p_no, mainFrame.loginUser.getUserId());
						mainFrame.orderPanel.displayOrderList();
						mainFrame.chobomungoTabbedPane.setSelectedIndex(3);
						//메세지 출력
						JOptionPane.showMessageDialog(null, "주문목록에 상품이 추가되었습니다.");
						productAmountCB.setSelectedIndex(0);
					}else {
						//로그인 안했을 때 로그인창으로
						mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
						mainFrame.userTabbedPane.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		productOrderBtn.setBounds(219, 225, 100, 35);
		productDetailPanel.add(productOrderBtn);

	}

	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
