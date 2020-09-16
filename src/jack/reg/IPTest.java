package jack.reg;

public class IPTest {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public static String solve (String IP) {
        // write code here
        if(isIpv4(IP)) {
            return "IPv4";
        } else if(isIpv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    // 判断是否为Ipv4
    public static boolean isIpv4(String IP){
        String[] parts = IP.split("\\.");
        if(parts.length != 4){
            return false;
        }
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if(part.startsWith("0") &&  part.length() > 1){
                return false;
            }
            try {
                int result = Integer.parseInt(part);
                if(result < 0 || result > 255){
                    return false;
                }
            }catch (Exception ex){
                return false;
            }
        }
        return true;
    }

    // 判断是否为Ipv6
    public static boolean isIpv6(String IP){
        String[] parts = IP.split(":");
        if(parts.length != 8){
            return false;
        }
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if(part.length() > 4){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String ip = "172.16.254.1";
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(solve(ip));
    }
}
