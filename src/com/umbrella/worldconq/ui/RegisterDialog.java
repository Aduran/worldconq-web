package com.umbrella.worldconq.ui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5128501222928885944L;
	private JPanel registerPanel;
	private JButton CancelButton, AcceptButton;

	private JLabel mapLabel;

	private JLabel UserLabel;
	private JLabel EmailLabel;
	private JLabel PasswdLabel;

	private JTextField UserTextField;
	private JTextField EmailTextField;
	private JPasswordField PasswdField;

	private boolean selection;

	public RegisterDialog(JFrame f, String string, boolean b) {
		super(f, string, b);
		this.initGUI();
	}

	private void initGUI() {
		this.setResizable(false);
		this.setSize(500, 250);

		registerPanel = new JPanel();
		this.getContentPane().add(registerPanel, BorderLayout.CENTER);
		registerPanel.setLayout(null);

		try {
			this.setIconImage(new ImageIcon(
				this.getClass().getClassLoader().getResource("image/logo.png")).getImage());
		} catch (final Exception e) {
			System.out.println("Imagen no encontrada");
		}

		UserLabel = new JLabel();
		UserLabel.setText("Nombre de usuario :");
		UserLabel.setBounds(35, 23, 143, 16);

		UserTextField = new JTextField();
		UserTextField.setBounds(170, 20, 295, 30);
		UserTextField.setToolTipText("Introduzca aqui su nombre de usuario");
		UserTextField.addKeyListener(new AcceptDialogKeyAdapter(this));

		EmailLabel = new JLabel();
		EmailLabel.setText("Email :");
		EmailLabel.setBounds(35, 63, 143, 16);

		EmailTextField = new JTextField();
		EmailTextField.setBounds(170, 60, 295, 30);
		EmailTextField.setToolTipText("Introduzca aqui su correo electrónico");
		EmailTextField.addKeyListener(new AcceptDialogKeyAdapter(this));

		PasswdLabel = new JLabel();
		PasswdLabel.setText("Contraseña :");
		PasswdLabel.setBounds(35, 103, 143, 16);

		PasswdField = new JPasswordField();
		PasswdField.setBounds(170, 100, 295, 30);
		PasswdField.setToolTipText("Introduzca aqui su contraseña");
		PasswdField.addKeyListener(new AcceptDialogKeyAdapter(this));

		AcceptButton = new JButton("Aceptar");
		AcceptButton.setIcon(new ImageIcon(
			this.getClass().getClassLoader().getResource(
			"image/ok.png")));
		AcceptButton.setBounds(100, 160, 150, 35);
		AcceptButton.addMouseListener(new AcceptDialogMouseAdapter(this, true));

		CancelButton = new JButton("Cancelar");
		CancelButton.setIcon(new ImageIcon(
			this.getClass().getClassLoader().getResource(
			"image/cancel.png")));
		CancelButton.setBounds(265, 160, 150, 35);
		CancelButton.addMouseListener(new AcceptDialogMouseAdapter(this, false));

		mapLabel = new JLabel();
		mapLabel.setIcon(new ImageIcon(
			this.getClass().getClassLoader().getResource("image/mapa.png")));
		mapLabel.setBounds(50, 0, 357, 215);

		registerPanel.add(UserLabel);
		registerPanel.add(UserTextField);
		registerPanel.add(EmailLabel);
		registerPanel.add(EmailTextField);
		registerPanel.add(PasswdLabel);
		registerPanel.add(PasswdField);
		registerPanel.add(AcceptButton);
		registerPanel.add(CancelButton);
		registerPanel.add(mapLabel);
	}

	public boolean getSelection() {
		return selection;
	}

	public String getUser() {
		return UserTextField.getText();

	}

	public String getEmail() {
		return EmailTextField.getText();

	}

	@SuppressWarnings("deprecation")
	public String getPasswd() {
		return PasswdField.getText();
	}

	private class AcceptDialogMouseAdapter extends MouseAdapter {

		private final RegisterDialog dlg;
		private final boolean selection;

		public AcceptDialogMouseAdapter(RegisterDialog dlg, boolean selection) {
			this.dlg = dlg;
			this.selection = selection;
		}

		@Override
		public void mouseClicked(MouseEvent evt) {
			dlg.selection = selection;
			dlg.setVisible(false);
		}
	}

	private class AcceptDialogKeyAdapter extends KeyAdapter {
		private final RegisterDialog dlg;

		public AcceptDialogKeyAdapter(RegisterDialog dlg) {
			this.dlg = dlg;
		}

		@Override
		public void keyPressed(KeyEvent evt) {
			if (evt.getKeyCode() == 10) {
				dlg.selection = true;
				dlg.setVisible(false);
			} else if (evt.getKeyCode() == 27) {
				dlg.selection = false;
				dlg.setVisible(false);
			}
		}
	}
}
