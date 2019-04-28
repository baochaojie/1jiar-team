package com.jk.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092700608292";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCI9OZGbjd39XyXfLc3HD7ruy5am+H6MQg+ltEAF/YIb3bC3FjD00YURD36Kzf9okLUbKWdB0JREvzORvX0SaBwmP/t7DYJSqBLrZL1WdGJQ5aVgBNne96AAAdG8fWuuS3gIyq4SlEpQ5TYRZOEIDq24a21quOha1obpBHzLgnf6xNmyl4LgPm6tWq9KuJO6A0RCYRuDYkh/IftvVOv3EayXaaBgYFaZjL3oQ0AGP0+62xvCoKzG1vEffaOtxyUBEaxrfWvXAk+tNZEsqm5isuYexx2fC/3cZ4gJrI/5xoq2k6om3aD49vjnLLpDlYVFa5tkNR+klnE6yA/0TIw52lFAgMBAAECggEARJxrwFz27OHOyRVxs+oym2XqkvoE+5IUz0Y+7g0S9KbimDxLO89cDEsjwXBlXGstj73eOgyo7HTWsYBbN0arWb1MeaUcbQs1wrPyK3gTwPBbQAoprm4fyYA6JRCSRDYBBYiYnjqc7k8tAivY+xgqUfQ9UgWKhBOD0NUhKPKnf8U//ZKmMqmFwLCirTgsrn3d0kOJrA4TrdqVF0H65VnbwT/HZ0q7dS/NL8HwIIWzERdl1CFhRO6RCBaiuY5d+4tEEcs36XLmBLcc4a4hutciGbv4bQhCLHA0aMWbIlQlR76XIzGJe/OZL3SbLP5EJuXgGtBWykBk3BhD7iFu12RjAQKBgQD/VvHMKzJTIY8PJQ121c1pH4mYvwaz3uRNbLn743u4IoWZCHRNLHMEAfvuSch7LHwqwfMct5xQGR2NEocvntGbd790yTtI9TvShkD4M6pWxAredI8OldL6t0DwXXJhJDgnbh6LL2whEmu65GANTz2ZqFeLPSm+hWWf6dtZSeNQ+wKBgQCJT5Ns6CtHdEwCCS8uyh0KHibgVYQXKkgcrD+VXu3FvgnjQAVyjuwttyYecYc/hiB7OULlbyWMfafwGH+WDNRbJ9j4QR2i6O8Fi/TpGCWYYO3a4Xv7iyUeeWl4N2uuVDOguiu6kd7c+gD6wB2uyIKxdYBCj5MnwErdmojVdxWavwKBgQC5oV7mXJ0YfLRBgWF5fFP6Udg5uN7Jk4iMlTfc3PPL2SUhLVlH5cG0LzEVeoSKr7uRZjE1NnModCncrpSjVSXzjaod4FH+Z3LXSY0gJId4zstMEJcUNm4MoX9Pf9AwuSEt4UvJSm+k13yEgZUm9+3DsPP8ITog7WAFUwGJt0LQUwKBgF3wVwfW/mTwJ1/tMJ5uH9fgMPChELFYd+VF4moqe7kg/lq+Xfu109aiyi1htgm7lVU4I5AbrjCjdtVHrWHWfSGv7TxKMCBYA85jpbYikvXgullYkh3RYB+tKH7aS40Ehh2bwHbvfOzpDOp/rM761o7ZuFnRJ/e2EoHxS1PfGKS5AoGBAJh7ek+UGtsnfZ6fEJC9FIlGF+pR1diwDQeeAHqsYqT0B21PMfbbV4BFh6ruNKHG0xSa9mJXm80om/DpyCw1hL9tRfotgUUAbcy0g6CqZ8fO85yu5DukRAfdDTlxISm4Xa89h2jB520QIykRryqqyOyLi+1MDRlYaZVYRr0X4qxF";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8776/house/chenggong";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
