package MehrereDigitaleUhren;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SetSchrift extends JDialog {

	// Results:
	static JFrame f = new JFrame("FontChooser Startup");

	protected static Font resultFont;

	protected String resultName;

	protected int resultSize;

	protected boolean isBold;

	protected boolean isItalic;

	protected String displayText = "Setting Schrift";

	protected String fontList[];

	protected List fontNameChoice;

	protected List fontSizeChoice;

	Checkbox bold, italic;

	protected String fontSizes[] = { "8", "10", "11", "12", "14", "16", "18",
			"20", "24", "30", "36", "40", "48", "60", "72" };

	protected static final int DEFAULT_SIZE = 4;

	protected JLabel previewArea;

	public SetSchrift(Frame f) {
		super(f, "Font Chooser", true);

		Container cp = getContentPane();
		Panel top = new Panel();
		top.setLayout(new FlowLayout());

		fontNameChoice = new List(8);
		top.add(fontNameChoice);

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		fontList = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();

		for (int i = 0; i < fontList.length; i++)
			fontNameChoice.add(fontList[i]);
		fontNameChoice.select(0);

		fontSizeChoice = new List(8);
		top.add(fontSizeChoice);

		for (int i = 0; i < fontSizes.length; i++)
			fontSizeChoice.add(fontSizes[i]);
		fontSizeChoice.select(DEFAULT_SIZE);

		cp.add(top, BorderLayout.NORTH);

		Panel attrs = new Panel();
		top.add(attrs);
		attrs.setLayout(new GridLayout(0, 1));
		attrs.add(bold = new Checkbox("Bold", false));
		attrs.add(italic = new Checkbox("Italic", false));

		previewArea = new JLabel(displayText, JLabel.CENTER);
		previewArea.setSize(200, 50);
		cp.add(previewArea, BorderLayout.CENTER);

		Panel bot = new Panel();

		JButton showButton = new JButton("Show");
		bot.add(showButton);
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewFont();

				setVisible(true);
			}
		});

		JButton okButton = new JButton("Apply");
		bot.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previewFont();
				dispose();

				setVisible(false);
			}
		});

		JButton canButton = new JButton("Default");
		bot.add(canButton);
		canButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				resultFont = null;
				resultName = null;
				resultSize = 0;
				isBold = false;
				isItalic = false;

				dispose();
				setVisible(false);
			}
		});
		cp.add(bot, BorderLayout.SOUTH);
		previewFont();
		setLocation(100, 100);
	}

	protected void previewFont() {
		resultName = fontNameChoice.getSelectedItem();
		String resultSizeName = fontSizeChoice.getSelectedItem();
		int resultSize = Integer.parseInt(resultSizeName);
		isBold = bold.getState();
		isItalic = italic.getState();
		int attrs = Font.PLAIN;
		if (isBold)
			attrs = Font.BOLD;
		if (isItalic)
			attrs |= Font.ITALIC;
		resultFont = new Font(resultName, attrs, resultSize);

		previewArea.setFont(resultFont);
		pack();
	}

	public String getSelectedName() {
		return resultName;
	}

	public int getSelectedSize() {
		return resultSize;
	}

	public Font getSelectedFont() {
		return resultFont;
	}

}