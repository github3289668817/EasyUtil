package per.xgt;

import per.xgt.utils.NumberFormatUtil;
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
        SyslogUtil syslog = SyslogUtil.getSyslogUtil("127.0.0.1", 416, "udp");
        try {
            syslog.sentSyslog(5,"hahaha");
        } catch (UnsupportedEncodingException e) {
            System.out.println("转码错误");
        }
    }
    
}
