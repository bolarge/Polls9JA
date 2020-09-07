package com.corespecs.polls9ja.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Choice")
@Table(name = "choice")
public class Option {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="OPTION_ID")
    private Long id;

    @Column(name="OPTION_VALUE")
    private String value;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getId() + "," + getValue();
    }
}
