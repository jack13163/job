package job.jack.str;

/**
 * 版本比较
 */
public class VersionCompare {
    /**
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public static int compare (String version1, String version2) {
        // write code here
        String[] vs1 =  version1.split("\\.");
        String[] vs2 =  version2.split("\\.");

        int max = Math.max(vs1.length, vs2.length);

        for(int i = 0; i < max; i++){
            if(i >= vs1.length){
                return -1;
            }
            if(i >= vs2.length){
                return 1;
            }
            int v1 = Integer.parseInt(vs1[i]);
            int v2 = Integer.parseInt(vs2[i]);
            if(v1 == v2){
                continue;
            }else if(v1 > v2){
                return 1;
            }else{
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compare("50.52.145.192", "185.223.215.112.122"));
    }
}
