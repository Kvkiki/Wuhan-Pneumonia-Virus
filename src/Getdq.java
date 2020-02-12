import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Getdq {
	protected byte b[];
	protected String str1;
	protected String gapi() throws IOException {
		URL u = new URL("https://route.showapi.com/2217-2?showapi_appid=144392&showapi_timestamp=20200209213935&showapi_sign=6bc36a2827b64f95a4ab8e1900d44da5");
		InputStream in = u.openStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
		byte buf[] = new byte[1024];
		int read = 0;
		while ((read = in .read(buf)) > 0) {
		out.write(buf, 0, read);
		}
		} finally {
		if ( in != null) {
		in .close();
		}
		}
		byte b[] = out.toByteArray();
		str1=new String(b);
		return str1;
	}
}
