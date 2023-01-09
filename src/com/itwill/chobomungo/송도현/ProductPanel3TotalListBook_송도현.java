package com.itwill.chobomungo.송도현;

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

public class ProductPanel3TotalListBook_송도현 extends JPanel {
	
	private ProductService productService;
	private UserService userService;
	private CartService cartService;
	private OrderService orderService;
	public ProductPanel3TotalListBook_송도현(JTabbedPane shopTabbedPane) {
		
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
	private JPanel panel;
	private JPanel panel_1;
	
	
	
	
	
	public ProductPanel3TotalListBook_송도현() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel productInBookContentPanel = new JPanel();
		productInBookContentPanel.setBounds(0, 0, 400, 620);
		add(productInBookContentPanel);
		productInBookContentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 221, 400, 187);
		productInBookContentPanel.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 399, 437);
		panel.add(panel_1);


	
	
	
	}
}
