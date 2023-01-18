import java.util.HashSet;
import java.util.Set;

public class Pair {

    private String name1;
    private String name2;
    private Set<String> commonTags = new HashSet<>();

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Set<String> getCommonTags() {
        return commonTags;
    }

    public void setCommonTags(Set<String> commonTags) {
        this.commonTags = commonTags;
    }

    @Override
    public String toString() {
        return name1 + ", " + name2 + " - " + commonTags + "";
    }
}
