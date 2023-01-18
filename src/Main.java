import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        File file = new File("resources/data.json");
        InputData inputData = MAPPER.readValue(file, InputData.class);
        Set<Pair> results = getPair(inputData.getRecipients());

        System.out.println("Here are the results\n");
        for (Pair pair : results) {
            System.out.println(pair + "\n");
        }
    }

    private static Set<Pair> getPair(List<InputData.Recipient> recipients) {
        Set<Pair> results = new HashSet<>();

        for (int i = 0; i < recipients.size() - 1; i++) {
            Map<String, Integer> common = new HashMap<>();
            InputData.Recipient recipient1 = recipients.get(i);
            recipient1.getTags().forEach(tag -> common.put(tag, common.getOrDefault(tag, 0) + 1));

            for (int j = i + 1; j < recipients.size(); j++) {
                InputData.Recipient recipient2 = recipients.get(j);
                recipient2.getTags().forEach(tag -> common.put(tag, common.getOrDefault(tag, 0) + 1));

                Pair pair = new Pair();
                pair.setName1(recipient1.getName());
                pair.setName2(recipient2.getName());

                for (Map.Entry<String, Integer> entry : common.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value == 2) {
                        pair.getCommonTags().add(key);
                    }
                }

                if (pair.getCommonTags().size() >= 2) {
                    results.add(pair);
                }

                recipient2.getTags().forEach(tag -> common.put(tag, common.get(tag) - 1));
            }
        }

        return results;
    }

}
