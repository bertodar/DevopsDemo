package ch.zhaw.iwi.devops.demo;

public class ToDo {

    private Integer id;
    private String title;
    private String description;

    public ToDo() {
    }
    
    public ToDo(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }    

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
}
