package com.andigital.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Just a POJO that describes a greeting.
 *
 * Created by Paul Pop on 27/10/2015.
 */
@Entity
public class Greeting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String what;

    @Column(nullable = false)
    private String to;

    // Needed by Spring Data Interceptors
    protected Greeting() {}

    public Greeting(String what, String to) {
        super();
        this.what = what;
        this.to = to;
    }

    public String getWhat() {
        return what;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(what, greeting.what) &&
                Objects.equals(to, greeting.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(what, to);
    }
}
