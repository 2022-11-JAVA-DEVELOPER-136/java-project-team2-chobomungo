package com.itwill.chobomungo.ui.박준식;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class OrderPanel_js extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrderPanel_js() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 620);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주문이완료되었습니다.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(42, 77, 316, 81);
		panel.add(lblNewLabel);
		
		JPanel orderTotalPricePanel = new JPanel();
		orderTotalPricePanel.setBounds(42, 407, 316, 50);
		panel.add(orderTotalPricePanel);
		orderTotalPricePanel.setLayout(null);
		
		JLabel orderTotalNameLB = new JLabel("총결제 금액");
		orderTotalNameLB.setBounds(0, 10, 105, 30);
		orderTotalPricePanel.add(orderTotalNameLB);
		
		JLabel orderTotalPriceLB = new JLabel("200,000");
		orderTotalPriceLB.setBounds(229, 18, 75, 15);
		orderTotalPricePanel.add(orderTotalPriceLB);

	}
}
