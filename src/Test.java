import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {
	static int i;
	public static void main(String[] args) throws IOException{
		Processd aa =new Processd();
		System.out.println(aa.array2("湖北省"));
		System.out.println(aa.Num2("湖北省", "武汉", 1));
	}
}
