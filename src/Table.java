import java.util.List;
import java.util.ArrayList;

public class Table {

    private final String name;
    private final List<Field> fields =  new ArrayList<>();
    
    public Table(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }
    
    public void addField(String tableName, String fieldName){
        fields.add(new Field(tableName, fieldName));
    }
    
}
