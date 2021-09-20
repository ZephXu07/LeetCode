package codetop;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: TelegramNotify
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-26
 */
public class TelegramNotify {


    public static final String TG_BOT_TOKEN="1832159836:AAEr5nj48IZdCtCp2VMRztt54JAb-mIruDs";
    public static final String TG_USER_ID="1601813261";
    public static final String TG_API_HOST="bold-dew-0b8b.zeph07.workers.dev";
    public static void main(String[] args) {
        String url = "https://"+TG_API_HOST + "/bot" + TG_BOT_TOKEN + "/sendMessage";
        String body = "chat_id=" + TG_USER_ID + "&text=" + "测试 " + "&disable_web_page_preview=true";
        Map<String, List<String>> headers = new HashMap<>(1);
        String key = "Content-Type";
        List<String> value = new ArrayList<>(1);
        value.add("application/x-www-form-urlencoded");
        headers.put(key, value);
        String res = HttpRequest.post(url).body(body).header(headers).
                execute().body();
    }
}
