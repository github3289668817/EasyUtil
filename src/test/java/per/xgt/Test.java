package per.xgt;

import per.xgt.utils.AESUtil;
import per.xgt.utils.NumberFormatUtil;
import per.xgt.utils.RandomUtil;
import per.xgt.utils.SyslogUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Valen
 * @version V1.0
 * @date 2021/12/7 11:04
 */
public class Test {

    @org.junit.Test
    public void formatRankChange(){
        Integer a = null;
        Integer b = null;
        String s = NumberFormatUtil.formatRankChange(a, b);
        System.out.println(s);
    }

    @org.junit.Test
    public void formatNumberStringByPoint(){
        String s = NumberFormatUtil.formatNumberStringByPoint("0.056", 2, "-");
        System.out.println(s);
    }

    @org.junit.Test
    public void formatNumberStringByPointAndThousands(){
        String s = NumberFormatUtil.formatNumberStringByPointAndThousands("14258.3524", 0, "-");
        System.out.println(s);
    }

    @org.junit.Test
    public void formatNumberStringByPercentage(){
        String s = NumberFormatUtil.formatNumberStringByPercentage("0.000000", 1, "-");
        System.out.println(s);
    }

    @org.junit.Test
    public void formatNumberStringByPercentageAndPositiveAndnNegative(){
        String s = NumberFormatUtil.formatNumberStringByPercentageAndPositiveAndnNegative("-0.32512", 20, "-");
        System.out.println(s);
    }

    @org.junit.Test
    public void sentSyslog(){
        SyslogUtil syslog = SyslogUtil.getSyslogUtil();
        try {
            syslog.sentSyslog("udp","127.0.0.1",8080,0,"哈哈哈");
        } catch (UnsupportedEncodingException e) {
            System.out.println("转码错误");
        }
    }

    @org.junit.Test
    public void AESTest() throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "1234567890123456";
        // 需要加密的字串
        String cSrc = "www.gowhere.so";
        System.out.println(cSrc);
        // 加密
        String enString = AESUtil.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);
        // 解密
        String DeString = AESUtil.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);
    }

    @org.junit.Test
    public void getSecureRandomIntTest(){
        System.out.println(RandomUtil.getSecureRandomInt(100));
        System.out.println(RandomUtil.getSecureRandomInt(100,200));
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.RandomVerificationCode(4));
        }
    }
    
}
