package kr.megaptera.assignment.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Embeddable
public class MultilineText {

    @ElementCollection
    private List<String> lines;

    public MultilineText(String text) {
        this.lines = Arrays.asList(text.split("\n"));
    }

    public MultilineText() {
    }

    public static MultilineText of(String text) {
        return new MultilineText(text);
    }

    @Override
    public String toString() {
        return String.join("\n", lines);
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultilineText that = (MultilineText) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
