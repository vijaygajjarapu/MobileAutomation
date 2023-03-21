package com.iehp.pageClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.json.JSONArray;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapper {
    public static void main(String[] args) throws Exception {
        String url = "https://en.wikipedia.org/wiki/N._Chandrababu_Naidu";
        HashSet<String> wikiLinks = getWikiLinks(url,20);
        JSONArray wikiPages = new JSONArray();
        JSONObject obj = new JSONObject();

        int totalLinksCountOrUniqueCount = wikiLinks.size();
        System.out.println(totalLinksCountOrUniqueCount);

        for(String wikiLink:wikiLinks){
            wikiPages.put(wikiLink);
        }

        obj.put("Wiki Links",wikiPages);

        System.out.println(obj);

        FileWriter file = new FileWriter("/Users/technoidentity/Documents/mobile-automation-framework/src/test/java/com/iehp/pageClasses/WikiData.json");
        file.write(obj.toString());
        file.flush();
        file.close();


    }

    public static HashSet<String> getWikiLinks(String url, int number) throws Exception {

        HashSet<String> wikiLinks = new HashSet<>();
        int count=0;

            try {
                // Connect to the URL and retrieve the page HTML
                Document doc = Jsoup.connect(url).get();

                // Select all the links on the page
                Elements links = doc.select("a[href]");


                // Loop through the links and print out the ones that point to other Wikipedia pages
                for (Element link : links) {
                    String href = link.attr("href");
                    // while(count<=number) {
                    if (wikiLinks.size()<number) {
                        if (href.startsWith("/wiki/")) {
                            String WikiLink = "https://en.wikipedia.org" + href;
                            wikiLinks.add(WikiLink);
                            count++;
                        }
                    }
                }
                //}
            } catch (IOException e) {
                throw new Exception("Not a valid wiki link");
            }

        return wikiLinks;
    }
}

