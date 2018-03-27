

import sun.security.provider.MD5;

import java.io.*;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Blong on 2018/3/27.
 */
public class ControlValid {
    private final String REGISTERNUMBER; //加密的原始字符串
    private String md5Number; //MD5加密后的字符串
    private String writeContent; //需要写入文本的内容
    private int loginTimesLimit; //登陆次数限制
    private static int loginTimesTrue; //用户的实际登陆次数
    private MD5 md5Object; //实例化MD5对象
    private Calendar cal; //日期时间类
    private int orderTime; //设定的系统到期时间 //构造方法进行初始化赋值

    public ControlValid() {
        REGISTERNUMBER = "你想输入的正确验证字符串";
        md5Object = new MD5();
        loginTimesLimit = 99;
        loginTimesTrue = 0;
        writeContent = null;
        cal = Calendar.getInstance();
        orderTime = 0;
    } //返回经过MD5加密过的字符串

    public String returnMd5String() {
        try { //得到经过MD5加密过的字符串

            return "test";
        } catch (Exception e) {
            return null;
        }
    } //将字符串写进指定文本

    public void writeFile() {
        try {
            String returnFileString;
            int returnLastLoginTimes = 0; //
            Calendar cal = Calendar.getInstance(); //测试获得系统时间
            int currentDate = cal.get(cal.YEAR) + (cal.get(cal.MONTH) + 1) + cal.get(cal.DAY_OF_MONTH); //
            System.out.println(currentDate); //需要写入文本文件的字符串
            String returnInitDate = this.readFile("InitDate.txt");
            orderTime = Integer.parseInt(returnInitDate);
            returnFileString = this.readFile("ControlValid.txt"); //获得换行的位置
            int pos = returnFileString.indexOf("＼n");
            if (pos != -1) {
                returnLastLoginTimes = Integer.parseInt(returnFileString.substring(pos + 1, pos + 3));
            }
            loginTimesTrue = returnLastLoginTimes;
            this.setLoginTimesTrue(); //根据日期和用户登陆次数判断写入的字符串
            if ((currentDate < orderTime) && (this.getLoginTimesTrue() < loginTimesLimit)) { //
                writeContent = this.returnMd5String() + "＼n" + this.getLoginTimesTrue();
                writeContent = this.returnMd5String() + "＼r" + this.getLoginTimesTrue();
            } else { //随机产生一数字进行输入
                Random ranInt = new Random(); //

                int randomInt = ranInt.nextInt();
                writeContent = String.valueOf(ranInt.nextInt(10000000)) + "＼r" + this.getLoginTimesTrue();
            } //将加密过的字符串写入文本文件
            File f = new File("ControlValid.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            DataOutputStream outFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            byte[] byteWriteContent = writeContent.getBytes();
            outFile.write(byteWriteContent);
            outFile.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //在指定文本中读取数据
    public String readFile(String fileName) {
        String sLine = "", sResult = "";
        boolean testFirstLine = true;
        try {
            DataInputStream inFile = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            while ((sLine = inFile.readLine()) != null) {
                if (testFirstLine) {
                    sResult = sLine;
                    testFirstLine = false;
                } else {
                    sResult += "＼n" + sLine;
                }
            }
            inFile.close();
            return sResult;
        } catch (Exception e) {
            return null;
        }
    }

    //注册字符串和文本中返回的字符串对比
    public boolean ContractRegisterString() {
        String returnFileString;
        String md5String;
        String returnMd5String = "";
        int i = 0;
        returnFileString = this.readFile("ControlValid.txt");
//获得换行的位置
        int pos = returnFileString.indexOf("＼n");
        if (pos != -1) {
            returnMd5String = returnFileString.substring(0, pos);
        }
        md5String = this.returnMd5String(); //
        System.out.println(returnFileString); //得到经过MD5加密过的字符串
        if (md5String.equals(returnMd5String)) {
            return true;
        } else {
            return false;
        }
    }

    //用户每登陆一次就把实际登陆次数变量加1
    public void setLoginTimesTrue() {
        loginTimesTrue += 1;
    }

    //返回用户实际登陆次数
    public static int getLoginTimesTrue() {
        return loginTimesTrue;
    }

    //主方法测试用
    public static void main(String[] args) { //
        int i = 0;
        ControlValid controlValid = new ControlValid();
//设置登陆次数 //
        for (i = 0; i < 25; i++) {
            controlValid.setLoginTimesTrue();
        }
//写入内容到文件
        controlValid.writeFile();
        controlValid.ContractRegisterString();
    }
}
