package com.devstromo.bfs.web_crawler;

import org.junit.jupiter.api.Test;

class BFSTest {

    @Test
    public void testCrawler(){
        BFS crawler = new BFS();
        crawler.discoverWeb("https://www.bbc.com");
    }
}