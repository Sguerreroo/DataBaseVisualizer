public class Field {
    String tableName;
    String fieldName;

    public Field(String tableName, String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return tableName + "." + fieldName ;
    }
    
}
