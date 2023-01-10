package com.itwill.chobomungo.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class ChobomugoMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField globalSerchTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChobomugoMainFrame frame = new ChobomugoMainFrame();
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
	public ChobomugoMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane chobomungoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(chobomungoTabbedPane, BorderLayout.CENTER);
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		JTabbedPane userTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		chobomungoTabbedPane.addTab("유저", null, userTabbedPane, null);
		
		JPanel globalNorthPanel = new JPanel();
		globalNorthPanel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(globalNorthPanel, BorderLayout.NORTH);
		
		globalSerchTF = new JTextField();
		globalSerchTF.setDisabledTextColor(Color.WHITE);
		globalNorthPanel.add(globalSerchTF);
		globalSerchTF.setColumns(10);
		
		JButton globalSerchBTN = new JButton("검색");
		globalNorthPanel.add(globalSerchBTN);
		
		JButton globalCartBTN = new JButton("카트");
		globalNorthPanel.add(globalCartBTN);
		
		JPanel globalSouthPanel = new JPanel();
		globalSouthPanel.setPreferredSize(new Dimension(10, 70));
		contentPane.add(globalSouthPanel, BorderLayout.SOUTH);
		
		JButton globalOrderBTN = new JButton("New button");
		globalSouthPanel.add(globalOrderBTN);
		
		JButton globalHomeBTN = new JButton("New button");
		globalSouthPanel.add(globalHomeBTN);
		
		JButton globalUserBTN = new JButton("New button");
		globalSouthPanel.add(globalUserBTN);
	}

}