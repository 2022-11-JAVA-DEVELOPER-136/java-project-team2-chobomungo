package com.itwill.chobomungo.ui.송도현;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductService;
import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.User;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class ProductMainListPanel extends JPanel {
	
	public ChobomungoMainFrame mainFrame;
	
	JLabel productListLB;
	JPanel productItemListPanel;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductMainListPanel() throws Exception {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(0, 0, 400, 398);
		add(productListScrollPane);
		
		productItemListPanel = new JPanel();
		FlowLayout fl_productItemListPanel = (FlowLayout) productItemListPanel.getLayout();
		fl_productItemListPanel.setAlignment(FlowLayout.LEFT);
		productItemListPanel.setPreferredSize(new Dimension(260, 3000));
		productListScrollPane.setViewportView(productItemListPanel);
		
		/*************product item start*************/
		JPanel productPanel = new JPanel();
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productPanel.setLayout(null);
		productPanel.setSize(new Dimension(120, 120));
		productPanel.setPreferredSize(new Dimension(350, 170));
		productPanel.setMinimumSize(new Dimension(150, 150));
		productPanel.setMaximumSize(new Dimension(200, 200));
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productPanel.setBorder(null);
		productPanel.setBackground(Color.WHITE);
		productPanel.setAlignmentY(1.0f);
		productPanel.setAlignmentX(1.0f);
		
		JLabel productImageLabel = new JLabel("");
		productImageLabel.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/product_Image/국내도서1.png")));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(0, 0, 145, 170);
		productPanel.add(productImageLabel);
		
		productItemListPanel.add(productPanel);
		
		JButton ProductDetailDescBtn = new JButton("제품상세보기");
		ProductDetailDescBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
				mainFrame.productTabbedPane.setSelectedIndex(1);
			}
		});
		ProductDetailDescBtn.setBounds(152, 119, 166, 41);
		productPanel.add(ProductDetailDescBtn);
		
		JComboBox cartQtyComboBox = new JComboBox();
		cartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartQtyComboBox.setBounds(157, 10, 40, 34);
		productPanel.add(cartQtyComboBox);
		
		JButton cartBtn = new JButton("");
		cartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cartBtn.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/image/smallcart.png")));
		cartBtn.setOpaque(false);
		cartBtn.setBorder(null);
		cartBtn.setBackground(Color.WHITE);
		cartBtn.setBounds(198, 0, 49, 52);
		productPanel.add(cartBtn);
		
		JLabel sumLabel = new JLabel("<html>상품번호: 1<br>상품명: 만일 내가 인생을 다시 산다면<br>가격: 10,000원</html>");
		sumLabel.setForeground(Color.BLACK);
		sumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		sumLabel.setBackground(Color.WHITE);
		sumLabel.setBounds(157, 43, 176, 76);
		productPanel.add(sumLabel);
		/*************product item end*************/
		
	}
	
	public void productList() throws Exception{
		
		List<Product> productList= 
			mainFrame.productService.productList();
		
		productItemListPanel.removeAll();
		for(Product product:productList) {
			
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.setLayout(null);
			productPanel.setSize(new Dimension(120, 120));
			productPanel.setPreferredSize(new Dimension(330, 170));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setMaximumSize(new Dimension(200, 200));
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setBorder(null);
			productPanel.setBackground(Color.WHITE);
			productPanel.setAlignmentY(1.0f);
			productPanel.setAlignmentX(1.0f);
			
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/product_Image"+product.getP_image())));
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setBounds(0, 0, 145, 170);
			productPanel.add(productImageLabel);
			
			productItemListPanel.add(productPanel);
			
			JButton ProductDetailDescBtn = new JButton("제품상세보기");
			ProductDetailDescBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.productTabbedPane.setSelectedIndex(1);
						mainFrame.productDetailPanel.displayProductDetail(product.getP_no());
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
			ProductDetailDescBtn.setBounds(152, 119, 166, 41);
			productPanel.add(ProductDetailDescBtn);
			
			JComboBox cartQtyComboBox = new JComboBox();
			cartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			cartQtyComboBox.setBounds(157, 15, 40, 23);
			productPanel.add(cartQtyComboBox);
			
			JButton cartBtn = new JButton("");
			/*
			 * cartBtn 액션시 카트 객체 생성
			 */
			cartBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(mainFrame.loginUser!=null) {
							String cartQtyStr = (String)cartQtyComboBox.getSelectedItem();
							int cartQty = Integer.parseInt(cartQtyStr);
							mainFrame.cartService.addCart(cartQty, mainFrame.loginUser.getUserId(), product.getP_no());
							mainFrame.cartPannel.displayCartList(mainFrame.loginUser);
							mainFrame.chobomungoTabbedPane.setSelectedIndex(2);
							//메세지 출력
							JOptionPane.showMessageDialog(null, "장바구니에 상품이 추가되었습니다.");
							cartQtyComboBox.setSelectedIndex(0);
						}else {
							mainFrame.chobomungoTabbedPane.setSelectedIndex(1);
							mainFrame.userTabbedPane.setSelectedIndex(0);
							JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});
			cartBtn.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/image/smallcart.png")));
			cartBtn.setOpaque(false);
			cartBtn.setBorder(null);
			cartBtn.setBackground(Color.WHITE);
			cartBtn.setBounds(213, 10, 40, 28);
			productPanel.add(cartBtn);
			
			JLabel sumLabel = new JLabel("<html>상품번호: "+product.getP_no()+"<br>상품명: "+product.getP_title()+ "<br>가격: "+product.getP_price()+"</html>");
			sumLabel.setForeground(Color.BLACK);
			sumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
			sumLabel.setBackground(Color.WHITE);
			sumLabel.setBounds(157, 43, 176, 76);
			productPanel.add(sumLabel);
			productPanel.add(productImageLabel);
			
			productItemListPanel.add(productPanel);
		}
	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) throws Exception {
		this.mainFrame = mainFrame;
		productList();
	}
	
	
	
	
	
	
}
