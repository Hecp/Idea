package com.hcp.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * 用jsoup抓取页面数据
 * Created by Administrator on 2016/5/20.
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        grapDemo("http://www.zhgscp.roboo.com");
    }

    public static void grapDemo(String url) throws IOException {
        if (url == null || "".equals(url)){
            throw new IllegalArgumentException(url + "url can not be empty!");
        }
        Document doc = Jsoup.parse(new URL(url), 3000);
        Elements elements = doc.select("div.content2");
        Elements aEle = elements.select("a[href^=/web/shop/]");
        System.out.println(aEle.outerHtml());
        System.out.println(aEle.text());
    }
}
