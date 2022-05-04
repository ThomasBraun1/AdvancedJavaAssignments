import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Code3Mers {

    public static int translater(Character letter){
        if(letter=='A'){
            return 0;
        }
        else if(letter=='T'){
            return 1;
        }
        else if(letter=='C'){
            return 2;
        }
        else if(letter=='G') {
            return 3;
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String pathFasta = args[0];
        Scanner sc = new Scanner(new File(pathFasta));
        String seq = "";
        List<String> kMers = new ArrayList<String>();
        Map<String, Integer> code = new HashMap<>();
        Map<String,Long> count = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.charAt(0) != '>')
            seq+= line.toUpperCase();
        }

        //System.out.println(seq);

        for(int i=0; i<(seq.length()-2); i++){
            String threeMer= seq.substring(i, i+3);
            kMers.add(threeMer);
        }

        //System.out.println(kMers);

        count = kMers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //System.out.println(count);

        int x,y,z,result = 0;

        for(int j=0; j<kMers.size(); j++){
            x = translater(kMers.get(j).charAt(0));
            y = translater(kMers.get(j).charAt(1));
            z = translater(kMers.get(j).charAt(2));

            result = x*16+y*4+z;

            code.put(kMers.get(j), result);
        }

        LinkedHashMap<String,Integer> sortedKmers = new LinkedHashMap<>();

        code.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(k -> sortedKmers.put(k.getKey(), k.getValue()));

        Map<String, Long> finalCount = count;
        System.out.printf("%-8s%-8s%-8s\n","code","3-mers","count");
        sortedKmers.entrySet().forEach(entry -> {
            System.out.printf("%-8d%-8s%-8d\n",entry.getValue(),entry.getKey(),finalCount.get(entry.getKey()));
        });
    }
}
