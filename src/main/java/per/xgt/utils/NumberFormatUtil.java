package per.xgt.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Valen
 * @version V1.0
 * @date 2021/12/7 10:49
 */
public class NumberFormatUtil {

    /**
     * 格式化排名变化-加上↑或者↓
     */
    public static String formatRankChange(Integer now, Integer old) {
        if (null != now && null != old && now > 0 && old > 0) {
            String change = "—";
            int num = now - old;
            if (num > 0) {
                change = "↓ " + num;
            } else if (num < 0) {
                num = old - now;
                change = "↑ " + num;
            } else {
                change = "—";
            }
            return change;
        } else {
            return "参数异常!";
        }
    }

    /**
     * 四舍五入保留point位小数
     * 外部需要捕获格式化异常
     *
     * @param number        需要格式化的数
     * @param point         需要保留的小数位数
     * @param defaultString 默认返回的字符串
     * @return
     */
    public static String formatNumberStringByPoint(String number, Integer point, String defaultString) {
        if (StringUtils.isNotBlank(number) && point >= 0) {
            BigDecimal numberToFormat = new BigDecimal(number);
            BigDecimal result = numberToFormat.setScale(point, BigDecimal.ROUND_HALF_UP);
            return result.toString();
        } else {
            // 如果为空，返回默认字符串
            return defaultString;
        }
    }

    /**
     * 四舍五入，并千分位格式化
     *
     * @param number        需要格式化的数
     * @param point         需要保留的小数位数
     * @param defaultString 默认返回的字符串
     * @return
     */
    public static String formatNumberStringByPointAndThousands(String number, Integer point, String defaultString) {
        if (StringUtils.isNotBlank(number) && point >= 0) {
            // 四舍五入
            BigDecimal numberToFormat = new BigDecimal(number);
            BigDecimal result = numberToFormat.setScale(point, BigDecimal.ROUND_HALF_UP);
            // 整数部分
            BigDecimal temp;
            // 小数部分
            String decimalPrt;
            // 如果有保留小数
            if (point > 0) {
                // split方法接受正则表达书，"."小数点在正则里面有特殊含义，所以需要转义
                String[] split = String.valueOf(result).split("\\.");
                temp = new BigDecimal(split[0]);
                decimalPrt = "." + split[1];
            } else {
                temp = result;
                decimalPrt = "";
            }
            // 格式化整数部分
            DecimalFormat format = new DecimalFormat("##,###,###");
            String integerPart = format.format(temp);
            // 整数部分和小数部分拼接
            return integerPart + decimalPrt;
        } else {
            return defaultString;
        }
    }

    /**
     * 四舍五入，格式化为百分数
     *
     * @param number        需要格式化的数
     * @param point         需要保留的小数位数
     * @param defaultString 默认返回的字符串
     * @return
     */
    public static String formatNumberStringByPercentage(String number, Integer point, String defaultString) {
        if (StringUtils.isNotBlank(number) && point >= 0) {
            BigDecimal numberToFormat = new BigDecimal(number);
            BigDecimal result = numberToFormat.multiply(new BigDecimal(100)).setScale(point, BigDecimal.ROUND_HALF_UP);
            return result.toString() + "%";
        } else {
            // 如果为空，返回默认字符串
            return defaultString;
        }
    }

    /**
     * 四舍五入，格式化为百分数，且带上正负号
     *
     * @param number        需要格式化的数
     * @param point         需要保留的小数位数
     * @param defaultString 默认返回的字符串
     * @return
     */
    public static String formatNumberStringByPercentageAndPositiveAndnNegative(String number, Integer point, String defaultString) {
        if (StringUtils.isNotBlank(number) && point >= 0) {
            BigDecimal numberToFormat = new BigDecimal(number);
            BigDecimal result = numberToFormat.multiply(new BigDecimal(100)).setScale(point, BigDecimal.ROUND_HALF_UP);
            if (numberToFormat.compareTo(BigDecimal.ZERO) > 0) {
                return "+" + result.toString() + "%";
            } else {
                return result.toString() + "%";
            }
        } else {
            // 如果为空，返回默认字符串
            return defaultString;
        }
    }

}
