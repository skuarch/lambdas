package mx.javaday.lambda.exercise4;

import java.util.Objects;

/**
 *
 * @author jgmnx
 */
public final class Hacker {

    private final String name;
    private final String city;
    private final int age;
    private final String hobbie;
    private final String language;
    private double score;
    private final String nickName;

    public Hacker(String name, String city, int age, String hobbie,
        String language, double score, String nickName) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.hobbie = hobbie;
        this.language = language;
        this.score = score;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getHobbie() {
        return hobbie;
    }

    public String getLanguage() {
        return language;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "Hacker{" + "name=" + name + ", city=" + city + ", age=" + age
            + ", hobbie=" + hobbie + ", language=" + language + ", score="
            + score + ", nickName=" + nickName + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Hacker)) {
            return false;
        }
        Hacker other = (Hacker) obj;
        return this.getName().equals(other.getName()) && this.getNickName().equals(other.getNickName());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.city);
        hash = 89 * hash + this.age;
        hash = 89 * hash + Objects.hashCode(this.hobbie);
        hash = 89 * hash + Objects.hashCode(this.language);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.nickName);
        return hash;
    }

}