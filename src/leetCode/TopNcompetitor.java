package leetCode;

import java.util.*;

public class TopNcompetitor {
    public static void main(String[] args) {
        ArrayList<String> competitors1 = new ArrayList<>();
       competitors1.add("newshop");
        competitors1.add("shopnow");
        competitors1.add("afshion");
        competitors1.add("fashionbeats");
        competitors1.add("mymarket");
        competitors1.add("tcellular");
        ArrayList<String> competitors2 = new ArrayList<>();
        competitors2.add("anacell");
       competitors2.add("betacellular");
       competitors2.add("cetracular");
       competitors2.add("deltacellular");
       competitors2.add("eurocell");

        ArrayList<String> reviews1 = new ArrayList<>();
        reviews1.add("newshop is providing good services in the city; everyone should use newshop");
        reviews1.add("best services by newshop");
        reviews1.add("fashionbeats has great services in the city");
        reviews1.add("I am proud to have fashionbeats");
        reviews1.add("mymarket has awesome services");
        reviews1.add("Thanks Newshop for the quick delivery");
        ArrayList<String> reviews2 = new ArrayList<>();
        reviews2.add("I love anacell Best services; Best services provided by anacell");
        reviews2.add("betacellular has great services");
        reviews2.add("deltacellular provides much better services than betacellular");
        reviews2.add("cetracular is worse than anacell");
        reviews2.add("Betacellular is better than deltacellular.");

        System.out.println(topNCompetitors(6,2,competitors2,6,reviews2));
    }

    private static ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
                                                     int numReviews, List<String> reviews){
        HashMap<String, Integer> map = new HashMap<>();
        for(String comp: competitors){
            for(String rev: reviews){
                rev.toLowerCase();
                if(rev.contains(comp)){
                    map.put(comp,map.getOrDefault(comp, 0)+1); // putting all the competitors with its total count in the map
                }
            }
        }
        ArrayList<String> tempKeys = new ArrayList<>();
        for(String key : map.keySet()){
                tempKeys.add(key); // storing all the keys of map in a list of String
        }
        if(topNCompetitors > numCompetitors){ // as per requirement, if topNcompt is greater than no of compet then return all the compt which is discussed in reviews
            return tempKeys;
        }

        ArrayList<Integer> countList = new ArrayList<Integer>(map.values());
        Collections.sort(countList, new Comparator<Integer>() { // sorting all the values as Descending so that top N competitor can be fetched
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < topNCompetitors; i++){ // will fetch first top N values from countList and add its corresponding key in the set
            int val = countList.get(i);
            for(Map.Entry<String, Integer> entry : map.entrySet()){ //iterating thru the set of map to get the matching value and if found then
                if(entry.getValue() == val) {
                    set.add(entry.getKey()); // add into the set and increase it's value to MAX VALUE so that the same record will not come during next iteration and break
                    map.replace(entry.getKey(), Integer.MAX_VALUE);// so that only 1 per main iteration the key will be added in the set
                    break;
                }
            }
        }
        ArrayList<String> in = new ArrayList<String>();
        for(String s: set) in.add(s);

        return in;
    }
}
