import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Processq {
	protected static JSONArray arr1;
	public JSONArray Processq() throws IOException {
		Getqg gq=new Getqg();
		String str1=gq.gapi();
		JSONObject obj1=JSONObject.parseObject(str1);
		String str2=obj1.getString("showapi_res_body");
		JSONObject obj2=JSONObject.parseObject(str2);
		arr1 = obj2.getJSONArray("historyList");
		return arr1;
	}
}
