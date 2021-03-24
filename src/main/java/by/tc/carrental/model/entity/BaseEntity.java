package by.tc.carrental.model.entity;

public abstract class BaseEntity {
    protected long id;

    protected BaseEntity(){}

    protected BaseEntity(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }
}

