package model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseModel {
    public static final int START_SEQ = 0;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Access(value = AccessType.PROPERTY)
    private Integer id;

    protected BaseModel()
    {}

    protected BaseModel(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew()
    {
        return id != null;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}
