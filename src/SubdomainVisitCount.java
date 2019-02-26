import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(domainCountMap.toString());
        return new ArrayList<>();
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
