import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Processd {
	protected static String str1;
	protected static String str2;
	protected static String str3;
	protected static String str4;
	protected static String str6;
	protected static int num1;
	protected static int num2;
	protected static JSONObject obj1;
	protected static JSONObject obj2;
	protected static JSONObject obj3;
	protected static JSONObject obj4;

	protected static JSONArray arr1;
	protected static JSONArray arr2;
	public Processd() throws IOException{
		Getdq ge =new Getdq();
		str1=ge.gapi();
		obj1=JSONObject.parseObject(str1);
		str2 = obj1.getString("showapi_res_body");
		obj2=JSONObject.parseObject(str2);
		str3 = obj2.getString("todayStatictic");
		obj3=JSONObject.parseObject(str3);
		
	}
	protected JSONArray array1() {
		arr1=obj2.getJSONArray("todayDetailList");
		return arr1;
	}
	protected JSONArray array2(String str) {
		JSONArray arr3=this.array1();
		for(int i=0;i<arr3.size();i++) {
			JSONObject obj5=arr3.getJSONObject(i);
			String str5=obj5.getString("provinceName");
			if(str.equals(str5)) {
				arr2=obj5.getJSONArray("cityList");
			}				
		}
		return arr2;
	}
	protected String Num2(String sf,String sx,int n) {
		JSONArray arr3=this.array2(sf);
		for(int i=0;i<arr3.size();i++) {
			JSONObject obj5=arr3.getJSONObject(i);
			String str5=obj5.getString("cityName");
			if(sx.equals(str5)) {
				if(n==1) {
					str6=obj5.getString("confirmedNum");
				}
				else if (n==2) {
					str6=obj5.getString("deadNum");
				} 
				else if (n==3) {
					str6=obj5.getString("curedNum");
				} 
			}
		}
		return str6;		
	}

	
	protected String Num1(String str,int n) {
		arr1=obj2.getJSONArray("todayDetailList");
		num1=arr1.size();
		for(int i=0;i<num1;i++) {
			obj4=arr1.getJSONObject(i);
			String str5 = obj4.getString("provinceName");
			if(str.equals(str5)) {
				if(n==1) {
					str4=obj4.getString("confirmedNum");
				}
				else if (n==2) {
					str4=obj4.getString("deadNum");
				}
				else if (n==3) {
					str4=obj4.getString("curedNum");
				}
			}
		}
		return str4;
	}
	
	protected String confirmedNum() {
		String confirmedNum=obj3.getString("confirmedNum");
		return confirmedNum;		
	}
	protected String suspectedNum() {
		String suspectedNum=obj3.getString("suspectedNum");
		return suspectedNum;		
	}
	protected String deadNum() {
		String deadNum=obj3.getString("deadNum");
		return deadNum;		
	}
	protected String curedNum() {
		String curedNum=obj3.getString("curedNum");
		return curedNum;		
	}	
	protected String updateTime() {
		String updateTime=obj2.getString("updateTime");
		return updateTime;		
	}	
}

