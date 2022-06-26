package crud.model;

public abstract class AbstractClass {
    private int classId;
    private String title;
    private String description;

    public AbstractClass() {
    }

    public AbstractClass(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AbstractClass [description=" + description + ", title=" + title + "]";
    }

}
