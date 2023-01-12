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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;


public class CartPannel extends JPanel {
	
	/***Service***/
	ProductService productService;
	CartService cartService;
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
		
		//카트 전체삭제
		deleteTopBtn = new JButton("전체삭제");
		deleteTopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					mainFrame.cartService.removeCartItemByUserId(mainFrame.loginUser.getUserId());
					JOptionPane.showMessageDialog(null, "전체 상품이 삭제되었습니다.");
					displayCartList();
					resetCartTotalPrice();
					mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
					mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
					
				} catch(Exception e1) {
					e1.getMessage();
				}

			} 
 		});
		deleteTopBtn.setForeground(new Color(0, 0, 128));
		deleteTopBtn.setBackground(new Color(255, 255, 255));
		deleteTopBtn.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		deleteTopBtn.setBounds(246, 7, 90, 23);
		cartTopUpdateDeletePanel.add(deleteTopBtn);
		
		carImageLabel = new JLabel("");
		carImageLabel.setIcon(new ImageIcon(CartPannel.class.getResource("/image/shopping-cart.png")));
		carImageLabel.setBounds(11, 2, 52, 33);
		cartTopUpdateDeletePanel.add(carImageLabel);
		
		JLabel textLabel = new JLabel("장바구니");
		textLabel.setFont(new Font("경기천년제목L Light", Font.PLAIN, 16));
		textLabel.setBounds(63, 10, 79, 15);
		cartTopUpdateDeletePanel.add(textLabel);
		
		cartTotalPricePanel = new JPanel();
		cartTotalPricePanel.setBackground(new Color(255, 255, 255));
		cartTotalPricePanel.setBounds(12, 326, 348, 39);
		cartPanel.add(cartTotalPricePanel);
		cartTotalPricePanel.setLayout(null);
		
		cartTotalLabel = new JLabel("장바구니 총 액");
		cartTotalLabel.setFont(new Font("경기천년제목L Light", Font.PLAIN, 16));
		cartTotalLabel.setBounds(12, 10, 99, 15);
		cartTotalPricePanel.add(cartTotalLabel);
		
		// 카트 총액 
	
		cartTotalPriceLabel = new JLabel("0원\r\n");
		cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartTotalPriceLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
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
		cartDetailPanel.setBorder(new LineBorder(new Color(142, 205, 238)));
		cartDetailPanel.setBackground(new Color(255, 255, 255));
		cartListpanel.add(cartDetailPanel);
		cartDetailPanel.setLayout(null);
		cartDetailPanel.setPreferredSize(new Dimension(320, 120));
		
		//카트 상품 이미지
		productImageLabel = new JLabel("이미지");
		productImageLabel.setBounds(5, 12, 88, 97);
		cartDetailPanel.add(productImageLabel);
		
		//카트 상품명 클릭 시 상세페이지 버튼
		productDescBtn = new JButton("상품");
		productDescBtn.setHorizontalAlignment(SwingConstants.LEFT);
		productDescBtn.setFont(new Font("경기천년제목L Light", Font.PLAIN, 12));
		productDescBtn.setBackground(new Color(245, 245, 245));
		productDescBtn.setBounds(106, 46, 134, 23);
		cartDetailPanel.add(productDescBtn);
		
		//카트 상품 수량 
		cartCountcomboBox = new JComboBox();
		cartCountcomboBox.setBorder(new CompoundBorder());
		cartCountcomboBox.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		
		cartCountcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartCountcomboBox.setBackground(new Color(245, 245, 245));
		cartCountcomboBox.setBounds(252, 46, 35, 23);
		cartDetailPanel.add(cartCountcomboBox);
		
		//카트 안에서? 상품 삭제
		deleteCartBtn = new JButton("");
		deleteCartBtn.setBorder(null);
		deleteCartBtn.setIcon(new ImageIcon(CartPannel.class.getResource("/image/close.png")));
		deleteCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		deleteCartBtn.setBackground(new Color(255, 255, 255));
		deleteCartBtn.setFont(new Font("경기천년제목 Light", Font.BOLD, 12));
		deleteCartBtn.setBounds(287, 46, 30, 23);
		cartDetailPanel.add(deleteCartBtn);
		
		
		orderBtn = new JButton("주문하기");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.orderService.create(mainFrame.loginUser.getUserId());
					mainFrame.orderPanel.displayOrderList();
					mainFrame.cartPannel.displayCartList();
					resetCartTotalPrice();
					mainFrame.chobomungoTabbedPane.setSelectedIndex(3);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
	
		orderBtn.setBackground(new Color(255, 255, 255));
		orderBtn.setFont(new Font("경기천년제목L Light", Font.PLAIN, 16));
		orderBtn.setBounds(52, 379, 277, 31);
		cartPanel.add(orderBtn);
		
		backgroundLB = new JLabel("");
		backgroundLB.setIcon(new ImageIcon(CartPannel.class.getResource("/image/grass.png")));
		backgroundLB.setBounds(0, 390, 398, 52);
		cartPanel.add(backgroundLB);
		} // 생성자 끝
	
	
	private JLabel cartTotalLabel;
	private JPanel cartTotalPricePanel;
	private JPanel cartTopUpdateDeletePanel;
	private JPanel cartPanel;
	private JLabel backgroundLB;

	public void displayCartList () throws Exception {	
		
		cartListpanel.removeAll();
		List<Cart> cartList = mainFrame.cartService.getCartListByUserId(mainFrame.loginUser.getUserId());
		totPrice = 0;

		for(Cart cart : cartList) {
			
			totPrice += cart.getCart_qty()*cart.getProduct().getP_price();
			cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
			cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			cartTotalPriceLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
			cartTotalPriceLabel.setBounds(220, 10, 128, 15);
			cartTotalPricePanel.add(cartTotalPriceLabel);
			
			// >>>>>>>>>> 카트 디테일 패널

			cartDetailPanel = new JPanel();
			cartDetailPanel.setBorder(new LineBorder(new Color(142, 205, 238)));
			cartDetailPanel.setBackground(new Color(255, 255, 255));
			cartListpanel.add(cartDetailPanel);
			cartDetailPanel.setLayout(null);
			cartDetailPanel.setPreferredSize(new Dimension(320, 150));

			//카트 상품 이미지 가져오기
			productImageLabel = new JLabel();
			productImageLabel.setIcon(new ImageIcon(CartPannel.class.getResource("/product_image"+cart.getProduct().getP_image())));
			productImageLabel.setBounds(5, 12, 88, 97);
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
			productDescBtn.setHorizontalAlignment(SwingConstants.LEFT);
			productDescBtn.setFont(new Font("경기천년제목L Light", Font.PLAIN, 12));
			productDescBtn.setBackground(new Color(245, 245, 245));
			productDescBtn.setBounds(106, 46, 134, 23);
			cartDetailPanel.add(productDescBtn);

			//카트 상품 수량 수정 (콤보박스)

			cartCountcomboBox = new JComboBox();
			cartCountcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			cartCountcomboBox.setBackground(new Color(221, 221, 221));
			cartCountcomboBox.setBounds(252, 46, 35, 23);
			cartCountcomboBox.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
			//카트 상품 수량 수정 (콤보박스)
			cartCountcomboBox.setSelectedItem(Integer.toString(cart.getCart_qty()));
			cartCountcomboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						try {
							int cart_qty=Integer.parseInt((String)cartCountcomboBox.getSelectedItem());
							mainFrame.cartService.addCartByCartNo(cart_qty, cart.getCart_no());
							//displayCartList();
							List<Cart> cartList=mainFrame.cartService.getCartListByUserId(mainFrame.loginUser.getUserId());
							int totPrice = 0;
							for (Cart cart : cartList) {
								totPrice += cart.getCart_qty()*cart.getProduct().getP_price();
							}
							//카트 총 액 (수량 수정 시 금액)
							cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							JOptionPane.showMessageDialog(null, "상품이 수정 되었습니다.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			cartDetailPanel.add(cartCountcomboBox);

			//카트 리스트 안에서 X 버튼 누르면 상품 삭제
			deleteCartBtn = new JButton();
			deleteCartBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					//loginUser.getUserId());
					try {
						//삭제메소드, user_id 인자.
						mainFrame.cartService.removeCartItemByCartNo(cart.getCart_no());
						JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다.");

						cartTotalPricePanel.removeAll();
						cartTotalLabel = new JLabel("장바구니 총 액");
						cartTotalLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
						cartTotalLabel.setBounds(12, 10, 99, 15);
						cartTotalPricePanel.add(cartTotalLabel);
						// 카트 총액 
						if(cartList.size()<=1) {
							cartTotalPriceLabel.setText("0원");
							cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
							cartTotalPriceLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
							cartTotalPriceLabel.setBounds(220, 10, 128, 15);
							cartTotalPricePanel.add(cartTotalPriceLabel);
						}else {
							cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
							cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
							cartTotalPriceLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
							cartTotalPricePanel.add(cartTotalPriceLabel);
						}

						displayCartList();
						cartTotalPriceLabel.setText(new DecimalFormat("#,###원").format(totPrice));
						cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
						cartTotalPriceLabel.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
						cartTotalPricePanel.add(cartTotalPriceLabel);
						
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
					} catch(Exception e1) {
						e1.getMessage();
					}
				}
			});
			deleteCartBtn.setBorder(null);
			deleteCartBtn.setIcon(new ImageIcon(CartPannel.class.getResource("/image/close.png")));
			deleteCartBtn.setBackground(new Color(255, 255, 255));
			deleteCartBtn.setFont(new Font("경기천년제목 Light", Font.BOLD, 12));
			deleteCartBtn.setBounds(287, 46, 30, 23);
			cartDetailPanel.add(deleteCartBtn);
			cartListpanel.add(cartDetailPanel);
			//카트 상세패널 끝

		}
		
	}
	public void resetCartTotalPrice() {
		cartTotalPricePanel.removeAll();
		cartTotalPricePanel.setBackground(new Color(255, 255, 255));
		cartTotalPricePanel.setBounds(12, 326, 348, 39);
		cartPanel.add(cartTotalPricePanel);
		cartTotalPricePanel.setLayout(null);
		cartTotalLabel = new JLabel("장바구니 총 액");
		cartTotalLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		cartTotalLabel.setBounds(12, 10, 99, 15);
		cartTotalPricePanel.add(cartTotalLabel);
		cartTotalPriceLabel = new JLabel("0원\r\n");
		cartTotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartTotalPriceLabel.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		cartTotalPriceLabel.setBounds(220, 10, 128, 15);
		cartTotalPricePanel.add(cartTotalPriceLabel);
	}

	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
