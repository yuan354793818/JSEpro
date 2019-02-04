package com.test.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/*@SqlResultSetMapping
        (
                name = "ItemResults",
                entities = {
                        @EntityResult(
                                entityClass = User.class, //就是当前这个类的名字
                                fields = {
                                        @FieldResult(name = "id", column = "id"),
                                        @FieldResult(name = "itemId", column = "item_id")
                                }
                        )
                },
                columns = {
                        @ColumnResult(name = "item_id")
                }
        )*/
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

  /*  @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;*/
    /*
    或者
    */
    @OneToMany(targetEntity = Comment.class,mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "u_id"), inverseJoinColumns = @JoinColumn(name = "r_id"))
    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User() {
    }

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
