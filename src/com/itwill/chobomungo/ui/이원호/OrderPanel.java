package com.itwill.chobomungo.ui.이원호;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Dimension;

public class OrderPanel extends JFrame {

	private JPanel contentPane;
	private JTextField orderDeliveryAddressTF;
	private JTextField orderDeliveryNameTF;
	private JPanel orderListPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPanel frame = new OrderPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderScrollPane = new JScrollPane();
		contentPane.add(orderScrollPane, BorderLayout.CENTER);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(Color.WHITE);
		orderScrollPane.setViewportView(orderPanel);
		orderPanel.setLayout(null);
		
		JPanel orderDeliveryPanel = new JPanel();
		orderDeliveryPanel.setBorder(null);
		orderDeliveryPanel.setBackground(new Color(226, 226, 226));
		orderDeliveryPanel.setBounds(12, 10, 348, 102);
		orderPanel.add(orderDeliveryPanel);
		orderDeliveryPanel.setLayout(null);
		
		JLabel orderDeliveryInfoLB = new JLabel("배송정보");
		orderDeliveryInfoLB.setFont(new Font("D2Coding ligature", Font.PLAIN, 14));
		orderDeliveryInfoLB.setBounds(12, 10, 68, 15);
		orderDeliveryPanel.add(orderDeliveryInfoLB);
		
		JCheckBox orderDeliveryCB = new JCheckBox("기본 배송지");
		orderDeliveryCB.setBorder(null);
		orderDeliveryCB.setBackground(new Color(226, 226, 226));
		orderDeliveryCB.setFont(new Font("D2Coding", Font.PLAIN, 14));
		orderDeliveryCB.setHorizontalTextPosition(SwingConstants.LEADING);
		orderDeliveryCB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDeliveryCB.setBounds(238, 6, 102, 23);
		orderDeliveryPanel.add(orderDeliveryCB);
		
		orderDeliveryAddressTF = new JTextField();
		orderDeliveryAddressTF.setBounds(92, 36, 229, 21);
		orderDeliveryPanel.add(orderDeliveryAddressTF);
		orderDeliveryAddressTF.setColumns(10);
		
		orderDeliveryNameTF = new JTextField();
		orderDeliveryNameTF.setColumns(10);
		orderDeliveryNameTF.setBounds(92, 67, 229, 21);
		orderDeliveryPanel.add(orderDeliveryNameTF);
		
		JLabel orderDeliveryAddressLB = new JLabel("주소");
		orderDeliveryAddressLB.setFont(new Font("D2Coding ligature", Font.PLAIN, 14));
		orderDeliveryAddressLB.setBounds(12, 39, 57, 15);
		orderDeliveryPanel.add(orderDeliveryAddressLB);
		
		JLabel orderDeliveryNameLB = new JLabel("받는 사람");
		orderDeliveryNameLB.setFont(new Font("D2Coding ligature", Font.PLAIN, 14));
		orderDeliveryNameLB.setBounds(12, 69, 68, 15);
		orderDeliveryPanel.add(orderDeliveryNameLB);
		
		JPanel orderNumberOfItemPanel = new JPanel();
		orderNumberOfItemPanel.setBounds(12, 138, 348, 30);
		orderPanel.add(orderNumberOfItemPanel);
		orderNumberOfItemPanel.setLayout(null);
		
		JLabel orderNumberOfItemtLB = new JLabel("");
		orderNumberOfItemtLB.setBounds(12, 0, 75, 30);
		orderNumberOfItemPanel.add(orderNumberOfItemtLB);
		
		
		
		JButton orderBTN = new JButton("주문 하기");
		orderBTN.setBounds(12, 429, 348, 43);
		orderPanel.add(orderBTN);
		
		JPanel orderTotalPricePanel = new JPanel();
		orderTotalPricePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		orderTotalPricePanel.setBackground(Color.WHITE);
		orderTotalPricePanel.setBounds(12, 376, 348, 30);
		orderPanel.add(orderTotalPricePanel);
		orderTotalPricePanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("최종 결제 금액");
		lblNewLabel_2.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 0, 99, 26);
		orderTotalPricePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("원");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("D2Coding ligature", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(237, 0, 99, 26);
		orderTotalPricePanel.add(lblNewLabel_2_1);
		
		JScrollPane orderListScrollPane = new JScrollPane();
		orderListScrollPane.setBounds(12, 178, 348, 188);
		orderPanel.add(orderListScrollPane);
		
		orderListPanel = new JPanel();
		orderListPanel.setPreferredSize(new Dimension(10, 250));
		orderListPanel.setBackground(Color.ORANGE);
		orderListScrollPane.setViewportView(orderListPanel);
		
		
		JPanel orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(300, 60));
		orderListPanel.add(orderDetailPanel);
		
		displayOrderList();
	}
	
	private void displayOrderList() {
		orderListPanel.removeAll();
		for(int i=0;i<3;i++) {
			JPanel orderDetailPanel = new JPanel();
			orderDetailPanel.setPreferredSize(new Dimension(300, 60));
			orderListPanel.add(orderDetailPanel);
		}
		
	}
}
