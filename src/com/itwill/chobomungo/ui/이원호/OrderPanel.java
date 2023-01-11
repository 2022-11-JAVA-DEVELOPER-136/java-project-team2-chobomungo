package com.itwill.chobomungo.ui.이원호;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.itwill.chobomungo.order.OrderService;
import com.itwill.chobomungo.order.Orders;
import com.itwill.chobomungo.ui.ChobomungoMainFrame;
import com.itwill.chobomungo.user.User;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class OrderPanel extends JPanel {
	private JTextField orderDeliveryAddressTF;
	private JTextField orderDeliveryNameTF;
	private JCheckBox orderDeliveryCKB;
	private JButton orderBTN;
	private JLabel orderTotalPriceLB;
	private JPanel orderTotalPricePanel;
	private ChobomungoMainFrame mainFrame;
	private JPanel orderDetailPanel;
	private JLabel orderDetailImageLB;
	private JLabel orderDetailTitleLB;
	private JLabel orderPriceLB;
	private JPanel orderPanel;
	private JLabel backgroundLB;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public OrderPanel() throws Exception {
		setPreferredSize(new Dimension(400, 620));

		setLayout(new BorderLayout(0, 0));
		
		orderPanel = new JPanel();
		orderPanel.setLayout(null);
		orderPanel.setBackground(Color.WHITE);
		add(orderPanel, BorderLayout.CENTER);
		
		JPanel orderDeliveryPanel = new JPanel();
		orderDeliveryPanel.setLayout(null);
		orderDeliveryPanel.setBorder(null);
		orderDeliveryPanel.setBackground(new Color(226, 226, 226));
		orderDeliveryPanel.setBounds(12, 10, 348, 102);
		orderPanel.add(orderDeliveryPanel);
		
		JLabel orderDeliveryInfoLB = new JLabel("배송정보");
		orderDeliveryInfoLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderDeliveryInfoLB.setBounds(12, 10, 68, 15);
		orderDeliveryPanel.add(orderDeliveryInfoLB);
		
		orderDeliveryCKB = new JCheckBox("기본 배송지");
		orderDeliveryCKB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderDeliveryCKB.isSelected()) {
					orderDeliveryAddressTF.setText(mainFrame.loginUser.getUserAddress());
					orderDeliveryNameTF.setText(mainFrame.loginUser.getUserName());
				}else {
					orderDeliveryAddressTF.setText("");
					orderDeliveryNameTF.setText("");
					orderDeliveryAddressTF.requestFocus();
				}
			}
		});
		orderDeliveryCKB.setHorizontalTextPosition(SwingConstants.LEADING);
		orderDeliveryCKB.setHorizontalAlignment(SwingConstants.CENTER);
		orderDeliveryCKB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderDeliveryCKB.setBorder(null);
		orderDeliveryCKB.setBackground(new Color(226, 226, 226));
		orderDeliveryCKB.setBounds(238, 6, 102, 23);
		orderDeliveryPanel.add(orderDeliveryCKB);
		
		orderDeliveryAddressTF = new JTextField();
		orderDeliveryAddressTF.setColumns(10);
		orderDeliveryAddressTF.setBounds(92, 36, 229, 21);
		orderDeliveryPanel.add(orderDeliveryAddressTF);
		
		orderDeliveryNameTF = new JTextField();
		orderDeliveryNameTF.setColumns(10);
		orderDeliveryNameTF.setBounds(92, 67, 229, 21);
		orderDeliveryPanel.add(orderDeliveryNameTF);
		
		JLabel orderDeliveryAddressLB = new JLabel("주소");
		orderDeliveryAddressLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderDeliveryAddressLB.setBounds(12, 39, 57, 15);
		orderDeliveryPanel.add(orderDeliveryAddressLB);
		
		JLabel orderDeliveryNameLB = new JLabel("받는 사람");
		orderDeliveryNameLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderDeliveryNameLB.setBounds(12, 69, 68, 15);
		orderDeliveryPanel.add(orderDeliveryNameLB);
		
		JPanel orderNumberOfItemPanel = new JPanel();
		orderNumberOfItemPanel.setLayout(null);
		orderNumberOfItemPanel.setBounds(12, 128, 348, 30);
		orderPanel.add(orderNumberOfItemPanel);
		
		JLabel orderNumberOfItemtLB = new JLabel("주문 리스트");
		orderNumberOfItemtLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderNumberOfItemtLB.setBounds(12, 0, 87, 30);
		orderNumberOfItemPanel.add(orderNumberOfItemtLB);
		
		orderBTN = new JButton("주문 하기");
		orderBTN.setFont(new Font("Dialog", Font.PLAIN, 12));
		orderBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.orderService.deleteUserId(mainFrame.loginUser.getUserId());
					JOptionPane.showMessageDialog(null, "주문에 성공하였습니다.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		orderBTN.setBounds(12, 376, 167, 30);
		orderPanel.add(orderBTN);
		
		orderTotalPricePanel = new JPanel();
		orderTotalPricePanel.setLayout(null);
		orderTotalPricePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		orderTotalPricePanel.setBackground(Color.WHITE);
		orderTotalPricePanel.setBounds(12, 339, 348, 30);
		orderPanel.add(orderTotalPricePanel);
		
		JLabel orderTotalNameLB = new JLabel("최종 결제 금액");
		orderTotalNameLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderTotalNameLB.setBounds(12, 0, 99, 26);
		orderTotalPricePanel.add(orderTotalNameLB);
		
		orderTotalPriceLB = new JLabel("200,000원");
		orderTotalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderTotalPriceLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 14));
		orderTotalPriceLB.setBounds(237, 0, 99, 26);
		orderTotalPricePanel.add(orderTotalPriceLB);
		
		JButton orderCancleBTN = new JButton("취소하기");
		orderCancleBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.orderService.deleteUserId(mainFrame.loginUser.getUserId());
					JOptionPane.showMessageDialog(null, "주문이 취소되었습니다.");
					mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
					mainFrame.productTabbedPane.setSelectedIndex(0);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		orderCancleBTN.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderCancleBTN.setBounds(191, 376, 167, 30);
		orderPanel.add(orderCancleBTN);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setBounds(12, 162, 348, 164);
		orderPanel.add(orderDetailPanel);
		orderDetailPanel.setLayout(null);
		
		orderDetailImageLB = new JLabel("New label");
		orderDetailImageLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailImageLB.setBounds(11, 10, 100, 144);
		orderDetailPanel.add(orderDetailImageLB);
		
		orderDetailTitleLB = new JLabel("New label");
		orderDetailTitleLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailTitleLB.setBounds(123, 23, 212, 54);
		orderDetailPanel.add(orderDetailTitleLB);
		
		JLabel orderPriceTitleLB = new JLabel("총 주문금액 :");
		orderPriceTitleLB.setBounds(123, 110, 79, 35);
		orderDetailPanel.add(orderPriceTitleLB);
		
		JLabel orderDeliveryPriceLB = new JLabel("배송비 :                                    0원");
		orderDeliveryPriceLB.setBounds(123, 71, 212, 35);
		orderDetailPanel.add(orderDeliveryPriceLB);
		
		orderPriceLB = new JLabel("");
		orderPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderPriceLB.setBounds(256, 110, 79, 35);
		orderDetailPanel.add(orderPriceLB);
		
		backgroundLB = new JLabel("");
		backgroundLB.setIcon(new ImageIcon(OrderPanel.class.getResource("/image/grass.png")));
		backgroundLB.setBounds(0, 391, 398, 52);
		orderPanel.add(backgroundLB);
		
	}
	public void displayOrderList() throws Exception {
		String orderTitle = null;
		int orderNo = 0;
		Orders tempOrder = null;
		List<Orders> orderList = mainFrame.orderService.orderList(mainFrame.loginUser.getUserId());
		for (Orders order : orderList) {
			orderTitle = order.getO_desc();
			orderNo = order.getO_no();
		}
		tempOrder = mainFrame.orderService.orderDetail(mainFrame.loginUser.getUserId(), orderNo);
		
		orderDetailPanel.removeAll();
		
		orderDetailImageLB = new JLabel(new ImageIcon(OrderPanel.class.getResource("/product_Image"+tempOrder.getOrderItemList().get(0).getProduct().getP_image())));
		orderDetailImageLB.setBounds(11, 10, 100, 144);
		orderDetailPanel.add(orderDetailImageLB);
		
		orderDetailTitleLB = new JLabel(orderTitle+"  외  "+(orderList.size()-1)+"건");
		orderDetailTitleLB.setBounds(123, 23, 212, 54);
		orderDetailTitleLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailPanel.add(orderDetailTitleLB);
		
		JLabel orderPriceTitleLB = new JLabel("총 주문금액 :");
		orderPriceTitleLB.setBounds(123, 110, 79, 35);
		orderPriceTitleLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailPanel.add(orderPriceTitleLB);
		
		JLabel orderDeliveryPriceLB = new JLabel("배송비 :                                    0원");
		orderDeliveryPriceLB.setBounds(123, 71, 212, 35);
		orderDeliveryPriceLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailPanel.add(orderDeliveryPriceLB);
		
		orderPriceLB = new JLabel(new DecimalFormat("#,###원").format(mainFrame.orderService.orderTotPrice(mainFrame.loginUser.getUserId())));
		orderPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderPriceLB.setBounds(256, 110, 79, 35);
		orderPriceLB.setFont(new Font("경기천년제목 Light", Font.PLAIN, 12));
		orderDetailPanel.add(orderPriceLB);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setBounds(12, 162, 348, 164);
		orderDetailPanel.setLayout(null);
		orderPanel.add(orderDetailPanel);
		
		orderTotalPricePanel.removeAll();
		JLabel orderTotalNameLB = new JLabel("최종 결제 금액");
		orderTotalNameLB.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		orderTotalNameLB.setBounds(12, 0, 99, 26);
		orderTotalPricePanel.add(orderTotalNameLB);
		
		orderTotalPriceLB = new JLabel(new DecimalFormat("#,###원").format(mainFrame.orderService.orderTotPrice(mainFrame.loginUser.getUserId())));
		orderTotalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderTotalPriceLB.setFont(new Font("경기천년제목 Light", Font.BOLD, 14));
		orderTotalPriceLB.setBounds(237, 0, 99, 26);
		orderTotalPricePanel.add(orderTotalPriceLB);			
		
		
	}
	/* 취소버튼
	 			Orders o = order;
				public void actionPerformed(ActionEvent e) {
					// 오더리스트 1개 삭제
					try {
						int deleteOrderListCount = mainFrame.orderService.deleteOrderNo(mainFrame.loginUser.getUserId(), o.getO_no());
						JOptionPane.showMessageDialog(null, deleteOrderListCount + "개의 주문이 삭제되었습니다.");
						displayOrderList();
						mainFrame.chobomungoTabbedPane.setSelectedIndex(0);
						mainFrame.chobomungoTabbedPane.setSelectedIndex(3);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
	 
	 */
	
	
	
	public void setMainFrame(ChobomungoMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
