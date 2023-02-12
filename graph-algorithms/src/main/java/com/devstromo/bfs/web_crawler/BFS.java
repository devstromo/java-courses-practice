package com.devstromo.bfs.web_crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public class BFS {

    // contains the URLs such as (www.bbc.com or www.facebook.com)
    private final Queue<String> queue;
    private final List<String> discoveredWebsiteList;

    private final Pattern pattern = Pattern.compile("https://(\\w+\\.)*(\\w+)");

    public BFS() {
        this.queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();
    }

    // root is the starting URL(www.bbc.com) for the algorithm
    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsiteList.add(root);

        while (!queue.isEmpty()) {
            var website = this.queue.remove();
            var rawHTML = readUrl(website);
            // we want to find valid URLs(https://..)
            var matcher = pattern.matcher(rawHTML);

            while (matcher.find()) {
                var w = matcher.group();
                if (!discoveredWebsiteList.contains(w)) {
                    discoveredWebsiteList.add(w);
                    System.out.println("Website found: " + w);
                    queue.add(w);
                }
            }
        }
    }

    // read the HTML content of the given website
    // and we return with a String format
    private String readUrl(String website) {
        var rawHtml = new StringBuilder("");
        try {
            var url = new URL(website);
            var reader = new BufferedReader(new InputStreamReader(url.openStream()));
            var line = "";
            while ((line = reader.readLine()) != null) {
                rawHtml.append(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Problem while crawling the website...");
        }

        return rawHtml.toString();
    }
}
