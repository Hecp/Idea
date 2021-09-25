package com.hcp.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 用jsoup抓取页面数据
 * Created by Administrator on 2016/5/20.
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        String cookie = grapDemo("http://wiki.yjk.cn/dologin.action");
        grapDemo1("http://wiki.yjk.cn/pages/viewpage.action?pageId=29985349", cookie);
    }

    public static String grapDemo(String url) throws IOException {
        if (url == null || "".equals(url)) {
            throw new IllegalArgumentException(url + "url can not be empty!");
        }
        Map<String, String> map = new HashMap<>(2);
        map.put("os_username", "hechengping");
        map.put("os_password", "hcp0113@@");
        Connection.Response response = Jsoup.connect(url).data(map).method(Connection.Method.POST).execute();
        return response.cookies().get("JSESSIONID");
    }

    public static void grapDemo1(String url, String cookie) throws IOException {
        if (url == null || "".equals(url)) {
            throw new IllegalArgumentException(url + "url can not be empty!");
        }
        Map<String, String> map = new HashMap<>(2);
        map.put("JSESSIONID", cookie);
        Document doc = Jsoup.connect(url).cookies(map).method(Connection.Method.POST).get();
        Elements elements = doc.select("div.wiki-content");
        Elements tableNames = elements.select("div.g-unit");
        Elements table = elements.select("table");
        StringBuilder sql = new StringBuilder("create table ");
        for (int i = 0; i < tableNames.size(); i++) {
            sql.append(tableNames.get(i).text()).append("(");
            Elements rows = table.get(i).select("tr");
            for (int j = 1; j < rows.size(); j++) {
                Elements columns = rows.get(j).select("td");
                for (int k = 0; k < columns.size(); k++) {
                    sql.append(" ").append(getField(columns.get(k).text(), k));
                }
            }
            sql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8 ");
            System.out.println("sql = " + sql.toString());
            break;
        }
    }

    private static String getField(String text, int i) {
        switch (i) {
            case 0:
                return text;
            case 1:
                return text;
            case 2:
                if ("Y".equals(text)) {
                    return "not null";
                } else {
                    return "null";
                }
            case 3:

            case 4:
                if ("Y".equals(text)) {
                    return "AUTO_INCREMENT";
                } else {
                    return "";
                }
            case 5:
                return "COMMENT '" + text + "', ";
            default:
                return text;
        }
    }
}
