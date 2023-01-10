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
				
			}
		});
		ProductDetailDescBtn.setBounds(152, 119, 166, 41);
		productPanel.add(ProductDetailDescBtn);
		
		JComboBox CartQtyComboBox = new JComboBox();
		CartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		CartQtyComboBox.setBounds(157, 10, 40, 34);
		productPanel.add(CartQtyComboBox);
		
		JButton CartBtn = new JButton("");
		CartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CartBtn.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/image/smallcart.png")));
		CartBtn.setOpaque(false);
		CartBtn.setBorder(null);
		CartBtn.setBackground(Color.WHITE);
		CartBtn.setBounds(198, 0, 49, 52);
		productPanel.add(CartBtn);
		
		JLabel SumLabel = new JLabel("<html>상품번호: 1<br>상품명: 만일 내가 인생을 다시 산다면<br>가격: 10,000원</html>");
		SumLabel.setForeground(Color.BLACK);
		SumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		SumLabel.setBackground(Color.WHITE);
		SumLabel.setBounds(157, 43, 176, 76);
		productPanel.add(SumLabel);
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
			productImageLabel.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/product_Image/국내도서1.png")));
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setBounds(0, 0, 145, 170);
			productPanel.add(productImageLabel);
			
			productItemListPanel.add(productPanel);
			
			JButton ProductDetailDescBtn = new JButton("제품상세보기");
			ProductDetailDescBtn.setBounds(152, 119, 166, 41);
			productPanel.add(ProductDetailDescBtn);
			
			JComboBox CartQtyComboBox = new JComboBox();
			CartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			CartQtyComboBox.setBounds(157, 15, 40, 23);
			productPanel.add(CartQtyComboBox);
			
			JButton CartBtn = new JButton("");
			CartBtn.setIcon(new ImageIcon(ProductMainListPanel.class.getResource("/image/smallcart.png")));
			CartBtn.setOpaque(false);
			CartBtn.setBorder(null);
			CartBtn.setBackground(Color.WHITE);
			CartBtn.setBounds(213, 10, 40, 28);
			productPanel.add(CartBtn);
			
			JLabel SumLabel = new JLabel("<html>상품번호: "+product.getP_no()+"<br>상품명: "+product.getP_title()+ "<br>가격: "+product.getP_price()+"</html>");
			SumLabel.setForeground(Color.BLACK);
			SumLabel.setFont(new Font("굴림", Font.PLAIN, 13));
			SumLabel.setBackground(Color.WHITE);
			SumLabel.setBounds(157, 43, 176, 76);
			productPanel.add(SumLabel);
			productPanel.add(productImageLabel);
			
			productItemListPanel.add(productPanel);
		}
	}
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	
	
	
	
	
}
