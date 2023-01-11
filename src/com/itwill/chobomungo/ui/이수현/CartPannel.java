package com.itwill.chobomungo.ui.이수현;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.cart.Cart;
import com.itwill.chobomungo.cart.CartService;
import com.itwill.chobomungo.order.OrderService;
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserService;


public class CartPannel extends JPanel {
	
	/***Service***/
	ProductService productService;
	CartService cartService;
	
	
	/******************************/
	public JButton updateTopBtn;
	public JButton deleteTopBtn;
	private JPanel cartDetailPanel;
	private JPanel cartListpanel;
	private JLabel productImageLabel;
	private JButton productDescBtn;
	private JComboBox cartCountcomboBox;
	private JButton deleteCartBtn;
	public JButton orderBtn;
	private JLabel cartTotalPriceLabel;
	private JLabel carImageLabel;
	int totPrice = 0;
	/***Frame***/
	private ChobomungoMainFrame mainFrame;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public CartPannel() throws Exception {
		setPreferredSize(new Dimension(400, 600));
		setLayout(new BorderLayout(0, 0));
		
		cartPanel = new JPanel();
		cartPanel.setBackground(new Color(255, 255, 255));
		add(cartPanel);
		cartPanel.setLayout(null);
		
		
		
		cartTopUpdateDeletePanel = new JPanel();
		cartTopUpdateDeletePanel.setBackground(new Color(255, 255, 255));
		cartTopUpdateDeletePanel.setBounds(12, 10, 348, 39);
		cartPanel.add(cartTopUpdateDeletePanel);
		cartTopUpdateDeletePanel.setLayout(null);
		
		
		//카트 수정 버튼
		updateTopBtn = new JButton("수정");
		updateTopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		updateTopBtn.setForeground(new Color(0, 0, 128));
		updateTopBtn.setBackground(new Color(255, 255, 255));
		updateTopBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 13));
		updateTopBtn.setBounds(169, 10, 65, 23);
		cartTopUpdateDeletePanel.add(updateTopBtn);
		
		//카트 전체삭제
		deleteTopBtn = new JButton("전체삭제");
		deleteTopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteTopBtn.setForeground(new Color(0, 0, 128));
		deleteTopBtn.setBackground(new Color(255, 255, 255));
		deleteTopBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 13));
		deleteTopBtn.setBounds(246, 10, 90, 23);
		cartTopUpdateDeletePanel.add(deleteTopBtn);
		
		carImageLabel = new JLabel("");
		carImageLabel.setIcon(new ImageIcon(CartPannel.class.getResource("/image/shopping-cart.png")));
		carImageLabel.setBounds(12, 0, 52, 33);
		cartTopUpdateDeletePanel.add(carImageLabel);
		
		cartTotalPricePanel = new JPanel();
		cartTotalPricePanel.setBackground(new Color(255, 255, 255));
		cartTotalPricePanel.setBounds(12, 326, 348, 39);
		cartPanel.add(cartTotalPricePanel);
		cartTotalPricePanel.setLayout(null);
		
		cartTotalLabel_1 = new JLabel("장바구니 총 액");
		cartTotalLabel_1.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
		cartTotalLabel_1.setBounds(12, 10, 99, 15);
		cartTotalPricePanel.add(cartTotalLabel_1);
		
		// 카트 총액 
	
		cartTotalPriceLabel = new JLabel("123,456 원");
		cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartTotalPriceLabel.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
		cartTotalPriceLabel.setBounds(220, 10, 128, 15);
		cartTotalPricePanel.add(cartTotalPriceLabel);
		
		JScrollPane cartListscrollPane = new JScrollPane();
		cartListscrollPane.setBounds(12, 69, 348, 239);
		cartPanel.add(cartListscrollPane);
		
		//카트 리스트 
		cartListpanel = new JPanel();
		cartListpanel.setBackground(new Color(255, 255, 255));
		cartListscrollPane.setViewportView(cartListpanel);
		cartListpanel.setPreferredSize(new Dimension(320, 500));
		cartListpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		cartDetailPanel = new JPanel();
		cartDetailPanel.setBackground(new Color(255, 255, 255));
		cartListpanel.add(cartDetailPanel);
		cartDetailPanel.setLayout(null);
		cartDetailPanel.setPreferredSize(new Dimension(320, 100));
		
		//카트 상품 이미지
		productImageLabel = new JLabel("이미지");
		productImageLabel.setBounds(12, 10, 65, 80);
		cartDetailPanel.add(productImageLabel);
		
		//카트 상품명 클릭 시 상세페이지 버튼
		productDescBtn = new JButton("상품");
		productDescBtn.setBackground(new Color(221, 221, 221));
		productDescBtn.setBounds(89, 39, 95, 23);
		cartDetailPanel.add(productDescBtn);
		
		//카트 상품 수량 
		cartCountcomboBox = new JComboBox();
		cartCountcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartCountcomboBox.setBackground(new Color(221, 221, 221));
		cartCountcomboBox.setBounds(196, 39, 44, 23);
		cartDetailPanel.add(cartCountcomboBox);
		
		//카트 안에서? 상품 삭제
		deleteCartBtn = new JButton("X");
		deleteCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteCartBtn.setBackground(new Color(221, 221, 221));
		deleteCartBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 12));
		deleteCartBtn.setBounds(252, 39, 40, 23);
		cartDetailPanel.add(deleteCartBtn);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setLayout(null);
	
		
		
		} // 생성자 끝
	
	
	private JLabel cartTotalLabel_1;
	private JPanel cartTotalPricePanel;
	private JPanel cartTopUpdateDeletePanel;
	private JPanel cartPanel;

	public void displayCartList () throws Exception {	
		
		cartListpanel.removeAll();
		List<Cart> cartList = mainFrame.cartService.getCartListByUserId(mainFrame.loginUser.getUserId());
		
		for(Cart cart : cartList) {
			totPrice += cart.getCart_qty()*cart.getProduct().getP_price();
			//수정 전체삭제 패널
			
			cartTopUpdateDeletePanel.removeAll();
			//(int cart_qty,String user_id, int p_no)
			//카트 수정 버튼
			updateTopBtn = new JButton("수정");
			updateTopBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						mainFrame.cartService.addCart(cart.getCart_qty(),mainFrame.loginUser.getUserId(), cart.getProduct().getP_no());
						displayCartList();
						JOptionPane.showMessageDialog(null, "상품이 수정 되었습니다.");
						
					} catch(Exception e1) {
						e1.getMessage();
					}
				}
					
			});
			updateTopBtn.setForeground(new Color(0, 0, 128));
			updateTopBtn.setBackground(new Color(221, 221, 221));
			updateTopBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 13));
			updateTopBtn.setBounds(169, 10, 65, 23);
			cartTopUpdateDeletePanel.add(updateTopBtn);
			
			//카트 전체삭제
			deleteTopBtn = new JButton("전체삭제");
			deleteTopBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						mainFrame.cartService.removeCartItemByUserId(mainFrame.loginUser.getUserId());
						cartTotalPrice(totPrice);
						displayCartList();
						JOptionPane.showMessageDialog(null, "전체 상품이 삭제되었습니다.");
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
						
					} catch(Exception e1) {
						e1.getMessage();
					}

				}
			});
			deleteTopBtn.setForeground(new Color(0, 0, 128));
			deleteTopBtn.setBackground(new Color(221, 221, 221));
			deleteTopBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 13));
			deleteTopBtn.setBounds(246, 10, 90, 23);
			cartTopUpdateDeletePanel.add(deleteTopBtn);
			
		
			// >>>>>>>>>> 카트 디테일 패널
			
			cartDetailPanel = new JPanel();
			cartDetailPanel.setBackground(new Color(221, 221, 221));
			cartListpanel.add(cartDetailPanel);
			cartDetailPanel.setLayout(null);
			cartDetailPanel.setPreferredSize(new Dimension(320, 150));

			//카트 상품 이미지 가져오기
			productImageLabel = new JLabel();
			productImageLabel.setIcon(new ImageIcon(CartPannel.class.getResource("/product_image"+cart.getProduct().getP_image())));
			productImageLabel.setBounds(37, 10, 40, 40);
			cartDetailPanel.add(productImageLabel);
			productImageLabel.setBounds(37, 10, 40, 40);
			cartDetailPanel.add(productImageLabel);

			//카트 상품명 클릭 시 상세페이지 버튼
			productDescBtn = new JButton("");
			productDescBtn.setText(cart.getProduct().getP_title());
			productDescBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.productTabbedPane.setSelectedIndex(1);
						mainFrame.productDetailPanel.displayProductDetail(cart.getProduct().getP_no());
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}                          
					
				}
			});
			productDescBtn.setBackground(new Color(221, 221, 221));
			productDescBtn.setBounds(89, 14, 95, 23);
			cartDetailPanel.add(productDescBtn);

			//카트 상품 수량 
			cartCountcomboBox = new JComboBox();
			cartCountcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			cartCountcomboBox.setBackground(new Color(221, 221, 221));
			cartCountcomboBox.setBounds(209, 14, 32, 23);
			
			cartCountcomboBox.setSelectedItem(Integer.toString(cart.getCart_qty()));
			cartDetailPanel.add(cartCountcomboBox);
			
			

			//카트 리스트 안에서 X 버튼 누르면 상품 삭제
			deleteCartBtn = new JButton("X");
			deleteCartBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					//loginUser.getUserId());
					try {
						//삭제메소드, user_id 인자.
						mainFrame.cartService.removeCartItemByCartNo(cart.getCart_no());
						cartTotalPrice(totPrice);
						displayCartList();
						JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다.");
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
					} catch(Exception e1) {
						e1.getMessage();
					}
				}
			});
			deleteCartBtn.setBackground(new Color(221, 221, 221));
			deleteCartBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 12));
			deleteCartBtn.setBounds(268, 14, 40, 23);
			cartDetailPanel.add(deleteCartBtn);
			cartListpanel.add(cartDetailPanel);
			//카트 상세패널 끝
			
			
			orderBtn = new JButton("주문하기");
			orderBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						mainFrame.orderService.create(cart.getCart_qty(),cart.getProduct().getP_no(),mainFrame.loginUser.getUserId());
						mainFrame.cartService.removeCartItemByUserId(mainFrame.loginUser.getUserId());
						mainFrame.orderPanel.displayOrderList();
						mainFrame.cartPannel.displayCartList();
						mainFrame.chobomungoTabbedPane.setSelectedIndex(3);
						
					} catch (Exception e2) {
						e2.printStackTrace();
						
					}
					
				}
			});
			cartTotalPrice(totPrice);
		
			orderBtn.setBackground(new Color(255, 255, 255));
			orderBtn.setFont(new Font("D2Coding ligature", Font.BOLD, 12));
			orderBtn.setBounds(52, 387, 277, 23);
			cartPanel.add(orderBtn);
		}

	}
		public void cartTotalPrice(int price) {
			
			cartTotalPricePanel.removeAll();
			JLabel cartTotalLabel_1 = new JLabel("장바구니 총 액");
			cartTotalLabel_1.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
			cartTotalLabel_1.setBounds(12, 10, 99, 15);
			cartTotalPricePanel.add(cartTotalLabel_1);
			
			cartTotalPriceLabel = new JLabel(new DecimalFormat("#,###원").format(price));
			cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			cartTotalPriceLabel.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
			cartTotalPriceLabel.setBounds(220, 10, 128, 15);
			cartTotalPricePanel.add(cartTotalPriceLabel);
		}
		
	
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
