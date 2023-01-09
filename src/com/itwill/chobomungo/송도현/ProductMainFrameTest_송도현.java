package com.itwill.chobomungo.송도현;

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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class ProductMainFrameTest_송도현 extends JFrame {

	private JPanel contentPane;
	private JTextField globalSerchTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMainFrameTest_송도현 frame = new ProductMainFrameTest_송도현();
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
	public ProductMainFrameTest_송도현() {
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
		
		JPanel productInBookPane = new JPanel();
		productTabbedPane.addTab("국내도서", null, productInBookPane, null);
		productInBookPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		productInBookPane.add(scrollPane, BorderLayout.CENTER);
		
		ProductPanel1InBook_송도현 productPanel1InBook_송도현 = new ProductPanel1InBook_송도현();
		scrollPane.setViewportView(productPanel1InBook_송도현);
		
		JPanel productOutBookPane = new JPanel();
		productTabbedPane.addTab("외국도서", null, productOutBookPane, null);
		productOutBookPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		productOutBookPane.add(scrollPane_1, BorderLayout.CENTER);
		
		ProductPanel2OutBook_송도현 productPanel2OutBook_송도현 = new ProductPanel2OutBook_송도현();
		scrollPane_1.setViewportView(productPanel2OutBook_송도현);
		
		JPanel productTotalBookPane = new JPanel();
		productTabbedPane.addTab("전체", null, productTotalBookPane, null);
		productTotalBookPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane productTotalBookPaneScrollPane = new JScrollPane();
		productTotalBookPane.add(productTotalBookPaneScrollPane);
		
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