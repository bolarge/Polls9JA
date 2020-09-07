package com.corespecs.polls9ja.domain;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

import javax.persistence.*;

@Entity(name = "Poll")
@Table(name = "poll")
public class Poll {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    private String question;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<Option> options;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public Set<Option> getOptions() {
        return options;
    }
    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return getId() + ", " + getQuestion() + ", " + getOptions();
    }

}

