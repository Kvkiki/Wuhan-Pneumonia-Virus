import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComboBoxUI;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class View {
	static JComboBox comboBox;
	static JComboBox comboBox1;
	static JComboBox comboBox2;
	static JFrame jf;
	static JLabel tqz;
	static JLabel tys;
	static JLabel tsw;
	static JLabel tzy;
	static JLabel tqzd;
	static JLabel tswd;
	static JLabel tzyd;
	static JSONArray arr1;
	static Processd pro;
	static Processq pq;
	static int num1;
	static String uptime;
	static String str1;
	static int j;

	public static void main(String[] args) throws IOException {
		pro = new Processd();
		pq = new Processq();
		arr1 = pq.Processq();
		num1 = arr1.size();
		uptime=pro.updateTime();

		jf = new JFrame("武汉肺炎疫情");
		Image im = (new ImageIcon("src/img/psw.jpg")).getImage();
		jf.setIconImage(im);
		JTabbedPane jtab = new JTabbedPane(JTabbedPane.TOP);
		jf.setBounds(400, 250, 300, 400);
		JPanel jpq = new JPanel();
		JPanel jpd = new JPanel();
		jpq.setLayout(new GridLayout(5, 1));
		jpd.setLayout(new GridLayout(4, 1));

		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 35);
		JPanel jp1 = new JPanel(fl);
		JPanel jp2 = new JPanel(fl);
		JPanel jp3 = new JPanel(fl);
		JPanel jp4 = new JPanel(fl);
		JPanel jp5 = new JPanel(fl);
		JPanel jp6 = new JPanel(fl);
		JPanel jp7 = new JPanel(fl);
		JPanel jp8 = new JPanel(fl);
		JPanel jp9 = new JPanel(fl);

		JLabel qz = new JLabel("确诊人数：");
		JLabel ys = new JLabel("疑似人数：");
		JLabel sw = new JLabel("死亡人数：");
		JLabel zy = new JLabel("治愈人数：");
		JLabel ls = new JLabel("历史记录：");
		JLabel qzd = new JLabel("确诊人数：");
		JLabel swd = new JLabel("死亡人数：");
		JLabel zyd = new JLabel("治愈人数：");
		JLabel sz = new JLabel("省/直辖市");
		JLabel sx = new JLabel("市/县");
		tqz = new JLabel(pro.confirmedNum());
		tys = new JLabel(pro.suspectedNum());
		tsw = new JLabel(pro.deadNum());
		tzy = new JLabel(pro.curedNum());
		tqzd=new JLabel("000");
		tswd=new JLabel("000");
		tzyd=new JLabel("000");
		comboBox = new JComboBox();
		comboBox.addItem(uptime);
		for (int i = 0; i < num1; i++) {
			JSONObject obj = arr1.getJSONObject(i);
			String str1 = obj.getString("date");
			comboBox.addItem(str1);
		}
		comboBox1=new JComboBox();
		comboBox1.addItem("省/直辖市");
		for (int i=0;i<pro.array1().size();i++) {
			JSONObject obj1 = pro.array1().getJSONObject(i);
			String str = obj1.getString("provinceName");
			comboBox1.addItem(str);
		}
		comboBox2=new JComboBox();
		comboBox2.addItem("市/县");

		jp1.add(qz);
		jp2.add(ys);
		jp3.add(sw);
		jp4.add(zy);
		jp5.add(ls);
		jp1.add(tqz);
		jp2.add(tys);
		jp3.add(tsw);
		jp4.add(tzy);
		jp5.add(comboBox);
		jp6.add(comboBox1);
		jp6.add(comboBox2);
		jp7.add(qzd);
		jp7.add(tqzd);
		jp8.add(swd);
		jp8.add(tswd);
		jp9.add(zyd);
		jp9.add(tzyd);
		jpq.add(jp1);
		jpq.add(jp2);
		jpq.add(jp3);
		jpq.add(jp4);
		jpq.add(jp5);
		jpd.add(jp6);
		jpd.add(jp7);
		jpd.add(jp8);
		jpd.add(jp9);
		jtab.add("全国", jpq);
		jtab.add("地区", jpd);
		jf.add(jtab);
		comboBox.addItemListener(new MyaddItemListener());
		comboBox1.addItemListener(new MyaddItemListener1());
		comboBox2.addItemListener(new MyaddItemListener2());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	static class MyaddItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			JComboBox combobox1 = (JComboBox) e.getSource();
			String str2 = (String) combobox1.getSelectedItem();
			for (int i = 0; i < num1; i++) {
				JSONObject obj = arr1.getJSONObject(i);
				String str1 = obj.getString("date");
				if (str2.equals(str1)) {
					tqz.setText(obj.getString("confirmedNum"));
					tys.setText(obj.getString("suspectedNum"));
					tsw.setText(obj.getString("deadNum"));
					tzy.setText(obj.getString("curedNum"));
				}
				else if(str2.equals(uptime)) {
					tqz.setText(pro.confirmedNum());
					tys.setText(pro.suspectedNum());
					tsw.setText(pro.deadNum());
					tzy.setText(pro.curedNum());
				}
			}
		}
	}
	static class MyaddItemListener1 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			JComboBox com= (JComboBox) e.getSource();
			str1 = (String) com.getSelectedItem();
			for (int i = 0; i < pro.array1().size(); i++) {
				JSONObject obj1 = pro.array1().getJSONObject(i);
				String str3 = obj1.getString("provinceName");
				if(str1.equals(str3)) {
					tqzd.setText(pro.Num1(str1, 1));
					tswd.setText(pro.Num1(str1, 2));
					tzyd.setText(pro.Num1(str1, 3));
					JSONArray arr5=pro.array2(str1);
					j=comboBox2.getItemCount();
					for(int m=j-1;m>0;m--) {
						comboBox2.removeItemAt(m);
					}
					for(int j=0;j<arr5.size();j++) {
						JSONObject obj5=arr5.getJSONObject(j);
						String str5=obj5.getString("cityName");
						comboBox2.addItem(str5);
					}
				}
				else if (str1.equals("省/直辖市")) {
					j=comboBox2.getItemCount();
					for(int m=j-1;m>0;m--) {
						comboBox2.removeItemAt(m);
					}
					tqzd.setText("000");
					tswd.setText("000");
					tzyd.setText("000");
				}
			}

		}
	}
	static class MyaddItemListener2 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			JComboBox com1= (JComboBox) e.getSource();
			String str7 = (String) com1.getSelectedItem();
			String str8 = (String) comboBox1.getSelectedItem();
			for(int i=0;i<pro.array2(str8).size();i++) {
				JSONObject obj7=pro.array2(str8).getJSONObject(i);
				String str9=obj7.getString("cityName");
				if(str7.equals(str9)) {
					tqzd.setText(pro.Num2(str8, str7, 1));
					tswd.setText(pro.Num2(str8, str7, 2));
					tzyd.setText(pro.Num2(str8, str7, 3));
				}
				else if (str7.equals("市/县")) {
					tqzd.setText(pro.Num1(str8, 1));
					tswd.setText(pro.Num1(str8, 2));
					tzyd.setText(pro.Num1(str8, 3));
				}
			}
		}
	}

}
