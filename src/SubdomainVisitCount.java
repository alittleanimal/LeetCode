import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。

 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 */
public class SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<>();
        Integer count = 0;
        String domain = "";
        for (String cpDomain : cpdomains) {
            String[] splitString = cpDomain.split(" ");
            count = Integer.parseInt(splitString[0]);
            domain = splitString[1];
            splitDomain(domainCountMap, domain, count);
        }
//        System.out.println(domainCountMap.toString());
        List<String> returnList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
            returnList.add("\"" + entry.getValue() + " " + entry.getKey() + "\"");
        }
        System.out.println(returnList);
        return returnList;
    }

    private static void splitDomain(Map<String, Integer> domainCountMap, String domain, Integer count) {
        if (domain.equals("")) {
            return;
        }

        if (domainCountMap.containsKey(domain)) {
            domainCountMap.put(domain, domainCountMap.get(domain) + count);
        } else {
            domainCountMap.put(domain, count);
        }
        if (domain.split("\\.", 2).length > 1) {
            splitDomain(domainCountMap, domain.split("\\.", 2)[1], count);
        }
    }

    public static void main(String[] args) {
        String[] test = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(test);
    }
}
