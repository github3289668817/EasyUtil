package per.xgt.utils;

import java.security.SecureRandom;

/**
 * @author Valen
 * @version V1.0
 * @date 2022/1/12 16:14
 */
public class RandomUtil {

    // 待取的随机字符
    private static String str = "1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z";
    private static String srArray[] = str.split(",");

    private static final SecureRandom random = new SecureRandom();

    /**
     * 获取0~end 的随机数（左闭右开）
     * @param end 最大值
     * @return
     */
    public static Integer getSecureRandomInt(Integer end){
        return random.nextInt(end);
    }

    /**
     * 获取start~end 的随机数（左闭右开）
     * @param start 最小值
     * @param end 最大值
     * @return
     */
    public static Integer getSecureRandomInt(Integer start,Integer end){
        return random.nextInt(end-start) + start;
    }

    /**
     * 获取count位随机字符
     * @param count 字符个数
     * @return
     */
    public static String RandomVerificationCode(Integer count){
        // 字符串
        StringBuffer code = new StringBuffer();
        // 随机字符数据下标
        Integer index;
        for (int i = 0; i < count; i++) {
            index = getSecureRandomInt(srArray.length);
            code.append(srArray[index]);
        }
        return code.toString();
    }

}
