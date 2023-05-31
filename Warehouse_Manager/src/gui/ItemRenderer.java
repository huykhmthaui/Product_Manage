package gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import objects.Product;

public class ItemRenderer extends JPanel implements ListCellRenderer<Product> {

	private JLabel lbNumber = new JLabel();
	private JLabel lbId = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbPrice = new JLabel();
	private JLabel lbTotal = new JLabel();
	private JLabel lbExp = new JLabel();
	private JLabel lbMfg = new JLabel();
	private JLabel lbRelease = new JLabel();
	
	public ItemRenderer() {
		setOpaque(true);
		setLayout(new GridLayout(1, 8, 10, 10));
		lbNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbNumber);
		
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbId);
		
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbName);
		
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbPrice);
		
		lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbTotal);
		
		lbExp.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbExp);
		
		lbMfg.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbMfg);
		
		lbRelease.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbRelease);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		
		if (index == 0) {
			lbNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbNumber.setText("STT");
			lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbId.setText("ID");
			lbName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbName.setText("Tên sản phẩm");
			lbPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbPrice.setText("Giá sản phẩm");
			lbTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbTotal.setText("Số lượng");
			lbExp.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbExp.setText("Năm sản xuất");
			lbMfg.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbMfg.setText("Hạn sử dụng");
			lbRelease.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbRelease.setText("Năm nhập hàng");
			setBackground(list.getSelectionBackground());
		    setForeground(list.getSelectionForeground());
		} else {
			value = list.getModel().getElementAt(index);
			lbNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbNumber.setText(String.valueOf(index));
			lbId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbId.setText(value.getProduct_id());
			lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbName.setText(value.getProduct_name());
			lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbPrice.setText(String.valueOf(value.getProduct_price()));
			lbTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbTotal.setText(String.valueOf(value.getProduct_total()));
			lbExp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbExp.setText(String.valueOf(value.getProduct_exp()));
			lbMfg.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbMfg.setText(String.valueOf(value.getProduct_mfg()));
			lbRelease.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbRelease.setText(String.valueOf(value.getProduct_addtime()));
			
			if (isSelected) {
			    setBackground(list.getSelectionBackground());
			    setForeground(list.getSelectionForeground());
			} else {
			    setBackground(list.getBackground());
			    setForeground(list.getForeground());
			}
		}
		return this;
	}

}

