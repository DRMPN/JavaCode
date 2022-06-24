package crud.model;

public class Class {
    private int classId;
    private String title;
    private String description;

    public Class() {
    }

    public Class(String title, String description) {
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
        return "Class [description=" + description + ", title=" + title + "]";
    }

}
