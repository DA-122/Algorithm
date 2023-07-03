import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        System.out.println( );
        Scanner in = new Scanner(System.in);
        int[] count = new int[8];
        Judger solution = new Judger();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] arr = line.split("~");
            if(arr.length != 2){
                break;
            }
            // 注意Split要区分转义字符 \\.
            String[] ips = arr[0].split("\\.");
            String[] masks = arr[1].split("\\.");
            if (solution.isValidIp(ips) && solution.isValidMask(masks)) {
                int [] num = new int[4];
                for (int i = 0; i < 4; i++) {
                    num[i] = Integer.parseInt(ips[i]);
                }
                int res = solution.classify(num);
                count[res]++;
                if (solution.isPrivate(num)) {
                    count[7]++;
                }
            } else {
                if(ips[0] != "0" && ips[0]!="127"){
                    count[6]++;
                }
            }

        }
        for (int i = 1; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}

class Judger {
    private int [][][] ipRange = {
        {{1, 0, 0, 0}, {126, 255, 255, 255}},
        {{128, 0, 0, 0}, {191, 255, 255, 255}},
        {{192, 0, 0, 0}, {223, 255, 255, 255}},
        {{224, 0, 0, 0}, {239, 255, 255, 255}},
        {{240, 0, 0, 0}, {255, 255, 255, 255}},
        {{10, 0, 0, 0}, {10, 255, 255, 255}},
        {{172, 16, 0, 0}, {172, 31, 255, 255}},
        {{192, 168, 0, 0}, {192, 168, 255, 255}},
    };

    public Judger() {

    }
    public int classify(int[] ips) {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0 ; j < 4; j++) {
                if (ips[j] >= ipRange[i][0][j] && ips[j] <= ipRange[i][1][j]) {
                    if (j == 3) {
                        res = i+1;
                        break;
                    }
                } else {
                    break;
                }
                if (res != 0)
                    break;
            }
        }
        return res;
    }

    // 校验字符合法性
    public boolean isValid(String[] strs) {
        boolean res = true;
        if (strs.length != 4) {
            res = false;
        } else {
            for (String mask : strs) {
                for (char word : mask.toCharArray()) {
                    if (word < '0' || word > '9') {
                        res = false;
                        break;
                    }
                }
                if (mask.length() == 0 || !res || Integer.parseInt(mask) > 255) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public boolean isValidMask(String[] masks) {
        boolean res = true;
        // 校验掩码合法性
        if (isValid(masks)) {
            int sum = 0;
            // 左移组合4个数
            for (int i = 0; i < 4; i++) {
                sum += (Integer.parseInt(masks[i]) << (8 * (3 - i)));
            }

            // 255.255.255.255 -> - 2^31 + 1
            if (sum == 0 || sum == -1) {
                res = false;
            } else {
                // int num = -(int)Math.pow(2, 30);
                for (int i = 0 ; i < 32 ; i++) {
                    // 最高位是1 是负数
                    if ((sum << i) >= 0) {
                        if ((sum << i) != 0) {
                            res = false;
                        }
                        break;
                    }
                }
            }
        } else {
            res = false;
        }
        return res;
    }
    public boolean isValidIp(String [] ips) {
        return isValid(ips);
    }

    // 判断是否是私网地址
    public boolean isPrivate(int [] ips) {
        boolean res = false;

        for (int i = 5; i < 8; i++) {
            for (int j = 0 ; j < 4; j++) {
                if (ips[j] >= ipRange[i][0][j] && ips[j] <= ipRange[i][1][j]) {
                    if (j == 3) {
                        res = true;
                        break;
                    }
                } else {
                    break;
                }
                if (res)
                    break;
            }
        }
        return res;
    }
}
