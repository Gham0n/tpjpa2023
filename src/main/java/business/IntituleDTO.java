package business;

import java.io.Serializable;

public class IntituleDTO implements Serializable {
    private String name;

    private Long id;

    public IntituleDTO() {
        super();
    }

    public IntituleDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
