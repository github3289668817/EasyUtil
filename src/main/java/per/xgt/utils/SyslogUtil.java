package per.xgt.utils;

import org.graylog2.syslog4j.Syslog;
import org.graylog2.syslog4j.SyslogIF;
import org.graylog2.syslog4j.impl.net.udp.UDPNetSyslogConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Valen
 * @version V1.0
 * @date 2021/12/31 23:12
 */
public class SyslogUtil {

    private  static SyslogUtil syslogUtil = new SyslogUtil();

    private static SyslogIF syslog;

    private SyslogUtil(){}

    public static SyslogUtil getSyslogUtil(String ip,Integer port,String protocol){
        UDPNetSyslogConfig config = new UDPNetSyslogConfig();
        config.setHost(ip);
        config.setPort(port);
        Syslog.shutdown();
        syslog = Syslog.createInstance(protocol,config);
        return syslogUtil;
    }

    public void sentSyslog(Integer level,String content) throws UnsupportedEncodingException {
        syslog.log(level, URLDecoder.decode(content,"utf-8"));
    }

}
