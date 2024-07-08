public class cardGetter {

    //https://nanonets.com/blog/java-web-scraping-tutorial/ ->

    public static void main(String[] args) {
        String url = "https://www.db.yugioh-card.com/yugiohdb/card_search.action";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
// optional request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String html = response.toString();

        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[keyword]");
        for (Element link : links) {
            String href = link.attr("keyword");
            System.out.println(href);
        }
    }
}
