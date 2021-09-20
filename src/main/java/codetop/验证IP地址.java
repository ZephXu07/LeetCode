package codetop;

/**
 * Title: 验证IP地址
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 验证IP地址 {
    public String validIPAddress(String IP) {
        if (IP.length() == 0) {
            return "Neither";
        }
        if (IP.contains(".")) {
            if (IP.charAt(IP.length() - 1) == '.') {
                return "Neither";
            }
            String[] ipv4 = IP.split("\\.");
            if (ipv4.length != 4) {
                return "Neither";
            }
            for (String ip : ipv4) {
                if (!isValidIPv4(ip)) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            if (IP.charAt(IP.length() - 1) == ':') {
                return "Neither";
            }
            String[] ipv6 = IP.split(":");
            if (ipv6.length != 8) {
                return "Neither";
            }
            for (String ip : ipv6) {
                if (!isValidIPv6(ip)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
    }

    private boolean isValidIPv4 (String IP) {
        if (IP.length() == 0) {
            return false;
        }
        if (IP.charAt(0) == '0' && IP.length() == 1) {
            return true;
        }
        int val = 0;
        boolean flag = false;
        for (int i = 0; i < IP.length(); i++) {
            char c = IP.charAt(i);
            if (!flag && c == '0') {
                return false;
            }

            if (Character.isDigit(c)) {
                val = val * 10 + c - '0';
                if (c != '0') {
                    flag = true;
                }
            } else {
                return false;
            }
        }
        return val >= 0 && val <= 255;

    }

    private boolean isValidIPv6 (String IP) {
        int len = IP.length();
        if (len > 4 || len == 0) {
            return false;
        }
        int val = 0;
        for (int i = 0; i < len; i++) {
            char c = IP.charAt(i);
            if (Character.isDigit(c)) {
                val = val * 16 + c - '0';
            } else if ('a' <= c && c <= 'f') {
                val = val * 16 + c - 'a' + 10;
            } else if ('A' <= c && c <= 'F') {
                val = val * 16 + c - 'A' + 10;
            } else {
                return false;
            }
        }
        return val <= 1048575 && val >= 0;
    }


    public static void main(String[] args) {
        验证IP地址 res = new 验证IP地址();
        String IP = "172.16.204.0";
        System.out.println(res.validIPAddress(IP));
    }
}
