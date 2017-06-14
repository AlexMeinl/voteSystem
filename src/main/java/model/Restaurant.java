package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseModel{

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Meal> menu = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "voted_users", joinColumns = @JoinColumn(name = "r_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> votedUsers;

    @Column(name = "name")
    private String name;

    @Column(name = "count_votes")
    private Integer countVotes;

    public Restaurant()
    {}

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Restaurant(Integer id, String name, Collection<Meal> meals) {
        super(id);
        this.name = name;
        this.menu.addAll(meals);
    }

    public Set<Meal> getMenu() {
        return menu;
    }

    public void setMenu(Set<Meal> menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getVotedUsers() {
        return votedUsers;
    }

    public void setVotedUsers(List<User> votedUsers) {
        this.votedUsers = votedUsers;
    }

    public void setCountVotes(Integer countVotes) {
        this.countVotes = countVotes;
    }

    public Integer getCountVotes() {
        countVotes = getVotedUsers().size();
        return countVotes;
    }

    //REMASTER COUNTVOTES!!!!

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", countVotes=" + countVotes +
                "} " + super.toString();
    }
}
