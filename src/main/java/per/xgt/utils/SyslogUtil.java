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

    private static final SyslogUtil syslogUtil = new SyslogUtil();

    private SyslogUtil(){}

    public static SyslogUtil getSyslogUtil(){
        return syslogUtil;
    }

    /**
     * 发送单个IP地址
     * @param protocol 协议
     * @param ip 目标IP地址
     * @param port 端口
     * @param level 日志等级
     * @param content 日志内容
     * @throws UnsupportedEncodingException
     */
    public void sentSyslog(String protocol,String ip,Integer port,Integer level,String content) throws UnsupportedEncodingException {
        SyslogIF syslog = Syslog.getInstance(protocol);
        syslog.getConfig().setHost(ip);
        syslog.getConfig().setPort(port);
        syslog.log(level,URLDecoder.decode(content,"utf-8"));
    }

    /**
     * 发送多个IP地址
     * @param protocol 协议
     * @param ip 目标IP地址
     * @param port 端口
     * @param level 日志等级
     * @param content 日志内容
     * @throws UnsupportedEncodingException
     */
    public void sentResSyslog(String protocol,String ip,Integer port,Integer level,String content) throws UnsupportedEncodingException {
        // syslog配置类
        UDPNetSyslogConfig config = new UDPNetSyslogConfig();
        // 设置IP和端口
        config.setHost(ip);
        config.setPort(port);
        // syslog为单例，不调用销毁方法不能重新实例化
        Syslog.shutdown();
        // 获取syslog操作类，一般使用udp协议，支持udp、tcp、unix_syslog,unix_socket协议
        SyslogIF syslog = Syslog.createInstance(protocol, config);
        syslog.log(level,URLDecoder.decode(content,"utf-8"));
    }

}
