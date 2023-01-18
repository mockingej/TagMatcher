import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputData {

    private List<Recipient> recipients = new ArrayList<>();

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "recipients=" + recipients +
                '}';
    }

    static class Recipient {
        private Set<String> tags = new HashSet<>();
        private String name;
        private Integer id;

        public Set<String> getTags() {
            return tags;
        }

        public void setTags(Set<String> tags) {
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Recipient{" +
                    "tags=" + tags +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}
