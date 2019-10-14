package br.com.utils.ui.modelo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class ModeloJFrameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	/** Attributes */
	private static Integer width = 800;
	private static Integer height = 600;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Dimension windowSize = new Dimension(width, height);

	public ModeloJFrameUI() {
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("TITULO DA JANELA");
		/* --- Set Components --- */
		JPanel pnlTop = new JPanel();
		JPanel pnlBotton = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlBotton, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnlBotton, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}

	private void initEvents() {

	}
	
	public static void principal() {
		ModeloJFrameUI mainUi = new ModeloJFrameUI();
		mainUi.setVisible(true);
		mainUi.setBounds((screenSize.width - windowSize.width) / 2,	(screenSize.height - windowSize.height) / 2, windowSize.width, windowSize.height);		
	}
	
	public static void main(String[] args) {
		principal();
	}
	
	

}