package com.corespecs.polls9ja.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Vote")
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Option option;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Option getOption() {
        return option;
    }
    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return getId() + ", " + getOption();
    }

}
